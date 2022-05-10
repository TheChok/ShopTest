package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.mapper.AdminMapper;
import com.shop.model.AttachImageVO;
import com.shop.model.BookVO;

//--------------------------------------------------------------------------------------------------------------------//
// public class AdminServiceTests
//--------------------------------------------------------------------------------------------------------------------//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AdminServiceTests {
	
	@Autowired
	private AdminService service;
	
	@Autowired
	private AdminMapper adminMapper;
	
	/* 상품 등록 & 상품 이미지 등록 테스트 */
	@Test
	public void bookEnrollTEsts() {

		BookVO book = new BookVO();
		// 상품 정보
		book.setBook_name("service 테스트");
		book.setAuthor_id(27);
		book.setPubleYear("2021-03-18");
		book.setPublisher("출판사");
		book.setCateCode("202001");
		book.setBook_price(20000);
		book.setBook_stock(300);
		book.setBook_discount(0.23);
		book.setBook_intro("책 소개 ");
		book.setBook_contents("책 목차 ");

		// 이미지 정보
		List<AttachImageVO> imageList = new ArrayList<AttachImageVO>(); 
		
		AttachImageVO image1 = new AttachImageVO();
		AttachImageVO image2 = new AttachImageVO();
		
		image1.setFileName("test Image 1");
		image1.setUploadPath("test image 1");
		image1.setUuid("test11111");
		
		image2.setFileName("test Image 2");
		image2.setUploadPath("test image 2");
		image2.setUuid("test22221");
		
		imageList.add(image1);
		imageList.add(image2);
		
		
		book.setImageList(imageList);
		
		// bookEnroll() 메서드 호출
		service.bookEnroll(book);
		
		System.out.println("등록된 VO : " + book);
		
		System.out.println("imageList 정보 : " + imageList.size() + ", 상세 정보 : " + imageList);
		
	}
	
	
	
	
} // End - public class AdminServiceTests
