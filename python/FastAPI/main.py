from fastapi import FastAPI, UploadFile
import uvicorn
import mnist_learning as ml

app = FastAPI()

@app.get('/')
async def index():
	return {"msg" : "Hello FastAPI"}

@app.post('/text')
async def text(file:UploadFile): 
	print(f'URL : /text')

	return {"msg" : "Hello FastAPI"}

if __name__ == '__main__':
	# reload=True 사용시 주의 사항.
	# 자동으로 변경 사항을 적용하면 시간이 오래 걸리는 경우 안 쓰는 것이 좋음
	uvicorn.run('main:app', port=8000, reload=True)