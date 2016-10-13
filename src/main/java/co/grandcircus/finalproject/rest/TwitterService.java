package co.grandcircus.finalproject.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;



import co.grandcircus.finalproject.model.Twitter;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.util.List;

@Service
public class TwitterService {

	private String user;


	public List<Twitter> getCurrentTweetsAt() {

		return getCurrentTweets(user);
	}

	public List<Twitter> getCurrentTweets(String user) {
	//user = "cnn";
		// TODO Auto-generated method stub

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("JKqGbkTQK2jSSOssE0XsmXIkF")
				.setOAuthConsumerSecret("DTnvXMLYPqLgqgPkaxbD8JUOxZKiteXGD8Rh2xVKOLGi3eebTS")
				.setOAuthAccessToken("785948155099570177-ooScjQr0mAiSo88omJkiaKZu2Hs90aK")
				.setOAuthAccessTokenSecret("urK9LBU9imWuWvP9honql4E9e4rp14Rzec5FdAHQAdsQi");
		List<Twitter> statusList = new ArrayList<Twitter>();
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter4j.Twitter twitter = tf.getInstance();

		
		try {
			List<Status> status;
			int number_of_pages=5;
			int count_per_page=20;
			Paging paging = new Paging(1,count_per_page);		
			for (int i=1;i<=number_of_pages;i++){
					status = twitter.getUserTimeline(user,paging);
					// System.out.println("test");
					for (Status st : status) {
		
					Twitter tw = new Twitter();
						tw.setText(st.getText());
						tw.setId(st.getId());
					
						 //System.out.println(st.getText());
				    	  // statusList.add(st.getText());
					statusList.add(tw);
					
					}
					paging.setPage(i+1);
			}
					
			
            //storeInDB(statusList);
		System.out.println(" after test" +statusList.size() );
		} catch (Exception e) {
			e.printStackTrace();
		}

		return statusList;
	}
	

}
