package kr.hi.boot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.hi.boot.model.vo.Post;
import kr.hi.boot.service.PostService;

@Controller
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping("/post/list")
	public String postList(Model model) {
		//게시글 목록 전체를 가져오려고 함
		ArrayList<Post> list = postService.getPostList();
		//가져온 게시글 목록을 화면에 전달 
		model.addAttribute("list", list);
		return "post/list";
	}
	
	@GetMapping("/post/detail/{num}")
	public String postDetail(
		Model model,
		@PathVariable("num")int num) {
		//번호에 맞는 게시글을 가져와서 화면에 전달
		//컨트롤러, 서비스, 다오, 매퍼
		Post post = postService.getBoard(num);
		model.addAttribute("post", post);
		return "post/detail";
	}
}






