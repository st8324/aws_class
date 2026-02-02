package kr.hi.community2.security.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.hi.community2.security.jwt.JwtTokenProvider;
import kr.hi.community2.service.MemberDetailService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberDetailService userDetailsService;

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        /* 로그인 성공 후 
         * fetch에서 headers에 아래와 같이 토큰을 넣어줌 
         * 	headers : {
				"Content-Type" : "appclication/json",
				"Authorization" : "Bearer 토큰값"
			}
         * */
        //header에 Authorization고 있고, "Bearer "로 시작하면 => 토큰이 있음 
        if (header != null && header.startsWith("Bearer ")) {
        	//"Bearer "를 제외한 나머지를 추출 => 토큰
            String token = header.substring(7);

            Claims claims = jwtTokenProvider.parseClaims(token);
            String username = claims.getSubject();

            UserDetails userDetails =
            		userDetailsService.loadUserByUsername(username);

            Authentication auth = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );

            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }
}
