/*
 * Source Material (c) 2016 GCD
 * All rights reserved
 */
package co.grandcircus.finalproject.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.movies.dao.MovieDao;
import co.grandcircus.movies.model.Movie;
import co.grandcircus.movies.rest.MovieInfoService;
import co.grandcircus.movies.rest.WeatherService;

/**
 * Handles requests for the additional movie info page.
 */
@Controller
public class SentimentAnalyzerController {

	private static final Logger logger = LoggerFactory.getLogger(SentimentAnalyzerController.class);

	@Autowired
	private SentimentAnalyzerService movieInfo;
//	@Autowired
//	private MovieDao movieDao;

	/**
	 * Retrieves movie info from Netflix API for "Flight"
	 */
	@RequestMapping("/movieinfo") 	// will work for GET or POST
	public String movieinfo(Model model, @RequestParam(value="movieName")String movieName) {
		// add the 'movieinfo' variable to the JSP
		model.addAttribute("movieinfo", movieInfo.getSelectedMovieInfo(movieName));

		logger.info("/movieinfo -> movieinfo.jsp");

		// select to use the movieinfo.jsp view
		return "movieinfo";
	}
	
}