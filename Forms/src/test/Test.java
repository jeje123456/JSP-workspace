package test;

import beans.User2;

public class Test {
	
	public static void main(String[] args) {
		//유저클래스의 유효성 검사 테스트
		User2 user = new User2("drv98@naver.com", "abcd12345");
		
		if(user.validate()) {
			System.out.println("검사 성공!");
		} else {
			System.out.println("오류 메세지 : " + user.getMessage());
		}
	}

}
