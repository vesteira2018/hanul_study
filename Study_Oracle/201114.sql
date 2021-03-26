-- 3.3 날짜함수 : 송금, 출결, 회원가입날짜, 결제시간
-- 1. 시스템의 현재 날짜를 반환하는 함수 - SYSDATE
-- 다른 함수와는 달리 파라미터가 없어 괄호를 사용하지 않는다.

SELECT  SYSDATE
FROM    dual;

-- 날짜 +/- 숫자 : 날짜, 오늘 날짜 +/- 1 : 내일날짜/어제날짜
-- 날짜 - 날짜 : 숫자(일수 차이) : SYSDATE + 30 = 30일 후

-- 날짜 시간 표시(ms 단위 까지)
SELECT  SYSTIMESTAMP
FROM    dual;

-- 2. 특정 날짜로부터 몇 개월 전/후의 날짜 반환하는 함수
-- : ADD_MONTHS(날짜, +/-개월 수)

SELECT  ADD_MONTHS(SYSDATE, 6) after, -- 6개월 후
        ADD_MONTHS(SYSDATE, -3) before -- 3개월 전
FROM    dual;

-- 3. 두 날짜 사이의 개월 수 차이를 반환하는 함수
-- : MONTHS_BETWEEN(날짜1, 날짜2) (날짜1 > 날짜2)
SELECT  TRUNC(MONTHS_BETWEEN(SYSDATE, '2020/09/21'), 1) gap
FROM    dual;

-- 지난 개월 수와 남은 개월 수 계산
SELECT  TRUNC(MONTHS_BETWEEN(SYSDATE, '2020/09/21'), 2) passed,
        TRUNC(MONTHS_BETWEEN('2021/03/26', SYSDATE), 2) left
FROM    dual;

-- 사번이 100인 사원의 사번, 성, 입사일자, 근무개월 수, 근무년 수를 조회
SELECT  employee_id, last_name, hire_date,
        TRUNC(MONTHS_BETWEEN(SYSDATE, hire_date), 0) months,
        TRUNC(MONTHS_BETWEEN(SYSDATE, hire_date)/12, 0) years
FROM    employees
WHERE   employee_id = 100;

-- 4. 해당 날짜가 포함된 달의 마지막 일자를 반환하는 함수
-- : LAST_DAY(날짜)

SELECT  LAST_DAY(SYSDATE) L1,
        -- 오늘부터 3달 전 마지막 날짜
        LAST_DAY(ADD_MONTHS(SYSDATE, -3)) L2,
        -- 오늘로부터 3달 후 마지막 날짜
        LAST_DAY(ADD_MONTHS(SYSDATE, 3)) L3
FROM    dual;

-- 5. 해당 날짜 이후의 날짜 중에서 CHAR로 명시된 요일에 해당하는 첫 날짜를 반환
-- : NEXT_DAY(날짜), CHAR : 요일문자, ex) 월요일, 일요일, 일, 월, 숫자도 가능(1: SUNDAY)
SELECT  NEXT_DAY(SYSDATE, '월요일') N1,
        NEXT_DAY(SYSDATE, '금') N2,
        -- 다가오는 Wednesday
        NEXT_DAY(SYSDATE, 4) N3
FROM    dual;

-- ##형변환 함수
-- 1. 숫자화 함수 : TO_NUMBER : 문자 -> 숫자
-- byte < short(2byte) < int(4byte) < long(8byte)
-- int -> short : overflow
-- short -> int : 암묵적 형전환

-- 알파벳, 기호, 한글 문자 등은 숫자화 불가능
-- 명시적 형변환
SELECT  TO_NUMBER('12345') s1,
        12345
FROM    dual;

-- 숫자 : NUMBER, 문자 : CHARACTER, 날짜 : DATE
-- 숫자 → 문자 : TO_CHAR
-- 문자 → 날짜 : TO_DATE
-- 날짜 → 문자 : TO_CHAR
-- 문자 → 숫자 : TO_NUMBER

-- 2. 문자화 함수 : TO_CHAR(숫자나 날짜)
-- 2.1 숫자 → 문자 : TO_CHAR(대상, [포맷형식]) : 단순히 문자로만 변환

-- < FORMAT > --
-- 9 : 한 자리 숫자, 무효 숫자는 공백 (001 → ' '' '1)
-- 0 : 한 자리 숫자, 무효 숫자는 0 (001)
-- , ; 천 단위 구분
-- L : 통화기호

SELECT  123456 N1, TO_CHAR(123456) C1, TO_CHAR(123456, '999999') C2,
        TO_CHAR(123456, '999999999') C3, TO_CHAR(123456, '9999') C4,
        TO_CHAR(123456, '999,999,999') C5
FROM    dual;

-- 2.2 날짜 → 문자 : TO_CHAR(대상, [표현방식])
-- 표현 형식 --
-- 년 : YYYY, YY (2000년 이후), RRRR, RR (2000년 이전)
-- 월 : MM(11), MONTH(NOVEMBER), MON(NOV)
-- 일 : DD
-- 요일 : DAY(한글, 월요일), DY(한글, 월)
-- 시 : HH, HH24
-- 분 : MI
-- 초 : SS

SELECT  TO_CHAR(SYSDATE, 'YYYY-MM-DD DY HH24:MI:SS') D1,
        TO_CHAR(SYSDATE, 'RRRR-MON-DD DAY HH24:MI:SS') D2
FROM    dual;

-- 날짜화 함수 : TO_DATE(대상, 표현방식)
SELECT  '201116' D1,
        TO_DATE('20-11-16') D2,
        TO_DATE('201116','RR-MM-DD') D3
FROM    dual;

SELECT  TO_CHAR('2016/11/16 16:32:25', 'RRRR/MM/DD HH24:MI:SS') D1
FROM    dual; -- 직접 입력한 날짜는 TO_CHAR에서 에러가 발생


SELECT  TO_CHAR(hire_date, 'RRRR/MM/DD') D1
FROM    employees;

-- 일반 함수
-- : NULL과 함께 계산되었을 때는 결과 값이 NULL이 되어버린다

-- 커미션 금액이 1000 미만인 사원의 사번, 급여, 커미션율, 커미션 금액 조회
-- 커미션 금액 = 급여 * 커미션율
SELECT  employee_id, salary, commission_pct, salary * commission_pct comm
FROM    employees
WHERE   commission_pct IS NOT NULL 
        AND (salary * commission_pct) < 1000;
        
-- NULL 값을 치환해주는 함수 : NVL(NULL VALUE), DECODE
-- NVL(column, 0) : NULL값을 0으로 치환
-- DECODE(column, A, 1, B, 2, 3)
-- : column=A → 1, column=B → 2, NOR 3

-- NVL(대상, NULL일 때 반환표현), Oracle에서만 사용
-- ★ 대상과 NULL일 때 반환 표현이 데이터 타입과 같아야 한다.

SELECT  employee_id, salary, commission_pct, salary * commission_pct comm
FROM    employees
WHERE   salary * NVL(commission_pct, 0) < 1000;

-- 사번, 성, 급여, 커미션율, 총 급여 조회
SELECT  employee_id, last_name, salary, commission_pct, salary+salary*NVL(commission_pct, 0) t_salary
FROM    employees;

-- NVL2(대상, NULL이 아닐 때 반환표현, NULL일 때 반환표현)
-- 커미션 받는 사원의 총 급여 = 급여 + 커미션 금액
-- 그렇지 않은 사원의 총 급여 = 급여
-- 사번, 성, 급여, 커미션율, 총 급여 조회
SELECT  employee_id, last_name, salary, commission_pct, 
        NVL2(commission_pct, salary*(1 + commission_pct), salary) t_salary,
        NVL2(commission_pct, '급여+커미션 금액', '급여') t_salary2
FROM    employees;

-- 3. 데이터 값이 NULL인 경우 대체해서 반환 표현을 여러 개 지정할 수 있는 형태의 함수
-- 3.1 NULL이 아닌 첫 번째 데이터를 반환하는 함수
-- COALESCE(대체표현1, 대체표현2, 대체표현3, ...)

-- 이름    휴대폰         집전화        사무실전화
-- 홍길동  010-1234-5678  062-111-1111  062-555-5555
-- 심청                   062-222-2222
-- 전우치                               062-333-3333
--
-- SELECT  이름, COALESCE(휴대폰, 집전화, 사무실전화) 연락처
-- FROM    dual;