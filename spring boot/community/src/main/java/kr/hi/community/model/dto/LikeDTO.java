package kr.hi.community.model.dto;

import lombok.Data;

@Data
public class LikeDTO {
	int postNum;//추천 게시글
	int state;//추천(1)/비추천(-1)
	String id;//추천한 사용자 id
}
