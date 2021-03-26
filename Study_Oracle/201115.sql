-- 3.6 DECODE와 CASE

-- 1. 조건문에 해당하는 함수
-- IF (조건식1) {
-- ...
-- } ELSE IF (조건식2) {
-- ...
-- } ELSE {
-- ... }

-- 부서별로 보너스를 지급하려고 한다.
-- 부서코드가 10이면 급여의 10%, 20이면 급여의 20%, 30이면 급여의 30%,
-- 나머지 부서는 급여의 5%
-- IF (department_id = 10) {
--  Bonus = salary * 0.1
-- } ELSE IF (department_id = 20) {
--  Bonus = salary * 0.2 
-- } ELSE IF (department_id = 30) {
--  Bonus = salary * 0.3
-- } ELSE {
--  Bonus = salary * 0.05 }

-- 조건문에 해당하는 함수 : DECODE (오라클에서만 사용 가능)
-- : DECODE (대상표현, 비교데이터표현1, 반환데이터1,
--                     비교데이터표현2, 반환데이터2,
--                     비교데이터표현3, 반환데이터3,
--                     defalut반환데이터);

-- 대상표현과 비교데이터표현은 데이터타입이 같아야 한다.

-- 사번, 성, 부서코드, 급여, 보너스
SELECT  employee_id, last_name, department_id, salary,
        DECODE(department_id, 10, salary*0.1,
                              20, salary*0.2,
                              30, salary*0.3,
                              salary*0.05) bonus
FROM    employees;

-- 사원들의 사번, 성, 업무코드, 업무등급조회(업무코드에 따라)
-- AD_PRESS / A
-- ST_MAN / B
-- IT_PROG / C
-- ELSE / X

SELECT  employee_id, last_name, job_id,
        DECODE(job_id, 'AD_PRES', 'A',
                       'ST_MAN', 'B',
                       'IT_PROG', 'C',
                       'X') job_grade
FROM    employees;

-- 조건문에 해당하는 구문 : CASE ~ END
-- CASE함수는 DECODE함수보다 더 큰 개념을 가진 표현식이다
-- DECODE는 동등연산만 가능
-- CASE는 더 다양한 범위비교연산도 가능

-- 동등비교시 표현
-- CASE 대상표현 WHEN 비교데이터값1 THEN 반환데이터1
--               WHEN 비교데이터값2 THEN 반환데이터2
--               WHEN 비교데이터값3 THEN 반환데이터3
--      ELSE defalut 반환데이터
-- END

SELECT  employee_id, last_name, job_id,
        CASE  department_id WHEN 10 THEN salary*0.1
                            WHEN 20 THEN salary*0.2
                            WHEN 30 THEN salary*0.3
              ELSE salary*0.4
        END bonus
FROM    employees;


SELECT  employee_id, last_name, job_id,
        CASE job_id WHEN 'AD_PRES' THEN 'A'
                    WHEN 'ST_MAN' THEN 'B'
                    WHEN 'IT_PROG' THEN 'C'
              ELSE 'X'
        END job_grade
FROM    employees;

SELECT  employee_id, last_name, job_id,
        CASE  WHEN department_id = 10 THEN salary*0.1
              WHEN department_id = 20 THEN salary*0.2
              WHEN department_id = 30 THEN salary*0.3
              ELSE salary*0.4
        END bonus
FROM    employees;

SELECT  employee_id, last_name, job_id,
        CASE  WHEN job_id = 'AD_PRES' THEN 'A'
              WHEN job_id = 'ST_MAN' THEN 'B'
              WHEN job_id = 'IT_FROG' THEN 'C'
              ELSE 'X'
        END bonus
FROM    employees;

-- 동등비교 또는 범위비교시 표현 (연산자 =, <, <=, >, >=, !=)
SELECT  employee_id, last_name, department_id, salary,
        CASE WHEN department_id BETWEEN 10 AND 30 THEN salary*0.1
             WHEN department_id BETWEEN 40 AND 60 THEN salary*0.2
             WHEN department_id BETWEEN 70 AND 100 THEN salary*0.3
             ELSE salary*0.05
        END bonus
FROM    employees;

SELECT  employee_id, last_name, department_id, salary, job_id,
        CASE WHEN department_id <= 20 THEN salary*0.3
             WHEN salary >= 10000 THEN salary*0.2
             WHEN job_id = '%CLERK' THEN salary*0.1
             ELSE salary*0.05
        END bonus
FROM    employees;

-- 그룹함수 : 여러 행으로부터 하나의 결과값을 반환
-- 전체 데이터를 그룹별로 구분하여 통계적인 결과를 구하기 위해서 사용하는 함수
-- 1. COUNT : 입력되는 데이터의 총 개수를 출력
-- 2. SUM : 입력되는 데이터의 합계 값을 출력
-- 3. AVG : 입력되는 데이터의 평균 값을 출력
-- 4. MAX : 입력되는 데이터의 가장 큰 값을 출력
-- 5. MIN : 입력되는 데이터의 가장 작은 값을 출력
-- 6. ROLLUP : 입력되는 데이터의 소계값을 출력
-- 7. CUBE : 입력되는 데이터의 소계값과 전체총계를 출력
-- 8. RANK : 주어진 컬럼의 그룹에서 값의 순위를 출력
-- 9. DENSE_RANK : 주어진 컬럼의 구룹에서 값의 순위를 출력 (RANK와 비슷, 
--                 동일한 순위를 하나의 건수로 취급)

-- DISTINCT : SELECT 바로 다음에 쓰여 중복제거한 결과를 보여준다 (키워드, null 포함)
SELECT  DISTINCT department_id
FROM    employees;

SELECT  DISTINCT department_id
FROM    employees
WHERE   department_id IS NOT NULL;

-- NULL은 내림차순에서 우선순위를 갖는다 (먼저 정렬된다)
-- 오름차순일 때는 반대로 NULL이 가장 마지막에 위치

-- 내림차순일 때 NULL을 가장 마지막에 정렬시키려면 DESC NULLS LAST
-- 오름차순일 때 NULL을 가장 먼저 정렬시키려면 ASC NULLS FIRST

-- 그룹함수 : NULL 제외
-- 1. 개수를 세어 반환하는 함수 : COUNT(컬럼명), COUNT(*)
-- 사원 수, 부서배치를 받은 사원 수, 부서 수, 커미션을 받는 사원 수
SELECT  COUNT(employee_id) CNT1,
        COUNT(department_id) CNT2,
        COUNT(DISTINCT department_id) CNT3,
        COUNT(commission_pct) CNT4
FROM    employees;

-- 2. 회사 사원 수
SELECT  COUNT(*) cnt
FROM    employees;

-- 3. 회사 부서수
SELECT  COUNT(DISTINCT department_id) cnt
FROM    employees;

-- 4. 매니저인 사원들 조회
SELECT    DISTINCT manager_id
FROM      employees
WHERE     manager_id IS NOT NULL
ORDER BY  1;

-- 부서코드 60번 부서에 속한 사원 수
SELECT  COUNT(*) cnt
FROM    employees
WHERE   department_id = 60;

-- clerk 업무에 종사하는 사원 수
SELECT  COUNT(*) cnt
FROM    employees
WHERE   UPPER(job_id) LIKE '%CLERK';

-- 2. 합을 반환하는 함수 : SUM(컬럼명)
-- 01. 회사 모든 사원들의 급여를 합한 결과를 조회
SELECT  SUM(salary) sum_salary
FROM    employees;

-- 02. 부서코드 60번 부서에 속한 사원들의 급여 합 조회
SELECT  SUM(salary) sum_salary
FROM    employees
WHERE   department_id = 60;

-- 03. account 업무를 하는 사원들의 급여 합 조회
SELECT  TRIM(TO_CHAR(SUM(salary), '999,999')) sum_salary
FROM    employees 
WHERE   LOWER(job_id) LIKE ('%account%');

-- 3. 가장 큰 값/작은 값 반환하는 함수 : MAX(컬럼명)/MIN(컬럼명)
-- 숫자, 문자, 날짜에 사용 가능

-- 01. 회사 사원들 중 가장 많은 급여, 적은 급여를 조회
SELECT  MAX(salary) max_sal, MIN(salary) min_sal
FROM    employees;

-- 02. 회사 사원 중 가장 먼저 입사, 가장 나중에 입사한 사원 조회
SELECT  MIN(hire_date) "대장", MAX(hire_date) "막내"
FROM    employees;

-- 03. 회사 사원 중 이름순으로 정렬할 때 가장 먼저/나중에 나오는 사람 조회
SELECT  MIN(last_name) "A", MAX(last_name) "Z"
FROM    employees;

-- 04. clerk 업무를 하는 사원 중 가장 선배/막내 의 입사 일자
SELECT  MIN(hire_date) "선배", MAX(hire_date) "막내"
FROM    employees
WHERE   LOWER(job_id) LIKE '%clerk';

-- 4. 평균값 반환 : AVG(컬럼명), 숫자만 가능
-- 01. 회사 사원들의 급여 평균을 조회
SELECT  ROUND(AVG(salary), 2) average
FROM    employees;





