package co.grandcircus.finalproject.model;

/**
 * Responsibility: Provide additional movie info fromNetflix API
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
	/**
	 * Strategic selection of words to analyze from the string.
	 */
	private String summary;
	
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
//	public String getWord() {
//		return word;
//	}
//	public void setWord(String word) {
//		this.word = word;
//	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
		

}