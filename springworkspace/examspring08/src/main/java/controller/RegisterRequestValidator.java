package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.RegisterRequest;

//커맨드 객체를 검증하기 위한 클래스
public class RegisterRequestValidator implements Validator{

	private static final String EMAIL_REG_EXP = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;

	public RegisterRequestValidator() {
		pattern = Pattern.compile(EMAIL_REG_EXP);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		//파라미터 모두 스프링에서 관리
		//target: 검증 대상 객체(커맨드 객체)
		//errors: 검증 후 에러코드를 저장하는 객체
		RegisterRequest regReq = (RegisterRequest)target;
		if(regReq.getEmail() == null || regReq.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required"); //에러 발생 필드 이름, 에러 코드(임의)
		}else {
			Matcher matcher = pattern.matcher(regReq.getEmail());
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		if(!regReq.getPassword().isEmpty()) {
			if(!regReq.isPasswordEqualsToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
	}
	
	
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

}
