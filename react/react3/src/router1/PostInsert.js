
function PostInsert(){
	//등록 버튼 누르면 입력된 정보를 받아옴
	return (
		<div>
			<h1>게시글 등록</h1>
			<form>
				<input type="text" name="title" placeholder="제목 입력" />
				<br/>
				<input type="text" name="writer" placeholder="작성자 입력" />
				<br/>
				<textarea name="content" placeholder="내용 입력"></textarea>
				<br/>
				<button>등록</button>
			</form>
		</div>
	)
}

export default PostInsert;