package co.grandcircus.finalproject.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.grandcircus.finalproject.model.SentimentAnalyzer;


public interface SearchDataDao<Score> {

	public String addTweets(String name, Double avg, String type);
	
	public Double retrieveRunningAvg(String keyword);
	
	public SentimentAnalyzer getMaxScore() throws SQLException;

	public SentimentAnalyzer getMinScore() throws SQLException;
	
	
	
	

}
