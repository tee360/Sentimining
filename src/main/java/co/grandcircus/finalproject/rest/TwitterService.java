package co.grandcircus.finalproject.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.grandcircus.finalproject.model.Twitter;

import twitter4j.Status;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.util.List;

@Service
public class TwitterService {

	private String user;

	public List<Status> getCurrentTweetsAt() {
		return getCurrentTweets(user);
	}
	
	public List<Status> getCurrentTweets(String user){
	 user="realdonaldtrump";
	// TODO Auto-generated method stub
       ConfigurationBuilder cb = new ConfigurationBuilder();
       cb.setDebugEnabled(true)
       	   .setOAuthConsumerKey("JKqGbkTQK2jSSOssE0XsmXIkF")
       	   .setOAuthConsumerSecret("DTnvXMLYPqLgqgPkaxbD8JUOxZKiteXGD8Rh2xVKOLGi3eebTS")
       	   .setOAuthAccessToken("785948155099570177-ooScjQr0mAiSo88omJkiaKZu2Hs90aK")
       	   .setOAuthAccessTokenSecret("urK9LBU9imWuWvP9honql4E9e4rp14Rzec5FdAHQAdsQi");
       List<Status> statusList=new ArrayList<Status>();
       TwitterFactory tf = new TwitterFactory(cb.build());
       twitter4j.Twitter twitter = tf.getInstance();
       try{
    	
       List<Status> status = twitter.getUserTimeline(user);
      // System.out.println("test");
       for (Status st : status) {
    	   
    	   System.out.println(st.getText());
    	   statusList.add(st);
       }
     
       	   
     //  System.out.println(" after test");
       }catch (Exception e){e.printStackTrace();}
       return statusList;
}


}
