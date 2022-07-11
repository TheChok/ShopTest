package com.shop;

import java.lang.Enum;

public enum EnumCartStatus  {
	
	// FAIL_ERROR 		= 등록 실패
	// SUCCESS 			= 등록 성공
	// SAME_ERROR 		= 등록된 값 존재
	// LOGIN_NOT_ERROR 	= 멤버정보 없음, 로그인 필요
	FAIL_ERROR, SUCCESS, SAME_ERROR, LOGIN_NOT_ERROR
		
}
