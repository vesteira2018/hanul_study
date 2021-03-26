-----------------------------------------------------------------------------------------------
--실습 오라클 조인, ANSI JOIN(JOIN ON,JOIN USING) 까지 --INNER 조인까지만
--01. 사번, 성, 부서코드, 부서명, 위치코드, 도시 조회
--Type 1. Oracle JOIN
SELECT  e.employee_id, e.last_name, e.department_id,
        d.department_name, d.location_id,
        l.city
FROM    employees e, departments d, locations l
WHERE   e.department_id = d.department_id
        AND d.location_id = l.location_id;

--Type 2. ANSI JOIN (JOIN ON)
SELECT  e.employee_id, e.last_name, e.department_id,
        d.department_name, d.location_id,
        l.city
FROM    employees e JOIN departments d
ON      e.department_id = d.department_id
JOIN    locations l
ON      d.location_id = l.location_id;

--Type 3. ANSI JOIN (JOIN USING)
SELECT  e.employee_id, e.last_name, department_id,
        d.department_name, location_id,
        l.city
FROM    employees e JOIN departments d
USING   (department_id)
JOIN    locations l
USING   (location_id);



--02. 사번이 110, 130, 150 인 사원들의 사번, 성, 부서명 조회하는 ANSI조인형식
--Type 1. Oracle JOIN
SELECT   e.employee_id, e.last_name, d.department_name
FROM     employees e, departments d
WHERE    e.department_id = d.department_id
         AND e.employee_id IN (110, 130, 150)
ORDER BY 1;

--Type 2. ANSI JOIN (JOIN ON)
SELECT   e.employee_id, e.last_name, d.department_name
FROM     employees e JOIN departments d
ON       e.department_id = d.department_id
WHERE    e.employee_id IN (110, 130, 150)
ORDER BY 1;

--Type 3. ANSI JOIN (JOIN USING)
SELECT   e.employee_id, e.last_name, d.department_name
FROM     employees e JOIN departments d
USING    (department_id)
WHERE    e.employee_id IN (110, 130, 150)
ORDER BY 1;


--03. 사번, 성명, 관리자사번, 관리자 성명, 관리자업무코드 조회하는 ANSI 형식 --self 조인
--Type 1. Oracle JOIN
SELECT   e.employee_id, e.first_name || ' ' || e.last_name name,
         NVL(TO_CHAR(m.employee_id), ' ') manager_id, 
         m.first_name || ' ' || m.last_name manager_name,
         NVL(m.job_id, ' ') manager_job
FROM     employees e, employees m
WHERE    e.manager_id = m.employee_id(+)
ORDER BY 1;

--Type 2. ANSI JOIN (JOIN ON)
SELECT   e.employee_id, e.first_name || ' ' || e.last_name name,
         NVL(TO_CHAR(m.employee_id), ' ') manager_id, 
         m.first_name || ' ' || m.last_name manager_name,
         NVL(m.job_id, ' ') manager_job
FROM     employees e JOIN employees m
ON       e.manager_id = m.employee_id(+)
ORDER BY 1;

--Type 3. ANSI JOIN (JOIN USING)
--사용 불가능


--04. 성이 king 인 사원의 사번, 성명, 부서코드, 부서명 ANSI 형식
--Type 1. Oracle JOIN
SELECT  e.employee_id, e.first_name || ' ' || e.last_name name,
        e.department_id, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id
        AND LOWER(e.last_name) LIKE 'king';

--Type 2. ANSI JOIN (JOIN ON)
SELECT  e.employee_id, e.first_name || ' ' || e.last_name name,
        e.department_id, d.department_name
FROM    employees e JOIN departments d
ON      e.department_id = d.department_id
WHERE   LOWER(e.last_name) LIKE 'king';

--Type 3. ANSI JOIN (JOIN USING)
SELECT  e.employee_id, e.first_name || ' ' || e.last_name name,
        department_id, d.department_name
FROM    employees e JOIN departments d
USING   (department_id)
WHERE   LOWER(e.last_name) LIKE 'king';


--05. 관리자 사번이 149 번인 사원의 사번, 성, 부서코드, 부서명 조회
--Type 1. Oracle JOIN
SELECT   e.employee_id, e.last_name, e.department_id, d.department_name
FROM     employees e, departments d
WHERE    e.department_id = d.department_id
         AND e.manager_id = 149
ORDER BY 1;

--Type 2. ANSI JOIN (JOIN ON)
SELECT   e.employee_id, e.last_name, e.department_id, d.department_name
FROM     employees e JOIN departments d
ON       e.department_id = d.department_id
WHERE    e.manager_id = 149
ORDER BY 1;

--Type 3. ANSI JOIN (JOIN USING)
SELECT   e.employee_id, e.last_name, department_id, d.department_name
FROM     employees e JOIN departments d
USING    (department_id)
WHERE    e.manager_id = 149
ORDER BY 1;


--06. 위치코드 1400인 도시명, 부서명 조회
--Type 1. Oracle JOIN
SELECT  l.city, d.department_name
FROM    locations l, departments d
WHERE   l.location_id = d.location_id
        AND d.location_id = 1400;

--Type 2. ANSI JOIN (JOIN ON)
SELECT  l.city, d.department_name
FROM    locations l JOIN departments d
ON      l.location_id = d.location_id
WHERE   d.location_id = 1400;

--Type 3. ANSI JOIN (JOIN USING)
SELECT  l.city, d.department_name
FROM    locations l JOIN departments d
USING   (location_id)
WHERE   location_id = 1400;


--07. 위치코드 1800에 근무하는 사원들의 사번, 성, 업무코드, 부서명, 위치코드 조회
--Type 1. Oracle JOIN
SELECT    e.employee_id, e.last_name, e.job_id, 
          d.department_name, d.location_id
FROM      employees e, departments d
WHERE     e.department_id = d.department_id
          AND d.location_id = 1800;

--Type 2. ANSI JOIN (JOIN ON)
SELECT    e.employee_id, e.last_name, e.job_id, 
          d.department_name, d.location_id
FROM      employees e JOIN departments d
ON        e.department_id = d.department_id
WHERE     d.location_id = 1800;

--Type 3. ANSI JOIN (JOIN USING)
SELECT    e.employee_id, e.last_name, e.job_id, 
          d.department_name, d.location_id
FROM      employees e JOIN departments d
USING     (department_id)
WHERE     d.location_id = 1800;


--08. 성에 대소문자 무관하게 z가 있는 사원들의 사번, 성, 부서명 조회
--Type 1. Oracle JOIN
SELECT  e.employee_id, e.last_name, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id
        AND LOWER(e.last_name) LIKE '%z%';

--Type 2. ANSI JOIN (JOIN ON)
SELECT  e.employee_id, e.last_name, d.department_name
FROM    employees e JOIN departments d
ON      e.department_id = d.department_id
WHERE   LOWER(e.last_name) LIKE '%z%';

--Type 3. ANSI JOIN (JOIN USING)
SELECT  e.employee_id, e.last_name, d.department_name
FROM    employees e JOIN departments d
USING   (department_id)
WHERE   LOWER(e.last_name) LIKE '%z%';


--09. 관리자보다 먼저 입사한 사원의 사번, 성, 입사일자, 
--    관리자사번, 관리자성, 관리자입사일자 조회
--Type 1. Oracle JOIN
SELECT    e.employee_id, e.last_name, e.hire_date,
          m.employee_id manager_id, 
          m.last_name manager_last_name,
          m.hire_date manager_hire_date
FROM      employees e, employees m
WHERE     e.manager_id = m.employee_id
          AND m.hire_date > e.hire_date
ORDER BY  1;

--Type 2. ANSI JOIN (JOIN ON)
SELECT    e.employee_id, e.last_name, e.hire_date,
          m.employee_id manager_id, 
          m.last_name manager_last_name,
          m.hire_date manager_hire_date
FROM      employees e JOIN employees m
ON        e.manager_id = m.employee_id
WHERE     m.hire_date > e.hire_date
ORDER BY  1;

--Type 3. ANSI JOIN (JOIN USING)
--사용 불가능


--10. 업무코드가 clerk종류의 업무형태인 사원들의 사번, 성, 부서명, 업무제목 조회
--Type 1. Oracle JOIN
SELECT   e.employee_id, e.last_name, d.department_name,
         j.job_title
FROM     employees e, departments d, jobs j
WHERE    e.department_id = d.department_id
         AND e.job_id = j.job_id
         AND LOWER(e.job_id) LIKE '%clerk%'
ORDER BY 1;

--Type 2. ANSI JOIN (JOIN ON)
SELECT   e.employee_id, e.last_name, d.department_name,
         j.job_title
FROM     employees e JOIN departments d
ON       e.department_id = d.department_id
JOIN     jobs j
ON       e.job_id = j.job_id
WHERE    LOWER(e.job_id) LIKE '%clerk%'
ORDER BY 1;

--Type 3. ANSI JOIN (JOIN USING)
SELECT   e.employee_id, e.last_name, d.department_name,
         j.job_title
FROM     employees e JOIN departments d
USING    (department_id)
JOIN     jobs j
USING    (job_id)
WHERE    LOWER(job_id) LIKE '%clerk%'
ORDER BY 1;


--11. toronto 에 근무하는 사번, 성, 부서코드, 부서명, 도시명 조회
--Type 1. Oracle JOIN
SELECT  e.employee_id, e.last_name, e.department_id,
        d.department_name, l.city
FROM    employees e, departments d, locations l
WHERE   e.department_id = d.department_id
        AND d.location_id = l.location_id
        AND l.city LIKE 'Toronto';

--Type 2. ANSI JOIN (JOIN ON)
SELECT  e.employee_id, e.last_name, e.department_id,
        d.department_name, l.city
FROM    employees e JOIN departments d
ON      e.department_id = d.department_id
JOIN    locations l
ON      d.location_id = l.location_id
WHERE   l.city LIKE 'Toronto';

--Type 3. ANSI JOIN (JOIN USING)
SELECT  e.employee_id, e.last_name, department_id,
        d.department_name, l.city
FROM    employees e JOIN departments d
USING   (department_id)
JOIN    locations l
USING   (location_id)
WHERE   l.city LIKE 'Toronto';


-----------------------------------------------------------------------------------------------