package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Account {
	private Connection conn;
	
	public Account(Connection conn) {
		this.conn = conn;
	}
	// 로그인 (이메일, 패스워드) DB에서 같은 이메일, 패스워드 확인해서 false true 리턴
	public boolean login(String email, String password) throws SQLException {
		String sql = "SELECT COUNT(*) AS count FROM users WHERE email=? and password=?";
		// import java.sql.PreparedStatement;
		PreparedStatement pstmt = conn.prepareStatement(sql); //프리페어드 sql문으로 준비
		
		pstmt.setString(1, email); // 1번째 ?에 email 입력
		pstmt.setString(2, password); // 2번째 ?에 password 입력
		// import java.sql.ResultSet; 
		ResultSet rs = pstmt.executeQuery(); //SQL문 실행 후 리턴 값 저장
		
		int count = 0;
		
		if(rs.next()) { //결과가 있으면 count = 1
			count = rs.getInt("count"); // count 열의 값을 리턴(int형)
		}
		
		rs.close();
		
		if(count == 0) return false; // 결과가 없으면 false 있으면 true
		else return true;
	}
	public boolean exists(String email) throws SQLException {
		// 이미 등록된 email이 있을 경우 true 없으면 false
		String sql = "SELECT COUNT(*) AS count FROM users WHERE email=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery(); // 실행 후 리턴 값 저장
		
		int count = 0;
		
		if(rs.next()) { //결과가 있으면 count = 1
			count = rs.getInt("count"); // count 열의 값을 리턴(int형)
		}
		
		rs.close();
		
		if(count == 0) return false; // 결과가 없으면 false 있으면 true
		else return true;
	}
	
	public void create(String email, String password) throws SQLException {
		// DB에 새 user email, password를 입력
		String sql = "insert into users (email, password) values(?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		
		pstmt.executeUpdate(); //결과값 rs가 없을 경우 (입력,수정,삭제)를 하는 executeUpdate() 사용
	
		pstmt.close();
	}
}
