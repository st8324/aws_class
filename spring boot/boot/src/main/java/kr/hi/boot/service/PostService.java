package kr.hi.boot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hi.boot.dao.PostDAO;
import kr.hi.boot.model.vo.Board;

@Service
public class PostService {

	@Autowired
	PostDAO postDAO;

	public ArrayList<Board> getBoardList() {
		return postDAO.getBoardList();
	}

	public void insertBoard(String name) {
		//시작문자 앞과 마지막문자 뒤의 공백을 제거
		name = name.trim();
		//공백을 제거한 문자열의 길이가 0일때=> 입력을 안하거나 공백으로만 이루어졌을때
		if(name.length() == 0) {
			return;
		}
		//게시판 추가
		try {
			//동일한 게시판을 추가하려고 할 때 예외가 발생
			postDAO.insertBoard(name);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteBoard(int num) {
		
		postDAO.deleteBoard(num);
		
	}

	public void updateBoard(int num, String name) {
		try {
			//변경할 이름을 다른 게시판이 사용중이면 예외 발생
			postDAO.updateBoard(num, name);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
