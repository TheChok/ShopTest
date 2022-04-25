package com.shop.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	//-----------------------------------------------------------------------//
	// 회원가입 페이지로 이동
	//-----------------------------------------------------------------------//

	// 회원가입 페이지로 이동
	@RequestMapping(value="join", method=RequestMethod.GET)
	public void joinGET() {
		
		logger.info("회원가입 페이지 진입");

	}	
	

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
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void loginGET() {
		
		logger.info("로그인 페이지로....");
		
	}
	
	//------------------------------------------------------------------------//
	// 아이디 중복 검사(ajax 기능)
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
	
	
	//------------------------------------------------------------------------//
	// 이메일 인증하기(ajax 기능)
	//------------------------------------------------------------------------//
	@RequestMapping(value="/emailCheck", method=RequestMethod.GET)
	@ResponseBody
	public String emailCheckGET(String email) throws Exception {
		
		/* 뷰(View)로부터 넘어온 데이터 확인 */
		logger.info("이메일 데이터 전송 확인");
		logger.info("인증 이메일 : " + email);
		
		/* 인증번호(난수) 생성 */
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("인증번호 : " + checkNum);
		
		/* 이메일 보내기 */
		String setFrom 	= "dasolgy008@gmail.com";
		String toMail 	= email;
		String title 	= "회원가입 인증 이메일입니다.";
		String content 	= "홈피이지를 방문해주셔서 감사합니다.<br><br>"
						+ "인증 번호는 " + checkNum + "입니다.<br>"
						+ "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";

		try {
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		String num = Integer.toString(checkNum);
		
		return num;
		
		// System.out.println("Return.....");
		// return "hello";
	}
	
	
	
	
} // End - public class MemberController
