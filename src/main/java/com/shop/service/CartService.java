package com.shop.service;

import java.util.List;

import com.shop.model.CartDTO;

//-----------------------------------------------------------------------------------------------//
// public interface CartService
//-----------------------------------------------------------------------------------------------//
public interface CartService {
	
	// 장바구니 추가
	public int addCart(CartDTO cart);
	
	// 장바구니 정보 리스트
	public List<CartDTO> getCartList(String member_id);
	
	// 카트 수량 수정
	public int modifyCount(CartDTO cart);
	
	
	
	
	
	
	
} // End - public interface CartService
