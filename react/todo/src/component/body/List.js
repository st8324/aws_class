import { useEffect, useState } from "react";
import "./List.css";
/* 
비동기 통신으로 할일 목록 전체를 요청해서 가져온 후 화면에 출력
url : /api/v1/todos
method : GET
*/
function List(){
	let [todos, setTodos] = useState([]);
	//목록을 새로고침할 때 사용할 변수
	let [isReload, setIsReload] = useState(true);

	useEffect(()=>{
		
		if(isReload){
			getTodos();
		}

	}, [todos]);

	//비동기 통신으로 할일 목록 전체를 요청해서 가져오는 함수 선언
	const getTodos = async ()=>{
		try{
			//선택한 날짜를 가져옴. 전체조회이면 빈문자열을, 날짜를 선택하면 선택한 날짜를 전송

			const response = await fetch("/api/v1/todos?date=" + "선택한 날짜",{
				method : "GET",
				// headers : {
				// 	"Content-Type" : "application/json"
				// },
				// body : { date : "선택한 날짜"}
			});

			if(response.status == 200){
				const result = await response.json();
				setTodos(result);
				setIsReload(false);
			}
		}catch(e){
			console.error(e);
		}
	}

	const btnClick = (num)=>{
		
		//비동기 통신으로 삭제 요청하는 함수를 선언
		const sendDeleteTodo = async()=>{
			try{
				const response = await fetch("/api/v1/todos/" + num, {
					method : "DELETE"
				});

				if(response.status === 200){
					const result = await response.json();
					if(result){
						alert("할일을 삭제했습니다.");
						//화면에서 목록 삭제
						//삭제한 할일 번호와 일치하지 않은 할일들만 찾음
						//화면에서 바로 제거
						setTodos(todos.filter(item=>item.num !== num));
						//db에서 가져와서 다시 재배치
						setIsReload(true);
					}else{
						alert("할일을 삭제하지 못햇습니다.");
					}
				}
			}catch(e){
				console.error(e);
			}
		}

		//함수 호출
		sendDeleteTodo();
	}

	return(
		<div>
			<h1>할일 목록</h1>
			{/* 날짜와 상관없이 전체 조회 */}
			<button>전체 조회</button>
			{/* 날짜를 선택하면 선택한 날짜에 맞는 할일을 조회 */}
			<input type="date" />
			{
				todos.length == 0 
				? 
				<h3>등록된 할일이 없습니다.</h3>
				: 
				<Todos todos={todos} delBtnClick={btnClick} />
			}
		</div>
	)
}

function Todos({todos, delBtnClick}){
	return (
		<ul className="todo-list">
			{
			todos.map(todo=>{
					return (
						<li key={todo.num} className="todo-item">
							<span className="todo-date">{todo.date}</span>
							<span className="todo-text">{todo.text}</span>
							<button className="todo-btn" onClick={()=>delBtnClick(todo.num)}>&times;</button>
						</li>
					)
				})
			}
		</ul>
	);
}

export default List;