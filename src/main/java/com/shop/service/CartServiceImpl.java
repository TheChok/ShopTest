package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mapper.AttachMapper;
import com.shop.mapper.CartMapper;
import com.shop.model.AttachImageVO;
import com.shop.model.CartDTO;

//-------------------------------------------------------------------------------------------------------//
// public class CartServiceImpl implements CartService
//-------------------------------------------------------------------------------------------------------//
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
	
	@Autowired
	private AttachMapper attachMapper;
	
	//---------------------------------------------------------------------------------------------------//
	// 카트 추가
	//---------------------------------------------------------------------------------------------------//
	@Override
	public int addCart(CartDTO cart) {
		
		// 장바구니 데이터 체크
		CartDTO checkCart = cartMapper.checkCart(cart);
		
		if(checkCart != null) {
			return 2;
		}
		
		// 장바구니 등록 & 에러 시 0반환
		try {
			return cartMapper.addCart(cart);
		} catch (Exception e) {
			return 0;
		}		
		
	}

	//---------------------------------------------------------------------------------------------------//
	// 장바구니 정보 리스트
	//---------------------------------------------------------------------------------------------------//
	@Override
	public List<CartDTO> getCartList(String member_id) {
		
		List<CartDTO> cart = cartMapper.getCart(member_id);
		
		for(CartDTO dto : cart) {
			// 종합정보 초기화
			dto.initSaleTotal();
			
			// 이미지 정보 얻기
			int book_id = dto.getBook_id();
			List<AttachImageVO> imageList = attachMapper.getAttachList(book_id);
			dto.setImageList(imageList);
		}
		
		return cart;
	}

	//---------------------------------------------------------------------------------------------------//
	// 카트 수량 수정
	//---------------------------------------------------------------------------------------------------//
	@Override
	public int modifyCount(CartDTO cart) {
		
		return cartMapper.modifyCount(cart);
	}
	
	//---------------------------------------------------------------------------------------------------//
	// 카트 삭제
	//---------------------------------------------------------------------------------------------------//
	@Override
	public int deleteCart(int cart_id) {
		
		return cartMapper.deleteCart(cart_id);
	}
	
	
	
	
	
	
	
} // End - public class CartServiceImpl implements CartService












