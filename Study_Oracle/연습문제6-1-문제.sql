------------------------------------------------------------------------
[연습문제 6-1]
01. 우리회사에서 가장 적은 급여를 받는 사원의 
사번, 성, 업무코드, 부서코드, 부서명, 급여 조회

SELECT  e.employee_id, e.last_name, e.job_id, e.department_id, 
        d.department_name, e.salary
FROM    employees e, departments d
WHERE   e.department_id = d.department_id
        AND e.salary = 
        (SELECT MIN(salary) FROM employees);



02. 부서명이 Marketing 인 부서에 속한 사원들의 
사번, 성명, 부서코드, 업무코드 조회

SELECT  e.employee_id, e.first_name || ' ' || e.last_name name,
        e.department_id, e.job_id
FROM    employees e, departments d
WHERE   e.department_id = d.department_id
        AND d.department_name LIKE 'Marketing';

03. 우리회사 사장님보다 먼저 입사한 사원들의 
사번, 성명, 입사일자 조회
사장은 그를 관리하는 매니저가 없는 사원을 말한다

SELECT  employee_id, first_name || ' ' || last_name name,
        hire_date
FROM    employees
WHERE   hire_date < (SELECT hire_date FROM employees 
        WHERE manager_id IS NULL);



------------------------------------------------------------------------