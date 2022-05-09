package com.shop.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//----------------------------------------------------------------------------------------//
//----------------------------------------------------------------------------------------//
@Getter
@Setter
@ToString
public class BookVO {
	
	private int 	book_id;		// 상품 아이디
	private String 	book_name;		// 상품명
	private int 	author_id;		// 작가 아이디
	private String 	author_name;	// 작가명
	private String  publeYear;		// 출판일
	private String  publisher;		// 출판사
	private String  cateCode;		// 카테고리 코드
	private String  cate_name;		// 카테고리명
	private int 	book_price;		// 상품 가격 
	private int 	book_stock;		// 상품 재고
    private double	book_discount;	// 할인율(백분율)
    private String  book_intro;		// 상품 소개
	private String  book_contents;	// 상품 목차
    private Date	regDate;		// 등록 날짜
    private Date 	updateDate;		// 수정 날짜
	
    private AttachImageVO		imageVO;	// 이미지 경로, uuid, 파일 이름
    private List<AttachImageVO> imageList;
    
	
	
	
	
} // End - public class BookVO
