package com.shop.mapper;

import java.util.List;

import com.shop.model.BookVO;
import com.shop.model.MemberVO;
import com.shop.model.OrderDTO;
import com.shop.model.OrderItemDTO;
import com.shop.model.OrderPageItemDTO;

//---------------------------------------------------------------------------------------------------------------------//
// public interface OrderMapper
//---------------------------------------------------------------------------------------------------------------------//
public interface OrderMapper {
	
	// 주문 상품 정보(주문 페이지)
	public OrderPageItemDTO getGoodsInfo(int book_id);
	
	// 주문 상품 정보(주문 처리)
	public OrderItemDTO getOrderInfo(int book_id);
	
	// 주문 테이블 등록
	public int enrollOrder(OrderDTO ord);
	
	// 주문 아이템 테이블 등록
	public int enrollOrderItem(OrderItemDTO orid);
	
	// 주문 금액 차감
	public int deductMoney(MemberVO member);
	
	// 주문 재고 차감
	public int deductStock(BookVO book);
	
	// 주문 취소
	public int orderCancle(String order_id);
	
	// 주문 상품 정보(주문취소)
	public List<OrderItemDTO> getOrderItemInfo(String order_id);
	
	// 주문 정보(주문 취소)
	public OrderDTO getOrder(String order_id);
	
	
	
	
	
} // End - public interface OrderMapper






















