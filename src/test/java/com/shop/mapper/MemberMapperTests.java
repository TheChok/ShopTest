package com.shop.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.model.MemberVO;

//------------------------------------------------------------------------------------------//
// public class MemberMapperTests
//------------------------------------------------------------------------------------------//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTests {
	
	@Autowired
	private MemberMapper membermapper;		// MemberMapper.java 인터페이스 의존성 주입
	
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
		
		membermapper.memberJoin(memberVO);	// memberVO의 각 속성들에는 값들이 바인딩되어 있는 상태이다.
											// membermapper 인터페이스의 memberJoin 메서드를 호출한다.(memberVO) 매개변수를 넣어준다.
											// membermapper 변수는 상단에 호출시켜 놓은 상태이다.
											// memberVO에 있는 값들을 매개로 쿼리 메서드가 실행 될 것이다.
	}
*/
	
	// 아이디 중복 검사
	@Test
	public void member_id_ck() throws Exception {
		String id = "admin";
		String id2 = "test123";
		
		membermapper.idCheck(id);
		membermapper.idCheck(id2);
		
	}
	
	
	
} // End - public class MemberMapperTests
