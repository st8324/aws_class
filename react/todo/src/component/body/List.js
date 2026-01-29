import { useEffect } from "react";

/* 
비동기 통신으로 할일 목록 전체를 요청해서 가져온 후 화면에 출력
url : /api/v1/todos
method : GET
*/
function List(){

	useEffect(()=>{
		//비동기 통신으로 할일 목록 전체를 요청해서 가져오는 함수 선언

		//함수 호출

	}, []);
	return(
		<div>
			<h1>할일 목록</h1>
			<ul>
				<li>
					<span>2026-01-29</span> 
					<span>점심</span>
				</li>
			</ul>
		</div>
	)
}

export default List;