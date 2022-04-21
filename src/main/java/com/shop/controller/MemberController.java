package com.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.model.MemberVO;
import com.shop.service.MemberService;

//-----------------------------------------------------------------------//
// public class MemberController
//-----------------------------------------------------------------------//
@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
<<<<<<< HEAD
	@Autowired
	private MemberService memberService;
	
	//-----------------------------------------------------------------------//
	// 회원가입 페이지로 이동
	//-----------------------------------------------------------------------//
=======
	// 회원가입 페이지로 이동
>>>>>>> refs/remotes/origin/main
	@RequestMapping(value="join", method=RequestMethod.GET)
	public void joinGET() {
		
<<<<<<< HEAD
		logger.info("회원가입 페이지 진입");
=======
		logger.info("회원가입 페이지로...");
>>>>>>> refs/remotes/origin/main
		
	}	
	
<<<<<<< HEAD
	//-----------------------------------------------------------------------//
	// 회원가입
	//-----------------------------------------------------------------------//
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPOST(MemberVO memberVO) throws Exception {
		
		logger.info("Join 진입");
		
		// 회원가입 서비스 실행
		memberService.memberJoin(memberVO);
		
		logger.info("Join Service 성공");
		
		return "redirect:/main";
	}		
	
	//-----------------------------------------------------------------------//
	// 로그인 페이지로 이동
	//-----------------------------------------------------------------------//
=======
	// 로그인 페이지로 이동
>>>>>>> refs/remotes/origin/main
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void loginGET() {
		
		logger.info("로그인 페이지로....");
		
	}
	
	//------------------------------------------------------------------------//
	// 아이디 중복 검사
	//------------------------------------------------------------------------//
	@RequestMapping(value="/member_id_ck", method=RequestMethod.POST)
	@ResponseBody
	public String member_id_ckPOST(String member_id) throws Exception {
		
		/* logger.info("member_id_ck() 진입"); */
		
		int result = memberService.idCheck(member_id);
		
logger.info("결과값 = " + result);
		
		if(result != 0) {			
			return "fail";	// 중복 아이디가 존재
			
		} else {			
			return "success";	// 중복 아이디 x
			
		}			
	}
	
	
	
} // End - public class MemberController
