----------------------------------------------------------------------------------------------------
--1. 입력테이블 : 회원관리테이블 생성 후 테이블 구조 확인
  CREATE  TABLE member (
      id  VARCHAR2(50) PRIMARY KEY NOT NULL,
password  VARCHAR2(50) NOT NULL,
    name  VARCHAR2(20) NOT NULL,
   phone  VARCHAR2(13),
   email  VARCHAR2(50),
joindate  DATE NOT NULL
);

DESCRIBE member;

SELECT * FROM member;

----------------------------------------------------------------------------------------------------

--2. 샘플데이터 입력 후 COMMIT 하고 난 후 회원정보 조회

--1)홍길동 입력
INSERT INTO member
  VALUES('hong', 'hong1234', '홍길동', '062-1234-5678',
  'hong@naver.com', '2020-01-10');

--2)심청 입력
INSERT INTO member
  VALUES('sim', 'simsim', '심청', '',
  'sim@daum.net', '2020-01-12');

--3)박문수 입력
INSERT INTO member
  VALUES('park', 'park', '박문수', '010-5678-1234',
  'park@naver.com', '2020-01-12');

--4)전우치 입력
INSERT INTO member
  VALUES('jeon', 'jeon9876', '전우치', '010-4252-9876',
  'jeon@gmail.com', '2020-01-14');

--5)박자바 입력
INSERT INTO member
  VALUES('java', 'park', '박자바', '032-8520-3697',
  'java@hrd.co.kr', '2020-01-14');
  
----------------------------------------------------------------------------------------------------

--3. 정보변경 후 COMMIT 하고 난 후 회원 정보 조회
UPDATE member
SET    phone='02-4567-3210', email='sim02@daum.net'
WHERE  id = 'sim';
  
UPDATE member
SET    phone='', email='jeon@naver.com'
WHERE  id = 'jeon';

COMMIT;

----------------------------------------------------------------------------------------------------

--4. 정보삭제 후 COMMIT 하고 난 후 회원 정보 조회
DELETE  member
WHERE   id = 'java';

COMMIT;
----------------------------------------------------------------------------------------------------

--5. 조회

--1) 성명이 홍길동인 회원정보를 조회하는 SQL을 작성
SELECT  *
FROM    member
WHERE   name LIKE '홍길동';

--2) 전화번호가 없는 회원정보를 조회하는 SQL을 작성
SELECT  *
FROM    member
WHERE   phone IS NULL;


--3) naver 이메일을 사용하는 회원정보를 조회하는 SQL을 작성
SELECT  *
FROM    member
WHERE   email LIKE ('%naver.com');


--4) 가장 최근에 가입한 회원정보를 조회하는 SQL을 작성
SELECT  *
FROM    member
WHERE   joindate = (SELECT MAX(joindate) FROM member);


--5) 가입일자별로 가입한 회원수를 파악할 수 있도록 가입일자, 회원수를 조회하는 SQL을 작성 
SELECT    joindate, COUNT(*) su
FROM      member
GROUP BY  joindate;

----------------------------------------------------------------------------------------------------