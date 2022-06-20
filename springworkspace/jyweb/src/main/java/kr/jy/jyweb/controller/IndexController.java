package kr.jy.jyweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping(value = "/")
	public String home(Model model) {
		logger.info("Welcome home!");
		return "/index";
	}
	
	@RequestMapping(value = "/index")
	public String index(Model model) {
		logger.info("Welcome index!");
		return "/index";
	}
}
