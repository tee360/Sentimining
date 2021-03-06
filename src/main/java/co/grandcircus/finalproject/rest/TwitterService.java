package co.grandcircus.finalproject.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.grandcircus.finalproject.model.Twitter;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


/* author Reflect
 *  Twitter Service is responsible for providing the tweets related to the search
 *  It returns the json object with text and id
 * 
 */
@Service
public class TwitterService {

	/*
	 * This is the configuration setting for the twitter4J
	 * 
	 */

	private ConfigurationBuilder getConfigBuilder() {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("JKqGbkTQK2jSSOssE0XsmXIkF")
				.setOAuthConsumerSecret("DTnvXMLYPqLgqgPkaxbD8JUOxZKiteXGD8Rh2xVKOLGi3eebTS")
				.setOAuthAccessToken("785948155099570177-ooScjQr0mAiSo88omJkiaKZu2Hs90aK")
				.setOAuthAccessTokenSecret("urK9LBU9imWuWvP9honql4E9e4rp14Rzec5FdAHQAdsQi");
		return cb;

		}		
			// getUserTimeline is responsible to return 20 tweets by default
			//status = twitter.getUserTimeline(user, paging);

	public List<Twitter> getCurrentTweets(String user) {

		ConfigurationBuilder cb = getConfigBuilder();
		List<Twitter> statusList = new ArrayList<Twitter>();
		
		//Create TwitterFactory using the ConfigurationBuilder
		TwitterFactory tf = new TwitterFactory(cb.build());
		
		//getInstance method  gives the twitter object
		twitter4j.Twitter twitter = tf.getInstance();

		try {
			List<Status> status;
			int number_of_pages = 1;
			int count_per_page = 10;
			Paging paging = new Paging(1, count_per_page);
			for (int i = 1; i <= number_of_pages; i++) {
				
				if(user.startsWith("@")) {
					status = twitter.getMentionsTimeline();
				}
				else {
					// getUserTimeline is responsible to return 20 tweets by default
					status = twitter.getUserTimeline(user, paging);
				}				

				for (Status st : status) {
					Twitter tw = new Twitter();
					tw.setText(st.getText());
					tw.setId(st.getId());
					statusList.add(tw);
				}
				paging.setPage(i + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return statusList;
	}
	/*
     * 
	 * This method is to search for the string with # or @
	 * 
	 */
	public List<Twitter> getCurrentHashTagTweets(String user, String searchType) {

		ConfigurationBuilder cb = getConfigBuilder();
		List<Twitter> statusList = new ArrayList<Twitter>();
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter4j.Twitter twitter = tf.getInstance();

		try {
			Query query = new Query(searchType + user);
			query.setResultType(Query.RECENT);
			query.count(10);
			QueryResult result;
			result = twitter.search(query);
			List<Status> tweets = result.getTweets();

			for (Status tweet : tweets) {
				Twitter twitterObj = new Twitter();
				twitterObj.setText(tweet.getText());
			//	twitterObj.setScreenName(tweet.getUser().getScreenName());
				statusList.add(twitterObj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return statusList;
	}
}