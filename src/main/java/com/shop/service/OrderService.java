package com.shop.service;

import java.util.List;

import com.shop.model.OrderDTO;
import com.shop.model.OrderPageItemDTO;

//------------------------------------------------------------------------------------------------------------------//
// public interface OrderService
//------------------------------------------------------------------------------------------------------------------//
public interface OrderService {
	
	// 주문상품 정보
	public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders);
	
	// 주문
	public void order(OrderDTO ord);
	
	
	
	
	
	
} // End - public interface OrderService
