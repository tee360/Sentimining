/*
 * Source Material (c) 2016 GCD
 * All rights reserved
 */
package co.grandcircus.finalproject.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.finalproject.rest.SentimentAnalyzerService;


/**
 * Handles requests for analysis of sentiments (strings).
 */
@Controller
public class SentimentAnalyzerController {

	private static final Logger logger = LoggerFactory.getLogger(SentimentAnalyzerController.class);

	@Autowired
	private SentimentAnalyzerService stringAnalyzer;
//	@Autowired
//	private MovieDao movieDao;

	/**
	 * Retrieves Sentiment Analysis
	 */
	@RequestMapping("/stringAnalyzer") 	// will work for GET or POST
	public String sentimentAnalyzer(Model model, @RequestParam(value="stringToAnalyze", required=false)String stringToAnalyze) {
		// add the 'sentimentAnalyzer' variable to the JSP
		model.addAttribute("stringAnalyzer", stringAnalyzer.getAnalysisOfSentiment(stringToAnalyze));

		logger.info("/stringAnalyzer -> stringAnalyzer.jsp");

		// select to use the movieinfo.jsp view
		return "stringAnalyzer";
	}
	
}