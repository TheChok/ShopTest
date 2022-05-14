package com.shop.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//----------------------------------------------------------------------------------------------------------//
// public class CatrDTO
//----------------------------------------------------------------------------------------------------------//
@Getter
@Setter
@ToString
public class CartDTO {
	
	private int 	cart_id;
	private String	member_id;
	private int		book_id;
	private int		book_count;
	
	// book
	private String 	book_name;
	private int 	book_price;
	private double 	book_discount;
	
	// 추가
	private int		sale_price;
	private int 	total_price;
	private int		point;
	private int		totalPoint;
	
	// 상품 이미지
	private List<AttachImageVO> imageList;
	
	
	public void initSaleTotal() {
		this.sale_price  	= (int) (this.book_price * (1 - this.book_discount));
		this.total_price 	= this.sale_price * this.book_count;
		this.point 			= (int)(Math.floor(this.sale_price * 0.05));
		this.totalPoint 	= this.point * this.book_count;
	}
	
	
	
	
	
} // End - public class CatrDTO




