package kr.jy.jyweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.jy.jyweb.repository.MemberDao;
import kr.jy.jyweb.service.SignupService;

@Controller
@RequestMapping(value = "/signup/*")
public class SignupController {
	private static final Logger logger = LoggerFactory.getLogger(SignupController.class);
	private final SignupService signupService;
	
	@Autowired
	public SignupController(SignupService signupService) {this.signupService = signupService;}
	
	// 회원가입 페이지
	@RequestMapping(value = "/")
	public String signupPage(Model model) {
		logger.info("Welcome signup!");

		return "/signup/signup";
	}
	// ID 중복 검사
	@RequestMapping(value = "/idcheck")
	@ResponseBody
	public String idcheck(Model model, @RequestParam("userId") String id) {
		logger.info("id check!");
		System.out.println(id);
		boolean result = signupService.idCheck(id);
		return String.valueOf(result);
	}
	// 회원가입 실행
	@RequestMapping(value = "/signup.do")
	public String signupImpl(Model model, 
			@RequestParam("id") String id, 
			@RequestParam("pwd") String pwd, 
			@RequestParam("email") String email) {
		logger.info("Welcome signupResult!");
		boolean result = signupService.signup(id, pwd, email);
		model.addAttribute("signupsuccess", result);
		return "redirect:/signup/signupResult";
	}
	// 회원가입 결과 페이지
	@RequestMapping(value = "/signupResult")
	public String signupResult() {
		return "/signup/signupResult";
	}
}
