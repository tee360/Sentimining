package co.grandcircus.finalproject.rest;

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

	
	
	private final static String STRING_RATING = "positive";
	private final static String HAPPY_STRING = "I love this place";

	public SentimentAnalyzer getSentimentAnalysisForHappyString() {
		return getAnalysisOfSentiment(HAPPY_STRING);
	}
/*
 * This method is to get sentimentanalysis for multiple tweets and return average score and type
 * 	
 */
	public SentimentAnalyzer getAnalysisOfSentiment(List<Twitter> tweets) {
		SentimentAnalyzer stringAnalyzer = new SentimentAnalyzer();
		int numberOfTweets = tweets.size();
		double score = 0;
		for(Twitter tweet:tweets){
			JSONObject jsonObject = getAnalysisOfSentimentJSONObject(tweet.getText());
			score += jsonObject.getDouble("score");
		}
		double averageScore = score/numberOfTweets;
		if(averageScore < 0){
			stringAnalyzer.setType("negative");
		}else if(averageScore > 0){
			stringAnalyzer.setType("positive");
		}else{
			stringAnalyzer.setType("neutral");
		}
		stringAnalyzer.setRatings(getRatings(averageScore));
	
		stringAnalyzer.setScore(averageScore);
		
		return stringAnalyzer;
	}
	
	public int getRatings(double averageScore){
		
		if(averageScore >= .5){
			return 5;
		}else if(averageScore > 0.05 && averageScore < .5){
			return 4;
		}else if(averageScore >= -0.05 && averageScore <= 0.05){
			return 3;
		}else if(averageScore < -0.05 && averageScore >- .5){
			return 2;
		}
		return 1;
		
	}
	/*
	 * To get Sentiment analysis as jsonobject for single tweet so this can be used in multiple method
	 */
	private JSONObject getAnalysisOfSentimentJSONObject(String tweet) {
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("https://twinword-sentiment-analysis.p.mashape.com/analyze/")
					.header("X-Mashape-Key", "vqKLeNUFrDmshfUd60DopAwITbrJp19qzOyjsnAURqfBjeFQ9w")
					.header("Content-Type", "application/x-www-form-urlencoded")
					.header("Accept", "application/json")
					.field("text", tweet)
					.asJson();
			
		} catch (UnirestException e) {
			
			e.printStackTrace();
		}
		
		JSONObject jObject = jsonResponse.getBody().getObject();
		return jObject;
	}
	/*
	 * This method is to get sentiment analysis for single tweet
	 * Not really being used anymore
	 * 
	 */
	public SentimentAnalyzer getAnalysisOfSentiment(String tweet) {

		
		JSONObject jObject = getAnalysisOfSentimentJSONObject(tweet);
		
		System.out.println(jObject);
		
		SentimentAnalyzer stringAnalyzer = new SentimentAnalyzer();
		stringAnalyzer.setType(jObject.get("type").toString());
		stringAnalyzer.setScore((jObject.getDouble("score")));
		stringAnalyzer.setRatings(getRatings(jObject.getDouble("score")));
		
		return stringAnalyzer;
		
	}
	
}
