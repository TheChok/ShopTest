package com.shop.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//----------------------------------------------------------------------------------------------------------//
// public class ReplyDTO
//----------------------------------------------------------------------------------------------------------//
@Getter
@Setter
@ToString
public class ReplyDTO {
	
	private int 	reply_id;
	private int 	book_id;
	private String	member_id;
	private Date	regDate;
	private String	content;
	private double	rating;
	
	
	
	
	
	
	
	
	
} // End - public class ReplyDTO
