-----------------------------------------------------------------------------------------------
--실습
--01. 성에 대소문자 무관하게 z가 포함된 성을 가진 사원들이 모두 몇명인지 파악하고자 한다.
--성에 대소문자 무관하게 z가 포함된 성을 가진 사원들의 수를 조회하시오.

SELECT  COUNT(*) cnt
FROM    employees
WHERE   LOWER(last_name) LIKE ('%z%');


--02. 우리회사 사원들 최고급여와 최저급여 간 급여차를 파악하고자 한다.
--우리회사 최고급여와 최저급여의 급여차를 조회하시오.

SELECT  MAX(salary)-MIN(salary) gap
FROM    employees;


--03. 우리회사에 매니저로 있는 사원들의 수를 파악하고자 한다.
--우리회사 매니저인 사원들의 수를 조회하시오.

SELECT  COUNT(DISTINCT manager_id) cnt
FROM    employees;


--04. 우리회사 account 업무를 하는 사원들의 급여평균를 조회하시오.
--소수이하 2자리까지 구하시오.

SELECT  ROUND(AVG(salary), 2) avg_salary
FROM    employees
WHERE   LOWER(job_id) LIKE '%account%';


--05. 우리회사 사원들의 사번, 성, 부서코드, 급여 조회하여 부서코드 순으로 정렬한다.
  
SELECT    employee_id, last_name, department_id, salary
FROM      employees
ORDER BY  department_id;


--06. 부서코드 50번 부서의 급여평균를 조회

SELECT  ROUND(AVG(salary), 2) avg_salary
FROM    employees
WHERE   department_id = 50;

-----------------------------------------------------------------------------------------------
--[연습문제 4-2]
--01. 우리회사 사원들 중 커미션을 받는 사원들이 모두 몇명인지 파악하고자 한다.
--커미션을 받는 사원의 수를 조회

SELECT  COUNT(commission_pct) cnt
FROM    employees
WHERE   commission_pct IS NOT NULL;



--02. 우리회사 사원들 중 가장 먼저/나중에 입사한 사원의 입사일자 조회

SELECT  MIN(hire_date) "선배", MAX(hire_date) "막내"
FROM    employees;



--03. 우리회사 부서코드 90번인 부서에 속한 사원들의 급여평균 조회

SELECT  TO_CHAR(ROUND(AVG(salary), 2), '999,999.99') sal_avg
FROM    employees
WHERE   department_id = 90;



-----------------------------------------------------------------------------------------------










