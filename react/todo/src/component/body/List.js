import { useEffect, useState } from "react";

/* 
비동기 통신으로 할일 목록 전체를 요청해서 가져온 후 화면에 출력
url : /api/v1/todos
method : GET
*/
function List(){
	let [todos, setTodos] = useState([
		{ num : 1, text : "점심", date : "2026-01-29", order : 1}, 
		{ num : 2, text : "4교시", date : "2026-01-29", order : 2}, 
	]);
	useEffect(()=>{
		//비동기 통신으로 할일 목록 전체를 요청해서 가져오는 함수 선언
		const getTodos = async ()=>{
			try{
				const response = await fetch("/api/v1/todos",{
					method : "GET",
					// headers : {
					// 	"Content-Type" : "application/json"
					// },
					// body : JSON.stringify({})
				});

				if(response.status == 200){
					const result = await response.json();
					console.log(result);
				}
			}catch(e){
				console.error(e);
			}
		}
		//함수 호출
		getTodos();
	}, []);
	return(
		<div>
			<h1>할일 목록</h1>
			<ul>
				{
					todos.map(todo=>{
						return (
							<li key={todo.num}>
								<span>{todo.date}</span>
								<span>{todo.text}</span>
							</li>
						)
					})
				}
			</ul>
		</div>
	)
}

export default List;