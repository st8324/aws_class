package kr.hi.community.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hi.community.jwt.JwtTokenProvider;
import kr.hi.community.model.dto.LoginRequest;
import kr.hi.community.model.util.CustomUser;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
    	try {
	        Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(
	                request.username(), request.password()
	            )
	        );
	        CustomUser user = (CustomUser) authentication.getPrincipal();
	        String token = jwtTokenProvider.createToken(user);
	
	        return ResponseEntity.ok(Map.of("accessToken", token));
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return ResponseEntity.ok(Map.of("accessToken", ""));
    }
}
