-----------------------------------------------------------------------------------------------
--[연습문제 3-4]
--사번, 성, 부서코드, 업무코드, 입사일자, 매니저코드, 매니저존재여부(NVL, NVL2 각각 사용) 조회
--매니저존재여부는 각 사원에 대해 
--
--NVL은 
--    관리자가 있으면 manager_id와 관리자가 없으면 '없음'으로 표시,
--NVL2는
--사원의 관리자(매니저)가 있으면 '있음' 으로 //manager_id, 'O','Manager'   
--       관리자(매니저)가 없으면 '없음' 으로 //'없음',     'X','No Manager' 등으로 조회되게 한다.
--       

SELECT  employee_id, last_name, department_id, hire_date,
        manager_id m1,
        NVL(TO_CHAR(manager_id), '없음') "NVL1",
        NVL2(manager_id, 'O', 'X') "NVL2"
FROM    employees;









-----------------------------------------------------------------------------------------------
--desc employees;  manager_id ☜ number(6,0)
-----------------------------------------------------------------------------------------------