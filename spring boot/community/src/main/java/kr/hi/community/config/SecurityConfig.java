package kr.hi.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import kr.hi.community.model.util.UserRole;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
		//암호화 하는 클래스
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf ->csrf.disable())
            .authorizeHttpRequests((requests) -> requests
        		//로그인한 사용자(USER)만 접근할 수 있는 URL 설정
                .requestMatchers("/post/insert/*").hasAuthority(UserRole.USER.name())
                //로그인한 관리자(ADMIN)만 접근할 수 있는 URL 설정
                .requestMatchers("/admin/**").hasAnyAuthority(UserRole.ADMIN.name())
                .anyRequest().permitAll()  //그 외 나머지 URL은 모든 사용자가 접근
            )
            .formLogin((form) -> form
            	//스프링 시큐리티가 제공하는 기본 로그인 화면 안쓰고 만들어써 쓸 경우
            	//연결할 URL 지정
                .loginPage("/login")
                //모든 사용자가 로그인 페이지에 접근하도록 허용
                .permitAll()           
                //로그인 처리할 URL을 지정. method는 post
                .loginProcessingUrl("/login")
                //로그인 성공후 URL
                .defaultSuccessUrl("/")
            )
            .logout((logout) -> logout
            	//로그아웃 처리 URL을 지정. 방식은 post	
        		.logoutUrl("/logout")
        		//로그아웃 성공시 이동할 URL을 지정
        		.logoutSuccessUrl("/")
        		//인증을 비움
        		.clearAuthentication(true)
        		//세션을 만료
        		.invalidateHttpSession(true)
        		//로그아웃을 모든 사용자가 접근하도록 허용
        		.permitAll());  
        return http.build();
    }
    
}