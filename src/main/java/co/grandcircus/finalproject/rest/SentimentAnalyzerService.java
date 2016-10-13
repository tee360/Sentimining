package co.grandcircus.finalproject.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import co.grandcircus.finalproject.model.SentimentAnalyzer;
import twitter4j.JSONObject;
@Service
public class SentimentAnalyzerService {
	
	private final static String STRING_RATING = "positive";
	private final static String HAPPY_STRING = "I love this place";

	public SentimentAnalyzer getSentimentAnalysisForHappyString() {
		return getAnalysisOfSentiment(HAPPY_STRING);
	}
	
	public SentimentAnalyzer getAnalysisOfSentiment(String tweet) {
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
		
		org.json.JSONObject jObject = jsonResponse.getBody().getObject();
		
		System.out.println(jObject);
		
		SentimentAnalyzer stringAnalyzer = new SentimentAnalyzer();
		stringAnalyzer.setType(jObject.get("type").toString());
		//stringAnalyzer.setScore(((JsonArray) jObject.get("score")).getAsDouble());
		
		return stringAnalyzer;
		
//		// parse the HTTP response body to JSON
		//JsonElement root = new JsonObject();
		 
		
//		String url = "https://twinword-sentiment-analysis.p.mashape.com/analyze/";
//		// Use HTTP GET with the above URL
//		try (BufferedReader reader = HttpHelper.doGet(url)) { // try with resources will auto close the reader
//			if (reader == null) {
//				throw new RuntimeException("Not found: " + url);
//			}
//			
//			// parse the HTTP response body to JSON
//			JsonElement root = new JsonParser().parse(reader);
//			// 
//			JsonObject jObject = root.getAsJsonObject();
//			//JsonArray keywords = root.getAsJsonObject().get("keywords").getAsJsonArray();
//			
//			//ArrayList<SentimentAnalyzer> keywordList = new ArrayList<SentimentAnalyzer>();
//			SentimentAnalyzer stringAnalyzer = new SentimentAnalyzer();
//			
////			for(int i = 0; i < keywords.size(); i++) {
////				stringAnalyzer.setWord(keywords.get(i).getAsJsonObject().get("word").getAsString());
////			}
//
//			// 
//			stringAnalyzer.setType(jObject.get("type").getAsString());
//			stringAnalyzer.setScore(jObject.get("score").getAsDouble());
//			// 
//		//	stringAnalyzer.setWord(jObject.get("word").getAsString());
//			// 
//			
//
//			return stringAnalyzer;
//		} catch (IOException ex) {
//			throw new RuntimeException("Error reading from URL: " + url, ex);
//		}
	}
	
}
