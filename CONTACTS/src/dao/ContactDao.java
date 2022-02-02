package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Contact;

public class ContactDao {
// DB에 있는 contacts 테이블을 CRUD 하는 클래스
	// DB 연결 객체들
	private DataSource dataSource; // jdbc/demo 커넥션 풀 연결 객체
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ContactDao(DataSource dataSource) {
		this.dataSource = dataSource; // 객체 생성시 커넥션 풀 dataSource를 입력
	}

	// 모든 연락처를 리스트로 리턴
	public List<Contact> findAll() {
		List<Contact> list = new ArrayList<Contact>(); // 빈 리스트 생성

		try {
			conn = dataSource.getConnection(); // DB 연결
			pstmt = conn.prepareStatement("SELECT * FROM contacts");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setPhone(rs.getString("phone"));

				list.add(contact);
			}

		} catch (SQLException e) {
			System.out.println("SQL 에러");
		} finally { // 에러에 상관없이 무조건 실행
			// DB 연결 객체들을 닫는 과정이 필요하다.
			// 클라이언트(접속자, 사용자)가 많아지면 열결을 안닫아주면 서버의 메모리가 가득차서 멈추게되므로 닫아줘야함
			closeAll(); // 모든 DB 연결 객체들을 닫아주는 메소드 만듬
		}

		return list;
	}

	private void closeAll() {

		try {
			// 순서 있음 : 나중에 연 순서부터 닫음 rs -> pstmt -> conn(풀로 되돌아감)
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception e2) {
			System.out.println("DB연결 닫을때 에러 발생");
		}

	}

	public Contact find(int id) {
		Contact contact = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select * from contacts where id = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				contact = new Contact();
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setPhone(rs.getString("phone"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return contact;
	}

	public boolean save(Contact contact) {
		boolean rowAffected = false;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("insert into contacts (name, email, phone) values (?, ?, ?)");
			pstmt.setString(1, contact.getName());
			pstmt.setString(2, contact.getEmail());
			pstmt.setString(3, contact.getPhone());

			rowAffected = pstmt.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return rowAffected;
	}

	
	public boolean update(Contact contact) {
		boolean rowAffected = false;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("update contacts set name = ?, email = ?, phone = ? where id = ?");
			// 직접 만들어 보자

			rowAffected = pstmt.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return rowAffected;
	}
	
	public boolean delete(int id) {
		boolean rowDeleted = false;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("delete from contacts where id = ?");
			pstmt.setInt(1, id);

			rowDeleted = pstmt.executeUpdate() > 0; // 실제 쿼리를 실행 -> 삭제되면 true

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return rowDeleted;
	}
}
