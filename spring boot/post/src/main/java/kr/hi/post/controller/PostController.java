package kr.hi.post.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hi.post.model.vo.PostVO;
import kr.hi.post.service.PostService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class PostController {

	private final PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostVO>> postList() {
		System.out.println("목록 로딩중");
		List<PostVO> 게시글목록 = postService.getPosts();
		return ResponseEntity.ok(게시글목록);
	}
	
	@GetMapping("/post/detail/{num}")
	public String postDetail(
			//화면에서 보낸 게시글번호 가져옴 
			@PathVariable("num") int num,
			Model model) {
		//서비스에게 게시글번호 주면서 게시글 정보 가져오라고 요청
		//게시글 = 서비스야.게시글가져와(번호);
		PostVO 게시글 = postService.getPost(num);
		//- 가져온 게시글 화면에 전달
		model.addAttribute("post", 게시글);
		return "post/detail";
	}
	
	@PostMapping("/posts")
	public ResponseEntity<Boolean> postInsertPost(
			@RequestBody PostVO post) {
		boolean 결과 = postService.insertPost(post);
		if(결과) {
			return ResponseEntity.ok(true);
		}
		return ResponseEntity.ok(false);
	}
}
