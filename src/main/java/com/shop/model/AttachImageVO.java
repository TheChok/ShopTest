package com.shop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//-------------------------------------------------------------------------------------------------------//
// public class AttachImageVO
//-------------------------------------------------------------------------------------------------------//
@Getter
@Setter
@ToString
public class AttachImageVO {
	BookVO bookVO;

	private int 	book_id;		// 상품 ID
	private String	fileName;		// 파일 이름
	private String	uploadPath;		// 경로
	private String	uuid;			// UUID

	
	
} // End - public class AttachImageVO
