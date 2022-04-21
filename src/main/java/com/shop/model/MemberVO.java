package com.shop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//--------------------------------------------------------------------------------//
// public class MemberVO
//--------------------------------------------------------------------------------//
@Getter
@Setter
@ToString
public class MemberVO {
	
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_email;
	private String member_addr1;		// 우편번호
	private String member_addr2;		// 주소
	private String member_addr3;		// 상세주소
	private String admin_ck;			// 관리자 구분(0: 일반 사용자, 1: 관리자)
	private String reg_date;			// 등록일자
	private String money;				// 회원 소지머니
	private String point;				// 회원 포인트
	
	
	
} // End - public class MemberVO
