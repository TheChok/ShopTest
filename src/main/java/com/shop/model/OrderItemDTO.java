package com.shop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//-------------------------------------------------------------------------------------------------------------------------------//
// public class OrderItemDTO
//-------------------------------------------------------------------------------------------------------------------------------//
@Getter
@Setter
@ToString
public class OrderItemDTO {
	
	private String 	order_id;		// 주문번호
	private int		book_id;		// 상품번호
	private int		book_count;		// 주문수량
	private int 	orderItem_id;	// book_orderItem 기본키
	private int		book_price;		// 상품 한 개 가격
	private	double	book_discount;	// 상품 할인율
	private int		savePoint;		// 상품 한 개 구매 시 획득 포인트
	
	// DB에 존재하지 않는 데이터 
	private int		sale_price;		// 할인 적용된 가격
	private int 	total_price;	// 총 가격(할인 적용된 가격 * 주문수량)
	private int 	totalSavePoint;	// 총 획득 포인트(상품 한 개 구매 시 획득 포인트 * 주문수량)
	
	// init
	public void initSaleTotal() {
		this.sale_price 	= (int)(this.book_price * (1 - this.book_discount));
		this.total_price 	= this.sale_price * this.book_count;
		this.savePoint		= (int)(Math.floor(this.sale_price * 0.05));
		this.totalSavePoint = this.savePoint * this.book_count;
	}
	
	
	
	
} // End - public class OrderItemDTO
