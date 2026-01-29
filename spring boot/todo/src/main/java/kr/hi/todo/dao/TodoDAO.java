package kr.hi.todo.dao;

import java.util.List;

import kr.hi.todo.model.vo.TodoVO;

public interface TodoDAO {

	List<TodoVO> selectTodos();

}
