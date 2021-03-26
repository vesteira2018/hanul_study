-- 6. 데이터행 조회
-- 데이터 행을 조회 : ROWNUM (가짜 컬럼, pseudo column)
-- SELECT 절과 WHERE 절에서 사용
-- 쿼리문의 결과로 나온 각 행에 대한 순서 값
-- 서브쿼리에서 먼저 정렬한 후 메인쿼리에서 순번 매기는 용도
-- ROWNUM과 인라인 뷰의 특성을 이용해 페이징 처리 작업

-- 10명까지 조회
SELECT   employee_id, last_name, salary
FROM     employees
WHERE    ROWNUM <= 10
ORDER BY 3 DESC;

-- 가장 먼저 입사한 사원 10명
SELECT  ROWNUM, e.*
FROM   (SELECT   employee_id, last_name, hire_date
        FROM     employees
        ORDER BY hire_date) e
WHERE   ROWNUM <= 10;

-- 8. 순위를 구하는 함수
-- : RANK() OVER(순위결정기준) : 1,2,2,4
-- : DENSE_RANK() OVER(순위결정기준) : 1,2,2,3
SELECT  e.*
FROM   (SELECT    RANK() OVER(ORDER BY hire_date) rank,
                  employee_id, last_name, hire_date
        FROM      employees) e
WHERE   rank <= 10;

SELECT  e.*
FROM   (SELECT    DENSE_RANK() OVER(ORDER BY hire_date) rank,
                  employee_id, last_name, hire_date
        FROM      employees) e
WHERE   rank <= 10;

-- DML (Data Manipulation Language) - INSERT, DELECT, UPDATE
-- TCL (Transaction Control Language) - COMMIT, ROLLBACK

-- 01. 부서테이블에 새로운 부서 등록
-- 부서코드 300, 부서명 : 영업부
INSERT  INTO departments
  VALUES (300, '영업부', NULL, NULL);

ROLLBACK;

SELECT  *
FROM    departments;

CREATE TABLE emp AS
  SELECT employee_id id, last_name, first_name, hire_date,
         job_id, department_id dept_id
  FROM   employees;
  
SELECT * FROM emp;
        
UPDATE  emp
SET     job_id = 'PU_CLERK'
WHERE   id = 202;

UPDATE  emp
SET     dept_id = ''
WHERE   id = 202;

UPDATE  emp
SET     hire_date = ADD_MONTHS(SYSDATE, -6)
WHERE   id = 202;

UPDATE  emp
SET     hire_date = (SELECT MAX(hire_date)
                     FROM   emp
                     WHERE  dept_id = 60)
WHERE   id = 200;

-- DDL (Date Definition Language)
-- CREATE, ALTER, DROP, TRUNCATE, RENAME

-- 데이터 타입 : 문자, 숫자, 날짜
-- 문자 : CHAR, VARCHAR2
--  CHAR(n) : 고정문자 - 지정된 크기만 메모리 확보
--            크기가 고정되어있어 메모리가 낭비
--  VARCHAR(n) : 가변문자 - 데이터를 저장할 때 메모리 확보

-- 숫자 : NUMBER
--  NUMBER(n) : 정수 데이터(8자리 까지)
--  NUMBER(n, p) : 부동소수점 데이터 (총 8자리 중에서 정수, 소수 범위 설정)

-- 날짜 : DATE


-- ALTER 