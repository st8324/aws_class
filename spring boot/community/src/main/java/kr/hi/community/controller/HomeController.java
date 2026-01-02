package kr.hi.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.hi.community.dao.MemberDAO;

@Controller
public class HomeController {

	/* Get : URL을 직접 입력하거나, 링크를 클릭해서 이동했을 때 대부분 Get.
	 * Post: 값을 입력하여 중요한 정보를 전송할 때(form태그 + method=post)
	 * */
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
}
