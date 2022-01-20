package beans;

public class User3 {
	private String email = "";
	private String password = "";
	
	private String message = "";
	
	public User3() {
		// 기본 생성자 : JSP bean으로 사용할려면 기본 생성자가 있어야 한다
	}
	// 생성자 추가
	public User3(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getMessage() {
		// 유효성 검사에 불합격 했을때 메세지
		return message;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
	public boolean validate() { // 입력된 필드 변수들의 값이 유효한지 유효성 검사 메소드
/**		초기화로 공백을 입력해서 null값이 안나오니 삭제
 * 		if(email == null) {
			message = "Invalid email";
			return false;
		}
		if(password == null) {
			message = "Invalid password";
			return false;
		}
**/
		if(!email.matches("\\w+@\\w+\\.\\w+")) {
			// \\w+@\\w+\\.\\w+: 정규 표현식으로 자바문자열은 \\역슬래쉬를 두번 적어야한다.
			// \\w+ = 모든 문자(숫자포함)
			message = "Invalid email";
			return false;
		}
		if(password.length() < 8) {
			message = "패스워드는 8자 이상";
			return false;
		}
		else if(password.matches("\\w*\\s+\\w*")) {
			message = "패스워드에 스페이스가 포함되면 안됩니다.";
			return false;
		}
		// 위의 검사들을 다 통과하면 유효성 메소드를 true로 리턴한다.
		return true;
	}
}
