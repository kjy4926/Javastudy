package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthCheckInterceptor implements HandlerInterceptor{
	
	//컨트롤러 수행 전: 반환 값이 true인 경우에만 컨트롤러 수행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		HttpSession session = request.getSession(false); //세션이 없으면 생성하지 않음
		if(session != null) {
			Object authInfo = session.getAttribute("authInfo");
			if(authInfo != null) {
				return true; //컨트롤러로 진행 계속
			}
		}
		response.sendRedirect(request.getContextPath() + "/login");
		return false; //컨트롤러로 진행 멈춤
	}
	
	//컨트롤러가 정상적으로 수행 된 후: 컨트롤러에서 Exception발생 시 동작하지 않음
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		System.out.println("postHandle");
	}

	//뷰가 클라이언트에 전송된 후: 컨트롤러 수행 중 발생된 예외는 네 번째 파라미터로 전달됨(없으면 null)
	//실행 후 예기치 못한 예외를 로그로 남기거나 실행시간 기록 등의 후처리에 유용
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
		System.out.println("afterCompletion");

	}
}
