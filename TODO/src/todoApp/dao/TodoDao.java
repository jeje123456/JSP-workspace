package todoApp.dao;

import java.util.List;

import todoApp.model.Todo;

// 인터페이스 dao로 이것을 구현해서 기능을 완성시키게 함
public interface TodoDao {
	
	// Create 입력 => 할 일을 DB에 입력
	void insertTodo(Todo todo);
	// Read(검색) => id 로 할 일을 검색 -> 리턴 1개
	Todo selectTodo(long todoId);
	// Read => 모든 할 일을 검색 -> 리턴 여러개(리스트로 만들어서 리턴)
	List<Todo> selectAllTodos();
	// Delete 할 일을 삭제(id로) -> 삭제를 하고 제대로 삭제 되었는지 true false로 리턴
	boolean	deleteTodo(long todoId);
	// Update 할 일을 업데이트 -> 업데이트 하고 업데이트가 되었는지 boolean 타입으로 리턴
	boolean updateTodo(Todo todo);
}
