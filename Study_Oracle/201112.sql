8. 데이터 값이 없는 형태의 표현 : NULL -> 비교불가, 산술연산 불가
그래서, 컬럼표현 IS NULL/IS NOT NULL 형태로 판단, NULL 인지 아닌지 파악
=null xxx
IS NULL OOO

SELECT  * --23개
FROM    locations;

SELECT  * --17개
FROM    locations
WHERE   state_province LIKE '%';

SELECT  * --17개
FROM    locations
WHERE   state_province IS NOT NULL;

01. 부서배치 받지 않는(부서코드가 NULL) 사원들의
사번, 성, 부서코드, 업무코드, 급여조회

SELECT  employee_id, last_name, department_id, job_id, salary
FROM    employees
--WHERE   department_id = NULL; --XXX
WHERE   department_id = NULL; --OOO

02. 커미션을 받는 사원들의
사번, 성, 부서코드, 커미션요율 조회
SELECT  employee_id, last_name, department_id, commission_pct
FROM    employees
WHERE   commission_pct IS NOT NULL; --커미션을 받는

2.4 데이터행 정렬 - ORDER BY 절, 쿼리문의 제일 마지막에 위치
ORDER BY 정렬기준표현 ASC(오름차순, 생략가능)/DESC(내림차순)
정렬기준표현 : 컬럼명, ALIAS명, 컬럼번호

프로그램상에서는 정렬 안하고 DB에서 정렬해서 프로그램을 넘김

01. 80번 부서의 사번, 성, 급여, 부서코드에 대해 성으로 오름차순/내림차순
SELECT  employee_id, last_name name, salary, department_id
FROM    employees
WHERE   department_id = 80
--ORDER BY  last_name ASC; --오름차순
--ORDER BY  last_name DESC; --내림차순, 컬럼명
--ORDER BY  2 DESC; --내림차순, 컬럼번호
ORDER BY  name DESC; --내림차순, alias 명

3장. 기본 함수
: 숫자함수, 문자함수, 날짜함수, 형변환함수, 일반함수

함수의 유형 : 단일(결과)행 함수, 다중(결과)행(복수행) 함수
함수에 사용하는 파라미터와 반환되는 값의 유형에 따라 함수를 구분
단일(결과)행 함수 : 하나의 데이터행에 대해 하나의 결과를 반환하는 형태의 함수
숫자함수: ROUND, TRUNC, CEIL, FLOOR
문자함수: UPPER, LOWER, TRIM, LTRIM/RTRIM, LPAD/RPAD, 
          SUBSTR, INSTR, REPLACE, TRANSLATE
날짜함수: SYSDATE, MONTHS_BETWEEN, ADD_MONTHS, LAST_DAY
형변환함수: TO_CHAR, TO_NUMBER, TO_DATE
일반함수: NVL, NVL2, COALESCE, DECODE, CASE~END

데이터 테스트를 위한 테이블 : dummy table ☞ dual, 실제로 데이터는 들어가 있지 않음.

3.1 숫자함수
ABS(n) : n의 절대값을 반환하는 함수이다.
SELECT  ABS(32), ABS(-32)
FROM    dual;

SIGN(n) : n이 양수인지 음수인지의 여부를 반환하는 함수이다. 
n이 양수이면 1을, n이 음수이면 -1을, 0이면 0을 반환한다. 
SELECT  SIGN(32), SIGN(-32), SIGN(0) 
FROM    dual;

1) 반올림 함수 : ROUND(n [, i]), ROUND(숫자, 소수이하/이상 자릿수)
소수이하/이상 자릿수 : 음수지정 가능, 생략시 default는 0 -> 정수로 표현
소수 둘째자리까지 표현 : ROUND(1234.56789, 2) -> 1234.57
SELECT  ROUND(1234.56789, 2)   r1,  /* 1234.57 */
        ROUND(1234.56789, 1)   r2,  /* 1234.6 */
        ROUND(1234.56789, 0)   r3,  /* 1235 */
        ROUND(1234.56789, -1)  r4,  /* 1230 */
        ROUND(56789.32154, -2) r5,  /* 56800 */
        ROUND(1234.56789)      r6   /* 1235 */
FROM    dual;

2) 무조건 버림 함수: TRUNC(n [, i]), TRUNC(숫자, 소수이하/이상 자릿수)
소수이하/이상 자릿수 : 음수지정 가능, 생략시 default는 0 -> 정수로 표현
SELECT  TRUNC(1234.56789, 2)   t1, /* 1234.56 */
        TRUNC(1234.56789, 0)   t2, /* 1234 */
        TRUNC(56789.32154, -2) t3, /* 56700 */
        TRUNC(1234.56789)      t4  /* 1234 */
FROM    dual;

3) 숫자보다 같거나 큰 정수를 반환하는 함수 : CEIL(n) - 무조건 올림의 정수
게시판에서 페이지 나눌 때(페이징처리 할때), 페이지당 10개씩 출력시
0 ~ 1 사이에는 무수히 많은 실수
0.9999999999999999999999 -> 1
0.000000000000000000000000000000001 -> 1

SELECT  CEIL(0.9999999999999999999999) c1, /* 1 */
        CEIL(0.000000000000000000000000000000001) c2, /* 1 */
        CEIL(0) c3, /* 0 */
        CEIL(12.1) c4 /* 13 */
FROM    dual;

4) 숫자보다 같거나 작은 정수를 반환하는 함수: FLOOR(n) - 무조건 버림의 정수
0 ~ 1 사이에는 무수히 많은 실수
0.9999999999999999999999 -> 0
0.000000000000000000000000000000001 -> 0

SELECT  FLOOR(0.9999999999999999999999) f1, /* 0 */
        FLOOR(0.000000000000000000000000000000001) f2, /* 0 */
        FLOOR(0) f3, /* 0 */
        FLOOR(12.1) f4 /* 12 */
FROM    dual;

SELECT  CEIL(12.0000000001) c1,  /* 13 */
        FLOOR(12.99999999999999999) f1 /* 12 */
FROM    dual;

숫자 데이터를 표현할 수 있는 함수 : ROUND, TRUNC, CEIL, FLOOR
소수점 데이터를 표현할 수 있는 함수 : ROUND, TRUNC
정수 데이터를 표현할 수 있는 함수 : CEIL, FLOOR, ROUND/TRUNC(두번째 파라미터가 0, 생략시 0)

5) 나머지를 반환하는 함수 : MOD(m, n), MOD(숫자, 나눌숫자)
SELECT  MOD(17, 4)   m1,     /* 1 */
        MOD(17, -4)  m2,     /* 1 */
        MOD(-17, 4)  m3,     /* -1 */
        MOD(-17, -4) m4,     /* -1 */
        MOD(17, 0)   m5      /* 17 */
FROM    dual;

17 / 4 : 17 = 4 * 4 + 1
17 / 4 : 17 = -4 * -4 + 1
-17 / 4 : -17 = 4 * -4 + (-1)
-17 / -4 : -17 = -4 * 4 + (-1)

3.2 문자함수
1. 대/소문자 변환 함수 : UPPER/LOWER(문자)
01. 문자/날짜 데이터 표현 : ''(홑따옴표)안에 입력
성이 'King'인 사원들의 사번, 성, 명 조회
SELECT employee_id, last_name, first_name
FROM   employees
WHERE  LOWER(last_name) = 'king';

02. 성에 대소문자 무관하게 z가 있는 사원들의 사번, 성, 명 조회
SELECT employee_id, last_name, first_name
FROM   employees
WHERE  LOWER(last_name) LIKE '%z%';

2. 단어의 첫 문자만 대문자로 변환하고 나머지는 소문자로 변환하는 함수
INITCAP(대상)
SELECT  email, INITCAP(email) INITCAP, first_name, UPPER(first_name), last_name, LOWER(last_name)
FROM    employees;

3. 문자데이터에 특정 문자를 채워서 반환하는 함수
: LPAD/RPAD(문자데이터, 전체크기, 특정문자)
SELECT  LPAD('abc',5,'?') lpad,
        RPAD('abc',5,'#') rpad
FROM    dual;

SELECT  employee_id, LPAD(last_name, 20, ' ') last_name
FROM    employees;

4. 문자데이터에서 특정문자를 제거하고 반환하는 함수 : TRIM()
: 제거할 문자는 한 개만 지정 가능
: 입력상자에서 사용자 실수로 공백을 입력 시 request.getParameter('userId').TRIM();

TRIM([LEADING, TRAILING, BOTH][, 제거문자] [FROM] 대상문자)
LEADING : 왼쪽부터 제거, TRAILING : 오른쪽부터 제거, BOTH : 양쪽에서 제거(default)
제거문자 미지정시 ' '

SELECT  TRIM('a' FROM 'abcadcbaaaa') t1,
        TRIM(LEADING 'a' FROM 'abcadcbaaaa') t2,
        TRIM(TRAILING 'a' FROM 'abcadcbaaaa') t3,
        TRIM('          abcadcbaaaa           ') t4
FROM    dual;

5. 문자데이터에 특정 문자를 제거하고 반환하는 함수
: 제거할 문자를 여러 개 지정가능
: LTRIM/RTRIM(대상문자, 제거할 문자)
: 제거할 문자 미지정 시 ' '

SELECT  LTRIM('abcdcba','a') t1,
        LTRIM('abcdcba','ba') t2,
        RTRIM('abcdcba','cba') t3,
        RTRIM('abcdcba','adb') t4,
        RTRIM('abcdcba','bc') t5
FROM    dual;

6. 문자열에서 문자열의 일부를 반환하는 함수 (몇번째부터 몇글자)
: SUBSTR(문자열, 시작위치, 개수)
시작위치 : 음수도 지정 가능, 오른쪽에서 시작
개수 : 생략시 문자열의 끝까지 반환

SELECT  SUBSTR('You are not alone',5,3) s1
FROM    dual;

7. 문자열에서 특정문자열이 위치한 시작위치를 반환하는 함수
: INSTR(문자열, 찾는 문자열, 문자열 찾는 시작위치, 몇번째)
문자열 찾는 시작위치 : 음수도 가능, 오른쪽에서 계속 진행
번지수 미지정 시 기본값은 첫번째

SELECT  INSTR('Every sha-la-la-la-la','la',1,2) instr1,
        INSTR('Every sha-la-la-la-la','la',12,2) instr2,
        INSTR('Every sha-la-la-la-la','la',12,4) instr3,
        INSTR('Every sha-la-la-la-la','la',12) instr4,
        INSTR('Every sha-la-la-la-la','la',-3,2) instr5
FROM    dual;

SELECT  'admin@naver.com' EMAIL,
        SUBSTR('admin@naver.com', 1, INSTR('admin@naver.com','@', 1, 1) - 1) ID,
        SUBSTR('admin@naver.com', INSTR('admin@naver.com','@', 1, 1) + 1) SITE
FROM    dual;

SELECT  *
FROM    employees;

SELECT  first_name || ' ' || last_name "성명",
        SUBSTR(job_id, 1, INSTR(job_id, '_', 1, 1) - 1) "직무",
        SUBSTR(job_id, INSTR(job_id, '_', 1, 1) + 1) "직책"
FROM    employees;

부서코드가 60,80,100인 부서에 속한 사원들의 사번, 성, 전화번호, 지역번호, 개인번호를 조회
SELECT  employee_id, last_name, phone_number,
        SUBSTR(phone_number, 1, INSTR(phone_number, '.', 1, 1) - 1) "local number",
        SUBSTR(phone_number, INSTR(phone_number, '.', -1, 1) + 1) "personal number"
FROM    employees
WHERE   department_id IN (60, 80, 100);


