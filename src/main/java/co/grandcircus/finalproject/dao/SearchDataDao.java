package co.grandcircus.finalproject.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.grandcircus.finalproject.model.SentimentAnalyzer;


public interface SearchDataDao<Score> {

	public String addTweets(String name, double avg, String type);
	
	public double retrieveRunningAvg();
	
	public SentimentAnalyzer getMaxScore() throws SQLException;

	public SentimentAnalyzer getMinScore() throws SQLException;
	
	
	
	

}
