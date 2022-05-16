package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mapper.MemberMapper;
import com.shop.model.MemberVO;

//-----------------------------------------------------------------------------//
// public class MemberServiceImpl implements MemberService
//-----------------------------------------------------------------------------//
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberMapper memberMapper;
	
	//----------------------------------------------------------------------------------//
	// 회원 가입
	//----------------------------------------------------------------------------------//
	@Override
	public void memberJoin(MemberVO memberVO) {
		
		memberMapper.memberJoin(memberVO);		
		
	}

	//----------------------------------------------------------------------------------//
	// 아이디 중복 검사
	//----------------------------------------------------------------------------------//
	@Override
	public int idCheck(String member_id) throws Exception {
		
		return memberMapper.idCheck(member_id);
	}
	
	//----------------------------------------------------------------------------------//
	// 로그인
	//----------------------------------------------------------------------------------//
	@Override
	public MemberVO memberLogin(MemberVO member) throws Exception {
		
		return memberMapper.memberLogin(member);
	}
	
	//----------------------------------------------------------------------------------//
	// 주문자 정보
	//----------------------------------------------------------------------------------//
	@Override
	public MemberVO getMemberInfo(String member_id) {
		
		return memberMapper.getMemberInfo(member_id);
	}
	
	
	
	
	
	
	
} // End - public class MemberServiceImpl implements MemberService
 