package todoApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import todoApp.model.Todo;
import todoApp.utils.JDBCUtils;

public class TodoDaoImpl implements TodoDao {
	// 클래스명 뒤에 implements TodoDao 입력하고 오류 눌러서 unimplemented 클릭 -> 생성해야될 메소드들 생성됨
	// DB 연결하고 각 기능에 맞게 작업한다. DAO 클래스에서 데이터베이스 todos테이블에 CRUD 작업

	@Override
	public void insertTodo(Todo todo) {
		String INSERT_TODOS_SQL = "INSERT INTO todos(title, username, description, target_date, is_done)"
				+ "VALUE (?, ?, ?, ?, ?)";

		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT_TODOS_SQL);
			pstmt.setString(1, todo.getTitle());
			pstmt.setString(2, todo.getUsername());
			pstmt.setString(3, todo.getDescription());
			pstmt.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate())); // 일반 날짜를 SQL 날짜로 변경
			pstmt.setBoolean(5, todo.isStatus()); // pstmt 준비 완료

			pstmt.executeUpdate(); // 실제 쿼리를 실행

		} catch (SQLException e) {
			System.out.println("SQL 입력 에러"); // sql 에러
		}
	}

	@Override
	public Todo selectTodo(long todoId) {
		Todo todo = null;

		Connection conn = JDBCUtils.getConnection(); // DB연결

		String SELECT_TODO_BY_ID = "SELECT id,title,username,description,target_date,is_done FROM todos WHERE id = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_TODO_BY_ID);
			pstmt.setLong(1, todoId); // sql문 준비 끝

			ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행 -> 마우스 올려보면 결과가 Resultset으로 리턴
			if (rs.next()) { // 결과가 있으면 true, 없으면 false -> 결과가 있을 경우에 값을 저장, 없으면 에러
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String username = rs.getString("username");
				String description = rs.getString("description");
				LocalDate targetDate = rs.getDate("target_date").toLocalDate();
				boolean status = rs.getBoolean("is_done");

				todo = new Todo(id, title, username, description, targetDate, status);
				// 여기에서 객체 생성하면 리턴이 안되므로 메소드 초반에 null값으로 선언
			}

		} catch (SQLException e) {
			System.out.println("SQL todo 검색 에러");
		}

		return todo;
	}

	@Override
	public List<Todo> selectAllTodos() {
		
		List<Todo> todos = new ArrayList<>(); // 빈 리스트를 생성
		String SELECT_ALL_TODOS = "select * from todos"; // todos 테이블 전체 검색
		
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_TODOS);

			ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행 -> 결과가 Resultset으로 리턴 -> 결과 저장
			
			// 결과가 여러줄일 경우 while() 사용하여 처리, 1줄일때는 if() 사용
			while (rs.next()) { // 결과가 있을 경우에 값을 저장, 없으면 에러 발생
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String username = rs.getString("username");
				String description = rs.getString("description");
				LocalDate targetDate = rs.getDate("target_date").toLocalDate();
				boolean status = rs.getBoolean("is_done");
				// 리스트에 담기(todo 객체로 입력)
				todos.add(new Todo(id, title, username, description, targetDate, status));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL todo 리스트 ALL 검색 에러"); // sql 에러
			return null;
		}
		
		System.out.println("todo 리스트 검색 완료");
		return todos;
	}

	@Override
	public boolean deleteTodo(long todoId) {
		
		String DELETE_TODO_BY_ID = "DELETE FROM todos WHERE id = ?";
		boolean rowDeleted = false;

		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE_TODO_BY_ID);
			pstmt.setLong(1, todoId); // pstmt 준비 완료

			rowDeleted = pstmt.executeUpdate() > 0; // 실제 쿼리를 실행 -> 삭제되면 true

		} catch (SQLException e) {
			System.out.println("SQL todo 삭제 에러"); // sql 에러
		}
		
		return rowDeleted;
	}

	@Override
	public boolean updateTodo(Todo todo) {
		
		String UPDATE_TODO = "UPDATE todos SET title = ?, username= ?, description =?, target_date =?, is_done = ? WHERE id = ?";
		boolean rowUpdated = false;
		
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_TODO);
			pstmt.setString(1, todo.getTitle());
			pstmt.setString(2, todo.getUsername());
			pstmt.setString(3, todo.getDescription());
			pstmt.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate())); // 일반 날짜를 SQL 날짜로 변경
			pstmt.setBoolean(5, todo.isStatus());
			pstmt.setLong(6, todo.getId());

			rowUpdated = pstmt.executeUpdate() > 0; // 실제 쿼리를 실행

		} catch (SQLException e) {
			System.out.println("SQL todo 업데이트 에러"); // sql 에러
			return false; // 에러나면 false 리턴
		}
		
		System.out.println("업데이트 완료!");
		return rowUpdated;
	}

}
