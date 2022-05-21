package com.shop.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date	regDate;
	
	private String	content;
	private double	rating;
	
	
	
	
	
	
	
	
	
} // End - public class ReplyDTO
