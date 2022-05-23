package com.shop.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//----------------------------------------------------------------------------------------------------------//
// public class SelectDTO
//----------------------------------------------------------------------------------------------------------//
@Getter
@Setter
@ToString
public class SelectDTO {
	
	private int 	book_id;
	private String 	book_name;
	private String 	cate_name;
	private double	ratingAvg;
	private List<AttachImageVO> imageList;
	
} // End - public class SelectDTO
