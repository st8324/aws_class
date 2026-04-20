import { useState } from "react"
import { Link } from "react-router-dom"
import { fetchPost } from "./Ai"

function RagChatBot(){
	return(
		<div>
			<Link to="/list">뒤로가기</Link>
			<h1>Rag 챗봇</h1>
			<IngestPdf/>
			<hr />
			<RagAsk/>
		</div>
	)
}
// 규정집 등록(pdf만)
function IngestPdf(){
	const [file, setFile] = useState(null)

	const submitHandler = async (e)=>{
		e.preventDefault()
		const formData = new FormData();
		//부트에서 받을 이름 pdfFile
		formData.append("pdfFile", file)
		console.log(file)
		//전송
		await fetchPost("/api/v1/ai/ingest-pdf",{
			method : 'post',
			body : formData
		},"json", (res)=>{
			alert(res.message)
		})
	}
	const fileChange = (e) =>{
		setFile(e.target.files[0])
	}
	return (
		<form onSubmit={submitHandler}>
			<input type="file" name="file" accept=".pdf" onChange={fileChange}/>
			<button>정규집 등록</button>
		</form>
	)
}
//규정집에 있는 내용 질문
function RagAsk(){
	return(
		<div>

		</div>
	)
}

export default RagChatBot