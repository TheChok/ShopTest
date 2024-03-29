package com.shop.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.model.SelectDTO;
import com.shop.service.BookService;

//----------------------------------------------------------------------------------------------------------------------//
// public class BookMapperTests
//----------------------------------------------------------------------------------------------------------------------//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BookMapperTests {
	
	@Autowired
	private BookMapper mapper;
	
	@Autowired
	private BookService bookService;
	
/*	
	@Test
	public void getGoodsListTest() {
		
		Criteria cri = new Criteria();
		// 테스트 키워드
		//cri.setKeyword("test");
		System.out.println("cri : " + cri);
		
		List<BookVO> list = mapper.getGoodsList(cri);
		System.out.println("list : " + list);
		
		System.out.println("==========");
		int goodsTotal = mapper.goodsGetTotal(cri);
		System.out.println("totla : " + goodsTotal);
		
	}
*/	
/*	
	// 작가 id 리스트 요청
	@Test
	public void getAuthorIdListTest() {
		
		String keyword	= "테스";
		String list[]	= mapper.getAuthorIdList(keyword);
		
		System.out.println("결과 : " + list.toString());
		
		for(String id : list) {
			System.out.println("개별 결과 : " + id);
		}
		
	}
*/	
/*	
	// 검색(동적 쿼리 적용) - 작가
	@Test
	public void getGoodsListTest1() {
		Criteria cri 	= new Criteria();
		String 	type 	= "A";
		String 	keyword ="테스";
		String 	cateCode = "";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setAuthorArr(mapper.getAuthorIdList(keyword));
		
		List<BookVO> list = mapper.getGoodsList(cri);
		
		System.out.println("cri : " + cri);
		System.out.println("list : " + list);
		
	}
*/	
/*	
	// 카테고리 리스트
	@Test
	public void getCateListTest() {
		
		Criteria cri = new Criteria();
		
		String type = "TC";
		String keyword = "테스";
		// String type ="A";
		// String keyword = "피카";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		// cri.setAuthorArr(mapper.getAuthorIdList(keyword));
		
		String[] cateList	= mapper.getCateList(cri);
		for(String codeNum : cateList) {
			System.out.println("codeNum ==> " + codeNum);
		}
		
	}
*/
/*	
	// 카테고리 정보 얻기
	@Test
	public void getCateInfoTest1() {
		
		Criteria cri = new Criteria();
		
		String type = "TC";
		String keyword = "test";
		String cateCode = "1004001";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setCateCode(cateCode);
		
		mapper.getCateInfo(cri);
		
	}
*/	
/*	
	// 상품 정보
	@Test
	public void getGoodsInfo() {
		int book_id = 14;
		BookVO goodsInfo = mapper.getGoodsInfo(book_id);
		System.out.println("=============================================");
		System.out.println(goodsInfo);
		System.out.println("=============================================");
		
	}
*/	
/*	
	// 상품 상세 정보
	@Test
	public void getGoodsInfoTest() {
		int book_id = 14;
		
		BookVO goodsInfo = bookService.getGoodsInfo(book_id);
		
		System.out.println("==결과==");
		System.out.println("전체 : " + goodsInfo);
		System.out.println("book_id : " + goodsInfo.getBook_id());
		System.out.println("이미지 정보 : " + goodsInfo.getImageList().isEmpty());
		
	}
*/	
	
	// 평점 순 상품 정보
	@Test
	public void likeSelect() {
		
		List<SelectDTO> list = bookService.likeSelect();
		
		System.out.println("결과값 : " + list);
		
		
	}
	
	
}
