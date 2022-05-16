package com.shop.service;

import com.shop.model.MemberVO;

//-------------------------------------------------------------------------------//
// public interface MemberService
//-------------------------------------------------------------------------------//
public interface MemberService {
	
	// 회원가입
	public void memberJoin(MemberVO memberVO) throws Exception;
	
	// 아이디 중복 검사
	public int idCheck(String member_id) throws Exception;
	
	// 로그인
	public MemberVO memberLogin(MemberVO member) throws Exception;
	
	// 주문자 정보
	public MemberVO getMemberInfo(String member_id);
	
	
	
} // End - public interface MemberService
