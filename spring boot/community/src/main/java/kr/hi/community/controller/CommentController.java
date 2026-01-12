package kr.hi.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hi.community.model.dto.CommentDTO;
import kr.hi.community.service.CommentService;

@RestController //@ResponseBody + @Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(
		@RequestBody CommentDTO commentDto){
		
		return ResponseEntity.ok("연결 성공");
	}
}







