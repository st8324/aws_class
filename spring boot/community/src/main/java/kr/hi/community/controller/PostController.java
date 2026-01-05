package kr.hi.community.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.hi.community.model.vo.PostVO;
import kr.hi.community.service.PostService;

@Controller
public class PostController {

	@Autowired
	PostService postService;
	
	
	// xxx : Get, Post
	/*@xxxMapping("url")
	public String 메서드명() {
		return "";
	}*/
	@GetMapping("/post/list")
	public String postList(Model model) {
		//서비스에게 게시글 목록을 가져오라고 요청
		//가져온 게시글 목록을 list에 저장
		ArrayList<PostVO> list = postService.getPostList();
		
		//게시글 목록을 화면에 전송
		model.addAttribute("list", list);
		return "post/list"; //post폴더에 list.html을 화면으로 보내줌
	}
}



