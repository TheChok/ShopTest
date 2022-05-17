package com.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.model.OrderDTO;
import com.shop.model.OrderPageDTO;
import com.shop.service.MemberService;
import com.shop.service.OrderService;

//-------------------------------------------------------------------------------------------------------------------------------------------------------//
// public class OrderController
//-------------------------------------------------------------------------------------------------------------------------------------------------------//
@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MemberService memberSerivce;
	
	//---------------------------------------------------------------------//
	// 주문 페이지 이동
	//---------------------------------------------------------------------//
	@GetMapping("/order/{member_id}")
	public String orderPgaeGET(@PathVariable("member_id") String member_id, OrderPageDTO opd, Model model) {
		
		model.addAttribute("orderList", orderService.getGoodsInfo(opd.getOrders()));
		model.addAttribute("memberInfo", memberSerivce.getMemberInfo(member_id));
		
		return "/order";
	}
	
	//---------------------------------------------------------------------//
	// 주문하기
	//---------------------------------------------------------------------//
	@PostMapping("/order")
	public String orderPagePOST(OrderDTO od, HttpServletRequest request) {
		
		System.out.println("메인페이지로 받은 order 정보 : " + od);
		
		return "redirect:/main";
	}
	
	
} // End - public class OrderController
























