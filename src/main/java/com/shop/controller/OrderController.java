package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.model.OrderPageDTO;

//-------------------------------------------------------------------------------------------------------------------------------------------------------//
// public class OrderController
//-------------------------------------------------------------------------------------------------------------------------------------------------------//
@Controller
public class OrderController {
	
	//---------------------------------------------------------------------//
	// 주문 페이지 이동
	//---------------------------------------------------------------------//
	@RequestMapping(value="/order/{member_id}", method=RequestMethod.GET)
	public void orderPgaeGET(@PathVariable("member_id") String member_id, OrderPageDTO opd, Model model) {
		
		System.out.println("member_id : " + member_id);
		System.out.println("orders : " + opd.getOrders());
		
	}
	
	
	
	
} // End - public class OrderController
























