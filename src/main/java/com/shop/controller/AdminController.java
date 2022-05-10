package com.shop.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.model.AttachImageVO;
import com.shop.model.AuthorVO;
import com.shop.model.BookVO;
import com.shop.model.Criteria;
import com.shop.model.PageDTO;
import com.shop.service.AdminService;
import com.shop.service.AuthorService;

import net.coobird.thumbnailator.Thumbnails;

//-----------------------------------------------------------------------//
//public class MemberController
//-----------------------------------------------------------------------//
@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private AdminService adminService;

	// 관리자 페이지 이동 및 관리
	// 작가 등록 및 관리
	// 상품 등록 및 관리
	
	
	// 관리자 페이지 이동 및 관리
	
	//------------------------------------------------------------------------------------------//
	// 관리자 메인 페이지 이동
	//------------------------------------------------------------------------------------------//
	@RequestMapping(value="admain", method=RequestMethod.GET)
	public void adminMainGET() throws Exception {
		
		logger.info("관리자 페이지 이동");
		
	}
	
	//------------------------------------------------------------------------------------------//
	// 상품 관리(상품목록) 페이지 접속
	//------------------------------------------------------------------------------------------//
	@RequestMapping(value="goodsManage", method=RequestMethod.GET)
	public void goodsManageGET(Criteria cri, Model model) throws Exception {
		
		logger.info("상품 관리(상품목록) 페이지 접속");
		
		// 상품 리스트 데이터
		List list = adminService.goodsGetList(cri);
		
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
		} else {
			model.addAttribute("listCheck", "empty");
			return;
		}
		
		// 페이지 인터페이스 데이터
		model.addAttribute("pageMaker", new PageDTO(cri, adminService.goodsGetTotal(cri)));
		
	}
	
	//------------------------------------------------------------------------------------------//
	// 상품 조회 페이지 접속
	//------------------------------------------------------------------------------------------//
	@GetMapping({"/goodsDetail", "/goodsModify"})
	public void goodsGetInfoGET(int book_id, Criteria cri, Model model) throws JsonProcessingException {
		
		logger.info("goodsGetDetail.............bookId : " + book_id);
		
		ObjectMapper mapper = new ObjectMapper();
		
		// 카테고리 리스트 데이터
		model.addAttribute("cateList", mapper.writeValueAsString(adminService.cateList()));
		
		// 목록 페이지 조건 정보
		model.addAttribute("cri", cri);
		
		// 조회 페이지 정보
		model.addAttribute("goodsInfo", adminService.goodsGetDetail(book_id));
		
	}
	
	//------------------------------------------------------------------------------------------//
	// 상품 등록 페이지 접속
	//------------------------------------------------------------------------------------------//
	@RequestMapping(value="/goodsModify", method=RequestMethod.POST)
	public String goodsModifyPOST(BookVO vo, RedirectAttributes rttr) {
		
		logger.info("goodsModifyPOST............vo : " + vo);
		
		int result = adminService.goodsModify(vo);
		
		rttr.addFlashAttribute("modify_result", result);
		
		return "redirect:/admin/goodsManage";
	}
	
	
	//------------------------------------------------------------------------------------------//
	// 상품 등록 페이지 접속
	//------------------------------------------------------------------------------------------//
	@RequestMapping(value="goodsEnroll", method=RequestMethod.GET)
	public void goodsEnrollGET(Model model) throws Exception {
		logger.info("상품 등록 페이지 접속");
		
		ObjectMapper objm	= new ObjectMapper();
		
		List list = adminService.cateList();
		
		String cateList = objm.writeValueAsString(list);
		
		model.addAttribute("cateList", cateList);
		
		//logger.info("변경 전............" + list);
		//logger.info("변경 후............" + cateList);
	}
	
	//------------------------------------------------------------------------------------------//
	// 상품 정보 삭제
	//------------------------------------------------------------------------------------------//
	@PostMapping("/goodsDelete")
	public String goodsDeletePOST(int book_id, RedirectAttributes rttr) {
		logger.info("goodsDeletePOST.............");
		
		List<AttachImageVO> fileList = adminService.getAttachInfo(book_id);
		
		if(fileList != null) {
			List<Path> pathList = new ArrayList();
			
			fileList.forEach(vo -> {
				
				// 원본 이미지
				Path path = Paths.get("C:\\upload", vo.getUploadPath(), vo.getUuid() + "_" + vo.getFileName());
				pathList.add(path);
				
				// 썸네일 이미지
				path = Paths.get("C:\\upload", vo.getUploadPath(), "s_" + vo.getUuid() + "_" + vo.getFileName());
				pathList.add(path);
				
			});
			
			pathList.forEach(path -> {
				path.toFile().delete();
			});
			
		}
		
		
		int result = adminService.goodsDelete(book_id);
		
		rttr.addFlashAttribute("delete_result", result);
		
		return "redirect:/admin/goodsManage";
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
	
	
	
	// 관리자 페이지 - 작가 등록 및 관리
	
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
	// 작가 상세, 수정 페이지 이동
	//------------------------------------------------------------------------------------------//
	@GetMapping({"/authorDetail", "/authorModify"})
	public void authorGetInfoGET(int author_id, Criteria cri, Model model) throws Exception {
		
		logger.info("authorDetail......." + author_id);
		System.out.println("author_id : " + author_id);
		
		/* 작가 관리 페이지 정보 */
		model.addAttribute("cri", cri);
		
		/* 선택 작가 정보 */
		model.addAttribute("authorInfo", authorService.authorGetDetail(author_id));
		
	}
	//------------------------------------------------------------------------------------------//	
	// 작가 정보 수정
	//------------------------------------------------------------------------------------------//
	@PostMapping("authorModify")
	public String authorModifyPOST(AuthorVO author, RedirectAttributes rttr) throws Exception {
		
		logger.info("authorModifyPOST...... author : " + author);
		
		int result = authorService.authorModify(author);
		rttr.addFlashAttribute("modify_result", result);
		
		return "redirect:/admin/authorManage";
	}
	
	//------------------------------------------------------------------------------------------//	
	// 작가 정보 삭제
	//------------------------------------------------------------------------------------------//
	@PostMapping("authorDelete")
	public String authorDelte(int author_id, RedirectAttributes rttr) throws Exception {
		
		logger.info("authorDeletePOST........... author : " + author_id);
		
		int result = 0;
		
		try {
			
			result = authorService.authorDelete(author_id);
			
		} catch(Exception e) {
			e.printStackTrace();
			
			result = 2;
			rttr.addFlashAttribute("delete_result", result);
			
			return "redirect:/admin/authorManage";
		}
		
		rttr.addFlashAttribute("delete_result", result);
		
		return "redirect:/admin/authorManage";
	}
	
	
	
	// 관리자 페이지 - 상품 등록 및 관리
	
	//------------------------------------------------------------------------------------------//	
	// 상품 등록(book)
	//------------------------------------------------------------------------------------------//
	@RequestMapping(value="/goodsEnroll", method=RequestMethod.POST)
	public String goodsEnrollPOST(BookVO book, RedirectAttributes rttr) {
		
		logger.info("goodsEnrollPOST........." + book);
		
		adminService.bookEnroll(book);
		
		rttr.addFlashAttribute("enroll_result", book.getBook_name());
		
		return "redirect:/admin/goodsManage";
	}
	
	//------------------------------------------------------------------------------------------//	
	// 작가 검색 팝업창
	//------------------------------------------------------------------------------------------//
	@GetMapping("/authorPop")
	public void authorPopGET(Criteria cri, Model model) throws Exception {
		
		logger.info("authorPopGET..........");
		
		cri.setAmount(5);
		
		// 작가 목록데이터 출력
		List list = authorService.authorGetList(cri);
				
		if(!list.isEmpty()) {		// 작가 있음.
			model.addAttribute("list", list);
		} else {					// 작가 없음.
			model.addAttribute("listCheck", "empty");
		}
		
		model.addAttribute("pageMaker", new PageDTO(cri, authorService.authorGetTotal(cri)));
		
	}
	
	//------------------------------------------------------------------------------------------//	
	// 첨부 파일 업로드
	//------------------------------------------------------------------------------------------//
	@PostMapping(value="uploadAjaxAction", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachImageVO>> uploadAjaxActionPOST(MultipartFile[] uploadFile) {
		logger.info("uploadAjaxActionPOST.............");
		
		/* 이미지 파일 체크 */
		for(MultipartFile multipartFile: uploadFile) {
			
			File checkfile = new File(multipartFile.getOriginalFilename());
			String type = null;
			
			try {
				type = Files.probeContentType(checkfile.toPath());
				logger.info("MIME TYPE : " + type);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(!type.startsWith("image")) {
				
				List<AttachImageVO> list = null;
				return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
				
			}
			
		}// for
		
		
		// 기본 폴더 생성	-- 1
		String uploadFolder = "C:\\upload";	
		
		// 날짜 폴더 경로	-- 2
		SimpleDateFormat sdf		= new SimpleDateFormat("yyyy-MM-dd");
		Date			 date		= new Date();
		String			 str		= sdf.format(date);
		String			 datePath	= str.replace("-", File.separator);
		
		// 기본 폴더에 날짜별 저장 위한 폴더 생성	-- 3
		File uploadPath	= new File(uploadFolder, datePath);	// 저장폴더(기본폴더, 날짜폴더) => 3 = (1 , 2)
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		// 이미지 정보를 담는 객체
		List<AttachImageVO> list = new ArrayList();
		
		for(MultipartFile multipartFile : uploadFile) {
			
			// 이미지 정보 객체
			AttachImageVO vo = new AttachImageVO();
			
			// 파일 이름
			String uploadFileName	= multipartFile.getOriginalFilename();	// <== 기본 파일 이름
			vo.setFileName(uploadFileName);
			vo.setUploadPath(datePath);
			
			// UUID 적용한 파일 이름
			String uuid		= UUID.randomUUID().toString();
			vo.setUuid(uuid);
			uploadFileName = uuid + "_" + uploadFileName;					// <== UUID 적용된 파일 이름(중복저장 시 덮어쓰기 방지)
			
			// 파일 위치, 파일 이름을 합친 File 객체
			File saveFile	= new File(uploadPath, uploadFileName);
			
			// 파일 저장
			try {
				multipartFile.transferTo(saveFile);							// saveFile에 바인딩된 정보에 따라 '해당 경로'에 '해당 파일'을 전송(저장)함.
				
				
				// 썸네일 생성(ImageIO)										// 기본 파일 외에 썸네일 파일을 추가 생성해서 저장할것임.
/*
				// 방법 1
				File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);

				BufferedImage bo_image = ImageIO.read(saveFile);
				
					// 비율
					double ratio = 3;
					// 넓이, 높이
					int width 	 = (int) (bo_image.getWidth() / ratio);
					int height	 = (int) (bo_image.getHeight() / ratio);
				
				BufferedImage bt_image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
				
				Graphics2D graphic = bt_image.createGraphics();
				
				graphic.drawImage(bo_image, 0, 0, width, height, null);
				
				ImageIO.write(bt_image, "jpg", thumbnailFile);
*/
				
				// 방법 2
				File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);
				
				BufferedImage bo_image	= ImageIO.read(saveFile);
				
					// 비율
					double ratio = 3;
					// 넓이, 높이
					int width	 = (int) (bo_image.getWidth() / ratio);
					int height	 = (int) (bo_image.getHeight() / ratio);
				
				Thumbnails.of(saveFile)
				.size(width, height)
				.toFile(thumbnailFile);
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			list.add(vo);
		}
		
		ResponseEntity<List<AttachImageVO>> result = new ResponseEntity<List<AttachImageVO>>(list, HttpStatus.OK);
		
		return result;
	} // End - public ResponseEntity<AttachImageVO> uploadAjaxActionPOST(MultipartFile[] uploadFile)
	
	//------------------------------------------------------------------------------------------//	
	// 이미지 파일 삭제
	//------------------------------------------------------------------------------------------//
	@PostMapping("/deleteFile")
	public ResponseEntity<String> deleteFile(String fileName) {
		
		logger.info("deleteFile............fileName : " + fileName);
		
		File file = null;
		
		try {
			/* 썸네일 파일 삭제 */
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
			file.delete();
			
			/* 원본 파일 삭제 */
			String originFileName = file.getAbsolutePath().replace("s_", "");
			
			logger.info("originFileName : " + originFileName);
			
			file = new File(originFileName);
			file.delete();
			
		} catch(Exception e) {
			e.printStackTrace();
			
			return new ResponseEntity<String>("fail", HttpStatus.NOT_IMPLEMENTED);
		}
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	} // End - public ResponseEntity<String> deleteFile(String fileName)
	
	
	
} // End - public class AdminController


















