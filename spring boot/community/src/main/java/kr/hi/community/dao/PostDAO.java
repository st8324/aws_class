package kr.hi.community.dao;

import java.util.ArrayList;

import kr.hi.community.model.vo.PostVO;

public interface PostDAO {

	ArrayList<PostVO> selectPostList();

}
