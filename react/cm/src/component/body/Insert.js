import { useState } from "react";


function Login(){

	let [user, setUser] = useState({username : '' , password : ''})

	const login = async (username, password) => {
		try {
			const response = await fetch('/api/auth/login', {
				method: 'POST',
				headers: { 'Content-Type': 'application/json' },
				body: JSON.stringify({ username, password }),
			});

			if (response.ok) {
				const data = await response.json();
				console.log(data);
				// 서버에서 받은 AccessToken 저장
				localStorage.setItem('accessToken', data.accessToken);
				alert("로그인 성공!");
			} else {
				alert("로그인 실패");
			}
		} catch (error) {
			console.error("네트워크 에러:", error);
		}
	};

	const changeHandler = e => {
		const {name, value} = e.target;
		setUser({...user, [name] : value})
	}

	const fetchLogin = e =>{
		e.preventDefault();
		login(user.username, user.password)
	}
	return(
		<div>
			<h1>로그인</h1>
			<form onSubmit={fetchLogin}>
				<input type="text" name="username" onChange={changeHandler}/> <br/>
				<input type="text" name="password" onChange={changeHandler}/> <br/>
				<button>등록</button>
			</form>
		</div>
	)
}

export default Login;