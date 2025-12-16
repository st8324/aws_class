# DCL : 데이터 조작어
# - 사용자 추가/삭제, 권한 부여/회수 

# 사용자 추가 
# - CREATE USER '아이디'@'호스트' IDENTIFIED BY '비번';
# - 호스트 : 접근 권한 
#   - localhost : 내부에서만 접근 가능 => 다른 PC에서 해당 계정으로 접근 못함 
#   - % : 외부에서도 접근 가능 
CREATE USER 'abc123'@'%' IDENTIFIED BY 'abc123';

# 사용자 조회 
SELECT USER, HOST FROM MYSQL.USER;

# 사용자 비번 변경 
# SET PASSWORD FOR '아이디'@'호스트' = '새비번';

