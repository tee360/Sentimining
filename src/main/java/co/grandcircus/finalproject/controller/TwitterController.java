package co.grandcircus.finalproject.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.finalproject.dao.SearchDataDaoJdbc;
import co.grandcircus.finalproject.model.SentimentAnalyzer;
import co.grandcircus.finalproject.model.Twitter;
import co.grandcircus.finalproject.rest.SentimentAnalyzerService;
import co.grandcircus.finalproject.rest.TwitterService;

@Controller
public class TwitterController {
	private static final Logger logger = LoggerFactory.getLogger(TwitterController.class);

	@Autowired
	private TwitterService twitterservice;

	@Autowired
	private SentimentAnalyzerService sentimentAnalyzer;

	@Autowired
	private SearchDataDaoJdbc jdbc;

	/**
	 * It retrieve the tweets and being processed by sentimentanalyzer service
	 * and returns the model to twitter.jsp
	 */
	@RequestMapping("/Reflect/twitter")
	public String home(Model model, @RequestParam("user") final String user,
			@RequestParam("searchType") final String searchType) {

		List<Twitter> tweets = null;

		if ("timeLine".equals(searchType)) {
			tweets = twitterservice.getCurrentTweets(user);
		} else {
			tweets = twitterservice.getCurrentHashTagTweets(user, searchType);
		}
		
		if (tweets != null && tweets.size() > 5) {
			model.addAttribute("twitter", tweets.subList(0, 5));
		} else {
			model.addAttribute("twitter", tweets);
		}

	SentimentAnalyzer analyzer = sentimentAnalyzer.getAnalysisOfSentiment(tweets);

	jdbc.addTweets(user,analyzer.getScore(),analyzer.getType());

//	Double dObj = new Double(null);
//	dObj = jdbc.retrieveRunningAvg();
	double avg = jdbc.retrieveRunningAvg();
	BigDecimal bd = new BigDecimal(avg);
	bd = bd.setScale(2, RoundingMode.HALF_UP);
//	System.out.println("AVG SCORE OVER HERE!!!"+bd);
	model.addAttribute("averageScore", bd);

	model.addAttribute("SentimentAnalyzer",analyzer);
	//model.addAttribute("maxTweetText", analyzer.getMaxTweetText());

	model.addAttribute("searchKeyword",user);
	model.addAttribute("maxScore",jdbc.getMaxScore());

	model.addAttribute("minScore",jdbc.getMinScore());

	logger.info("/twitter -> twitter.jsp");

	return"twitter";
}

}