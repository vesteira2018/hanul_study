--HR user에 관리되는 테이블 확인
SELECT  table_name
FROM    user_tables;

TABLE_NAME 
-----------------------------------------------------------------------------------------------
REGIONS     : 대륙정보
LOCATIONS   : 위치정보
DEPARTMENTS : 부서정보
JOBS        : 업무정보
EMPLOYEES   : 사원정보
JOB_HISTORY : 업무이력정보
COUNTRIES   : 국가정보
-----------------------------------------------------------------------------------------------


2.1 데이터 조회
DESC = DESCRIBE : 테이블의 컬럼이름, 데이터 형, 길이, NULL 허용 유무 등 특정테이블의 정보제공

DESC 테이블명 = DESCRIBE 테이블명

DESC employees; --employees 테이블의 구조 파악

SELECT ☞ 테이블에 저장된 데이터 조회, 가장 많이 사용
         SELECT 문장은 반드시 FROM 절이 따라 와야 함.
         
WHERE ☞ SELECT 문에서 마지막에 사용, 원하는 레코드 검색시 사용
        조건절의 구성은 컬럼, 연산, 비교 대상값이 온다.
        
사원테이블에서 모든 컬럼 조회
모든 컬럼 : *
특정 컬럼 : 해당 컬럼명

SELECT  *
FROM    테이블명;

SELECT  컬럼명1, 컬럼명2,...
FROM    테이블명;

사원테이블 모든 컬럼 조회
SELECT  *
FROM    employees;

--사원테이블에서 사번, 이름, 성 조회
SELECT  employee_id, first_name, last_name
FROM    employees;

--사원들에 대한 사번, 이름, 성, 부서코드, 입사일자, 업무코드, 급여 조회
SELECT  employee_id, first_name, last_name, department_id, 
        hire_date, job_id, salary
FROM    employees;

2.2 WHERE 절 ☜ 특정 조건에 맞는 레코드를 조회, 조건절에서는 ALIAS사용 불가

WHERE절에서 사용가능한 연산자
- 컬럼, 숫자, 문자, (문자, 숫자는 '(홑따옴표)로 구분
- 산술연산자(+,-,*,/) 비교연산자(=, !=, <>, ^=(같지 않다), >=,<=, <,>
- 연결연산자 (||)
- AND, OR, NOT
- LIKE, IN, BETWEEN,
- IS NULL, IS NOT NULL
- 함수

2.3 연산자
1. 산술연산자 +,-,*,/ SELECT절과 조건절안에서 사용 가능

01. 80번 부서의 사원의 사번, 성, 급여, 연봉 조회
SELECT  employee_id, last_name, salary, salary*12 annual_salary
FROM    employees;

다음과 같을때 SELECT절에 별명, 별칭, alias 를 습관적으로 지정하기
컬럼 표현이 연산자/함수 일때 
컬럼 표현이 너무 길때

컬럼의 다른 이름 ☞ ALIAS(별칭)
ALIAS 사용방법
1. 공백을 두고 사용한다. 컬럼표현 공백 ALIAS명
2. 키워드 AS를 사용한다. 컬럼표현 AS ALIAS명
3. ALIAS명에 공백이 있으면 쌍따옴표(")를 사용하고 공백이 없으면 "(쌍따옴표) 생략 가능
4. 한글 ALIAS명이 인식이 안될때는 "(쌍따옴표) 안에 작성

02. 연봉이 150000 이상인 사원들의
사번, 이름, 성, 업무코드, 급여, 연봉 조회
SELECT  employee_id, first_name, last_name, job_id, salary, salary*12 annual_salary
FROM    employees
WHERE   salary*12 > 150000; --WHERE절에서는 ALIAS 사용 불가

2. 문자 연결 연산자: || : SELECT 절과 조건절에 사용가능(SELECT 절에서 많이 사용)
SELECT  * 
FROM    employees;

01. 사번이 101번인 사원의 사번, 성명을 조회
성명은 이름과 성을 합해서 사용한다.
SELECT  employee_id, first_name || ' ' || last_name name
FROM    employees
WHERE   employee_id = 101;

02. 성명이 Steven King 인 사원의 
--StevenKing
사번, 성명, 업무코드, 급여, 부서코드 조회
성명은 이름과 성을 합해서 사용한다.
SELECT  employee_id, first_name || ' ' || last_name name, 
        job_id, salary, department_id
FROM    employees
WHERE   first_name || ' ' || last_name = 'Steven King';
--WHERE   first_name || last_name = 'StevenKing'


--3. 비교 연산자 : =, !=, <>, ^=, >, <, >=, <=
--01. 급여가 3000이하인 사원의 
--사번, 성, 급여, 부서코드, 업무코드를 조회
SELECT  employee_id, last_name, salary, department_id, job_id
FROM    employees
WHERE   salary <= 3000;

02. 부서코드가 80초과인 사원의
사번, 성, 급여, 부서코드 조회
SELECT  employee_id, last_name, salary, department_id
FROM    employees
WHERE   department_id > 80;

03. 부서코드가 90인 부서에 속한 사원들의
사번, 이름, 성, 부서코드, 업무코드 조회
SELECT  employee_id, first_name, last_name, department_id, job_id
FROM    employees
WHERE   department_id = 90;  /*부서코드가 90인 부서에 속한;*/
--WHERE   department_id IN (90);  /*부서코드가 90인 부서에 속한;*/

04. 급여가 17000 인 사원들의
사번, 이름, 성, 부서코드, 급여 조회
SELECT  employee_id, first_name, last_name, department_id, salary
FROM    employees
WHERE   salary = 17000; --급여가 17000;

05. 급여가 3000 이하인 사원들의 
사번, 이름, 성, 업무코드, 급여, 입사일자 조회
SELECT  employee_id, first_name, last_name job_id, salary, hire_date
FROM    employees
WHERE   salary <= 3000;   

06. 급여가 15000 이상인 사원들의
사번, 이름, 성, 업무코드, 급여 조회
SELECT  employee_id, first_name, last_name, job_id, salary
FROM    employees
WHERE   salary >= 15000; --급여가 15000 이상;

문자와 날짜는 '(홑따옴표)로 묶어서 사용

07. 성이 King인 사원들의 
사번, 이름, 성, 부서코드 조회
SELECT  employee_id, first_name, last_name, department_id
FROM    employees  
WHERE   last_name = 'King';

기본 날짜 데이터 포맷 조회
시스템의 현재 날짜를 반환하는 함수 - SYSDATE
다른함수와는 달리 파라미터가 없어 ()를 사용하지 않음

오늘 날짜 조회
SELECT  SYSDATE
FROM    dual;

날짜 포맷을 사용하여 사용자가 원하는 형태의 문자로 바꿔 표현
--SELECT  TO_CHAR(SYSDATE,'YYYY/MM/DD') today   --2020/11/11
--SELECT  TO_CHAR(SYSDATE,'YYYY/MONTH/DD') today  --2020/11월/11
--SELECT  TO_CHAR(SYSDATE,'YYYY/MM/DD HH:MI:SS') today --2020/11/11 03:28:18
SELECT  TO_CHAR(SYSDATE,'YYYY/MM/DD HH24:MI:SS') today --2020/11/11 15:28:58
FROM    dual; --dual : 가짜 데이터, 가라 데이터

08. 입사일이 2004년 1월 1일 이전(2003년까지)인 사원의
사원코드, 성, 입사일자를 조회
SELECT  employee_id, last_name, hire_date
FROM    employees 
--WHERE   hire_date < '2004-01-01';
--WHERE   hire_date < '2004/01/01';
--WHERE   hire_date <= '2003-12-31';
--WHERE   hire_date <= '2003/12/31';
--WHERE   TO_CHAR(hire_date,'YYYY') <= 2003;
WHERE   TO_CHAR(hire_date,'YYYY') < 2004;

4. 논리 연산
4.1 AND 연산자 : 조건이 모두 TRUE일때만 TRUE 반환

01. 30번 부서 사원중 급여가 10000이하인 사원의 
사원코드, 성명, 급여, 부서코드 조회
성명은 이름과 성을 합해서 'name'으로 별명한다.
SELECT employee_id, first_name || ' ' || last_name, salary, department_id
FROM   employees 
WHERE  department_id = 30
AND    salary <= 10000;

02. 30번 부서에서 급여가 10000 이하이면서 2005년 이전(2004년까지)에 입사한 사원의 
사원번호, 성명, 급여, 부서코드, 입사일자를 조회한다.
성명은 이름과 성을 합해서 사용하고 'name'으로 별명한다.
SELECT employee_id, first_name || ' ' || last_name, salary, department_id
FROM   employees 
WHERE  department_id = 30
AND    salary <= 10000
--AND    hire_date <= '2004-12-31';
--AND    hire_date < '2005-01-01';
AND    TO_CHAR(hire_date,'YYYY') <= 2004;

03. 부서코드가 10이상 30이하인 사원들의
사번, 성명, 부서코드 조회
성명은 이름과 성을 합해서 사용하고 'name'으로 별명한다.
SELECT employee_id, first_name || ' ' || last_name, salary, department_id
FROM   employees 
WHERE  department_id >= 10
AND    department_id <= 30;

4.2 OR연산자는 조건 중 하나만 TRUE이면 TRUE를 반환한다.
04. 30번 부서나 60번 부서에 속한 사원의 
성명, 급여, 부서코드 조회
SELECT  first_name || ' ' || last_name name, salary, department_id
FROM    employees
WHERE   department_id = 30 
OR      department_id = 60; 

05. 부서코드가 10, 20, 30인 부서에 속한 사원들의
사번, 성명, 부서코드, 업무코드 조회
SELECT  employee_id, first_name || ' ' || last_name name, department_id, job_id
FROM    employees
WHERE   department_id = 10 
OR      department_id = 20
OR      department_id = 30; 

4.3 AND연산자와 OR연산자를 혼합하여 문장을 작성
06. 30번 부서의 급여가 10000미만인 사원
    60번 부서의 급여가  5000이상인 사원의
성명, 급여, 부서코드 정보를 조회
SELECT  first_name || ' ' || last_name name, salary, department_id
FROM    employees
WHERE   (department_id = 30 AND salary < 10000)
OR      (department_id = 60 AND salary >= 5000);

연산자의 우선순위가 있다.
산술연산의 경우 : *,/ -> +,-
논리연산의 경우 : AND(논리곱), OR(논리합)


5. 범위 조건연산자 : BETWEEN 시작값 AND 끝값
A이상 B이하 : 컬럼명 BETWEEN A AND B, 
A미만 B초과 : 컬럼명 NOT BETWEEN A AND B

01. 사번 110부터 120까지
사원번호, 성명, 급여, 부서코드 조회
SELECT  employee_id, first_name || ' ' || last_name name, salary, department_id
FROM    employees
--WHERE   employee_id >= 100
--AND     employee_id <= 120;
WHERE   employee_id BETWEEN 100 AND 120;

02. 사번 110미만 120초과인
사원번호, 성명, 급여, 부서코드 조회
SELECT  employee_id, first_name || ' ' || last_name name, salary, department_id
FROM    employees
--WHERE   employee_id < 100
--OR      employee_id > 120;
WHERE   employee_id NOT BETWEEN 100 AND 120;

03. 사번이 110에서 120인 사원 중 급여가 5000에서 10000사이의
사번, 성명, 급여, 부서코드 조회



04. 2005년 1월 1일 이후부터 2007년 12월 31일 사이에 입사한 사원의
사번, 성명, 급여, 입사일자 정보를 조회한다.
SELECT  employee_id, first_name || ' ' || last_name name, salary, hire_date
FROM    employees
--WHERE   hire_date >= '2005-01-01'
--AND     hire_date <= '2007-12-31';
--WHERE   hire_date BETWEEN '2005-01-01' AND '2007-12-31'; --묵시적 표현
WHERE   hire_date BETWEEN TO_DATE('2005-01-01') AND TO_DATE('2007-12-31');  --명시적 표현

05. 부서코드가 20, 30, 40, 60, 100, 110 인 부서에 속한 사원들의 
사번, 성명, 부서코드 조회
SELECT  employee_id, first_name || ' ' || last_name name, department_id
FROM    employees
--WHERE   department_id = 20
--OR      department_id = 30
--OR      department_id = 40
--OR      department_id = 60
--OR      department_id = 100
--OR      department_id = 110;
WHERE   department_id IN (20, 30, 40, 60, 100, 110);

6. IN연산자 = OR연산자의 기능이 동일
여러개의 값 중 일치하는 값이 있는지 비교할때는 [NOT] IN(값1,값2,값3....)의 형태로
비교하는 값의 목록을 나열한다.
OR연산자로 나열한것을 컬럼 표현 IN(값 목록)으로 동일하다.

7. 검색에 해당하는 연산자 
필드명 LIKE 조건연산자(포함하는)
필드명 NOT LIKE 조건연산자(포함하지 않는)

컬럼값들 중에 특정패턴에 속하는 값을 조회하고자 할때 사용
% : 여러개의 문자열, 모든것
_ : 하나의 문자

컬럼표현 LIKE 검색할문자 + %
성명 = '홍길동' -> 성명이 홍길동
성명 LIKE '홍%' -> 성명이 홍으로 시작하는 모든 것, 홍길동, 홍명보, 홍금보, 홍시, 홍
성명 LIKE '%홍' -> 성명이 홍으로   끝나는 모든 것, 분홍, 다홍, 홍
성명 LIKE '%홍%' -> 성명이 홍을  포함한는 모든 것, 

01. 이름이 K로 시작되는 사원들의 
사번, 이름, 성 조회
SELECT  employee_id, first_name || ' ' || last_name name
FROM    employees
WHERE   first_name LIKE 'K%';


02. 이름이 s로 끝나는 이름을 가진 사원들의 
사번, 이름, 성 조회
SELECT  employee_id, first_name || ' ' || last_name name
FROM    employees
WHERE   first_name LIKE '%s';

03. 성에 소문자 z 가 포함된 성을 가진 사원들의
사번, 이름, 성 조회
SELECT  employee_id, first_name || ' ' || last_name name
FROM    employees
WHERE   last_name LIKE '%z%';

04. 성에 대소문자 무관하게 z 가 포함된 성을 가진 사원들의 
사번, 이름, 성 조회

SELECT  employee_id, first_name || ' ' || last_name name
FROM    employees
WHERE   last_name LIKE '%z%'
OR      last_name LIKE '%Z%';

05. 성명에 대소문자 무관하게 z가 포함된 성명을 가진 사원들의 
사번, 성명 조회
SELECT  employee_id, first_name || ' ' || last_name name
FROM    employees
WHERE   first_name || ' ' || last_name LIKE '%z%'
OR      first_name || ' ' || last_name LIKE '%Z%';


06. 성에 소문자 z가 2번째에 위치해 있는 성을 가진 사원들의 
사번, 성명 조회
SELECT  employee_id, first_name || ' ' || last_name name
FROM    employees
WHERE   last_name LIKE '_z%';

07. 성에 소문자 z가 5번째에 위치해 있는 성을 가진 사원들의 
사번, 성명 조회
SELECT  employee_id, first_name || ' ' || last_name name
FROM    employees
WHERE   last_name LIKE '____z%';

08. 성에 소문자 z가 뒤에서부터 5번째에 위치해 있는 성을 가진 사원들의 
사번, 성명 조회
SELECT  employee_id, first_name || ' ' || last_name name
FROM    employees
WHERE   last_name LIKE '%z____';

09. 전화번호가 6으로 시작되지 않는 사원의 
사번, 성명, 급여, 휴대전화 정보를 조회

WHERE NOT LIKE '6%';

******LIKE, BETWEEN, IN 모두 NOT 연산자와 같이 사용이 가능합니다.

10. ※※※※※ 입사일자가 12월에 입사한 사원들의 
사번, 성, 입사일자 조회
SELECT  employee_id, last_name, hire_date
FROM    employees
--WHERE   hire_date LIKE '%12%'; --XXX
--WHERE   hire_date LIKE '%/12/%';
--WHERE   hire_date LIKE '___12___';
--WHERE   hire_date LIKE '__%12%__';
WHERE   TO_CHAR(hire_date,'MM') = 12;

SELECT job_id
FROM   employees;

사원들의 업무형태(업무코드)가 _A인 사원들의 
사번, 성, 업무코드 조회
예를 들어, FI_ACCOUNT, AD_ASST, AC_ACCOUNT
SELECT  employee_id, last_name, job_id
FROM    employees
WHERE   job_id LIKE '%\_A%' escape '\';  -- : _(언더바) -> 한글자, _A : A글자 앞에 한글자

LIKE 연산자와 함께 사용되는 %, _ 를 문자로 취급하려면
%, _ 앞에 기호문자를 붙이고 escape라는 옵션을 지정한다.
컬럼표현 LIKE '\_' 하고 escape '\'
특수문자 ~,!,@,#,$,^,&,*,-,?,\






























































































