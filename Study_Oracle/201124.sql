-- 부서별로 가장 많은 급여를 받는 사원의
-- 부서코드, 최대급여, 이름을 조회
-- 1.
SELECT   e.department_id, e.salary, first_name
FROM     employees e, (SELECT    department_id, MAX(salary) max_sal
                       FROM      employees
                       GROUP BY  department_id) m
WHERE    NVL(e.department_id, 0) = NVL(m.department_id, 0)
AND      e.salary = m.max_sal
ORDER BY 1;

-- 2.
SELECT   e.department_id, e.salary, first_name
FROM     employees e, (SELECT    department_id, MAX(salary) max_sal
                       FROM      employees
                       GROUP BY  department_id) m
WHERE    NVL(e.department_id, 0) = NVL(m.department_id, 0)
AND      e.salary = m.max_sal
ORDER BY 1;

SELECT    e.employee_id, e.last_name, e.department_id, e.hire_date
FROM      employees e, (SELECT    department_id, MAX(hire_date) max_hire_date
                        FROM      employees
                        GROUP BY  department_id) m
WHERE     NVL(e.department_id, 0) = NVL(m.department_id, 0)
AND       e.hire_date = m.max_hire_date
ORDER BY  1;

-- 05. 매너지가 없는 부서의 부서코드, 사번 조회
SELECT    department_id
FROM      employees
WHERE     manager_id IS NULL;  -- 90

SELECT    department_id, employee_id
FROM      employees
WHERE     department_id IN (SELECT department_id
                            FROM   employees
                            WHERE  manager_id IS NULL);
                            
SELECT    e.department_id, e.employee_id
FROM      employees e, (SELECT department_id
                        FROM   employees
                        WHERE  manager_id IS NULL) m
WHERE     NVL(e.department_id, 0) = NVL(m.department_id, 0);

-- 스칼라 서브쿼리 : SELECT 문에 사용, 단일결과행, 단일 컬럼만 사용 가능
-- 단순한 그룹함수의 결과를 SELECT 절에 조회하고자 할 때
-- 컬럼 표현 용도
-- JOIN의 대체 표현식으로 사용
-- JOIN조건식이 필요할 때 스칼라 서브쿼리 안에서 WHERE 조건식 사용

-- 1) 단순한 그룹함수의 결과값을 조회하고자 할 때
-- 01. 모든 사원의 사번, 성, 급여, 회사평균급여, 회사최대급여

SELECT   employee_id, last_name, salary,
         (SELECT ROUND(AVG(salary),2) FROM employees) avg_sal, 
         (SELECT MAX(salary) FROM employees) max_sal
FROM     employees
GROUP BY employee_id, last_name, salary;

-- 02. 모든 사원의 사원, 성, 부서코드, 부서명
SELECT  e.employee_id, e.last_name, e.department_id,
        (SELECT department_name
         FROM   departments
         WHERE  e.department_id = department_id) department_id
FROM    employees e;

-- 03
-- 사번, 성, 부서코드, 업무코드, 업무제목
SELECT  e.employee_id, e.last_name,
        e.department_id, e.job_id,
        (SELECT  department_name
         FROM    departments
         WHERE   e.department_id = department_id) "업무제목"
FROM    employees e;

-- 04
-- 부서코드, 부서명, 도시
SELECT    d.department_id, d.department_name,
          (SELECT city
           FROM   locations
           WHERE  d.location_id = location_id) city
FROM      departments d;

-- 05
-- 사번, 성, 급여, 부서코드, 부서명, 업무코드
SELECT  e.employee_id, e.last_name, e.salary,
        e.department_id, 
        (SELECT department_name
         FROM   departments
         WHERE  e.department_id = department_id) department_name,
         e.job_id
FROM     employees e;

-- 06
-- 각 부서에 대해 부서코드, 부서명, 위치코드, 도시명 조회
SELECT  d.department_id, d.department_name, d.location_id,
        (SELECT city
         FROM   locations
         WHERE  d.location_id = location_id) city
FROM    departments d;

SELECT   d.department_id, d.department_name, d.location_id,
         l.city
FROM     departments d, locations l 
WHERE    d.location_id = l.location_id
ORDER BY 1;
      
-- 07
-- 각 부서별로 부서코드, 부서평균급여 조회
SELECT   department_id, ROUND(AVG(salary),2)
FROM     employees
GROUP BY department_id
ORDER BY 1;

SELECT   e.department_id, 
         (SELECT  ROUND(AVG(salary),2)
          FROM    employees
          WHERE   e.department_id = department_id) avg_sal
FROM     employees e
GROUP BY e.department_id
ORDER BY 1;

-- 08
-- 각 사원에 대해 사원이 소속된 부서의 급여정보 대비 
-- 사원의 급여를 파악하고자 한다
-- 사번, 성, 부서코드, 급여, 각 사원이 속한 부서의 평균 급여
SELECT   e.employee_id, e.last_name, e.department_id, e.salary,
        (SELECT   ROUND(AVG(salary), 2)
         FROM     employees
         WHERE    e.department_id = department_id) avg_sal
FROM     employees e
ORDER BY 3;

-- 5. FROM 절에 사용하는 인라인 뷰 서브쿼리
-- SELECT 절의 결과를 FROM 절에서 하나의 테이블 용도로 사용
-- FROM 절에 사용하는 인라인 뷰 서브쿼리에서 
-- 그룹함수를 반드시 ALIAS 지정

-- 01. 최대급여, 최소급여, 평균급여 조회
SELECT  MAX(salary), MIN(salary), ROUND(AVG(salary), 2)
FROM    employees;

-- 02. 사번, 성, 급여, 최대급여, 최소급여, 평균급여 조회
SELECT  employee_id, last_name, salary, m.max_sal, m.min_sal, m.avg_sal
FROM    employees e, (SELECT  MAX(salary) max_sal, MIN(salary) min_sal, ROUND(AVG(salary),2) avg_sal
                      FROM    employees) m;
                      
-- 03. 사원이 받는 급여가 회사평균급여 이상 최대급여 이하에 해당하는
-- 사번, 성, 급여, 최대급여, 최소급여, 평균급여
SELECT   e.employee_id, e.last_name, e.salary, m.max_sal, m.min_sal, m.avg_sal
FROM     employees e, (SELECT MAX(salary) max_sal, MIN(salary) min_sal, ROUND(AVG(salary)) avg_sal
                       FROM employees) m
WHERE    salary BETWEEN (SELECT AVG(salary) FROM employees)
         AND (SELECT MAX(salary) FROM employees);
         
-- 사번, 성, 부서코드, 부서원 수, 부서최대급여, 최소급여, 평균급여
SELECT  e.employee_id, e.last_name, e.department_id,
        m.cnt, m.max_sal, m.min_sal, m.avg_sal
FROM    employees e, (SELECT department_id,
                             COUNT(*) cnt,
                             MAX(salary) max_sal, 
                             MIN(salary) min_sal, 
                             ROUND(AVG(salary)) avg_sal
                      FROM   employees
                      GROUP BY department_id) m
WHERE e.department_id = NVL(m.department_id,0);