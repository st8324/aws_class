# 내장 함수
# if(수식, 수식1, 수식2) : 수식이 참이면 수식1을, 거짓이면 수식2를 반환 
SELECT IF(2>1, 2, 1);

# IFNULL(수식1, 수식2) 
# - 수식1이 NULL이 아니면 수식1을, NULL이면 수식2를 반환 
# - 수식1값이 NULL일 때 어떻게 처리할지를 정할 때 사용 
SELECT IFNULL(NULL, 0) , IFNULL(1, 0);

# NULLIF(수식1, 수식2) : 수식1과 수식2가 같으면 NULL, 다르면 수식1을 반환 
SELECT NULLIF(1,1), NULLIF(1,0);

# CASE 속성
# 	WHEN 값1 THEN 결과
# 	WHEN 값2 THEN 결과
#	ELSE 결과
# END
USE SHOPPINGMALL2;
SELECT CASE NUM 
	WHEN 1 THEN "악세서리"
    ELSE "기타"
END 결과 FROM PRODUCT;

# CASE 
# WHEN 조건 THEN 결과
# ELSE 결과 
# END 
SELECT PRODUCT.*, CASE  
	WHEN PRICE > 50000 THEN "비쌈"
    ELSE "적당함"
END 결과 FROM PRODUCT;



