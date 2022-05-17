package com.shop.mapper;

import java.util.List;

import com.shop.model.CartDTO;

//----------------------------------------------------------------------------------------------------------//
// public interface CartMapper
//----------------------------------------------------------------------------------------------------------//
public interface CartMapper {
	
	// 카트 추가
	public int addCart(CartDTO cart) throws Exception;
	
	// 카트 수량 수정
	public int modifyCount(CartDTO cart);
	
	// 카트 목록
	public List<CartDTO> getCart(String member_id);
	
	// 카트 확인
	public CartDTO checkCart(CartDTO cart);
	
	// 카트 삭제
	public int deleteCart(int cart_id);
	
	// 카트 제거(주문)
	public int deleteOrderCart(CartDTO dto);
	
	
} // End - public interface CartMapper
