package todoApp.model;
// 로그인 체크를 할 때 사용할 자바 Bean 객체
public class LoginBean {
	private String userName;
	private String password;
	
	public String getUsername() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
