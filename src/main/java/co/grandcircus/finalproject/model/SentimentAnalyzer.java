package co.grandcircus.finalproject.model;

import java.util.ArrayList;

/**
 * Responsibility: Provide sentimentanalyzer data given by sentimentanalyzerservice
 */
public class SentimentAnalyzer {

	/**
	 * Returns string of 'positive' or 'negative', depending on user input.
	 */
	private String type;
	/**
	 * Average score analysis of entire string.
	 */
	private int score;
	/**
	 * Ratings based on analysis.
	 */
	private int ratings;
	
	private String summary;
	private Double averageScore;
	
	private Double scoreValue;
	private String keyword;
	
	
	
    public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

   public Double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(Double averageScore) {
		this.averageScore = averageScore;
	}
	public Double getScoreValue() {
		return scoreValue;
	}
	public void setScoreValue(Double scoreValue) {
		this.scoreValue = scoreValue;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	

}