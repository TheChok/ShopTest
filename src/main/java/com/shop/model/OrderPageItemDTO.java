package com.shop.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//--------------------------------------------------------------------------------------------------------------------------------------------------//
// public class OrderPageItemDTO
//--------------------------------------------------------------------------------------------------------------------------------------------------//
@Getter
@Setter
@ToString
public class OrderPageItemDTO {
	
	// 뷰에서 전달받을 값
	private int book_id;
	private int book_count;
	
	// DB에서 꺼내올 값
	private String 	book_name;
	private int		book_price;
	private double	book_discount;
	
	// 만들어 낼 값
	private int		sale_price;
	private int		total_price;
	private int		point;
	private int		totalPoint;
	
	// 상품 이미지
	private List<AttachImageVO> imageList; 
	
	
	// initSaleTotal
	public void initSaleTotal() {
		this.sale_price 	= (int)(this.book_price * (1 - this.book_discount));
		this.total_price 	= this.sale_price * this.book_count;
		this.point			= (int)(Math.floor(this.sale_price * 0.05));
		this.totalPoint		= this.point * this.book_count;
	}
	
} // End - public class OrderPageItemDTO
