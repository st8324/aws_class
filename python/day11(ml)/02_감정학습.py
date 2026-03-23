# konlpy를 import할 때 생기는 에러 처리를 위한 초기화
def init(java_path:str):
	import jpype
	import os

	# 켜져 있다면 완전히 끄기
	if jpype.isJVMStarted():
			jpype.shutdownJVM()

	#환경 변수를 코드 상단에서 다시 세팅
	os.environ['JAVA_HOME'] = java_path

init(r'C:\Users\hi6\Documents\JAVA CLASS\IDE\JDK\jdk_21')

import pandas as pd 
from konlpy.tag import Okt
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.linear_model import LogisticRegression
import joblib as jl

# 문장에서 명사, 동사, 형용사면 원형을 추출해서 문장을 만들어 반환
def text_preprocessing(text):
	okt = Okt()
	result = okt.pos(text, stem=True)
	words = [word for word, pos in result if pos in  ['Noun', 'Verb', 'Adjective']]
	return " ".join(words)

def train_and_save_model(dataset_x, dataset_y):

	# 형태소 분리
	dataset_pp_x = dataset_x.apply(text_preprocessing)
	#벡터화 
	vectorizer = TfidfVectorizer()
	# 독립, 종속 분리
	X = vectorizer.fit_transform(dataset_pp_x)
	y = dataset_y
	# 학습
	model = LogisticRegression()
	model.fit(X, y)
	# 모델과 벡터라이저를 저장
	model_data = {
		'vectorizer' : vectorizer, 
		'model' : model
	}
	jl.dump(model_data, 'model.pkl')

if __name__ == '__main__':
	# print(text_preprocessing("오늘은 날이 너무 너무 좋습니다."))
	df = pd.read_csv(r'sample.csv')
	train_and_save_model(df['sentence'], df['label'])
	pass