package com.shop.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//------------------------------------------------------------------------------------------------------------------//
// public class OrderDTO
//------------------------------------------------------------------------------------------------------------------//
@Getter
@Setter
@ToString
public class OrderDTO {
	
	private String 	order_id;			 // 주문번호
	private String	addressee;			 // 수신인
	private String	member_id;			 // 주문회원 아이디
	private	String	member_addr1;		 // 우편번호
	private	String	member_addr2;		 // 회원주소
	private	String	member_addr3;		 // 회원상세주소
	
	private String	order_state;		 // 주문상태
	private List<OrderItemDTO> 	orders;	 // 주문상품
	private int		deliveryCost;		 // 배송비
	private int 	usePoint;			 // 사용포인트
	private Date	orderDate;			 // 주문날짜
	
	// DB에 존재하지 않는 데이터
	private int		orderSalePrice;		 // 판매가
	private int		orderSavePoint;		 // 적립 포인트
	private int		orderFinalSalePrice; // 최종 판매 비용
	
	// init
	public void getOrderPriceInfo() {
		// 상품 비용 & 적립 포인트
		for(OrderItemDTO order : orders) {
			orderSalePrice += order.getTotal_price();
			orderSavePoint += order.getTotalSavePoint();
		}
		// 배송비
		if(orderSalePrice >= 30000) deliveryCost = 0;
		else						deliveryCost = 3000;
		// 최종 비용(상품 비용 + 배송비 - 사용 포인트) 
		orderFinalSalePrice = orderSalePrice + deliveryCost - usePoint;
	}
	
	
} // End - public class OrderDTO
