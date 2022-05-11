package com.shop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//---------------------------------------------------------------------------------------------------//
//	public class Criteria
//---------------------------------------------------------------------------------------------------//
@Getter
@Setter
@ToString
public class Criteria {
	
	private int 	pageNum;		// 현재 페이지 번호
	private int 	amount;			// 페이지 표시 개수
	private String 	type;			// 검색 타입
	private String	keyword;		// 검색 키워드
	private String	authorArr[]; 	// 작가 리스트
	private String	cateCode;		// 카테고리 코드
	
	
	// 생성자
	public Criteria(int pageNum, int amount) {
		this.pageNum	= pageNum;
		this.amount		= amount;
	}
	
	public Criteria() {	this(1, 10); }
	
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	
	
	
	
	
} // End - public class Criteria
