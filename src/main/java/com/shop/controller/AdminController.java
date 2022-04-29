package com.shop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shop.model.AuthorVO;
import com.shop.model.Criteria;
import com.shop.model.PageDTO;
import com.shop.service.AuthorService;

//-----------------------------------------------------------------------//
//public class MemberController
//-----------------------------------------------------------------------//
@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AuthorService authorService;
	
	
	//------------------------------------------------------------------------------------------//
	// 관리자 메인 페이지 이동
	//------------------------------------------------------------------------------------------//
	@RequestMapping(value="admain", method=RequestMethod.GET)
	public void adminMainGET() throws Exception {
		
		logger.info("관리자 페이지 이동");
		
	}
	
	//------------------------------------------------------------------------------------------//
	// 상품 등록 페이지 접속
	//------------------------------------------------------------------------------------------//
	@RequestMapping(value="goodsManage", method=RequestMethod.GET)
	public void goodsManageGET() throws Exception {
		logger.info("상품 등록 페이지 접속");
	}
	
	//------------------------------------------------------------------------------------------//
	// 상품 등록 페이지 접속
	//------------------------------------------------------------------------------------------//
	@RequestMapping(value="goodsEnroll", method=RequestMethod.GET)
	public void goodsEnrollGET() throws Exception {
		logger.info("상품 등록 페이지 접속");
	}
	
	//------------------------------------------------------------------------------------------//
	// 작가 등록 페이지 접속
	//------------------------------------------------------------------------------------------//
	@RequestMapping(value="authorEnroll", method=RequestMethod.GET)
	public void authorEnrollGET() throws Exception {
		logger.info("작가 등록 페이지 접속");
	}
	
	//------------------------------------------------------------------------------------------//
	// 작가 관리 페이지 접속
	//------------------------------------------------------------------------------------------//
	@RequestMapping(value="authorManage", method=RequestMethod.GET)
	public void authorManageGET(Criteria cri, Model model) throws Exception {
		logger.info("작가 관리 페이지 접속");
		
		// 작가 목록데이터 출력
		List list = authorService.authorGetList(cri);
		
		if(!list.isEmpty()) {		// 작가 있음.
			model.addAttribute("list", list);
		} else {					// 작가 없음.
			model.addAttribute("listCheck", "empty");
		}
		
		// 페이지 이동 인터페이스 데이터
		int 	total 		= authorService.authorGetTotal(cri);
		PageDTO pageMaker	= new PageDTO(cri, total);
		
		model.addAttribute("pageMaker", pageMaker);
		// model.addAttribute("pageMaker", new PageDTO(cri, authorService.authorGetTotal(cri)));
	}
	
	//------------------------------------------------------------------------------------------//
	// 작가 등록
	//------------------------------------------------------------------------------------------//
	@RequestMapping(value="authorEnroll.do", method=RequestMethod.POST)
	public String authorEnrollPOST(AuthorVO author, RedirectAttributes rttr) throws Exception {
		
		logger.info("authorEnroll : " + author);
		
		authorService.authorEnroll(author);									// 작가 등록 쿼리 수행
		
		rttr.addFlashAttribute("enroll_result", author.getAuthor_name());	// 등록 성공 메시지(작가이름)
		
		System.out.println("작가 등록 완료.... 등록된 작가 이름 : " + author.getAuthor_name());
		
		return "redirect:/admin/authorManage";
		
	}
	
	//------------------------------------------------------------------------------------------//
	// 작가 등록
	//------------------------------------------------------------------------------------------//
	@GetMapping("/authorDetail")
	public void authorGetInfoGET(int author_id, Criteria cri, Model model) throws Exception {
		
		logger.info("authorDetail......." + author_id);
		
		/* 작가 관리 페이지 정보 */
		model.addAttribute("cri", cri);
		
		/* 선택 작가 정보 */
		model.addAttribute("authorInfo", authorService.authorGetDetail(author_id));
		
	}
	
	
	
	
} // End - public class AdminController


















