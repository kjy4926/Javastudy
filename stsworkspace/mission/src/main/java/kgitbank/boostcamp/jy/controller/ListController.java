package kgitbank.boostcamp.jy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kgitbank.boostcamp.jy.service.BookService;
import kgitbank.boostcamp.jy.vo.BookVO;

@Controller
public class ListController {
	private static final Logger logger = LoggerFactory.getLogger(ListController.class);
	private final BookService bookService;
	
	@Autowired
	public ListController(BookService bookService) {this.bookService = bookService;}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String doGetlist(Model model) {
		logger.info("list METHOD GET");
		model.addAttribute("booklist", bookService.selectBookList());
		return "/list/book_list";
	}
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String doPostlist(Model model) {
		logger.info("list METHOD POST");
		return "redirect:/list";
	}
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(Model model, @RequestParam(value="search", required=false) String title) {
		logger.info("search");
		model.addAttribute("booklist", bookService.searchBookList(title));
		return "/list/book_list";
	}
}
