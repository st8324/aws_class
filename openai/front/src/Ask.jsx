import { useState } from "react"
import {sendData} from "./Ask"

function Ask(){

	const [form, setForm] = useState({prompt : ''})
	const [result, setResult] = useState('')

	//이벤트 함수들
	const formSubmit = (e)=>{
		e.preventDefault()

		if(form.prompt.trim() === ''){
			alert("내용을 입력하세요.")
			return
		}
		
		sendData(form, (datas)=>{
			setResult(datas.message)
			setForm({...form, prompt : ''})
		})

	}
	const inputChange = (e)=>{
		const {name, value} = e.target
		setForm({...form, [name] : value})
	}

	return (
		<div>
			<h1>기본 ai 테스트 페이지</h1>
			<form style={{display:'flex'}} onSubmit={formSubmit}>
				<textarea name="prompt" rows={5} cols={30} 
					onChange={inputChange}
					value={form.prompt}></textarea>
				<button>전송</button>
			</form>
			<h1>결과</h1>
			<div style={{border:"1px solid black", minHeight : "200px"}}>{result}</div>
		</div>
	)
}

export default Ask