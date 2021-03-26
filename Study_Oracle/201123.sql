-- 6.1 서브쿼리 (Sub Query)
-- : SQL 문장 안에 존재하는 또 다른 SQL 문장
-- 서브 쿼리는 괄호 안에 묶어 사용, 서브쿼리가 포함된 쿼리문을
-- 메인쿼리라고 한다.

-- ★ 서브쿼리의 위치에 따른 명칭
-- 1. SELECT 절에 사용하는 서브쿼리
--  - 스칼라 서브쿼리, SQL에서 단일 값을 스칼라값이라 한다.
--  - Scalar : (크기)하나, Vector : 크기와 방향
--  - SELECT 문에서 서브쿼리를 사용하여 하나의 컬럼처럼 사용
--  - JOIN의 대체 표현식으로 자주 사용

--  - 상호연관서브쿼리 : 메인쿼리의 컬럼이 서브쿼리의 조건절에 사용

-- 2. FROM 절에 사용하는 서브쿼리
--  ○ 인라인 뷰
--    - SELECT 절의 결과를 FROM 절에서 하나의 테이블처럼 사용
--    - 인라인 뷰 서브쿼리는 ORDER BY 절에 올 수 없음 (출력용도가 아님)
--    - 인라인 뷰 쿼리에서 그룹함수는 반드시 ALIAS 지정
--      (ALIAS 지정해서 하나의 컬럼으로 사용해야 함)

-- 3. WHERE 절에 사용하는 서브쿼리 → 기본 서브쿼리
--  - ○ 기본 서브쿼리 : 메인쿼리문 안에 또 다른 쿼리문
--  (즉, WHERE/HAVING 조건절에서 사용)
--  - SELECT 절의 결과를 하나의 변수(상수)처럼 사용할 때
--  (조건절의 결과에 따라 달라진다) → 결과가 하나인지, 
--   결과가 여러개인지, 다중컬럼인지
--   보통, 함수로 구한 값과 비교할 때, 다른 곳에서 구한 값과 비교할 때

-- =========================================================

-- 01. 조건절 WHERE/HAVING 에서 사용하는 단일(결과)행 서브쿼리,
--  조건의 결과값이 하나
--  단일(결과)행 서브쿼리 연산자 : =, !=, >, >=, <, <=


-- 1. 급여가 회사 평균급여보다 더 적은 급여를 받는 사원의
-- 사번, 이름, 급여 정보를 조회

SELECT  employee_id, first_name, salary
FROM    employees
WHERE   salary < (SELECT AVG(salary)
                  FROM   employees);
                  

-- 02. 급여가 회사급여의 평균보다 적게 받는 사원들의
-- 사번, 성, 업무코드, 급여 조회
SELECT  employee_id, last_name, job_id, salary
FROM    employees
WHERE   salary < (SELECT AVG(salary)
                  FROM   employees);
                  
-- 03. 회사에서 가장 많은 급여를 받는 사원들의
-- 사번, 성, 명, 급여 조회
SELECT  employee_id, last_name, first_name, salary
FROM    employees
WHERE   salary = (SELECT MAX(salary) FROM employees);


-- 04. 사번 150번보다 더 많은 급여를 받는 사원들의
-- 사번, 성, 부서코드, 업무코드, 급여
SELECT  employee_id, last_name, department_id, job_id, salary
FROM    employees
WHERE   salary > 
        (SELECT salary FROM employees WHERE employee_id = 150);
        
-- 05. 월급여가 가장 많은 사원
-- 사번, 이름, 성, 업무제목
SELECT  e.employee_id, e.first_name, e.last_name, j.job_title
FROM    employees e, jobs j
WHERE   e.salary = (SELECT MAX(salary) FROM employees)
        AND e.job_id = j.job_id;
        
-- 06. 사원들의 급여가 회사 평균 급여 이상 최고 급여 이하에 해당
-- 사번, 성, 급여
SELECT  employee_id, last_name, salary
FROM    employees
WHERE   salary BETWEEN
        (SELECT AVG(salary) FROM employees) AND
        (SELECT MAX(salary) FROM employees);
        
-- 2. 다중(결과)행 서브쿼리
-- : 조건절에 사용한 서브쿼리의 결과행이 여러행인 경우, 조건의 
-- 결과값을 기준으로 결과가 여러개
-- 연산자 : IN, NOT IN

-- 비교의 대상이 두 개 이상은 대소비교가 불가능
-- 서브쿼리의 결과가 여러 행인 경우 연산자 사용 불가
-- WHERE 절에서는 그룹함수 사용 불가

-- 컬럼표현 IN, 컬럼표현 NOT IN, NOT 컬럼표현 IN

-- ===============================================

-- 01. 부서의 위치코드가 1700인 부서에 속한 사원
-- 사번, 성명, 부서코드, 업무코드
SELECT  employee_id, first_name, last_name, 
        department_id, job_id
FROM    employees
WHERE   department_id IN (SELECT department_id
        FROM departments
        WHERE location_id = 1700);
        
-- 02. 회사에서 mgr업무에서 종사하는 사원들과 같은 부서에 속한
-- 사번, 성, 업무코드
SELECT  employee_id, last_name, job_id
FROM    employees
WHERE   department_id IN (SELECT department_id
        FROM employees WHERE LOWER(job_id) LIKE '%mgr%');
        
-- 03. 각 부서의 최소 급여가 40번 부서의 최소급여보다 더 많은
-- 부서코드, 최소 급여
SELECT   department_id, MIN(salary)
FROM     employees
GROUP BY department_id
HAVING   MIN(salary) >
         (SELECT MIN(salary) FROM employees
         WHERE department_id = 40);
         
-- 04. 근무지의 국가코드가 UK인 위치에 있는 부서
-- 부서코드, 위치코드, 부서명
SELECT  department_id, location_id, department_name
FROM    departments
WHERE   location_id IN (SELECT location_id FROM locations
        WHERE country_id LIKE 'UK');
        
-- 60번 부서원들과 같은 급여를 받는 사원들의
-- 사번, 성, 급여, 부서코드 조회
SELECT  employee_id, last_name, salary, department_id
FROM    employees
WHERE   salary IN (SELECT salary FROM employees
        WHERE department_id = 60);
        
-- 60번 부서에 속하지 않으면서 60번 부서원들과 같은 급여를 받는 사원
SELECT  employee_id, last_name, salary, department_id
FROM    employees
WHERE   salary IN (SELECT salary FROM employees
        WHERE department_id = 60)
        AND department_id NOT IN 60;
        
-- 부서명이 Marketing이거나 IT에 속한 사원들의
-- 사번, 성, 부서코드
SELECT  employee_id, last_name, department_id
FROM    employees
WHERE   department_id IN (SELECT department_id FROM
 departments WHERE department_name IN ('Marketing', 'IT'));
 
-- 
SELECT  department_id, department_name
FROM    departments
WHERE   department_id IN (SELECT department_id FROM employees WHERE manager_id = 100);

-- 3. 다중컬럼 서브쿼리
-- : 서브퀄의 결과 컬럼이 여러 컬럼인 경우
-- : 조건의 결과값을 기준으로 컬럼이 여러 개
-- : 다중컬럼을 pair의 형태로 비교

-- 01. 부서별로 가장 많은 급여를 받는 사원
-- 부서코드, 최대급여를 조회
SELECT   department_id, MAX(salary)
FROM     employees
GROUP BY department_id
ORDER BY 1;

-- 02. 부서별로 가장 많은 급여를 받는 사원
-- 부서코드, 최대급여, 이름를 조회
SELECT   e.department_id, e.salary, e.first_name
FROM     employees e, (SELECT    department_id, MAX(salary) max_sal
                       FROM      employees
                       GROUP BY  department_id) m
WHERE    NVL(e.department_id, 0) = NVL(m.department_id, 0)
         AND e.salary = m.max_sal
ORDER BY 1;

SELECT    e.department_id, e.salary, e.first_name
FROM      employees e
WHERE     (NVL(e.department_id, 0), e.salary) 
  IN (SELECT NVL(department_id, 0), MAX(salary) max_sal
  FROM      employees
  GROUP BY  NVL(department_id, 0))
ORDER BY  1;

-- 03. 부서별로 가장 많은 급여를 받는 사원의
-- 사번, 성, 부서코드, 최대급여, 업무코드
SELECT  employee_id, last_name, department_id, salary, job_id
FROM    employees
WHERE   (NVL(department_id,0), salary) IN
  (SELECT NVL(department_id,0), MAX(salary) max_sal
   FROM   employees
   GROUP BY NVL(department_id,0))
ORDER BY 3;



SELECT NVL(department_id,0), MAX(salary) max_sal
   FROM   employees
   GROUP BY NVL(department_id,0)
   ORDER BY 1;