import { useEffect, useState } from "react";
import "./List.css";
/* 
비동기 통신으로 할일 목록 전체를 요청해서 가져온 후 화면에 출력
url : /api/v1/todos
method : GET
*/
function List(){

	let [user, setUser] = useState({ id : '', pw : '', email : ''})
	
	const fetchUser = async () =>{
		const response = await fetch("/api/v1/auth/signup",{
			method : "post",
			headers : {
				"Content-Type" : "application/json"
			},
			body : JSON.stringify(user)
		});

		if(response.ok){
			const res = await response.json();
			if(res){
				alert("회원 가입 성공!");
			}
			else{
				alert("회원 가입 실패!");
			}
		}
	}

	const submitHandler = (e) =>{
		e.preventDefault();
		fetchUser();
		try{

		}catch(e){
			console.error(e);
		}
	}

	const changeHandler = e => {
		const {name, value} = e.target;
		setUser({...user, [name] : value})
	}
	return(
		<div>
			<h1>회원가입</h1>
			<form onSubmit={submitHandler}>
				<input type="text" name="id" onChange={changeHandler}/> <br/>
				<input type="text" name="pw" onChange={changeHandler}/> <br/>
				<input type="text" name="email" onChange={changeHandler}/> <br/>
				<button>회원가입</button>
			</form>
			
		</div>
	)
}

export default List;