package co.grandcircus.finalproject.rest;

import java.io.BufferedReader;
import java.io.IOException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import co.grandcircus.finalproject.model.SentimentAnalyzer;

public class SentimentAnalyzerService {
	
	private final static String STRING_RATING = "positive";
	private final static String HAPPY_STRING = "I love this place";

	public SentimentAnalyzer getMovieRatingForGhostbusters() {
		return getAnalysisOfSentiment(HAPPY_STRING);
	}
	
	public SentimentAnalyzer getAnalysisOfSentiment(String title) {
		String url = "https://twinword-sentiment-analysis.p.mashape.com/analyze/";
		// Use HTTP GET with the above URL
		try (BufferedReader reader = HttpHelper.doGet(url)) { // try with resources will auto close the reader
			if (reader == null) {
				throw new RuntimeException("Not found: " + url);
			}
			
			// parse the HTTP response body to JSON
			JsonElement root = new JsonParser().parse(reader);
			// pick the "rating1" key from the root JSON object.
			JsonObject jObject = root.getAsJsonObject();

			SentimentAnalyzer stringAnalyzer = new SentimentAnalyzer();
			// pick the "Rating" key from the JSON object
			stringAnalyzer.setType(jObject.get("type").getAsString());
			// pick the "Poster" key from the JSON object
			stringAnalyzer.setWord(jObject.get("word").getAsString());
			// pick the "Summary" key from the JSON object
			stringAnalyzer.setScore(jObject.get("score").getAsDouble());

			return stringAnalyzer;
		} catch (IOException ex) {
			throw new RuntimeException("Error reading from URL: " + url, ex);
		}
	}
	
}
