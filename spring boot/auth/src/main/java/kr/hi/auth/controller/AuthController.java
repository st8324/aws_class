package kr.hi.auth.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hi.auth.domain.UserDTO;
import kr.hi.auth.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
	
	private final UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<Boolean> signup(
			@RequestBody UserDTO user){
		
		boolean res = userService.signup(user);
		
		return ResponseEntity.ok(res);
	}
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody UserDTO user){
		System.out.println(user);
		
		return ResponseEntity.ok(Map.of(
				"accessToken", "토큰값 보낼 예정"
		));
	}
}
