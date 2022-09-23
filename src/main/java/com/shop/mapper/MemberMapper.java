package com.shop.mapper;

import com.shop.model.MemberVO;

//--------------------------------------------------------------------------------------------//
// public class MemberMapper
//--------------------------------------------------------------------------------------------//
public interface MemberMapper {
	
	// 아이디 중복 검사
	public int idCheck(String member_id);

	// 회원가입
	public void memberJoin(MemberVO memberVO);
	
	// 로그인
	public MemberVO memberLogin(MemberVO member);
	
	// 주문자 정보
	public MemberVO getMemberInfo(String member_id);
	
	
	
	
} // End - public class MemberMapper
