package com.shop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//-----------------------------------------------------------------------------------------------------------------//
// public class CateFilterDTO
//-----------------------------------------------------------------------------------------------------------------//
@Getter
@ToString
public class CateFilterDTO {
	
	// 멤버변수
	private String 	cate_name;	// 카테고리 이름
	private String 	cateCode;	// 카테고리 넘버
	private int		cateCount;	// 카테고리 상품 수
	private String	cateGroup;	// 국내, 국외 분류
	
	
	// Setter - setCateCode 수정
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
		this.cateGroup	= cateCode.split("")[0];
	}
	public void setCateCount(int cateCount) {
		this.cateCount = cateCount;
	}
	public void setCateGroup(String cateGroup) {
		this.cateGroup = cateGroup;
	}
	
	
	
	
	
} // End - public class CateFilterDTO
