package com.shop.mapper;

import com.shop.model.OrderPageItemDTO;

//---------------------------------------------------------------------------------------------------------------------//
// public interface OrderMapper
//---------------------------------------------------------------------------------------------------------------------//
public interface OrderMapper {
	
	// 주문상품 정보
	public OrderPageItemDTO getGoodsInfo(int book_id);
	
	
	
	
} // End - public interface OrderMapper
