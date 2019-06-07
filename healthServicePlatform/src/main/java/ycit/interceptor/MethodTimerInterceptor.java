package ycit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MethodTimerInterceptor implements HandlerInterceptor{
	
	private static  final Logger LOGGER = Logger.getLogger(MethodTimerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//定义一个开始的时间
		long start = System.currentTimeMillis();
		//将开始的时间放置到请求域中
		request.setAttribute("start", start);
		//记录一下请求
		LOGGER.info(request.getRequestURI()+"请求到达");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//拿到开始的时间
		long start = (long) request.getAttribute("start");
		//结束的时间
		long end = System.currentTimeMillis();
		long timecha = end - start;
		if (timecha>=1000) {
			LOGGER.warn("耗时超过1000"+timecha+"ms");
		}else{
			LOGGER.info("方法的耗时为:"+timecha+"ms");
		}
		
		//HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
      
}
