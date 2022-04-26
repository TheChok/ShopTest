package com.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//-----------------------------------------------------------------------//
//public class MemberController
//-----------------------------------------------------------------------//
@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	// 관리자 메인 페이지 이동
	@RequestMapping(value="admain", method=RequestMethod.GET)
	public void adminMainGET() throws Exception {
		
		logger.info("관리자 페이지 이동");
		
		
	}
	
	
	
} // End - public class AdminController
