package kgitbank.boostcamp.jy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kgitbank.boostcamp.jy.service.BookService;
import kgitbank.boostcamp.jy.vo.PageVO;

@Controller
public class ListController {
	private static final Logger logger = LoggerFactory.getLogger(ListController.class);
	private final BookService bookService;
	
	@Autowired
	public ListController(BookService bookService) {this.bookService = bookService;}
	
	// 도서 목록 최초 화면
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String doGetList(Model model, @RequestParam(value="search", required=false) String title) {
		logger.info("list METHOD GET");
		Long maxPage = 1L;
		if(title == null) {
			maxPage = bookService.getMaxPageNum();
			model.addAttribute("booklist", bookService.selectBookList(new PageVO(maxPage, 1L, 10L)));
			model.addAttribute("maxP", maxPage);
			model.addAttribute("p", 1);
		} else {
			maxPage = bookService.getSearchMaxPageNum(title);
			model.addAttribute("booklist", bookService.searchBookList(new PageVO(maxPage, 1L, 10L, title)));
			model.addAttribute("maxP", maxPage);
			model.addAttribute("p", 1);
		}
		return "/list/book_list";
	}
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String doPostList(Model model) {
		logger.info("list METHOD POST");
		return "redirect:/list";
	}
	// 페이지에 대한 도서 목록
	@RequestMapping(value="/list/{page}")
	public String doGetListPage(Model model, @PathVariable Long page, @RequestParam(value="search", required=false) String title) {
		logger.info("List with page");
		Long p = page;
		Long start = (p-1)*10 + 1;
		Long end = p*10;
		if(title == null) {
			Long maxPage = bookService.getMaxPageNum();
			model.addAttribute("booklist", bookService.selectBookList(new PageVO(maxPage, start, end)));
			model.addAttribute("maxP", maxPage);
			model.addAttribute("p", p);
		}else {
			Long maxPage = bookService.getSearchMaxPageNum(title);
			model.addAttribute("booklist", bookService.searchBookList(new PageVO(maxPage, start, end, title)));
			model.addAttribute("maxP", maxPage);
			model.addAttribute("p", 1);
		}
		return "/list/book_list";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String doGetSearch(Model model, @RequestParam(value="search", required=false) String title) {
		logger.info("search get");
		// 검색어가 없다면 목록 초기 화면으로 이동
		if(title == null || title.trim().length()==0) {
			return "redirect:/list";
		}
		// 검색어 설정 후 리다이렉트
		model.addAttribute("search", title);
		return "redirect:/list";
	}
}
