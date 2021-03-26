--사용자 정보 확인
SELECT  username
FROM    dba_users;

--전체 테이블 조회
SELECT  *
FROM    user_tables;

pl/sql developer 사용자 환경 설정.
SQL developer 도구 글꼴 변경 
- 도구 > 환경설정... > 코드 편집기 > 글꼴 > 글꼴 크기
SQL developer 창 초기화 : 창 > 팩토리 설정으로 창 재설정

SQL에디터에서 줄번호 보이게 설정
 - 도구 > 환경설정 > 코드 편집기 > 행 여백 > 행 번호 표시에 체크.
 
4. 모델러
3. 튜너
2. DBA
1. DB엔지니어 ☞ 3~5년

오라클  : MySQL 합병, 유료화
MariaDB : 새로 창업, 구글과 연동(리눅스에서 기본 사용)

오라클 사용 가능 OS : 윈도우, 리눅스(리눅스에서 Maria DB를 기본으로 사용), UNIX

오라클에서는 user자체가 DB : cf) MySQL에서는 데이터베이스로 표현
오라클에서는 dba_users 테이블에 있는 username 이 하나의 데이터 베이스

※ 데이터베이스 설계
1. 요구사항 분석 	        ☞ 요구사항명세서
2. 개념적 설계			    ☞ ER 다이어그램
3. 논리적 설계			    ☞ 릴레이션 스키마, attribute, tuple
4. 물리적 설계(구현)	    ☞ 물리적 스키마, column, row

-----------------------------------------------------------------------------------------------
※ 오라클 버전
 8i : 이때부터 8080포트 사용
 9i : 
10g : g ☞ 그리드 컴퓨팅, 
      휴지통 개념 생김. 그래서, purge생김, drop table 테이블명 purge;
      10g ☞ 한글 2바이트
11g : 11g부터 한글 3바이트
12c : c ☞ 클라우드 서비스
 :
 :
19c
-----------------------------------------------------------------------------------------------
1521 : 기본 DB포트
8080 : 톰캣이 기본으로 사용
tomcat : WAS(Web Application Server)의 종류

Oracle XE버전 사용(Standard하고는 다름)
Orccle DB : 램 1기가 사용
설치는 쉽지만 제거는 어려움
오라클 사이트에서 reinstall 다운로드 받아 제거

※ 오라클 종류
- Database Standard Edition 2(SE2) : 가장 기본적인 DB 제품. CPU 소켓 2개까지만 사용이 가능하고 그 이상일 경우 EE로 구입해야함. 
        SE2에서는 Real Application Cluster(RAC : 관리 컨트롤) 옵션만 지원. 
- Database Enterprise Edition(EE) : 고사양 서버에서 사용가능한 기업용 DB. 
        SE2에서 지원되지 않는 모든 옵션이 지원 가능.
- Database Express Edition(XE) : 개발용, 교육용 등으로 무료사용이 가능한 DB.
        상업용도로 판매하는 것은 불가능.
- Database Personal Edition(PE) : 개인용 PC에서 사용할 수 있는 DB. 네트워크 연결이 되어 있지 않은 환경에서 사용 가능. 
        총판 통해 판매되고 있음.
- WebLogic Server
- Business Analyst
- Big Data(Big Data Appliance랑 다름)


SQL  : Structured Query Language
조회(Query Language): SELECT
조작 DML(Data Manipulation Language): INSERT, UPDATE, DELETE
       DML : SELECT, INSERT, UPDATE, DELETE
정의 DDL(Data Definition Language): CREATE, DROP, ALTER, TRUNCATE, RENAME
권한제어 DCL(Data Control Language): GRANT, REVOKE
트랜잭션제어 TCL (Transaction Control Language): COMMIT, ROLLBACK

※ SQL문의 작성 방법
SQL문은 대소문자를 구분하지 않고(안의 데이터만 구분) 
일반적으로 절 단위로 줄바꿈을 하여 쓴다.
문장의 끝에 세미콜론(;) 을 기술하여 명령의 끝을 표시한다.

DML만 commit 실행, 나머지는 auto commit 됨.
commit : 트랜잭션(묶음, 덩어리) 완료, 확정

CREATE USER hanul
IDENTIFIED BY 0000;

GRANT   CONNECT,
        RESOURCE,
        CREATE VIEW
TO      hanul;



○ SQL 명령어
- 데이터베이스에서 자료를 검색하고 수정하고 삭제하는 등을 위한 데이터베이스 언어이다.
- 관계형 데이터베이스를 처리하기 위해 고안된 언어이다.
- 독자적인 문법을 갖는 DB표준 언어이다.(ISO에 의해서 지정)
- 대다수 데이터베이스는 SQL을 사용하여 데이터를 조회, 입력, 수정, 삭제한다.

※ SQL 명령문의 종류
DQL : Data Query Language(질의어), SELECT
DML : Data Manipulation Language(데이터 조작어), INSERT, UPDATE, DELETE
DDL : Data Definition Language(데이터 정의어), CREATE, ALTER, DROP, TRUNCATE, RENAME
TCL : Transaction Control Language(트랜젝션 처리어), COMMIT, ROLLBACK, SAVEPOINT
DCL : Data Control Language(데이터 제어어), GRANT, REVOKE

-----------------------------------------------------------------------------------------------
DQL - SELECT문 ☞ 저장된 데이터를 조회

DML - INSERT문 ☞ 새로운 데이터를 삽입
DML - UPDATE문 ☞ 기존의 데이터를 변경
DML - DELETE문 ☞ 기존의 데이터를 삭제

DDL - CREATE문 ☞ 새로운 테이블을 생성
DDL - ALTER문  ☞ 기존의 테이블을 변경(컬럼 추가, 컬럼 크기 변경 등)
DDL - TRUNCATE문 ☞ 객체내의 데이터를 삭제
        DML의 DELETE문과의 차이점 : TCL의 ROLLBACK으로 삭제하기 이전 상태로 되돌릴 수 없다.
DDL - DROP문 ☞ 기존 테이블을 삭제할 때 사용
        테이블의 내용과 구조 자체를 모두 제거한다.
DDL - RENAME문 ☞ 기존의 테이블의 이름을 변경

TCL - COMMIT ☞ 변경된 내용을 영구 저장
TCL - ROLLBACK  ☞ 변경되기 이전 상태로 되돌림
TCL - SAVEPOINT ☞ 특정 위치까지는 영구 저장 혹은 이전 상태로 되돌릴 수 있도록 
        트랜잭션 중에 저장점을 만들 때 사용

DCL - GRANT문 ☞ 사용자에게 특정 권한을 부여할 때 사용
DCL - REVOKE문 ☞ 사용자에게 부여했던 특정 권한을 제거할 때 사용
-----------------------------------------------------------------------------------------------

○ SQL*PLUS 명령어
- 툴에서 출력 형식을 지정하는 등 환경을 설정한다.
- SQL 명령문을 저장하거나 편집 기능을 제공한다.
- 컬럼이나 데이터의 출력형식을 지정하며, 환경을 설정하는 기능을 포함한다.
- SQL 문을 실행시키고 그 결과를 볼 수 있도록 오라클에서 제공하는 툴이다.
-----------------------------------------------------------------------------------------------
  SQL 문                                    |  SQL*PLUS 문(SQL + 툴 자체명령)
-----------------------------------------------------------------------------------------------
- 관계형 DB의 ANSI 표준 언어                |  - SQL 문을 실행시킬 수 있는 오라클의 툴(도구)
- 여러 줄 실행                              |  - 한 줄 실행 
- 종결문자(;)의 사용으로 여러줄을 사용해도  |  - 종결문자(;)가 없기 때문에 여러줄을 사용할려면 
  끝에 종결문자(;)를 넣으면 한줄로 인식     |    연결문자(-)를 사용해 주어야함
- 키워드 단축 불가                          |  - 키워드 단축 가능
- 버퍼에 마지막 명령문 저장                 |  - 버퍼 저장 안함
-----------------------------------------------------------------------------------------------

※ SQL과 PL/SQL, SQL*Plus의 차이점
- SQL      : 관계형 데이터베이스에 저장된 데이터에 Access하기 위하여 사용하는 표준언어 이다.
- PL/SQL   : SQL문을 사용하여 프로그램을 작성할 수 있도록 확장해 놓은 
             오라클의 Procedural Language 이다.
- SQL*Plus : SQL 및 PL/SQL 문장을 실행할 수 있는 환경을 제공하는 오라클의 Tool 이다.
-----------------------------------------------------------------------------------------------

--tblMember테이블 생성
CREATE TABLE tblMember (
  num NUMBER,
  name VARCHAR2(10),
  age NUMBER,
  addr VARCHAR2(50),
  tel VARCHAR2(20)
);

--tblMember 구조보기
DESC tblMember;

--레코드 삽입
INSERT INTO tblMember(num, name, age, addr, tel)
VALUES (1,'홍길동',30,'광주시 서구 농성동','010-1111-1111');

INSERT INTO tblMember
VALUES (2,'김길동',27,'광주시 서구 쌍촌동','010-2222-2222');

SELECT  *
FROM    tblMember;

--메모리에 입력된 내용을 최종적으로 저장(DB에 반영)
COMMIT;

--tblMember테이블에 phone 필드 추가
ALTER TABLE tblMember
ADD   phone VARCHAR2(10);

DESC tblMember;

--tblMember테이블에 phone 필드 크기 변경
SELECT  *
FROM    tblMember;

ALTER TABLE tblMember
MODIFY  phone VARCHAR2(20);

DESC tblMember;

--tblMember테이블에 phone 필드의 이름을 mobilephone으로 변경
ALTER   TABLE tblMember
RENAME  COLUMN phone TO mobilephone;

DESC tblMember;

--tblMember테이블에 mobilephone 필드 삭제
ALTER TABLE tblMember
DROP COLUMN mobilephone;

DESC tblMember;

-tblMember 테이블 제거
DROP TABLE tblMember;

DESC tblMember;

--tblMember 테이블 복구
FLASHBACK TABLE tblMember TO BEFORE DROP;

--[DML]데이터 조작어
--레코드 삽입

INSERT INTO tblMember(num, name, age, addr, tel)
VALUES (1,'홍길동',30,'광주시 서구 농성동','010-1111-1111');

INSERT INTO tblMember(tel, addr, age, num, name)
VALUES ('010-2222-2222','광주시 서구 쌍촌동', 27, 2, '김길동');

INSERT INTO tblMember
VALUES (3, '박길동', 47, '광주시 북구 용봉동','010-3333-3333');

INSERT INTO tblMember (num, name, age)
VALUES (4,'이순신',55);

--tblMember 조회
SELECT *
FROM  tblMember;

--4번 레코드 정보를 갱신
UPDATE  tblMember
SET     addr = '광주시 광산구 신가동', tel = '010-4444-4444'
WHERE   num = 4;

--tblMember 조회
SELECT *
FROM  tblMember;

3번 레코드 주소를 '서울시 강서구 화곡동'으로 수정
UPDATE  tblMember
SET     addr = '서울시 강서구 화곡동'
WHERE   num = 3;

--tblMember 조회
SELECT *
FROM  tblMember;

COMMIT;

--4번 레코드 삭제
DELETE FROM tblMember
WHERE num = 4;

ROLLBACK;

--번호, 이름, 주소만 출력
SELECT num, name, addr
FROM tblMember;

--이름이 '김길동'인 회원의 이름, 나이, 주소 출력
SELECT name, age, addr
FROM tblMember
WHERE name='김길동';

--나이가 40세 이상인 회원만 출력(비교 연산자 사용)
SELECT *
FROM tblMember
WHERE age >= 40;

--나이가 30세~50세 사이의 회원만 출력
SELECT  *
FROM    tblMember
WHERE   age >= 30 AND age <= 50;

--주소에 특정 글자가 포함된 회원을 출력(LIKE연산자)
SELECT *
FROM tblMember;

--주소에서 서구가 포함된 레코드 출력
SELECT  *
FROM    tblMember
--WHERE   addr='서구';

--WHERE   addr LIKE '%서구'; --서구로 끝나는 것
--WHERE   addr LIKE '서구%'; --서구로 시작하는 것
WHERE   addr LIKE '%서구%'; --서구를 포함하는 것

