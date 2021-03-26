-----------------------------------------------------------------------------------------------
--[연습문제 3-5]
--1. 사원들의 사번, 이름, 업무코드, 업무등급 조회
--업무등급은 업무코드에 따라 분류한다.
--DECODE 와 CASE~END 사용하여 조회
--
--업무코드    업무등급
--AD_PRES      A
--ST_MAN       B
--IT_PROG      C
--SA_REP       D
--ST_CLERK     E
--그 외        X

SELECT  employee_id, first_name, job_id, 
        CASE job_id WHEN 'AD_PRES' THEN 'A'
                    WHEN 'ST_MAN' THEN 'B'
                    WHEN 'IT_PROG' THEN 'C'
                    WHEN 'SA_REP' THEN 'D'
                    WHEN 'ST_CLERK' THEN 'E'
                    ELSE 'X'
        END job_grade
FROM    employees;





-----------------------------------------------------------------------------------------------

--2. 모든 사원의 각 사원들의 근무년수, 근속상태를 파악하고자 한다.
--사원들의 사번, 성, 입사일자, 근무년수, 근속상태 조회
--근무년수는 오늘을 기준으로 근무한 년수를 정수로 표현한다.
--근속상태는 근무년수에 따라 표현한다.
--근무년수가 13년 미만 이면              '13년 미만 근속'으로 표현
--           13년 이상 15년 미만 이면    '15년 미만 근속'으로 표현
--           15년 이상 이면              '15년 이상 근속'으로 표현    
               
SELECT  employee_id, last_name, hire_date,
        TRUNC(MONTHS_BETWEEN(SYSDATE, hire_date)/12, 0) "years",
        CASE WHEN TO_CHAR(MONTHS_BETWEEN(SYSDATE, hire_date)/12) < 13 THEN '13년 미만 근속'
             WHEN TO_CHAR(MONTHS_BETWEEN(SYSDATE, hire_date)/12) BETWEEN 13 AND 15 THEN '15년 미만 근속'
             ELSE '15년 이상 근속'
        END "hire_state"
FROM    employees;







-----------------------------------------------------------------------------------------------
