-- GROUP BY

-- 01. 회사 사원들의 사번, 성, 부서코드, 급여 조회
-- 부서코드 순으로 정렬

SELECT    employee_id, last_name, department_id, salary
FROM      employees
ORDER BY  department_id;

-- 전체 데이터 행을 하나의 그룹으로 보고 그룹함수로 데이터를 조회
-- 특정 기준을 두어 기준으로 그룹을 짓고, 그룹별로 하나의 결과를 조회
-- : GROUP BY 사용

-- SELECT에 그룹함수 (COUNT, MAX, MIN, SUM, AVG, ...)과 함께
-- 그룹함수를 사용하지 않는 일반 컬럼이 있다면
-- 반드시 그룹함수를 사용하지 않는 컬럼에 대해서 GROUP BY에 명시해야 한다

-- 50번 부서의 부서코드, 업무코드, 급여 평균을 조회
SELECT   department_id, job_id, ROUND(AVG(salary), 2) avg_sal
FROM     employees
WHERE    department_id = 50 
GROUP BY department_id, job_id;

-- 부서별로, 업무별로 부서코드, 업무코드, 급여평균 조회
SELECT    department_id, job_id, ROUND(AVG(salary), 2) avg_sal
FROM      employees
GROUP BY  department_id, job_id
ORDER BY  1;

-- SELECT > FROM > WHERE > GROUP BY > HAVING > ORDER BY
-- GROUP BY의 조건절 : HAVING

-- WHERE vs HAVING
-- WHERE : 그룹함수(COUNT, MAX, MIN, AVG ...)를 사용할 수 없다.
-- HAVING : 일반조건, 그룹함수를 모두 사용 가능.

-- 80번 부서의 부서와 급여평균 조회
SELECT    department_id, ROUND(AVG(salary), 2) avg_sal
FROM      employees
WHERE     department_id = 80
GROUP BY  department_id;

SELECT    department_id, ROUND(AVG(salary), 2) avg_sal
FROM      employees
GROUP BY  department_id
HAVING    department_id = 80;

-- 부서별로 사원 수가 5명 이하인 부서와 그 수를 조회
SELECT    department_id, COUNT(*) worker
FROM      employees
GROUP BY  department_id
HAVING    department_id IS NOT NULL
          AND COUNT(*) <= 5
ORDER BY  department_id;

-- 사원수가 10명 이상인 부서의 부서코드, 사원 수, 급여평균, 최대급여, 최저급여 조회
SELECT    department_id, COUNT(*) "사원 수", 
          ROUND(AVG(salary), 2) "급여평균",
          MAX(salary) "최대급여", MIN(salary) "최소급여"
FROM      employees
GROUP BY  department_id
HAVING    COUNT(*) >= 10
ORDER BY  department_id;

-- CUBE : 소계, 총계를 구하는 함수
SELECT    department_id, job_id, COUNT(*) cnt, SUM(salary) sum_sal
FROM      employees
GROUP BY  CUBE(department_id), job_id
ORDER BY  1;

-- 5. JOIN
-- 하나의 테이블로부터 데이터를 조회할 수 없는 경우
-- 여러 개의 테이블로부터 데이터를 조회
-- 즉, 합쳐진 테이블에 데이터를 조회하는 것

-- 부서 정보 테이블 : departments
-- 사원 정보 테이블 : employees
-- 업무 정보 테이블 : jobs

-- 1. CARTESIAN PRODUCT
-- WHERE 절에 조건을 기술하지 않은 경우
-- = CROSS JOIN

-- 사번, 성, 부서명 조회 (107x27 = 2889)
SELECT  employee_id, last_name, department_name
FROM    employees, departments;

-- EQUI JOIN(ANSI에서는 INNER JOIN), 교집합
-- WHERE절에서 동등연산자를 사용하는 JOIN형식
-- 즉, 테이블들 간에 공통으로 만족된 값을 가진 경우의 결과를 반환

-- JOIN 조건식 (컬럼의 값이 같은 것에 설정)
-- 테이블명1.컬럼명 = 테이블명2.컬럼명

-- 사번, 성, 부서명 조회
SELECT  e.employee_id, e.last_name, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id;

-- 01. 사번, 성, 부서코드, 부서명 조회
SELECT  e.employee_id, e.last_name, e.department_id, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id;

-- 02. 사번, 성, 업무코드, 업무제목 조회
SELECT  e.employee_id, e.last_name, e.job_id, j.job_title
FROM    employees e, jobs j
WHERE   e.job_id = j.job_id;

-- JOIN하는 대상 테이블이 추가되면 JOIN 조건을 추가
-- WHERE 절에 JOIN 조건과 일반 조건을 함께 사용

-- WHERE 조인조건식 AND 일반조건식
-- JOIN 조건은 테이블 개수 - 1만큼

-- 03. 사번, 성, 부서명, 업무제목
-- 사번, 성 : employees
-- 부서명 : departments
-- 업무제목 : jobs
SELECT  e.employee_id, e.last_name, d.department_name, j.job_title
FROM    employees e, departments d, jobs j
WHERE   e.department_id = d.department_id
        AND e.job_id = j.job_id;
        
-- 04. 사번, 성, 부서코드, 부서명, 업무코드, 업무제목 조회
SELECT  e.employee_id, e.last_name, e.department_id, 
        d.department_name, e.job_id, j.job_title
FROM    employees e, departments d, jobs j
WHERE   e.department_id = d.department_id
        AND e.job_id = j.job_id;
        
-- 05. 사번이 101인 사원의 사번, 이름, 부서명, 업무제목 조회
SELECT  e.employee_id, e.first_name, d.department_name, j.job_title
FROM    employees e, departments d, jobs j
WHERE   e.department_id = d.department_id
        AND e.job_id = j.job_id
        AND e.employee_id = 101;


-- 06. 사번이 100, 120, 130, 140인 사원들의
-- 사번, 성, 부서코드, 부서명 조회
SELECT   e.employee_id, e.last_name, d.department_id, d.department_name
FROM     employees e, departments d
WHERE    e.department_id = d.department_id
         AND e.employee_id IN (100, 120, 130, 140)
ORDER BY 1;


-- 07. 매니저가 없는 사원의 사번, 이름, 업무제목 조회
SELECT  e.employee_id, e.first_name, j.job_title
FROM    employees e, jobs j
WHERE   e.job_id = j.job_id
        AND e.manager_id IS NULL;