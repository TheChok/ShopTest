package com.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.model.MemberVO;
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
	// 확인용
	//---------------------------------------------------------------------//
	@GetMapping("/order/")
	public String orderPgaeGET2(OrderPageDTO opd, Model model) {
		return "redirect:/main";
	}
	
	//---------------------------------------------------------------------//
	// 주문 페이지 이동
	//---------------------------------------------------------------------//
	@GetMapping("/order/{member_id}")
	public String orderPgaeGET(@PathVariable("member_id") String member_id, OrderPageDTO opd, Model model) {
		
		
		try {
			model.addAttribute("orderList", orderService.getGoodsInfo(opd.getOrders()));
			model.addAttribute("memberInfo", memberSerivce.getMemberInfo(member_id));
		} catch(Exception e) {
			return "redirect:/main";
		}

		
		return "/order";
	}
	
	//---------------------------------------------------------------------//
	// 주문하기
	//---------------------------------------------------------------------//
	@PostMapping("/order")
	public String orderPagePOST(OrderDTO od, HttpServletRequest request) {
		
		System.out.println("메인페이지로 받은 order 정보 : " + od);
		
		orderService.order(od);
		
		MemberVO member = new MemberVO();
		member.setMember_id(od.getMember_id());
		
		HttpSession session = request.getSession();
		
		try {
			MemberVO memberLogin = memberSerivce.memberLogin(member);
			memberLogin.setMember_pw("");
			session.setAttribute("member", memberLogin);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/main";
	}
	

	
	
	
	
	
	
	
	
	
	
	
} // End - public class OrderController
























