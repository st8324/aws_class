import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function PostDetail(){
	//url에 있는 게시글 번호를 가져옴 /post/detail/:num으로 처리했기 때문에
	//num으로 받아옴
	let {num} = useParams();
	let [post, setPost] = useState({
		num : 1, 
		title : "샘플 제목",
		writer : "작성자", 
		content : "샘플 내용",
		date : "2026-01-28"
	});
	
	useEffect(()=>{
		//비동기 통신으로 게시글을 가져오는 함수를 선언
		const getPost = async ()=>{
			console.log("게시글 가져오는 중...");

			try{
				const response = await fetch("/api/v1/posts/" + num);
	
				if(response.ok){
					const result = await response.json();
					setPost(result);
				}
			}
			catch(e){
				console.error(e);
			}
		}
		//함수를 호출
		getPost();
	}, []);
	
	return (
		<div>
			<h1>게시글 상세</h1>
			<div>제목 : {post.title}</div>
			<div>작성자 : {post.writer}</div>
			<div>작성일 : {post.date}</div>
			<div>내용</div>
			<div>{post.content}</div>
		</div>
	)
}

export default PostDetail;