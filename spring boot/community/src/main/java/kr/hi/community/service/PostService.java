package kr.hi.community.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hi.community.dao.PostDAO;
import kr.hi.community.model.vo.PostVO;

@Service
public class PostService {

	@Autowired
	PostDAO postDAO;

	public ArrayList<PostVO> getPostList() {
		//다오에게 게시글 목록을 가져오라고 요청
		ArrayList<PostVO> list = postDAO.selectPostList();
		//게시글 목록을 반환
		return list;
	}

	public void updateView(int po_num) {
		postDAO.updateView(po_num);
	}

	public PostVO getPost(int po_num) {
		PostVO post = postDAO.selectPost(po_num);
		return post;
	}
	
}
