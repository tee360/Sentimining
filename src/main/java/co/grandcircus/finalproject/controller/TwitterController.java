package co.grandcircus.finalproject.controller;

import java.util.List;
import java.util.Locale;

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
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/Reflect/twitter")
	public String home(Model model, @RequestParam("user") final String user) {

		List<Twitter> tweets = twitterservice.getCurrentTweets(user);
		model.addAttribute("twitter", tweets.subList(0, 5));

		SentimentAnalyzer analyzer = sentimentAnalyzer.getAnalysisOfSentiment(tweets);

		model.addAttribute("SentimentAnalyzer", analyzer);
		jdbc.addTweets(user, analyzer.getScore(), analyzer.getType());

		logger.info("/twitter -> twitter.jsp");

		return "twitter";
	}

}
