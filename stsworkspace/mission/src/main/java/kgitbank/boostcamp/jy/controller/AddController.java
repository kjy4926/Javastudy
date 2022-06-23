package kgitbank.boostcamp.jy.controller;

import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kgitbank.boostcamp.jy.service.BookService;
import kgitbank.boostcamp.jy.vo.BookVO;

@Controller
public class AddController {
	private static final Logger logger = LoggerFactory.getLogger(AddController.class);
	private static final String UPLOAD_PATH = "C:\\Users\\kim\\Desktop\\Javastudy\\stsworkspace\\mission\\src\\main\\webapp\\resources\\img";
	private final BookService bookService;
	
	@Autowired
	public AddController(BookService bookService){this.bookService = bookService;}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		logger.info("add get");
		return "/add/book_reg_form";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addSubmit(@ModelAttribute BookVO bookVO) {
		logger.info("add post");
		bookService.bookInsert(bookVO);
		return "redirect:/list";
	}
	@PostMapping("/add/imageUpload")
	// MultipartFile 의 이름은 전송한 formData의 key 이름과 일치해야함
	public void upload(MultipartFile file) {
		System.out.println(file);
		String saveName = file.getOriginalFilename();
		File saveFile = new File(UPLOAD_PATH, saveName);
		try {
			file.transferTo(saveFile);
		}catch(Exception e) {e.printStackTrace();}
	}
}
