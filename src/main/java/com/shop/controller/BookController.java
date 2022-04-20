package com.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//---------------------------------------------------------------------------//
// public class BookController
//---------------------------------------------------------------------------//
@Controller
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	//---------------------------------------------------------------------------//
	// 메인페이지로 이동
	//---------------------------------------------------------------------------//
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainPageGET() {
		
		logger.info("메인페이지 요청받음");
		
	}
	
	
} // End - public class BookController
