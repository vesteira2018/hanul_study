-- [DDL : 데이터 정의어]
-- tblMember 테이블 생성
CREATE TABLE tblMember(
  num   NUMBER,
  name  VARCHAR2(10),
  age   NUMBER,
  addr  VARCHAR2(50),
  tel   VARCHAR2(20)
);

-- tblMember 테이블 제거
DROP TABLE tblMember;

-- tblMember 테이블에 phone 필드(컬럼) 추가
ALTER TABLE tblMember ADD phone VARCHAR2(20);

-- tblMember 테이블의 phone 필드 크기 변경
ALTER TABLE tblMember MODIFY(phone VARCHAR2(15));

-- tblMember 테이블의 phone 필드 이름을 mobilephone으로 변경
ALTER TABLE tblMember RENAME COLUMN phone TO mobilephone;

-- tblMember 테이블의 mobilephone 필드 삭제
ALTER TABLE tblMember DROP COLUMN mobilephone;

-- 필드 순서를 변경하는 방법
-- 1. ALTER TABLE tblMember MODIFY (age INVISIBLE);
-- ALTER TABLE tblMember MODIFY (age VISIBLE);
-- 2. column_id를 변경

-- 임의의 레코드 삽입
INSERT INTO tblMember(num, name, age, addr, tel)
  VALUES(1, '홍길동', 30, '광주시 서구 농성동', '010-1111-1111');

INSERT INTO tblMember(tel, addr, age, num, name)
  VALUES('010-2222-2222', '광주시 남구 봉선동', 50, 2, '김길동');
  
INSERT INTO tblMember
  VALUES(3, '박길동', 40, '광주시 북구 용봉동', '010-3333-3333');
  
INSERT INTO tblMember(num, name, age)
  VALUES(4, '최길동', 60);

-- 4번 레코드의 정보를 삭제
DELETE FROM tblMember WHERE num = 4;

-- 4번 레코드의 정보를 갱신
UPDATE tblMember
  SET  addr = '광주시 광산구 신가동', tel = '010-4444-4444'
WHERE  num = 4;

-- 3번 레코드의 주소를 수정
UPDATE tblMember
  SET  addr = '서울시 강서구 화곡동'
WHERE  num = 3;

-- 전체 레코드 검색
SELECT  *
FROM    tblMember;

-- 번호, 이름, 주소만 출력
SELECT  num, name, addr
FROM    tblMember;

-- 이름이 김길동인 회원을 출력
SELECT  *
FROM    tblMember
WHERE   name = '김길동';

-- 이름이 김길동인 회원의 이름과, 나이, 주소 출력
SELECT  name, age, addr
FROM    tblMember
WHERE   name = '김길동';

-- 나이가 40세 이상인 회원만 출력
SELECT  *
FROM    tblMember
WHERE   age >= 40;

-- 나이가 40세 이상인 회원의 이름, 주소, 전화번호 출력
SELECT  name, addr, tel
FROM    tblMember
WHERE   age >= 40;

-- 나이가 30 ~ 50세 사이의 회원만 출력
SELECT  *
FROM    tblMember
WHERE   age BETWEEN 30 AND 50;

-- 주소에 특정 글자가 포함된 회원을 출력
SELECT  *
FROM    tblMember
WHERE   addr LIKE '%서구%';

SELECT  *
FROM    tblMember
WHERE   addr LIKE '광%';

SELECT  *
FROM    tblMember
WHERE   addr LIKE '%광';

-- 내장함수
SELECT SUM(age)
FROM   tblMember;

SELECT AVG(age)
FROM   tblMember;

SELECT MAX(age)
FROM   tblMember;

SELECT MIN(age)
FROM   tblMember;

SELECT age + 2
FROM   tblMember;

-- 기타연산
SELECT *
FROM   tblMember
WHERE  num IN (1, 3);

SELECT SYSDATE
FROM   dual;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD')
FROM   dual;

COMMIT;