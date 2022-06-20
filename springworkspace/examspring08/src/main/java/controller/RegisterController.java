package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.AlreadyExistingMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {
	
	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	

	@RequestMapping("/register/step1") //GET, POST 무관
	public String handleStep1() {
		return "register/step1";
	}
	
//	@RequestMapping(value="/register/step2", method=RequestMethod.POST)
//	public String handleStep2(HttpServletRequest request) {
//		String agree = request.getParameter("agree");
//		if(agree == null || !agree.equals("true")) {
//			return "register/step1";
//		}
//		return "register/step2";
//	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.POST)
	public String handleStep2(@RequestParam(value="agree", defaultValue = "false")Boolean agree, Model model) {
			if(!agree) {
				return "redirect:/register/step1";
			}
			RegisterRequest re = new RegisterRequest();
			//re.setEmail("gfsafas");
			model.addAttribute("formData", re);
			return "register/step2";
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.GET)
	public String handleStep2() {
		return "redirect:/register/step1"; //리디렉션 응답
	}
	
	@RequestMapping(value="/register/step3", method=RequestMethod.POST)
	public String handleStep3(
			@ModelAttribute("formData")RegisterRequest regReq,
			Errors errors) {
		//검증 대상 객체(커맨드 객체)바로 뒤에 Errors를 파라미터로 추가
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors()) { //에러가 하나라도 있다면
			return "register/step2";
		}
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		}catch(AlreadyExistingMemberException e) {
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}
	
}










