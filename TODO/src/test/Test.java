package test;

import java.time.LocalDate;
import java.util.List;

import todoApp.dao.TodoDaoImpl;
import todoApp.model.Todo;

public class Test {
	
	public static void main(String[] args) {
		
		TodoDaoImpl dao = new TodoDaoImpl();
		
		Todo todo1 = new Todo("할일 1", "drv98", "첫번째 할일", LocalDate.parse("2022-01-30"), false);
		// LocalDate.parse(문자열) -> 문자열을 LocalDate형으로 형변환
		
		 //dao.insertTodo(todo1); // DB에 입력되었는지 확인
		
		// Todo t1 = dao.selectTodo(1);
		// System.out.println(t1.toString()); // 할일이 출력되는지 확인
		
		//dao.deleteTodo(1);
		
		//Todo todo2 = new Todo("할일 1수정", "hong", "첫번째 할일수정", LocalDate.parse("2022-01-22"), true);
		//dao.insertTodo(todo1);
		//dao.updateTodo(todo2); // 할일 업데이트 확인
		
		List<Todo> todos = dao.selectAllTodos(); // 할일 리스트 확인
		
		for(Todo todo : todos) {
			System.out.println(todo.toString());
		}
	}
}
