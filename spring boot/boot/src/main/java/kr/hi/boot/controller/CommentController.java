package kr.hi.boot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hi.boot.model.util.Criteria;
import kr.hi.boot.model.util.PageMaker;
import kr.hi.boot.model.vo.Comment;
import kr.hi.boot.service.CommentService;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

	//@Autowired
	private final CommentService commentService;
	
	//생성자를 이용한 의존성 주입
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping("/posts/{num}/comments")
	public ResponseEntity<List<Comment>> getComments(
			//화면에서 보낸 게시글 번호를 가져옴 
			@PathVariable("num")int poNum,
			//화면에서 보낸 페이지 정보를 가져옴
			Criteria cri){
		
		//한페이에 댓글 5개로 설정
		cri.setPerPageNum(5);
		//서비스에게 게시글 번호와 페이지 정보를 주면서 댓글 목록 가져오라고 요청
		//댓글목록 = 서비스야.댓글목록가져와(게시글번호, 페이지정보);
		List<Comment> list = commentService.getComments(poNum, cri);
		
		//서비스에게 게시글 번호와 페이지 정보를 주면서 PageMaker 객체를 가져오라고 요청
		//PageMaker객체 = 서비스야.PageMaker객체가져와(게시글번호, 페이지정보)
		PageMaker pm = commentService.getPageMaker(poNum, cri);
		
		//가져온 댓글 목록을 화면에 전달
		return ResponseEntity.ok(list);
	}
	
}
