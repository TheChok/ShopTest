package com.shop.mapper;

import com.shop.model.MemberVO;

//--------------------------------------------------------------------------------------------//
// public class MemberMapper
//--------------------------------------------------------------------------------------------//
public interface MemberMapper {
	
	// 회원가입
	public void memberJoin(MemberVO memberVO);
	
	// 아이디 중복 검사
	public int idCheck(String member_id);
	
	// 로그인
	public MemberVO memberLogin(MemberVO member);
	
	
	
	
	
} // End - public class MemberMapper
