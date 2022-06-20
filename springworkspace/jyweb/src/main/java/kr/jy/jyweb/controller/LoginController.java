package kr.jy.jyweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.jy.jyweb.service.LoginService;

@Controller
@RequestMapping(value = "/login/*")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private final LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService) {this.loginService = loginService;}
	
	@RequestMapping(value = "/")
	public String loginPage() {
		logger.info("Welcome login!");
		return "/login/login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public String doLogin(Model model,
			@RequestParam("id") String id, 
			@RequestParam("pwd") String pwd) {
		boolean result = loginService.login(id, pwd);
		return String.valueOf(result);
	}
}
