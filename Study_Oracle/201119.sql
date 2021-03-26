-- 3. NON-EQUI JOIN
-- : 비교연산자(<, <=, >, >=), 범위연산자(BETWEEN), IN연산자 등의
-- 동등비교연산자(=, !=) 이외의 연산자를 사용하는 JOIN 형식

-- 01. employees, jobs 테이블 이용하여
-- 급여가 최고, 최소 범위 내에 있는  10번 부서원의
-- 사번, 이름, 급여, 업무제목 조회
SELECT    e.employee_id, e.first_name, e.salary, j.job_title
FROM      employees e, jobs j
WHERE     e.job_id = j.job_id
          AND e.department_id = 10
          AND e.salary BETWEEN j.min_salary AND j.max_salary;
          
-- 4. OUTER JOIN
-- : NULL값이 생략되는 정보도 포함해서 표시하기 위한 JOIN, 합집합
-- EQUI JOIN은 JOIN조건에 동등비교 연산자로 비교한 형태
-- 즉, 테이블 간에 공통으로 만족되는 값을 반환
-- OUTER JOIN은 만족되는 값이 없는 경우의 결과까지 반환
-- 만족되는 값이 없는 테이블 컬럼에 (+)기호를 표시한다
-- 데이터 누락이 발생하지 않도록 하기 위한 JOIN 기법
-- : JOIN조건식에서 (+)기호를 데이터 행이 부족한 JOIN조건 쪽에 붙인다.

-- OUTER JOIN → LEFT/RIGHT JOIN : 기준이 되는 테이블 방향으로 JOIN
-- LEFT   OUTER JOIN : 왼쪽 테이블 기준으로 NULL포함하여 모두 출력(등호의 오른쪽에 (+))
-- RIGHT  OUTER JOIN : 오른쪽 테이블 기준으로 NULL포함하여 모두 출력(등호의 왼쪽에 (+))

-- 01. 모든 사원의 사번, 성, 부서코드, 부서명 조회
SELECT  e.employee_id, e.last_name, e.department_id, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id(+);

-- 사원 테이블에서 부서배치를 받지 않은 사원(department_id = NULL) 데이터행
-- 부서 테이블에서 부서코드가 NULL인 것에 대한 데이터 행이 존재하지 않는다.
-- JOIN컬럼에서 데이터가 없는 테이블에 (+)를 붙인다
-- 부서테이블의 부서코드쪽에 OUTER 기호

-- employees(+)   departments(+)            locations(+)
-- 사번 부서코드  부서코드 부서명 위치코드   위치코드  부서위치
-- 100  10        10      영업부 1600       1600      Seattle
-- 100  20        20      총무부 1700       1700      Paris
-- 178  NULL      NULL    NULL   NULL       NULL      NULL

-- 01. 모든 사번의 사번, 성, 업무코드, 업무제목 표시
SELECT  e.employee_id, e.last_name, e.job_id, j.job_title
FROM    employees e, jobs j
WHERE   e.job_id = j.job_id;

-- 02. 사번, 성, 부서명, 업무제목 조회
SELECT  e.employee_id, e.last_name, d.department_name, j.job_title
FROM    employees e, departments d, jobs j
WHERE   e.department_id = d.department_id(+)
        AND e.job_id = j.job_id;

-- 03. 사번, 성, 부서코드, 부서명, 위치코드, 도시 조회
SELECT  e.employee_id, e.last_name, e.department_id, 
        d.department_name, d.location_id, l.city
FROM    employees e, departments d, locations l
WHERE   e.department_id = d.department_id(+)
        AND d.location_id = l.location_id(+);

-- 04. 사번, 성, 부서코드, 부서명, 업무코드, 업무제목
SELECT  e.employee_id, e.last_name, e.department_id, 
        d.department_name, e.job_id, j.job_title
FROM    employees e, departments d, jobs j
WHERE   e.department_id = d.department_id(+)
        AND e.job_id = j.job_id;
        

-- 5. SELF JOIN
-- : 하나의 테이블을 두 번 명시하여 동일한 테이블 두 개로부터 JOIN을 통해
-- 데이터를 조회하여 결과를 반환. 즉, 한 테이블 내에서 두 데이터 컬럼이 연관 관계가 있다.

-- employees 테이블에는 사원정보, 관리자 정보도 있다
-- 동일한 테이블을 여러 개 준비하여 테이블 조인을 하는 SELF JOIN

-- 01. 사번, 이름, 매니저사번, 매니저 이름 정보 조회
SELECT   e.employee_id, e.first_name, 
         NVL(TO_CHAR(e.manager_id), '매니저 없음') "manager_id",
         NVL(m.first_name, '매니저 이름 없음') "manager_name"
FROM     employees e, employees m
WHERE    e.manager_id = m.employee_id(+)
ORDER BY 1;

SELECT   e.employee_id, e.first_name, 
         NVL2(e.manager_id, TO_CHAR(e.manager_id), '매니저 없음') "manager_id", 
         NVL2(m.first_name, m.first_name, '매니저 이름 없음') "manager_name"
FROM     employees e, employees m
WHERE    e.manager_id = m.employee_id(+)
ORDER BY 1;
