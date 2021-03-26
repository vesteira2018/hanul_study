--내장함수 (COUNT, SUM, AVG, MAX, MIN)
SELECT  COUNT(name) AS nameCnt--name 필드 갯수, AS 별명
FROM  tblMember;

SELECT  COUNT(name) nameCnt--name 필드 갯수
FROM  tblMember;

SELECT  COUNT(name) 인원수--name 필드 갯수
FROM  tblMember;

SELECT  COUNT(name) "우리 구성원수"--name 필드 갯수
FROM  tblMember;

SELECT  SUM(age) ageSum --age합계
FROM  tblMember;

SELECT  MAX(age) ageMax --age 최대값
FROM  tblMember;

SELECT  MIN(age) ageMin --age 최소값
FROM  tblMember;

SELECT  age+2  "age+2" --age에 +2
FROM  tblMember;

서구에 사는 사람들 나이 합
SELECT *
FROM  tblmember;

SELECT  SUM(age) "나이 합"
FROM    tblMember
WHERE   addr LIKE '% 서구%';

--기타 연산
--num이 1 또는 3인 레코드 검색
SELECT *
FROM  tblMember
WHERE num = 1 OR num = 3;

SELECT *
FROM  tblMember
WHERE num IN(1,3);

SELECT 1000-100
FROM  dual;

SELECT SYSDATE --DBMS에 저장된 날짜 출력(RR/MM/DD)
FROM  dual;

SELECT  TO_CHAR(SYSDATE,'YYYY/MM/DD') "오늘날짜"
FROM    dual;

COMMIT; --확정


--tblPanme테이블 생성
CREATE TABLE tblPanme (
  code VARCHAR2(10),
  part VARCHAR2(20),
  price NUMBER
);

--레코드 입력
INSERT INTO tblPanme (code, part, price) VALUES ('001','A영업부',3000);
INSERT INTO tblPanme VALUES ('002','B영업부',6000);
INSERT INTO tblPanme VALUES ('003','A영업부',2000);
INSERT INTO tblPanme VALUES ('004','B영업부',5000);
INSERT INTO tblPanme VALUES ('005','C영업부',1000);
INSERT INTO tblPanme VALUES ('006','D영업부',4000);

COMMIT; --확정

--전체레코드 조회
SELECT *
FROM  tblPanme;

--각 부서별(GROUP BY)로 판매금액의 총합을 구하여 출력
SELECT  part, SUM(price)
FROM    tblPanme
GROUP BY part;

SELECT  part, SUM(price) total
FROM    tblPanme
GROUP BY part;

--각 부서별로 판매금액을 총합을 구하여 부서의 오름차순(ASC)으로 정렬(ORDER BY)하여 출력
SELECT  part, SUM(price) total
FROM    tblPanme
GROUP BY part
--ORDER BY part ASC;
ORDER BY 1 DESC; --기본 오름차순(ASC), 내림차순(DESC)

--부서명을 출력
SELECT  part
FROM    tblPanme;

SELECT  ALL part
FROM    tblPanme;

SELECT  DISTINCT part --DISTINCT 중복제거해서 출력
FROM    tblPanme;

--부서명을 출력(중복 제거하고, 부서명을 기준으로 내림차순으로 출력)
SELECT  DISTINCT part
FROM    tblPanme
ORDER BY part DESC;

--부서의 갯수 조회
SELECT  COUNT(DISTINCT part) cntPart
FROM    tblPanme;

--각 부서별로 판매금액의 총합을 구하여 부서의 오름차순으로 정렬하여 출력
--단, 부서가 2개 이상 있는 부서만 대상으로 하시오 예) A영업부, B영업부
SELECT  part, SUM(price) total
FROM    tblPanme
--WHERE    --WHERE절은 그룹함수 사용 불가, HAVING절에서 그룹함수 사용가능
GROUP BY part
HAVING COUNT(part) >= 2
ORDER BY part; --항상 마지막


※※※※SQL문 순서※※※※※
SELECT    
FROM    
WHERE 
GROUP BY
HAVING
ORDER BY --항상 마지막

--tblBook 테이블 생성
CREATE TABLE tblBook(
  num NUMBER PRIMARY KEY NOT NULL,
  title VARCHAR2(30),
  company VARCHAR2(20),
  name VARCHAR2(10),
  cost NUMBER
);

--레코드 삽입
INSERT INTO tblBook VALUES (1, 'JAVA','한빛','김윤영',27000);
INSERT INTO tblBook VALUES (2, 'JSP','혜지원','오정원',30000);

--확정
COMMIT;

--레코드 조회
SELECT  *
FROM    tblBook;



















