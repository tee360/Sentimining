package co.grandcircus.finalproject.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.finalproject.rest.TwitterService;

@Controller
public class TwitterController {
	private static final Logger logger = LoggerFactory.getLogger(TwitterController.class);

	@Autowired
	private TwitterService twitterservice;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/Reflect/twitter")
	public String home(Model model, @RequestParam("user") final String user) {
		// add the holiday variable to the JSP
		model.addAttribute("twitter", twitterservice.getCurrentTweets(user));

		logger.info("/twitter -> twitter.jsp");
		// logger.debug("holidayservice output ->" +
		// holidayservice.getCurrentHolidays().toString());

		// select to use the weather.jsp view
		return "twitter";
	}

}
