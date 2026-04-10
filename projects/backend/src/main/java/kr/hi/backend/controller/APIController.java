package kr.hi.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "[http://localhost:3000](http://localhost:3000/)")
public class APIController {

	@GetMapping("/test")
	public String test(@RequestParam("msg")String msg) {
		
		return msg;
	}
	@PostMapping("/test")
	public String testPost(@RequestBody Test dto) {
		return dto.msg();
	}
}
@Data
class TestDTO{
	String msg;
}
record Test(String msg) {}
