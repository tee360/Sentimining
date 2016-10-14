package co.grandcircus.finalproject.dao;
import java.util.List;
import java.util.Set;

import co.grandcircus.finalproject.model.Twitter;

/**
 * Responsibility: To provide access to all the movies.
 */
public interface TwitterDao {
	
	/**
	 * Get a list that contains every available movie.
	 */
	public String addTweets(Twitter tweet);
	
}