package kr.hi.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.hi.community.service.PostService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	PostService postService;

	@GetMapping("/board/list")//실제 URL : /admin/board/list
	public String baordList() {
		return "board/list";
	}
}
