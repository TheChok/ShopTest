package com.shop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//----------------------------------------------------------------------------//
// public class CateVO
//----------------------------------------------------------------------------//
@Getter
@Setter
@ToString
public class CateVO {
	
	private int 	tier;			// 카테고리 등급
	private String	cate_name;		// 카테고리 이름
	private String	cateCode;		// 카테고리 넘버
	private String	cate_parent;	// 상위 카테고리
	
	
	
	
} // End - public class CateVO
