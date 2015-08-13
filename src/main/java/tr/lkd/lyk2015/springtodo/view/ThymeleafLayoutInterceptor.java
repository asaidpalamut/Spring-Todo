package tr.lkd.lyk2015.springtodo.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ThymeleafLayoutInterceptor extends HandlerInterceptorAdapter {
	
	public static final String MAIN_LAYOUT = "layout/main";
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		
		String originalViewName = modelAndView.getViewName();
		
		
		//redirect ya da forward varsa interceptoru es gec..
		if(isRedirectOrForward(originalViewName))			
			return;
		
		
		//controllerdan gelen view i degistiriyoruz..
		modelAndView.setViewName(MAIN_LAYOUT);
		
		//modele attribute ekledik
		modelAndView.addObject("layout_main", originalViewName);
		
	
	}


	private boolean isRedirectOrForward(String originalViewName) {
		return originalViewName.startsWith("redirect:") || originalViewName.startsWith("forward:");
	}
	

}
