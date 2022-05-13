package com.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.shop.model.MemberVO;

//--------------------------------------------------------------------------------------------------------------//
// public class CartInterceptor
//--------------------------------------------------------------------------------------------------------------//
public class CartInterceptor  implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		MemberVO mvo = (MemberVO) session.getAttribute("member");
		
		
		
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	
	
	
	
	
	
} // End - public class CartInterceptor
