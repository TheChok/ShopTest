package com.shop.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//---------------------------------------------------------------------------------//
// public class AuthorVO
//---------------------------------------------------------------------------------//
@Getter
@ToString
public class AuthorVO {
	
	private String 	author_id;
	private String 	author_name;
	private String 	nation_id;
	private String 	nation_name;
	private String 	author_intro;
	private Date	regdate;
	private Date	updatedate;
	
	
	
	// Setter
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public void setNation_id(String nation_id) {
		this.nation_id = nation_id;
		if(nation_id.equals("01")) {
			this.nation_name = "국내";
		} else {
			this.nation_name = "국외";
		}
	}
	public void setAuthor_intro(String author_intro) {
		this.author_intro = author_intro;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	

	
} // End - public class AuthorVO
