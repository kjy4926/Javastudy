package kr.jy.jyweb.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(value = "/hello", method=RequestMethod.GET)
	public String hello(Locale locale, Model model) {		
		logger.info("Welcome hello! The client locale is {}.", locale);
		model.addAttribute("hello",  "Hello, World!");
		
		return "hello";
	}
}