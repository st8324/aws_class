# 프로시저 
# - 일련의 쿼리를 하나의 함수처럼 실행하기 위한 쿼리의 집합 
# - 장바구니에 있는 제품 여러개를 구매
#   => 제품 제고량 변경 
#   => 구매한 제품을 장바구니에서 삭제 

# 프로시저 목록 확인 
SHOW PROCEDURE STATUS;

# 프로시저 스크립트 확인 
# SAKILA DB에 있는 FILM_IN_STOCK 프로시저 확인 
USE SAKILA;
SHOW CREATE PROCEDURE FILM_IN_STOCK;
# 위 결과에서 CREATE PROCEDURE에 있는 내용 확인
# - 해당 칸 우클릭 Copy Field를 클릭하면 내용이 복사됨 
# - 다른 곳에 붙여서 확인 

# 프로시저 삭제 
# DROP PROCEDURE IF EXISTS 프로시저명;

/*
DELIMITER 기호
CREATE PROCEDURE 프로시저명( 
	[IN | OUT | INOUT 변수명 타입,]
)
BEGIN
	프로시저 구현;
END 기호 
DELIMITER ;
*/





