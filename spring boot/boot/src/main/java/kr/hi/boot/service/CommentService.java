package kr.hi.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.hi.boot.dao.CommentDAO;
import kr.hi.boot.model.util.Criteria;
import kr.hi.boot.model.util.PageMaker;
import kr.hi.boot.model.vo.Comment;

@Service
public class CommentService {

	private final CommentDAO commentDAO;
	
	public CommentService(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public List<Comment> getComments(int poNum, Criteria cri) {
		//다오에게 게시글 번호와 페이지 정보를 주면서 댓글 목록을 가져오라고 요청
		//게시글 목록 = 다오야.댓글목록가져와(게시글번호, 페이지정보);
		List<Comment> list = commentDAO.selectComments(poNum, cri);
		
		//가져온 댓글 목록을 반환 
		return list;
	}

	public PageMaker getPageMaker(int poNum, Criteria cri) {
		//한페이지네이션에서 최대 페이지수를 3개로 선언
		int pageCount = 3;
		//다오에게 게시글번호를 주면서 전체 댓글 수를 가져오라고 요청
		//전체댓글수 = 다오야.전체댓글수가져와(게시글번호);
		int count = commentDAO.selectCommentsCount(poNum);
		//최대 페이지수, 전체게시글수, 현재페이지 정보를 이용하여 PageMaker 객체를 생성
		PageMaker pm = new PageMaker(pageCount, cri, count);
		//생성된 객체를 반환
		return pm;
	}
}


