-- 5.6 ANSI JOIN
-- : 모든 DBMS에서 공통적으로 사용할 수 있는 국제 표준 JOIN 형식

-- 1. INNER JOIN(오라클에서 EQUI JOIN), 교집합
-- FROM   테이블명 1, INNER JOIN 테이블명 2
-- ON     JOIN조건식
-- WHERE  일반조건식

-- FROM   테이블명 1, INNER JOIN 테이블명 2
-- USING  JOIN컬럼명
-- WHERE  일반조건식

-- USING절에 사용된 JOIN컬럼명은 절대로 테이블명을 명시해서는 안된다.

-- 01. 부서코드가 60번인 사번, 성, 부서코드, 부서명 조회
-- Type 1. Oracle JOIN
SELECT  e.employee_id, e.last_name, e.department_id, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id(+)
        AND e.department_id = 60;

-- Type 2. ANSI JOIN (JOIN ON)
SELECT  e.employee_id, e.last_name, e.department_id, d.department_name
FROM    employees e INNER JOIN departments d
ON      e.department_id = d.department_id(+)
WHERE   e.department_id = 60;

-- Type 3. ANSI JOIN (USING)
SELECT  e.employee_id, e.last_name, department_id, d.department_name
FROM    employees e INNER JOIN departments d
USING   (department_id)
WHERE   department_id = 60;

-- Oracle JOIN        -- ANSI JOIN
-- SELECT                SELECT
-- FROM                  FROM     JOIN
-- WHERE (AND)           ON/USING
-- GROUP BY              WHERE
-- HAVING                GROUP BY
-- ORDER BY              HAVING
--                       ORDER BY

-- 02. 사번, 성, 업무코드, 업무제목 조회
-- Type 01. Oracle JOIN
SELECT  e.employee_id, e.last_name, e.job_id, j.job_title
FROM    employees e, jobs j
WHERE   e.job_id = j.job_id;

-- Type 02. ANSI JOIN (JOIN ON)
SELECT  e.employee_id, e.last_name, e.job_id, j.job_title
FROM    employees e JOIN jobs j
ON      e.job_id = j.job_id;

-- Type 03. ANSI JOIN (USING)
SELECT  e.employee_id, e.last_name, job_id, j.job_title
FROM    employees e JOIN jobs j
USING   (job_id);

-- 03. 업무코드가 clerk 종류 형태를 하는 사번, 성, 업무코드, 업무제목
-- Type 1. Oracle JOIN
SELECT  e.employee_id, e.last_name, e.job_id, j.job_title
FROM    employees e, jobs j
WHERE   e.job_id = j.job_id
        AND LOWER(e.job_id) LIKE '%clerk%';

-- Type 2. ANSI JOIN (JOIN ON)
SELECT  e.employee_id, e.last_name, e.job_id, j.job_title
FROM    employees e JOIN jobs j
ON      e.job_id = j.job_id
WHERE   LOWER(e.job_id) LIKE '%clerk%';

-- Type 3. ANSI JOIN (USING)
SELECT  e.employee_id, e.last_name, job_id, j.job_title
FROM    employees e JOIN jobs j
USING   (job_id)
WHERE   LOWER(job_id) LIKE '%clerk%';

-- 04. 부서코드, 부서명, 위치코드, 도시 조회
-- Type 1. Oracle JOIN
SELECT  d.department_id, d.department_name, d.location_id, l.city
FROM    departments d, locations l
WHERE   d.location_id = l.location_id;

-- Type 2. ANSI JOIN (JOIN ON)
SELECT  d.department_id, d.department_name, d.location_id, l.city
FROM    departments d JOIN locations l
ON      d.location_id = l.location_id;

-- Type 3. ANSI JOIN (USING)
SELECT  d.department_id, d.department_name, location_id, l.city
FROM    departments d JOIN locations l
USING   (location_id);

-- 05. 매너지의 부서가 60 이상인 부서에 속한 사원들의
-- 사번, 성, 매니저사번, 매니저 성 조회
-- Type 1. Oracle JOIN
SELECT  e.employee_id, e.last_name,
        m.employee_id manager_id, m.last_name manager_last_name
FROM    employees e, employees m
WHERE   e.manager_id = m.employee_id
        AND m.department_id >= 60;

-- Type 2. ANSI JOIN (JOIN ON)
SELECT  e.employee_id, e.last_name,
        m.employee_id manager_id, m.last_name manager_last_name
FROM    employees e JOIN employees m
ON      e.manager_id = m.employee_id
WHERE   m.department_id >= 60;

-- Type 3. ANSI JOIN (USING) -- 사용 불가능

-- JOIN에 사용하는 테이블이 3개 이상일 경우
-- 첫 번째 JOIN의 결과에 두 번째 JOIN을 추가하는 형태로 사용

-- 06. 부서코드 10, 20, 40, 60인 부서의
-- 사번, 성, 부서코드, 부서명, 업무코드, 업무제목
-- Type 1. Oracle JOIN
SELECT  e.employee_id, e.last_name, e.department_id,
        d.department_name, e.job_id, j.job_title
FROM    employees e, departments d, jobs j
WHERE   e.department_id = d.department_id
        AND e.job_id = j.job_id
        AND e.department_id IN (10, 20, 40, 60);
        
-- Type 2. ANSI JOIN (JOIN ON)
SELECT  e.employee_id, e.last_name, e.department_id,
        d.department_name, e.job_id, j.job_title
FROM    employees e JOIN departments d
ON      e.department_id = d.department_id
JOIN    jobs j 
ON      e.job_id = j.job_id
WHERE   e.department_id IN (10, 20, 40, 60);

-- Type 3. ANSI JOIN (USING)
SELECT  e.employee_id, e.last_name, department_id,
        d.department_name, job_id, j.job_title
FROM    employees e JOIN departments d
USING   (department_id)
JOIN    jobs j 
USING   (job_id)
WHERE   department_id IN (10, 20, 40, 60);

-- Type 4. ANSI JOIN (JOIN ON/USING)
SELECT  e.employee_id, e.last_name, e.department_id,
        d.department_name, job_id, j.job_title
FROM    employees e JOIN departments d
ON      e.department_id = d.department_id
JOIN    jobs j 
USING   (job_id)
WHERE   e.department_id IN (10, 20, 40, 60);

-- 2. OUTER JOIN : 오라클에서 기호(+)를 사용, 합집합
-- FROM 절에서 LEFT/RIGHT OUTER JOIN : 기준이 되는 방향으로 JOIN
-- LEFT OUTER JOIN : 왼쪽 테이블 기준으로 NULL 포함하여 모두 출력 (등호의 오른쪽 +)
-- RIGHT OUTER JOIN : 오른쪽 테이블 기준으로 NULL 포함하여 모두 출력 (등호의 왼쪽 +)

-- 01. 모든 사원들의 사번, 성, 부서코드, 부서명
-- Type 1. Oracle JOIN
SELECT   e.employee_id, e.last_name, e.department_id, d.department_name
FROM     employees e, departments d
WHERE    e.department_id = d.department_id(+)
ORDER BY 1;

-- Type 2. OUTER JOIN ON
SELECT   e.employee_id, e.last_name, e.department_id, d.department_name
FROM     employees e LEFT JOIN departments d
ON       e.department_id = d.department_id
ORDER BY 1;

-- Type 3. OUTER JOIN USING
SELECT   e.employee_id, e.last_name, department_id, d.department_name
FROM     employees e LEFT JOIN departments d
USING    (department_id)
ORDER BY 1;

-- 02. 모든 사원들의 사번, 성, 부서코드, 부서명, 도시
-- Type 1. Oracle JOIN
SELECT   e.employee_id, e.last_name, e.department_id, 
         d.department_name, l.city
FROM     employees e, departments d, locations l
WHERE    e.department_id = d.department_id(+)
         AND d.location_id = l.location_id(+)
ORDER BY 1;

-- Type 2. OUTER JOIN ON
SELECT    e.employee_id, e.last_name, e.department_id, 
          d.department_name, l.city
FROM      employees e LEFT JOIN departments d
ON        e.department_id = d.department_id
LEFT JOIN locations l
ON        d.location_id = l.location_id
ORDER BY  1;

-- Type 3. OUTER JOIN USING
SELECT    e.employee_id, e.last_name, department_id, 
          d.department_name, l.city
FROM      employees e LEFT JOIN departments d
USING     (department_id)
LEFT JOIN locations l
USING     (location_id)
ORDER BY  1;

-- 03. 모든 사원들의 사번, 성, 매니저 사번, 매니저 성
-- Type 1. Oracle JOIN
SELECT   e.employee_id, e.last_name,
         m.employee_id manager_id, m.last_name manager_ln
FROM     employees e, employees m
WHERE    e.manager_id = m.employee_id(+)
ORDER BY 1;

-- Type 2. OUTER JOIN ON
SELECT   e.employee_id, e.last_name,
         m.employee_id manager_id, m.last_name manager_ln
FROM     employees e LEFT JOIN employees m
ON       e.manager_id = m.employee_id
ORDER BY 1;