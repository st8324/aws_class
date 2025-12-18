# 학과별 등록된 교수 수를 조회
SELECT MAJOR.*, COUNT(PR_NUM) 교수수 FROM MAJOR 
	LEFT JOIN PROFESSOR ON MJ_CODE = PR_MJ_CODE
    GROUP BY MJ_CODE;
    
# 2025년도에 컴퓨터공학(160)에 임용한 교수 수를 조회
SELECT COUNT(*) FROM PROFESSOR 
WHERE PR_NUM LIKE CONCAT('_', 2025, 160,'%');

# 컴퓨터공학과 학생들을 조회 
# 컴퓨터공학과의 학과 코드인 160을 이용하여 조회 

# 방법1 : 학번에 학과코드 위치에 있는 값을 가져와서 160인지 확인  
SELECT * FROM STUDENT WHERE SUBSTRING(ST_NUM, 5, 3) = 160;

# 방법2 : 학생전공을 JOIN하여 학생 전공이 160공인 학생을 조회
SELECT * FROM STUDENT 
	JOIN STUDENT_MAJOR ON ST_NUM = SM_ST_NUM
    WHERE SM_MJ_CODE = 160;

# 방법3 : 학생전공 테이블을 서브쿼리로 이용하여 조회 
SELECT * FROM STUDENT 
WHERE
	# 일치하는 학생들을 조회 
	ST_NUM IN(
		# 학생 전공 테이블에서 컴퓨터공학과인 학생들의 학번들을 가져와서
		SELECT SM_ST_NUM 
        FROM STUDENT_MAJOR 
        WHERE SM_MJ_CODE = 160) ;
	# ST_NUM IN ('2025160001','2025160002','2025160003','2025160004')
    
# 학과별 등록된 학생수를 조회(학과 정보 + 학생수)
SELECT MAJOR.*, COUNT(SM_ST_NUM) 학생수 
FROM MAJOR
	LEFT JOIN STUDENT_MAJOR 
    ON MAJOR.MJ_CODE/*기본키*/ = STUDENT_MAJOR.SM_MJ_CODE/*외래키*/
    GROUP BY MJ_CODE;










