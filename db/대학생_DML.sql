START TRANSACTION;
# 컴퓨터공학과를 등록 
# 코드 : 160, 사무실 : 하이미디어 구리관 401호, 이름 : 컴퓨터공학과 
INSERT INTO MAJOR(MJ_CODE, MJ_OFFICE, MJ_NAME) 
VALUES('160', '하이미디어 구리관 401호', '컴퓨터공학과');

# 디자인과를 등록 
# 코드 : 123, 사무실 : 하이미디어 구리관 301호, 이름 : 디자인과 
INSERT INTO MAJOR(MJ_CODE, MJ_OFFICE, MJ_NAME) 
VALUES('123', '하이미디어 구리관 301호', '디자인과');

# 기계공학과를 등록 
# 코드 : 456, 사무실 : 하이미디어 구리관 201호, 이름 : 기계공학과 
INSERT INTO MAJOR(MJ_CODE, MJ_OFFICE, MJ_NAME) 
VALUES('456', '하이미디어 구리관 201호', '기계공학과');

# 교수 등록
# 이름 : 홍교수, 연락처 : 111-1234-5678, 주민번호 : 700101-5111111,
# 임용연도 : 2025, 전공 : 컴퓨터공학과(160)
INSERT INTO 
PROFESSOR(PR_NUM, PR_NAME, PR_CONTACT, PR_RESIDENT, PR_YEAR, PR_MJ_CODE)
VALUES("P2025160001", "홍교수", "111-1234-5678", "700101-5111111",
2025, 160);

/*
INSERT INTO
PROFESSOR(PR_NUM, PR_NAME, PR_CONTACT, PR_RESIDENT, PR_YEAR, PR_MJ_CODE)
SELECT CONCAT("P", 2025, 160, LPAD(COUNT(*) + 1, 3, '0')),
"홍교수", "111-1234-5678", "700101-5111111",
2025, 160 FROM PROFESSOR 
WHERE PR_YEAR = 2025 AND PR_MJ_CODE = 160;
# WHERE PR_NUM LIKE CONCAT('_', 2025, 160,'%'); # 이 조건식으로 해도 결과 같음 
*/
# 교수 등록
# 이름 : 김교수, 연락처 : 111-1111-1111, 주민번호 : 710101-5222222,
# 임용연도 : 2025, 전공 : 컴퓨터공학과(160)
INSERT INTO
PROFESSOR(PR_NUM, PR_NAME, PR_CONTACT, PR_RESIDENT, PR_YEAR, PR_MJ_CODE)
SELECT CONCAT("P", 2025, 160, LPAD(COUNT(*) + 1, 3, '0')),
"김교수", "111-1111-1111", "710101-5222222",
2025, 160 FROM PROFESSOR 
WHERE PR_YEAR = 2025 AND PR_MJ_CODE = 160;

# 교수 등록
# 이름 : 박교수, 연락처 : 111-9999-9999, 주민번호 : 740505-6222222,
# 임용연도 : 2025, 전공 : 디자인과(123)
INSERT INTO
PROFESSOR(PR_NUM, PR_NAME, PR_CONTACT, PR_RESIDENT, PR_YEAR, PR_MJ_CODE)
SELECT CONCAT("P", 2025, 123, LPAD(COUNT(*) + 1, 3, '0')),
"박교수", "111-9999-9999", "740505-6222222",
2025, 123 FROM PROFESSOR 
WHERE PR_YEAR = 2025 AND PR_MJ_CODE = 123;

# 교수 등록
# 이름 : 이교수, 연락처 : 111-5555-5555, 주민번호 : 740505-6333333,
# 임용연도 : 2025, 전공 : 디자인과(123)
INSERT INTO
PROFESSOR(PR_NUM, PR_NAME, PR_CONTACT, PR_RESIDENT, PR_YEAR, PR_MJ_CODE)
SELECT CONCAT("P", 2025, 123, LPAD(COUNT(*) + 1, 3, '0')),
"이교수", "111-5555-5555", "740505-6333333",
2025, 123 FROM PROFESSOR 
WHERE PR_YEAR = 2025 AND PR_MJ_CODE = 123;

# 교수 등록
# 이름 : 최교수, 연락처 : 111-1234-5555, 주민번호 : 840505-5444444,
# 임용연도 : 2025, 전공 : 기계공학과(456)
INSERT INTO
PROFESSOR(PR_NUM, PR_NAME, PR_CONTACT, PR_RESIDENT, PR_YEAR, PR_MJ_CODE)
SELECT CONCAT("P", 2025, 456, LPAD(COUNT(*) + 1, 3, '0')),
"최교수", "111-1234-5555", "840505-5444444",
2025, 456 FROM PROFESSOR 
WHERE PR_YEAR = 2025 AND PR_MJ_CODE = 456;

# 교수 등록
# 이름 : 장교수, 연락처 : 112-1234-5555, 주민번호 : 841005-6666666,
# 임용연도 : 2025, 전공 : 기계공학과(456)
INSERT INTO
PROFESSOR(PR_NUM, PR_NAME, PR_CONTACT, PR_RESIDENT, PR_YEAR, PR_MJ_CODE)
SELECT CONCAT("P", 2025, 456, LPAD(COUNT(*) + 1, 3, '0')),
"장교수", "112-1234-5555", "841005-6666666",
2025, 456 FROM PROFESSOR 
WHERE PR_YEAR = 2025 AND PR_MJ_CODE = 456;

COMMIT;

START TRANSACTION;

# 학생 추가 
# 이름 : 홍길동, 연락처 : 012-1111-1111, 주민번호 : 060101-3, 2025, 컴퓨터공학과 
# 이름 : 고길동, 연락처 : 012-1111-1112, 주민번호 : 060209-3, 2025, 컴퓨터공학과 
# 이름 : 김길동, 연락처 : 012-1111-1113, 주민번호 : 060310-3, 2025, 컴퓨터공학과 
# 이름 : 하니, 연락처 : 012-1111-1114, 주민번호 : 060425-4, 2025, 컴퓨터공학과 
INSERT INTO STUDENT(ST_NUM, ST_NAME, ST_CONTACT, ST_RESIDENT, ST_YEAR) 
VALUES
('2025160001', '홍길동', '012-1111-1111', '060101-3', 2025),
('2025160002', '고길동', '012-1111-1112', '060209-3', 2025),
('2025160003', '김길동', '012-1111-1113', '060310-3', 2025),
('2025160004', '하니' , '012-1111-1114', '060425-4', 2025);

INSERT INTO STUDENT_MAJOR(SM_ST_NUM, SM_MJ_CODE) 
VALUES
('2025160001','160'),
('2025160002','160'),
('2025160003','160'),
('2025160004','160');

# 과목 추가 
# 컴퓨터 개론, 2학점, 2시간, 분류 : COM, 과목코드 : COM001
# 프로그래밍 언어, 3학점, 3시간, 분류 : COM, 과목코드 : COM002
# 알고리즘, 3학점, 4시간, 분류 : COM, 과모코드 : COM003

# 확률과 통계, 3학점, 3시간, 분류 : MSC, 과목코드 : MSC001 
# 미분과 적분, 4학점, 4시간, 분류 : MSC, 과목코드 : MSC002
INSERT INTO SUBJECT(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE)
VALUES
('컴퓨터 개론', 2, 2, 'COM001'),
('프로그래밍 언어', 3, 3, 'COM002'),
('알고리즘', 3, 4, 'COM003'),
('확률과 통계', 3, 3, 'MSC001' ),
('미분과 적분', 4, 4, 'MSC002');

# 강의 등록
# 컴퓨터 개론, 홍교수, 2025년 1학기, 1분반, 강의실 : 미디어관 101호, 정원 : 20
# 강의 계획서 : "강의계획서입니다.", 시간 : "월1A,1B,2A,2B"

# 프로그래밍 언어, 홍교수, 2025년 1학기, 1분반, 강의실 : 미디어관 201호, 정원 : 20
# 강의 계획서 : "강의계획서입니다.", 시간 : "화1A,1B,2A,2B"

# 프로그래밍 언어, 김교수, 2025년 1학기, 2분반, 강의실 : 미디어관 202호, 정원 : 20
# 강의 계획서 : "강의계획서입니다.", 시간 : "화1A,1B,2A,2B"
INSERT INTO LECTURE(lt_pr_num, lt_sj_code, lt_year, lt_semester, 
lt_schedule, lt_room, lt_syllabus, lt_class, lt_max) 
VALUES
('P2025160001', 'COM001', 2025, 1, '월1A,1B,2A,2B', 
'미디어관 101호', '강의계획서입니다.', 1, 20),
('P2025160001', 'COM002', 2025, 1, '화1A,1B,2A,2B', 
'미디어관 201호', '강의계획서입니다.', 1, 20),
('P2025160002', 'COM002', 2025, 1, '화1A,1B,2A,2B', 
'미디어관 202호', '강의계획서입니다.', 2, 20);

# 알고리즘, 김교수, 2025년 1학기, 2분반, 강의실 : 미디어관 301호, 정원 : 20
# 강의 계획서 : "강의계획서입니다.", 시간 : "목1A,1B,2A,2B,3A,3B"

# 확률과 통계, 최교수, 2025년 1학기, 1분반, 강의실 : 하이관 101호, 정원 : 20
# 강의 계획서 : "강의계획서입니다.", 시간 : "금1A,1B,2A,2B,3A,3B"

# 미분과 적분, 장교수, 2025년 1학기, 1분반, 강의실 : 하이관 301호, 정원 : 20
# 강의 계획서 : "강의계획서입니다.", 시간 : "목5A,5B,6A,6B,7A,7B"

INSERT INTO LECTURE(lt_pr_num, lt_sj_code, lt_year, lt_semester, 
lt_schedule, lt_room, lt_syllabus, lt_class, lt_max) 
VALUES
('P2025160002', 'COM003', 2025, 1, '목1A,1B,2A,2B,3A,3B', 
'미디어관 301호', '강의계획서입니다.', 1, 20),
('P2025456001', 'MSC001', 2025, 1, '금1A,1B,2A,2B,3A,3B', 
'하이관 101호', '강의계획서입니다.', 1, 20),
('P2025456002', 'MSC002', 2025, 1, '목5A,5B,6A,6B,7A,7B', 
'하이관 301호', '강의계획서입니다.', 2, 20);

# 홍길동(2025160001) 학생이 컴퓨터 개론, 프로그래밍언어(1), 알고리즘, 확률과 통계, 
# 미분과 적분을 수강신청 함 
INSERT INTO COURSE(CO_ST_NUM, CO_LT_NUM)
VALUES
('2025160001' , 1),('2025160001' , 2),('2025160001' , 4),
('2025160001' , 5),('2025160001' , 6),
# 고길동(2025160002) 학생이 컴퓨터 개론, 프로그래밍언어(2), 알고리즘, 확률과 통계, 
# 미분과 적분을 수강신청 함 
('2025160002' , 1),('2025160002' , 3),('2025160002' , 4),
('2025160002' , 5),('2025160002' , 6),
# 김길동(2025160003) 학생이 컴퓨터 개론, 프로그래밍언어(1) 을 수강신청 함 
('2025160003' , 1),('2025160003' , 2),
# 하니(2025160004) 학생이  프로그래밍언어(2), 알고리즘, 확률과 통계를 수강신청 함 
('2025160004' , 3),('2025160004' , 4),('2025160004' , 5);

UPDATE LECTURE 
SET
	LT_CURRENT = 
      (SELECT COUNT(*) FROM COURSE WHERE CO_LT_NUM = 1)
WHERE
	LT_NUM = 1;
UPDATE LECTURE 
SET	LT_CURRENT = 
      (SELECT COUNT(*) FROM COURSE WHERE CO_LT_NUM = 2)
WHERE LT_NUM = 2;    
UPDATE LECTURE 
SET	LT_CURRENT = 
      (SELECT COUNT(*) FROM COURSE WHERE CO_LT_NUM = 3)
WHERE LT_NUM = 3;    
UPDATE LECTURE 
SET	LT_CURRENT = 
      (SELECT COUNT(*) FROM COURSE WHERE CO_LT_NUM = 4)
WHERE LT_NUM = 4;    
UPDATE LECTURE 
SET	LT_CURRENT = 
      (SELECT COUNT(*) FROM COURSE WHERE CO_LT_NUM = 5)
WHERE LT_NUM = 5;    
UPDATE LECTURE 
SET	LT_CURRENT = 
      (SELECT COUNT(*) FROM COURSE WHERE CO_LT_NUM = 6)
WHERE LT_NUM = 6;    
COMMIT;
