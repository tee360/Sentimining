package co.grandcircus.finalproject.dao;

import java.util.List;

import co.grandcircus.finalproject.model.SentimentAnalyzer;

public interface SearchDataDao {

	public String addTweets(String name, int score, String type);

	public SentimentAnalyzer retrieveRunningAvg();

}
