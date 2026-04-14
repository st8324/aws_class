from google import genai
from google.genai import types
from fastapi import FastAPI, Query
import uvicorn

app = FastAPI()

# gemini-2.5-flash-lite
GOOGLE_API_KEY = ""
GOOGLE_MODEL_NAME = "gemini-2.5-flash-lite"
client = genai.Client(api_key=GOOGLE_API_KEY)


@app.get("/ask")
async def ask_gemini(prompt: str):
	
	response = client.models.generate_content(
    model= GOOGLE_MODEL_NAME,
    contents=types.Part.from_text(text=prompt),
	)
	
	return {
		"question": prompt,
		"answer": response.text
	}

@app.get("/translate")
async def translate(
	text:str = Query(..., description='번역할 문장'),
	style:str =  Query("formal", description='말투: formal(격식), casual(반말), business(비즈니스)')
):

	# 좋은 번역을 위하여 번역 문장을 좋은 프롬프트로 변환
	# I am a boy => 나는 소년이다
	# f : 문자열 안에 변수를 쉽게 넣을 때 사용
	# """ : 문자열이 여러줄이 가능하게 해줌
	prompt = f"""
	너는 세계 최고의 다국어 번역가야. 아래의 규칙을 지켜서 번역해줘.
	1. 대상 문장 : {text}
	2. 요청 말투 : {style} 말투로 번역해줘.
	3. 도착어 : 한국어면 영어로, 영어이면 한국어로 자동 감지해서 번역해줘.
	4. 결과물 : 번역된 문장 외에 다른 설명은 생략해
	"""
	# Have you heard of that? I was the only one who didn’t know.
	# => "그것에 대해 들어본 적 있어요? 나만 몰랐어요."
	# => casual : "너 그거 들어봤어? 나만 몰랐어."
	response = client.models.generate_content(
    model=GOOGLE_MODEL_NAME,
    contents=types.Part.from_text(text=prompt),
	)

	return {
		"answer": response.text
	}

@app.get("/ad-copy")
def ad_copy(
	product:str = Query(..., description='상품명'),
	feature:str = Query(..., description='제품 특징'),
	target:str = Query('전연령', description='타겟'),
	# 1과 가까울수록 창의적
	temp:float = Query(0.8, ge=0.0, le=1.0, description='창의성 온도(0~1)')
):
	prompt = f"""

	"""

	response = client.models.generate_content(
    model=GOOGLE_MODEL_NAME,
    contents=types.Part.from_text(text=prompt),
    config=types.GenerateContentConfig(
        temperature=temp,
        top_p=0.95,
        top_k=20,
    ),
	)
	return { 'answer' : response.text}

if __name__ == '__main__':
	uvicorn.run('main:app',host='0.0.0.0', port=8000, reload=True)