import java.util.List;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TestTwitter {

	public static void main(String[] args)  {
		String user;
		user="quickenloans";
		// TODO Auto-generated method stub
           ConfigurationBuilder cb = new ConfigurationBuilder();
           cb.setDebugEnabled(true)
           	   .setOAuthConsumerKey("JKqGbkTQK2jSSOssE0XsmXIkF")
           	   .setOAuthConsumerSecret("DTnvXMLYPqLgqgPkaxbD8JUOxZKiteXGD8Rh2xVKOLGi3eebTS")
           	   .setOAuthAccessToken("785948155099570177-ooScjQr0mAiSo88omJkiaKZu2Hs90aK")
           	   .setOAuthAccessTokenSecret("urK9LBU9imWuWvP9honql4E9e4rp14Rzec5FdAHQAdsQi");
           
           TwitterFactory tf = new TwitterFactory(cb.build());
           twitter4j.Twitter twitter = tf.getInstance();
           try{
           List<Status> status = twitter.getUserTimeline(user);
         
           
           
          // System.out.println("test");
           for (Status st : status) {
        	   System.out.println(st.getText());
           }
           	   
         //  System.out.println(" after test");
           }catch (Exception e){e.printStackTrace();}
	}

}
