package com.shop.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//---------------------------------------------------------------------------------//
// public class AuthorVO
//---------------------------------------------------------------------------------//
@Getter
@Setter
@ToString
public class AuthorVO {
	
	private String 	author_id;
	private String 	author_name;
	private String 	nation_id;
	private String 	nation_name;
	private String 	author_intro;
	private Date	reg_date;
	
	
	
	
	
} // End - public class AuthorVO
