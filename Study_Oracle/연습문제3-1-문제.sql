------------------------------
--[연습문제 3-1]
--01. 사원 테이블에서 부서코드가 100, 110 인 부서에 속한 사원들의
--사번, 성명, 급여, 부서코드, 15%인상된 급여 조회 - 인상된 급여는 정수로 표현
--컬럼명은 Increased Salary 로 표시한다.

SELECT  employee_id, first_name || ' ' || last_name name, salary, department_id, ROUND(salary*1.15) "Increased Salary"
FROM    employees
WHERE   department_id IN (100, 110);
