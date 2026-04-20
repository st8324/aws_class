import { Link } from "react-router-dom"

function RagChatBot(){
	return(
		<div>
			<Link to="/list">뒤로가기</Link>
			<h1>Rag 챗봇</h1>
			<IngestPdf/>
			<RagAsk/>
		</div>
	)
}
// 규정집 등록(pdf만)
function IngestPdf(){
	return (
		<div>
			{/* 첨부파일 선택 후 "규정집 등록" 버튼을 클릭하면 규정집이 등록되도록 작업
			결과를 alert()으로 띄움 */}
		</div>
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