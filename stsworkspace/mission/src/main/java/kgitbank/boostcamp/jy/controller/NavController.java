package kgitbank.boostcamp.jy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavController {
	private static final Logger logger = LoggerFactory.getLogger(NavController.class);
	
	@RequestMapping(value="/nav", method=RequestMethod.GET)
	public String nav() {
		logger.info("get nav!");
		return "/nav/nav";
	}
	@RequestMapping(value="/nav2", method=RequestMethod.GET)
	public String nav2() {
		logger.info("get nav!");
		return "/nav/nav2";
	}
}
