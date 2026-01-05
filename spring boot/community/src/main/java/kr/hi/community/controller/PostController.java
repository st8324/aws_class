package kr.hi.community.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.hi.community.model.vo.PostVO;
import kr.hi.community.service.PostService;

@Controller
public class PostController {

	@Autowired
	PostService postService;
	
	
	// xxx : Get, Post
	/*
	@xxxMapping("url")
	public String 메서드명() {
		return "";
	}
	*/
	@GetMapping("/post/list")
	public String postList(Model model) {
		//서비스에게 게시글 목록을 가져오라고 요청
		//가져온 게시글 목록을 list에 저장
		ArrayList<PostVO> list = postService.getPostList();
		
		//게시글 목록을 화면에 전송
		model.addAttribute("list", list);
		return "post/list"; //post폴더에 list.html을 화면으로 보내줌
	}
	
	@GetMapping("/post/detail/{num}")
	public String postDetail(
		@PathVariable("num")int po_num, Model model) {
		//게시글 번호를 이용해서 조회수 증가
		postService.updateView(po_num);
		
		//게시글 번호를 이용해서 게시글 가져옴
		//게시글 번호(기본키)를 이용하여 게시글을 조회하면? => 최대 1개(왜?) 
		//기본키이니까 => 기본키의 정의 => 기본키로 검색하면 최대 1행이 조회되는 컬럼
		PostVO post = postService.getPost(po_num);
		
		//가져온 게시글을 화면에 전달
		model.addAttribute("post", post);
		return "post/detail";
	}
}



