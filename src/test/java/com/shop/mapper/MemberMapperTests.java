package com.shop.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.service.MemberService;

//------------------------------------------------------------------------------------------//
// public class MemberMapperTests
//------------------------------------------------------------------------------------------//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTests {
	
	@Autowired
	private MemberMapper memberMapper;		// MemberMapper.java 인터페이스 의존성 주입
	
	@Autowired
	private MemberService memberService;
/*	
	// 회원가입 쿼리 테스트 메서드
	@Test
	public void memberJoin() throws Exception {
		MemberVO memberVO = new MemberVO();	// MemberVO 메서드 호출 및 memberVO 변수 생성
		
		memberVO.setMember_id("test");		// memberVO 변수 안에 있는 속성들의 값을 설정해준다.
		memberVO.setMember_pw("test");		// 오라클 book_member 테이블의 각 속성 값들을 not null로 설정했기 때문.
		memberVO.setMember_name("test");
		memberVO.setMember_email("test");
		memberVO.setMember_addr1("test");
		memberVO.setMember_addr2("test");
		memberVO.setMember_addr3("test");
		
		memberMapper.memberJoin(memberVO);	// memberVO의 각 속성들에는 값들이 바인딩되어 있는 상태이다.
											// membermapper 인터페이스의 memberJoin 메서드를 호출한다.(memberVO) 매개변수를 넣어준다.
											// membermapper 변수는 상단에 호출시켜 놓은 상태이다.
											// memberVO에 있는 값들을 매개로 쿼리 메서드가 실행 될 것이다.
	}
*/

/*
	// 아이디 중복 검사
	@Test
	public void member_id_ck() throws Exception {
		String id = "admin";
		String id2 = "test123";
		
		membermapper.idCheck(id);
		membermapper.idCheck(id2);
		
	}
*/
/*	
	// 로그인 쿼리 mapper 메서드 테스트
	@Test
	public void memberLogin() throws Exception {
		System.out.println("테스트 시작");
		MemberVO member = new MemberVO();	// MemberVO 변수 선언 및 초기화
		
		// 올바른 아이디 비번 입력의 경우
		//member.setMember_id("test1");
		//member.setMember_pw("test1");
		
		// 올바르지 않은 아이디 비번 입력의 경우
		member.setMember_id("test112233");
		member.setMember_pw("test112233");
		
		memberMapper.memberLogin(member);
		System.out.println("결과 값: " + memberMapper.memberLogin(member));
		
	}
*/	
	
	// 주문상품 정보
	@Test
	public void getMemberInfoTest() {
		
		String member_id = "admin";
		
		memberMapper.getMemberInfo(member_id);
	}
	
	
	
} // End - public class MemberMapperTests
