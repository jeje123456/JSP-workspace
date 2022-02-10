package utills;
//패키지 utills = 뭔가 하는데 도움을 주는 내용 -> 제이슨으로 만들어서 요청이 오면 응답을 제이슨으로 해줌
//응답을 JSON으로 바꿔주는 라이브러리 -> gson 라이브러리
import model.Contact;
// 제이슨 형태로 보낼 클래스
public class ContactJson { 
	
	private boolean status;  // 상태 (성공/실패)
	private String message;	 // 메세지 입력
	private Contact contact; // 컨택트 객체(연락처 객체)를 하나 입력
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Contact getContact() {
		return contact;
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
