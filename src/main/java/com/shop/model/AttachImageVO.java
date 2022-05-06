package com.shop.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//-------------------------------------------------------------------------------------------------------//
// public class AttachImageVO
//-------------------------------------------------------------------------------------------------------//
@Data
@Getter
@Setter
@ToString
public class AttachImageVO {
	
	private String	uploadPath;		// 경로
	private String	uuid;			// UUID
	private String	fileName;		// 파일 이름
	private int 	book_id;		// 상품 ID
	
	
} // End - public class AttachImageVO
