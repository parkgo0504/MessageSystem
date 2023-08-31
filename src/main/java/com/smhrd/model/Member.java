package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 매개변수를 입력받는 생성자 메소드 지정
@NoArgsConstructor // 기본 생성자 메소드 지정
public class Member {
	
	// lombok -> 어노테이션을 사용하여 자주 쓰이는 코드를 자동화 할 수 있는 라이브러리
	
	private String email;
	private String pw;
	private String tel;
	private String address;
	
	// 생성자 메소드 -> 기본 생성자
	
	
	
	// get/set

	
}
