-----------------------------------------------------------------------------------------------
--[ 연습문제 5-1 ]                                                                             
--01. 이름에 소문자 v가 포함된 모든 사원의 사번, 이름, 부서명을 조회하는 쿼리문을 작성한다.

SELECT  e.employee_id, e.first_name, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id
        AND e.first_name LIKE '%v%';

--02. 커미션을 받는 사원의 사번, 이름, 급여, 커미션 금액, 부서명을 조회하는 쿼리문을 작성한다.
--단, 커미션 금액은 월급여에 대한 커미션 금액을 나타낸다.

SELECT  e.employee_id, e.first_name, e.salary, 
        e.salary*NVL(e.commission_pct, 0) "commission_cost",
        d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id(+)
        AND e.commission_pct IS NOT NULL;


--03. 각 부서의 부서코드, 부서명, 위치코드, 도시명, 국가코드, 국가명을 조회하는 쿼리문을 작성한다.

SELECT   d.department_id, d.department_name, d.location_id,
         l.city, l.country_id, c.country_name
FROM     departments d, locations l, countries c
WHERE    d.location_id = l.location_id
         AND l.country_id = c.country_id
ORDER BY 1;

--04. 사원의 사번, 이름, 업무코드, 매니저의 사번, 매니저의 이름, 매니저의 업무코드를 조회하여 
--사원의 사번 순서로 정렬하는 쿼리문을 작성한다.

SELECT   e.employee_id, e.first_name, e.job_id, e.manager_id,
         m.first_name manager_name, m.job_id manager_job_id
FROM     employees e, employees m
WHERE    e.manager_id = m.employee_id(+)
ORDER BY e.employee_id;

--05. 모든 사원의 사번, 이름, 부서명, 도시, 주소 정보를 조회하여 사번 순으로 정렬하는 쿼리문을 작성한다.

SELECT    e.employee_id, e.first_name, d.department_name, 
          l.city, l.street_address
FROM      employees e, departments d, locations l
WHERE     e.department_id = d.department_id(+)
          AND d.location_id = l.location_id(+)
ORDER BY  e.employee_id;

-----------------------------------------------------------------------------------------------
--실습
--01. 모든 사원의 사번, 성명, 업무코드, 매니저사번, 매니저성명, 매니저의 업무코드 조회하여
--사번 순으로 정렬 --SELF JOIN

SELECT   e.employee_id, e.first_name || ' ' || e.last_name name,
         e.job_id, e.manager_id, 
         m.first_name || ' ' || m.last_name manager, m.job_id
FROM     employees e, employees m
WHERE    e.manager_id = m.employee_id(+)
ORDER BY e.employee_id;

--02. 성이 King인 사원들의 사번, 성명, 부서코드, 부서명 조회

SELECT  e.employee_id, e.first_name || ' ' || e.last_name name,
        e.department_id, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id
        AND e.last_name LIKE 'King';

--03. 위치코드가 1400 인 도시에는 어느 부서가 있나 파악하고자 한다.
--위치코드가 1400 인 도시명, 부서명 조회

SELECT  l.city, d.department_name
FROM    locations l, departments d
WHERE   l.location_id = d.location_id
        AND l.location_id = 1400;

--04. 위치코드 1800 인 곳에 근무하는 사원들의
--사번, 성명, 업무코드, 급여, 부서명, 위치코드 조회

SELECT  e.employee_id, e.first_name || ' ' || e.last_name name,
        e.salary, d.department_name, d.location_id
FROM    employees e, departments d
WHERE   e.department_id = d.department_id
        AND d.location_id = 1800;

--05. 자신의 매니저보다 먼저 입사한 사원들의 
--사번, 성명, 입사일자, 매니저성명, 매니저 입사일자 조회 --SELF JOIN

SELECT   e.employee_id, e.first_name || ' ' || e.last_name name,
         e.hire_date, 
         NVL(m.first_name || ' ' || m.last_name, ' ') manager_name,
         NVL(TO_CHAR(m.hire_date), ' ') manager_hire_date
FROM     employees e, employees m
WHERE    e.manager_id = m.employee_id
         AND e.hire_date < m.hire_date
ORDER BY 1;

--06. toronto 에 근무하는 사원들의
--사번, 성, 업무코드, 부서코드, 부서명, 도시 조회

SELECT  e.employee_id, e.last_name, e.job_id, e.department_id,
        d.department_name, l.city
FROM    employees e, departments d, locations l
WHERE   e.department_id = d.department_id
        AND d.location_id = l.location_id
        AND l.city = 'Toronto';

--07. 커미션을 받는 모든 사원들의 성, 부서명, 위치코드, 도시 조회

SELECT  e.last_name, d.department_name, d.location_id, l.city
FROM    employees e, departments d, locations l
WHERE   e.department_id = d.department_id(+)
        AND d.location_id = l.location_id(+)
        AND e.commission_pct IS NOT NULL;



-----------------------------------------------------------------------------------------------






