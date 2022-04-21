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
	MemberMapper membermapper;
	
	//----------------------------------------------------------------------------------//
	// 회원 가입
	//----------------------------------------------------------------------------------//
	@Override
	public void memberJoin(MemberVO memberVO) {
		
		membermapper.memberJoin(memberVO);		
		
	}

	//----------------------------------------------------------------------------------//
	// 아이디 중복 검사
	//----------------------------------------------------------------------------------//
	@Override
	public int idCheck(String member_id) throws Exception {

		return membermapper.idCheck(member_id);
	}
	
	
	
	
	
	
	
} // End - public class MemberServiceImpl implements MemberService
 