package co.grandcircus.finalproject.rest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import co.grandcircus.finalproject.model.SentimentAnalyzer;
import co.grandcircus.finalproject.model.Twitter;

@Service
public class SentimentAnalyzerService {
	/*
	 * This method is to get sentiment analysis for multiple tweets and return
	 * average score and type
	 * 
	 */
	
	//private Twitter tObj;
	
	
	public SentimentAnalyzer getAnalysisOfSentiment(List<Twitter> tweets) {
		SentimentAnalyzer stringAnalyzer = new SentimentAnalyzer();

		int numberOfTweets = tweets.size();
		double score = 0;
		// validate the number of to have at least one
		if (numberOfTweets > 0) {
			
			double maxScore = -1.0;
			String maxTweetText = null;
			double minScore = 1;
			String minTweetText = null;

			for (Twitter tweet : tweets) {
				JSONObject jsonObject = getAnalysisOfSentimentJSONObject(tweet.getText());
				score += jsonObject.getDouble("score");
				
				if(score > maxScore) {
					maxScore = score;
					maxTweetText = tweet.getText();
				}
				
				if(score < minScore) {
					minScore = score;
					minTweetText = tweet.getText();
				}
				
			}
			
			stringAnalyzer.setMaxScore(maxScore);
			stringAnalyzer.setMaxTweetText(maxTweetText);
			stringAnalyzer.setMinScore(minScore);
			stringAnalyzer.setMinTweetText(minTweetText);
			
			double averageScore = score / numberOfTweets;
			if (averageScore < 0) {
				stringAnalyzer.setType("negative");
			} else if (averageScore > 0) {
				stringAnalyzer.setType("positive");
			} else {
				stringAnalyzer.setType("neutral");
			}

			stringAnalyzer.setRatings(getRatings(averageScore));
			
			/*
			 * Scales score so that it's rounded to 2 decimal places
			 */
			BigDecimal bd = new BigDecimal(averageScore);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			double avgScore = bd.doubleValue();
			avgScore*=100;
			stringAnalyzer.setScore(avgScore);

			// Sets the summary that appears
			stringAnalyzer.setSummary(getSummary2(stringAnalyzer.getRatings()));
		}
		return stringAnalyzer;
	}

	private SentimentAnalyzer setTweetScore(double maxScore) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getRatings(double averageScore) {

		if (averageScore >= .5) {
			return 5;
		} else if (averageScore > 0.05 && averageScore < .5) {
			return 4;
		} else if (averageScore >= -0.05 && averageScore <= 0.05) {
			return 3;
		} else if (averageScore < -0.05 && averageScore > -.5) {
			return 2;
		}
		return 1;

	}

	public String getSummary2(int ratings) {
		switch(ratings) {
		case 1: 
			return "After analyzing some of the more recent tweets, "
					+ "it was determined that this source has a highly unfavorable view among users.";
		case 2:
			return "After analyzing some of the more recent tweets, "
					+ "it was determined that this source has an unfavorable view among users.";
		case 3:
			return "After analyzing some of the more recent tweets, "
					+ "it was determined that this source has a favorable view among users.";
		case 4:
			return "After analyzing some of the more recent tweets, "
					+ "it was determined that this source has a highly favorable view among users.";
		case 5:
			return "After analyzing some of the more recent tweets, "
					+ "it was determined that this source has an excellent view among users.";
		default:
			return null;
		}
	}

	/*
	 * To get Sentiment analysis as jsonobject for single tweet so this can be
	 * used in multiple method
	 */
	private JSONObject getAnalysisOfSentimentJSONObject(String tweet) {
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("https://twinword-sentiment-analysis.p.mashape.com/analyze/")
					.header("X-Mashape-Key", "54k15gqO06mshqMSp5fKtKmBWL5op1XIXMujsnfi4tWVNldYrP")
					.header("Content-Type", "application/x-www-form-urlencoded").header("Accept", "application/json")
					.field("text", tweet).asJson();

		} catch (UnirestException e) {

			e.printStackTrace();
		}

		JSONObject jObject = jsonResponse.getBody().getObject();
		return jObject;
	}

	/*
	 * This method is to get sentiment analysis for single tweet Not really
	 * being used anymore
	 * 
	 */
	public SentimentAnalyzer getAnalysisOfSentiment(String tweet) {

		JSONObject jObject = getAnalysisOfSentimentJSONObject(tweet);

		System.out.println(jObject);

		SentimentAnalyzer stringAnalyzer = new SentimentAnalyzer();
		stringAnalyzer.setType(jObject.get("type").toString());
		stringAnalyzer.setScore((int)(jObject.getDouble("score")));
		stringAnalyzer.setRatings(getRatings(jObject.getDouble("score")));

		return stringAnalyzer;

	}

}
