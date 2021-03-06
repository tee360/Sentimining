package co.grandcircus.finalproject.model;

import java.util.ArrayList;

/**
 * Responsibility: Provide sentiment analyzer data given by sentiment analyzer service
 */
public class SentimentAnalyzer {

	/**
	 * Returns string of 'positive' or 'negative', depending on user input.
	 */
	private String type;
	/**
	 * Average score analysis of entire string.
	 */
	private double score;
	/**
	 * Ratings based on analysis.
	 */
	private int ratings;	
	private String summary;
	private Double averageScore;	
	private Double scoreValue;
	private String keyword;
	private double maxScore;
	private double minScore;
	private String maxTweetText;
	private String minTweetText;
	
	
    public String getMinTweetText() {
		return minTweetText;
	}
	public void setMinTweetText(String minTweetText) {
		this.minTweetText = minTweetText;
	}
	public String getMaxTweetText() {
		return maxTweetText;
	}
	public void setMaxTweetText(String maxTweetText) {
		this.maxTweetText = maxTweetText;
	}
	public double getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(double maxScore) {
		this.maxScore = maxScore;
	}
	
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
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
	public double getMinScore() {
		return minScore;
	}
	public void setMinScore(double minScore) {
		this.minScore = minScore;
	}

	
	

}