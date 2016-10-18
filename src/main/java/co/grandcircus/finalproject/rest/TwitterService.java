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

public List<Twitter> getTweetsByHashtag(String hashtag) {

	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true).setOAuthConsumerKey("JKqGbkTQK2jSSOssE0XsmXIkF")
			.setOAuthConsumerSecret("DTnvXMLYPqLgqgPkaxbD8JUOxZKiteXGD8Rh2xVKOLGi3eebTS")
			.setOAuthAccessToken("785948155099570177-ooScjQr0mAiSo88omJkiaKZu2Hs90aK")
			.setOAuthAccessTokenSecret("urK9LBU9imWuWvP9honql4E9e4rp14Rzec5FdAHQAdsQi");

	List<Twitter> statusList = new ArrayList<Twitter>();
	TwitterFactory tf = new TwitterFactory(cb.build());
	
	twitter4j.Twitter tHash =  TwitterFactory.getSingleton();
    
	try {
		Query query = new Query("ipl7");
        QueryResult result = tHash.search(query);
        
        List<Status> status;
        
        int number_of_pages = 1;
		int count_per_page = 20;
		Paging paging = new Paging(1, count_per_page);
		
		for (int i = 1; i <= number_of_pages; i++) {
			status = result.getTweets();
        
        for (Status st : status) {
            System.out.println("@" + st.getUser().getScreenName() + " : " + st.getText() + " : " + st.getGeoLocation());
            Twitter tw = new Twitter();
            tw.setUser(st.getUser().getScreenName());
            tw.setText(st.getText());
            tw.setGeoLocation(st.getGeoLocation());
            
            statusList.add(tw);	
        }
        paging.setPage(i + 1);
        
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
			// getUserTimeline is responsible to return 20 tweets by default
			//status = twitter.getUserTimeline(user, paging);

//			for (Status st : status) {
//				Twitter tw = new Twitter();
//				tw.setText(st.getText());
//				tw.setId(st.getId());

					

	return statusList;
}public List<Twitter> getTweetsByHashtag(String hashtag) {

	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true).setOAuthConsumerKey("JKqGbkTQK2jSSOssE0XsmXIkF")
			.setOAuthConsumerSecret("DTnvXMLYPqLgqgPkaxbD8JUOxZKiteXGD8Rh2xVKOLGi3eebTS")
			.setOAuthAccessToken("785948155099570177-ooScjQr0mAiSo88omJkiaKZu2Hs90aK")
			.setOAuthAccessTokenSecret("urK9LBU9imWuWvP9honql4E9e4rp14Rzec5FdAHQAdsQi");

	List<Twitter> statusList = new ArrayList<Twitter>();
	TwitterFactory tf = new TwitterFactory(cb.build());
	
	twitter4j.Twitter tHash =  TwitterFactory.getSingleton();
    
	try {
		Query query = new Query("ipl7");
        QueryResult result = tHash.search(query);
        
        List<Status> status;
        
        int number_of_pages = 1;
		int count_per_page = 20;
		Paging paging = new Paging(1, count_per_page);
		
		for (int i = 1; i <= number_of_pages; i++) {
			status = result.getTweets();
        
        for (Status st : status) {
            System.out.println("@" + st.getUser().getScreenName() + " : " + st.getText() + " : " + st.getGeoLocation());
            Twitter tw = new Twitter();
            tw.setUser(st.getUser().getScreenName());
            tw.setText(st.getText());
            tw.setGeoLocation(st.getGeoLocation());
            
            statusList.add(tw);	
        }
        paging.setPage(i + 1);
        
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
			// getUserTimeline is responsible to return 20 tweets by default
			//status = twitter.getUserTimeline(user, paging);

//			for (Status st : status) {
//				Twitter tw = new Twitter();
//				tw.setText(st.getText());
//				tw.setId(st.getId());

					

	return statusList;
}public List<Twitter> getTweetsByHashtag(String hashtag) {

	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true).setOAuthConsumerKey("JKqGbkTQK2jSSOssE0XsmXIkF")
			.setOAuthConsumerSecret("DTnvXMLYPqLgqgPkaxbD8JUOxZKiteXGD8Rh2xVKOLGi3eebTS")
			.setOAuthAccessToken("785948155099570177-ooScjQr0mAiSo88omJkiaKZu2Hs90aK")
			.setOAuthAccessTokenSecret("urK9LBU9imWuWvP9honql4E9e4rp14Rzec5FdAHQAdsQi");

	List<Twitter> statusList = new ArrayList<Twitter>();
	TwitterFactory tf = new TwitterFactory(cb.build());
	
	twitter4j.Twitter tHash =  TwitterFactory.getSingleton();
    
	try {
		Query query = new Query("ipl7");
        QueryResult result = tHash.search(query);
        
        List<Status> status;
        
        int number_of_pages = 1;
		int count_per_page = 20;
		Paging paging = new Paging(1, count_per_page);
		
		for (int i = 1; i <= number_of_pages; i++) {
			status = result.getTweets();
        
        for (Status st : status) {
            System.out.println("@" + st.getUser().getScreenName() + " : " + st.getText() + " : " + st.getGeoLocation());
            Twitter tw = new Twitter();
            tw.setUser(st.getUser().getScreenName());
            tw.setText(st.getText());
            tw.setGeoLocation(st.getGeoLocation());
            
            statusList.add(tw);	
        }
        paging.setPage(i + 1);
        
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
			// getUserTimeline is responsible to return 20 tweets by default
			//status = twitter.getUserTimeline(user, paging);

//			for (Status st : status) {
//				Twitter tw = new Twitter();
//				tw.setText(st.getText());
//				tw.setId(st.getId());

					

	return statusList;
}public List<Twitter> getTweetsByHashtag(String hashtag) {

	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true).setOAuthConsumerKey("JKqGbkTQK2jSSOssE0XsmXIkF")
			.setOAuthConsumerSecret("DTnvXMLYPqLgqgPkaxbD8JUOxZKiteXGD8Rh2xVKOLGi3eebTS")
			.setOAuthAccessToken("785948155099570177-ooScjQr0mAiSo88omJkiaKZu2Hs90aK")
			.setOAuthAccessTokenSecret("urK9LBU9imWuWvP9honql4E9e4rp14Rzec5FdAHQAdsQi");

	List<Twitter> statusList = new ArrayList<Twitter>();
	TwitterFactory tf = new TwitterFactory(cb.build());
	
	twitter4j.Twitter tHash =  TwitterFactory.getSingleton();
    
	try {
		Query query = new Query("ipl7");
        QueryResult result = tHash.search(query);
        
        List<Status> status;
        
        int number_of_pages = 1;
		int count_per_page = 20;
		Paging paging = new Paging(1, count_per_page);
		
		for (int i = 1; i <= number_of_pages; i++) {
			status = result.getTweets();
        
        for (Status st : status) {
            System.out.println("@" + st.getUser().getScreenName() + " : " + st.getText() + " : " + st.getGeoLocation());
            Twitter tw = new Twitter();
            tw.setUser(st.getUser().getScreenName());
            tw.setText(st.getText());
            tw.setGeoLocation(st.getGeoLocation());
            
            statusList.add(tw);	
        }
        paging.setPage(i + 1);
        
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
			// getUserTimeline is responsible to return 20 tweets by default
			//status = twitter.getUserTimeline(user, paging);

//			for (Status st : status) {
//				Twitter tw = new Twitter();
//				tw.setText(st.getText());
//				tw.setId(st.getId());

					

	return statusList;
}public List<Twitter> getTweetsByHashtag(String hashtag) {

	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true).setOAuthConsumerKey("JKqGbkTQK2jSSOssE0XsmXIkF")
			.setOAuthConsumerSecret("DTnvXMLYPqLgqgPkaxbD8JUOxZKiteXGD8Rh2xVKOLGi3eebTS")
			.setOAuthAccessToken("785948155099570177-ooScjQr0mAiSo88omJkiaKZu2Hs90aK")
			.setOAuthAccessTokenSecret("urK9LBU9imWuWvP9honql4E9e4rp14Rzec5FdAHQAdsQi");

	List<Twitter> statusList = new ArrayList<Twitter>();
	TwitterFactory tf = new TwitterFactory(cb.build());
	
	twitter4j.Twitter tHash =  TwitterFactory.getSingleton();
    
	try {
		Query query = new Query("ipl7");
        QueryResult result = tHash.search(query);
        
        List<Status> status;
        
        int number_of_pages = 1;
		int count_per_page = 20;
		Paging paging = new Paging(1, count_per_page);
		
		for (int i = 1; i <= number_of_pages; i++) {
			status = result.getTweets();
        
        for (Status st : status) {
            System.out.println("@" + st.getUser().getScreenName() + " : " + st.getText() + " : " + st.getGeoLocation());
            Twitter tw = new Twitter();
            tw.setUser(st.getUser().getScreenName());
            tw.setText(st.getText());
            tw.setGeoLocation(st.getGeoLocation());
            
            statusList.add(tw);	
        }
        paging.setPage(i + 1);
        
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
			// getUserTimeline is responsible to return 20 tweets by default
			//status = twitter.getUserTimeline(user, paging);

//			for (Status st : status) {
//				Twitter tw = new Twitter();
//				tw.setText(st.getText());
//				tw.setId(st.getId());

					

	return statusList;
}public List<Twitter> getTweetsByHashtag(String hashtag) {

	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true).setOAuthConsumerKey("JKqGbkTQK2jSSOssE0XsmXIkF")
			.setOAuthConsumerSecret("DTnvXMLYPqLgqgPkaxbD8JUOxZKiteXGD8Rh2xVKOLGi3eebTS")
			.setOAuthAccessToken("785948155099570177-ooScjQr0mAiSo88omJkiaKZu2Hs90aK")
			.setOAuthAccessTokenSecret("urK9LBU9imWuWvP9honql4E9e4rp14Rzec5FdAHQAdsQi");

	List<Twitter> statusList = new ArrayList<Twitter>();
	TwitterFactory tf = new TwitterFactory(cb.build());
	
	twitter4j.Twitter tHash =  TwitterFactory.getSingleton();
    
	try {
		Query query = new Query("ipl7");
        QueryResult result = tHash.search(query);
        
        List<Status> status;
        
        int number_of_pages = 1;
		int count_per_page = 20;
		Paging paging = new Paging(1, count_per_page);
		
		for (int i = 1; i <= number_of_pages; i++) {
			status = result.getTweets();
        
        for (Status st : status) {
            System.out.println("@" + st.getUser().getScreenName() + " : " + st.getText() + " : " + st.getGeoLocation());
            Twitter tw = new Twitter();
            tw.setUser(st.getUser().getScreenName());
            tw.setText(st.getText());
            tw.setGeoLocation(st.getGeoLocation());
            
            statusList.add(tw);	
        }
        paging.setPage(i + 1);
        
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
			// getUserTimeline is responsible to return 20 tweets by default
			//status = twitter.getUserTimeline(user, paging);

//			for (Status st : status) {
//				Twitter tw = new Twitter();
//				tw.setText(st.getText());
//				tw.setId(st.getId());

					

	return statusList;
}public List<Twitter> getTweetsByHashtag(String hashtag) {

	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true).setOAuthConsumerKey("JKqGbkTQK2jSSOssE0XsmXIkF")
			.setOAuthConsumerSecret("DTnvXMLYPqLgqgPkaxbD8JUOxZKiteXGD8Rh2xVKOLGi3eebTS")
			.setOAuthAccessToken("785948155099570177-ooScjQr0mAiSo88omJkiaKZu2Hs90aK")
			.setOAuthAccessTokenSecret("urK9LBU9imWuWvP9honql4E9e4rp14Rzec5FdAHQAdsQi");

	List<Twitter> statusList = new ArrayList<Twitter>();
	TwitterFactory tf = new TwitterFactory(cb.build());
	
	twitter4j.Twitter tHash =  TwitterFactory.getSingleton();
    
	try {
		Query query = new Query("ipl7");
        QueryResult result = tHash.search(query);
        
        List<Status> status;
        
        int number_of_pages = 1;
		int count_per_page = 20;
		Paging paging = new Paging(1, count_per_page);
		
		for (int i = 1; i <= number_of_pages; i++) {
			status = result.getTweets();
        
        for (Status st : status) {
            System.out.println("@" + st.getUser().getScreenName() + " : " + st.getText() + " : " + st.getGeoLocation());
            Twitter tw = new Twitter();
            tw.setUser(st.getUser().getScreenName());
            tw.setText(st.getText());
            tw.setGeoLocation(st.getGeoLocation());
            
            statusList.add(tw);	
        }
        paging.setPage(i + 1);
        
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
			// getUserTimeline is responsible to return 20 tweets by default
			//status = twitter.getUserTimeline(user, paging);

//			for (Status st : status) {
//				Twitter tw = new Twitter();
//				tw.setText(st.getText());
//				tw.setId(st.getId());

					

	return statusList;
}public List<Twitter> getTweetsByHashtag(String hashtag) {

	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true).setOAuthConsumerKey("JKqGbkTQK2jSSOssE0XsmXIkF")
			.setOAuthConsumerSecret("DTnvXMLYPqLgqgPkaxbD8JUOxZKiteXGD8Rh2xVKOLGi3eebTS")
			.setOAuthAccessToken("785948155099570177-ooScjQr0mAiSo88omJkiaKZu2Hs90aK")
			.setOAuthAccessTokenSecret("urK9LBU9imWuWvP9honql4E9e4rp14Rzec5FdAHQAdsQi");

	List<Twitter> statusList = new ArrayList<Twitter>();
	TwitterFactory tf = new TwitterFactory(cb.build());
	
	twitter4j.Twitter tHash =  TwitterFactory.getSingleton();
    
	try {
		Query query = new Query("ipl7");
        QueryResult result = tHash.search(query);
        
        List<Status> status;
        
        int number_of_pages = 1;
		int count_per_page = 20;
		Paging paging = new Paging(1, count_per_page);
		
		for (int i = 1; i <= number_of_pages; i++) {
			status = result.getTweets();
        
        for (Status st : status) {
            System.out.println("@" + st.getUser().getScreenName() + " : " + st.getText() + " : " + st.getGeoLocation());
            Twitter tw = new Twitter();
            tw.setUser(st.getUser().getScreenName());
            tw.setText(st.getText());
            tw.setGeoLocation(st.getGeoLocation());
            
            statusList.add(tw);	
        }
        paging.setPage(i + 1);
        
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
			// getUserTimeline is responsible to return 20 tweets by default
			//status = twitter.getUserTimeline(user, paging);

//			for (Status st : status) {
//				Twitter tw = new Twitter();
//				tw.setText(st.getText());
//				tw.setId(st.getId());

					

	return statusList;
}public List<Twitter> getTweetsByHashtag(String hashtag) {

	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true).setOAuthConsumerKey("JKqGbkTQK2jSSOssE0XsmXIkF")
			.setOAuthConsumerSecret("DTnvXMLYPqLgqgPkaxbD8JUOxZKiteXGD8Rh2xVKOLGi3eebTS")
			.setOAuthAccessToken("785948155099570177-ooScjQr0mAiSo88omJkiaKZu2Hs90aK")
			.setOAuthAccessTokenSecret("urK9LBU9imWuWvP9honql4E9e4rp14Rzec5FdAHQAdsQi");

	List<Twitter> statusList = new ArrayList<Twitter>();
	TwitterFactory tf = new TwitterFactory(cb.build());
	
	twitter4j.Twitter tHash =  TwitterFactory.getSingleton();
    
	try {
		Query query = new Query("ipl7");
        QueryResult result = tHash.search(query);
        
        List<Status> status;
        
        int number_of_pages = 1;
		int count_per_page = 20;
		Paging paging = new Paging(1, count_per_page);
		
		for (int i = 1; i <= number_of_pages; i++) {
			status = result.getTweets();
        
        for (Status st : status) {
            System.out.println("@" + st.getUser().getScreenName() + " : " + st.getText() + " : " + st.getGeoLocation());
            Twitter tw = new Twitter();
            tw.setUser(st.getUser().getScreenName());
            tw.setText(st.getText());
            tw.setGeoLocation(st.getGeoLocation());
            
            statusList.add(tw);	
        }
        paging.setPage(i + 1);
        
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
			// getUserTimeline is responsible to return 20 tweets by default
			//status = twitter.getUserTimeline(user, paging);

//			for (Status st : status) {
//				Twitter tw = new Twitter();
//				tw.setText(st.getText());
//				tw.setId(st.getId());

					

	return statusList;
}public List<Twitter> getTweetsByHashtag(String hashtag) {

	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true).setOAuthConsumerKey("JKqGbkTQK2jSSOssE0XsmXIkF")
			.setOAuthConsumerSecret("DTnvXMLYPqLgqgPkaxbD8JUOxZKiteXGD8Rh2xVKOLGi3eebTS")
			.setOAuthAccessToken("785948155099570177-ooScjQr0mAiSo88omJkiaKZu2Hs90aK")
			.setOAuthAccessTokenSecret("urK9LBU9imWuWvP9honql4E9e4rp14Rzec5FdAHQAdsQi");

	List<Twitter> statusList = new ArrayList<Twitter>();
	TwitterFactory tf = new TwitterFactory(cb.build());
	
	twitter4j.Twitter tHash =  TwitterFactory.getSingleton();
    
	try {
		Query query = new Query("ipl7");
        QueryResult result = tHash.search(query);
        
        List<Status> status;
        
        int number_of_pages = 1;
		int count_per_page = 20;
		Paging paging = new Paging(1, count_per_page);
		
		for (int i = 1; i <= number_of_pages; i++) {
			status = result.getTweets();
        
        for (Status st : status) {
            System.out.println("@" + st.getUser().getScreenName() + " : " + st.getText() + " : " + st.getGeoLocation());
            Twitter tw = new Twitter();
            tw.setUser(st.getUser().getScreenName());
            tw.setText(st.getText());
            tw.setGeoLocation(st.getGeoLocation());
            
            statusList.add(tw);	
        }
        paging.setPage(i + 1);
        
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
			// getUserTimeline is responsible to return 20 tweets by default
			//status = twitter.getUserTimeline(user, paging);

//			for (Status st : status) {
//				Twitter tw = new Twitter();
//				tw.setText(st.getText());
//				tw.setId(st.getId());

					

	return statusList;
}
@RequestMapping("/Reflect/twitter")
public String home(Model model, @RequestParam("user") final String query) {

	if(query.startsWith("#")){
		List<Twitter> tHash = twitterservice.getTweetsByHashtag(query);
		
		if (tHash != null && tHash.size() > 5) {
			model.addAttribute("twitter", tHash.subList(0, 7));
		} else {
			model.addAttribute("twitter", tHash);
		}

		SentimentAnalyzer analyzer = sentimentAnalyzer.getAnalysisOfSentiment(tHash);

		jdbc.addTweets(query, analyzer.getScore(), analyzer.getType());
		
		double avg = jdbc.retrieveRunningAvg(query);
		BigDecimal bd = new BigDecimal(avg);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		
		model.addAttribute("averageScore", avg);

		model.addAttribute("SentimentAnalyzer", analyzer);

		model.addAttribute("searchKeyword", query);
		model.addAttribute("maxScore", jdbc.getMaxScore());

		model.addAttribute("minScore", jdbc.getMinScore());
		
	}
	else {
		List<Twitter> tweets = twitterservice.getCurrentTweets(query);
		
		if (tweets != null && tweets.size() > 5) {
			model.addAttribute("twitter", tweets.subList(0, 7));
		} else {
			model.addAttribute("twitter", tweets);
		}

		SentimentAnalyzer analyzer = sentimentAnalyzer.getAnalysisOfSentiment(tweets);

		jdbc.addTweets(query, analyzer.getScore(), analyzer.getType());
		
		double avg = jdbc.retrieveRunningAvg(query);
		BigDecimal bd = new BigDecimal(avg);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		
		model.addAttribute("averageScore", avg);

		model.addAttribute("SentimentAnalyzer", analyzer);

		model.addAttribute("searchKeyword", query);
		model.addAttribute("maxScore", jdbc.getMaxScore());

		model.addAttribute("minScore", jdbc.getMinScore());
	}
	
	logger.info("/twitter -> twitter.jsp");

	return "twitter";
}
}