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
	
	
	
} // End - public interface MemberService
