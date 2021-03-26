--실습
-----------------------------------------------------------------------------------------------
--01. 성에 대소문자 무관하게 z가 있는 성을 가진 사원들의
--사번, 성, 부서코드, 부서명 조회

SELECT  e.employee_id, e.last_name, e.department_id, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id
        AND LOWER(last_name) LIKE '%z%';


--02. 커미션을 받는 사원들의 
--사번, 성, 급여, 커미션요율, 업무제목 조회

SELECT  e.employee_id, e.last_name, e.salary, e.commission_pct, j.job_title
FROM    employees e, jobs j
WHERE   e.job_id = j.job_id
        AND e.commission_pct IS NOT NULL;



--03. 커미션을 받는 사원들의 
--사번, 성, 급여, 커미션금액, 부서명 조회

SELECT  e.employee_id, e.last_name, e.salary, 
        e.salary*e.commission_pct "commission",
        d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id
        AND e.commission_pct IS NOT NULL;



--04. 각 부서에 대한 정보를 파악하고자 한다.
--각 부서의 부서코드, 부서명, 위치코드, 도시를 조회

SELECT   DISTINCT e.department_id, d.department_name, l.location_id, l.city
FROM     employees e, departments d, locations l
WHERE    e.department_id = d.department_id
         AND d.location_id = l.location_id
ORDER BY 1;


--05. 사번, 성, 부서코드, 부서명, 근무지도시명, 주소 조회

SELECT  e.employee_id, e.last_name, e.department_id,
        d.department_name, l.city, l.street_address
FROM    employees e, departments d, locations l
WHERE   e.department_id = d.department_id
        AND d.location_id = l.location_id;

--06. 사번, 성, 부서코드, 부서명, 업무코드, 업무제목 조회  --조인조건은 table갯수 -1 만큼 필요!!

SELECT  e.employee_id, e.last_name, e.department_id,
        d.department_name, e.job_id,
        j.job_title
FROM    employees e, departments d, jobs j
WHERE   e.department_id = d.department_id
        AND e.job_id = j.job_id;

--07. 각 부서의 부서코드, 부서명, 위치코드, 도시명, 국가코드, 국가명, 대륙명 조회 

SELECT   d.department_id, d.department_name,
         l.location_id, l.city,
         c.country_id, c.country_name, c.region_id
FROM     departments d, locations l, countries c
WHERE    d.location_id = l.location_id
         AND l.country_id = c.country_id
ORDER BY 1;

-----------------------------------------------------------------------------------------------