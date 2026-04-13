import { Link } from "react-router-dom"
import './ChatBot.css'

function ChatBot(){
	return (
		<div>
			<Link to="/">메인으로</Link>
			{/* 
			아래에 다음을 만족하는 화면을 간단하게 구현하세요. 
			1. 채팅목록
			2. 채팅입력
			3. 전송
			*/}
			<div className="chat-container">
				<div className="chat-body">
					<div className="chat-me">
						<div className="chat-content">오늘은 날씨가 좋아</div>
					</div>
					<div className="chat-bot">
						<div className="chat-content">네 날씨가 좋네요네 날씨가 좋네요네 날씨가 좋네요네 날씨가 좋네요네 날씨가 좋네요네 날씨가 좋네요</div>
					</div>
					<div className="chat-me">
						<div className="chat-content">오늘은 날씨가 좋아</div>
					</div>
					<div className="chat-bot">
						<div className="chat-content">네 날씨가 좋네요</div>
					</div>
				</div>
				<form className="chat-footer">
					<input type="text" name="msg" className="chat-input" />
					<button className="btn btn-chat-submit">전송</button>
				</form>
			</div>
		</div>
	)
}

export default ChatBot