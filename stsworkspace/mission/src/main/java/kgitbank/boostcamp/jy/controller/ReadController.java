package kgitbank.boostcamp.jy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kgitbank.boostcamp.jy.service.BookService;

@Controller
public class ReadController {
	private static final Logger logger = LoggerFactory.getLogger(ReadController.class);	
	private final BookService bookService;
	
	@Autowired
	public ReadController(BookService bookService) {this.bookService = bookService;}
	
	@RequestMapping(value="/read/{id}")
	public String read(Model model, @PathVariable String id) {
		logger.info("welcome read!");
		
		model.addAttribute("book", bookService.readBook(Long.valueOf(id)));
		
		return "/read/book_detail";
	}
}
