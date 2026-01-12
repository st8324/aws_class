package kr.hi.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hi.community.model.dto.CommentDTO;
import kr.hi.community.model.util.CustomUser;
import kr.hi.community.service.CommentService;

@RestController //@ResponseBody + @Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(
		@RequestBody CommentDTO commentDto,
		@AuthenticationPrincipal CustomUser customUser){
		// 서비스에게 댓글 정보와 사용자 정보를 주면서 댓글을 등록하고, 
		// 등록 결과를 문자열로 가져오도록 요청
		//결과 = 서비스야.댓글등록해(댓글정보, 사용자 정보);
		String result = 
			commentService.insertComment(commentDto, customUser);
		return ResponseEntity.ok(result);
	}
}







