package com.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.EnumCartStatus;
import com.shop.model.CartDTO;
import com.shop.model.MemberVO;
import com.shop.service.CartService;

import lombok.extern.log4j.Log4j;

//------------------------------------------------------------------------------------------------------//
// public class CartController
//------------------------------------------------------------------------------------------------------//
@Log4j
@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	/* 장바구니 추가 */
	/*  
	 * 0: 등록 실패
	 * 1: 등록 성공
	 * 2: 등록된 데이터 존재
	 * 3: 로그인 필요
	 * */
	
	//--------------------------------------------------------------------------------------------------------------//
	// 카트 추가
	//--------------------------------------------------------------------------------------------------------------//
	@PostMapping("/cart/add")
	@ResponseBody
	public String addCartPOST(CartDTO cart, HttpServletRequest request) {
		
		// 로그인 체크
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("member");
		System.out.println(mvo);
		
		String eResult = null;
		
		if(mvo == null) {
			eResult = EnumCartStatus.LOGIN_NOT_ERROR + "";
		} else {
			// 카트 등록
			int result = cartService.addCart(cart);
			if(result == 1) {
				eResult = EnumCartStatus.SUCCESS + "";
			} else {
				
			}
		} 
		System.out.println(eResult);
		
		return eResult;
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// 장바구니 페이지 이동
	//--------------------------------------------------------------------------------------------------------------//
	@GetMapping("/cart/{member_id}")
	public String cartPageGET(@PathVariable("member_id") String member_id, Model model) {
		
		model.addAttribute("cartInfo", cartService.getCartList(member_id));
		
		return "/cart";
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// 장바구니 수량 수정
	//--------------------------------------------------------------------------------------------------------------//
	@PostMapping("/cart/update")
	public String updateCarPOST(CartDTO cart) {

		cartService.modifyCount(cart);
		
		return "redirect:/cart/" + cart.getMember_id();
	}
	
	//--------------------------------------------------------------------------------------------------------------//
	// 장바구니 삭제
	//--------------------------------------------------------------------------------------------------------------//
	@PostMapping("/cart/delete")
	public String deleteCartPOST(CartDTO cart) {
		log.info("장바구니 삭제 컨트롤러에 진입했습니다.");
		System.out.println("cart.getCart_id ==>" + cart.getCart_id());
		cartService.deleteCart(cart.getCart_id());
		
		return "redirect:/cart/" + cart.getMember_id();
	}
	
} // End - public class CartController













