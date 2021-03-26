-----------------------------------------------------------------------------------------------
�ǽ� �� 05��. 03. ANSI����-outer-����.sql
-----------------------------------------------------------------------------------------------
01. ��� ����� ���, ��, �μ��� ��ȸ --����Ŭ ����, ANSI JOIN
-----------------------------------------------------------------------------------------------
����Ŭ ����
SELECT  e.employee_id, e.last_name, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id(+);

JOIN ON
SELECT  e.employee_id, e.last_name, d.department_name
FROM    employees e LEFT JOIN departments d
ON      e.department_id = d.department_id;

JOIN USING
SELECT  e.employee_id, e.last_name, d.department_name
FROM    employees e LEFT JOIN departments d
USING   (department_id);
-----------------------------------------------------------------------------------------------
SELECT  e.employee_id, e.last_name, d.department_name
FROM    departments d RIGHT OUTER JOIN employees e
ON      e.department_id = d.department_id;
-----------------------------------------------------------------------------------------------
02. ��� ����� ���, ��, �μ���, ������ ��ȸ
-----------------------------------------------------------------------------------------------
����Ŭ����
SELECT  e.employee_id, e.last_name, d.department_name, e.job_id
FROM    employees e, departments d
WHERE   e.department_id = d.department_id(+);

JOIN ON
SELECT  e.employee_id, e.last_name, d.department_name, e.job_id
FROM    employees e LEFT JOIN departments d
ON      e.department_id = d.department_id;

JOIN USING
SELECT  e.employee_id, e.last_name, d.department_name, e.job_id
FROM    employees e LEFT JOIN departments d
USING   (department_id);
-----------------------------------------------------------------------------------------------
03. ��� ����� ���, ��, �μ���, ���ø� ��ȸ
-----------------------------------------------------------------------------------------------
����Ŭ ����
SELECT  e.employee_id, e.last_name, d.department_name, l.city
FROM    employees e, departments d, locations l
WHERE   e.department_id = d.department_id(+)
AND     d.location_id = l.location_id(+);

JOIN ON
SELECT  e.employee_id, e.last_name, d.department_name, l.city
FROM    employees e LEFT JOIN departments d
ON      e.department_id = d.department_id
LEFT JOIN locations l
ON      d.location_id = l.location_id;

JOIN USING
SELECT  e.employee_id, e.last_name, d.department_name, l.city
FROM    employees e LEFT JOIN departments d
USING   (department_id)
LEFT JOIN locations l
USING   (location_id);
-----------------------------------------------------------------------------------------------
04. �����ڻ���� 149���� ��� ����� ���, ��, �μ��� ��ȸ
-----------------------------------------------------------------------------------------------
����Ŭ ����
SELECT  e.employee_id, e.last_name, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id(+)
AND     e.manager_id = 149;

JOIN ON
SELECT  e.employee_id, e.last_name, d.department_name
FROM    employees e LEFT JOIN departments d
ON      e.department_id = d.department_id
WHERE   e.manager_id = 149;

JOIN USING
SELECT  e.employee_id, e.last_name, d.department_name
FROM    employees e LEFT JOIN departments d
USING   (department_id)
WHERE   e.manager_id = 149;
-----------------------------------------------------------------------------------------------
05. Ŀ�̼��� �޴� ��� ������� ���, ��, �μ���, ���ø� ��ȸ
-----------------------------------------------------------------------------------------------
����Ŭ ����
SELECT  e.employee_id, e.last_name, d.department_name, l.city
FROM    employees e, departments d, locations l
WHERE   e.department_id = d.department_id(+)
AND     d.location_id = l.location_id(+)
AND     commission_pct IS NOT NULL;

JOIN ON
SELECT  e.employee_id, e.last_name, d.department_name, l.city
FROM    employees e LEFT JOIN departments d
ON      e.department_id = d.department_id
LEFT JOIN locations l
ON      d.location_id = l.location_id
WHERE   commission_pct IS NOT NULL;

JOIN USING
SELECT  e.employee_id, e.last_name, d.department_name, l.city
FROM    employees e LEFT JOIN departments d
USING   (department_id)
LEFT JOIN locations l
USING   (location_id)WHERE commission_pct IS NOT NULL;

-----------------------------------------------------------------------------------------------
06. ��� �μ��� ���� �μ��ڵ�, �μ���, ���ø�, ������, ����� ��ȸ
-----------------------------------------------------------------------------------------------
����Ŭ ����
SELECT  d.department_id, d.department_name, 
        l.city, c.country_id, r.region_name
FROM    departments d, locations l, countries c, regions r
WHERE   d.location_id = l.location_id
AND     l.country_id = c.country_id
AND     c.region_id = r.region_id;

JOIN ON
SELECT  d.department_id, d.department_name, 
        l.city, c.country_id, r.region_name
FROM    departments d JOIN locations l
ON      d.location_id = l.location_id
JOIN    countries c 
ON      l.country_id = c.country_id
JOIN    regions r
ON      c.region_id = r.region_id;

JOIN USING
SELECT  d.department_id, d.department_name, 
        l.city, country_id, r.region_name
FROM    departments d JOIN locations l
USING   (location_id)
JOIN    countries c 
USING   (country_id)
JOIN    regions r
USING   (region_id);
-----------------------------------------------------------------------------------------------
07. ������� �ٹ��ϴ� �μ��� �� �μ��� ����� �� ���̳� �ֳ� �ľ��ϰ��� �Ѵ�.
�μ��ڵ�, �μ���, ����� ��ȸ
-----------------------------------------------------------------------------------------------
����Ŭ ����
SELECT  d.department_id, d.department_name, COUNT(*) cnt
FROM    employees e, departments d
WHERE   e.department_id = d.department_id(+)
GROUP BY d.department_id, d.department_name
ORDER BY 1;

JOIN ON
SELECT  d.department_id, d.department_name, COUNT(*) cnt
FROM    employees e LEFT JOIN departments d
ON      e.department_id = d.department_id
GROUP BY d.department_id, d.department_name
ORDER BY 1;

JOIN USING
SELECT  department_id, d.department_name, COUNT(*) cnt
FROM    employees e LEFT JOIN departments d
USING   (department_id)
GROUP BY department_id, d.department_name
ORDER BY 1;
-----------------------------------------------------------------------------------------------
[�������� 5-2]
01. ����� 110, 130, 150 �� �������
���, �̸�, �μ��� ��ȸ�ϴ� ����Ŭ ���� �� ANSI��������
-----------------------------------------------------------------------------------------------
����Ŭ ����
SELECT  e.employee_id, e.first_name, d.department_name
FROM    employees e, departments d
WHERE   e.department_id = d.department_id(+)
AND     e.employee_id IN (110, 130, 150);

JOIN ON
SELECT  e.employee_id, e.first_name, d.department_name
FROM    employees e LEFT JOIN departments d
ON      e.department_id = d.department_id
WHERE   e.employee_id IN (110, 130, 150);

JOIN USING
SELECT  e.employee_id, e.first_name, d.department_name
FROM    employees e LEFT JOIN departments d
USING   (department_id)
WHERE   e.employee_id IN (110, 130, 150);
-----------------------------------------------------------------------------------------------
02. ������� ���, ��, �μ��ڵ�, �����ڵ�, �������� ��ȸ, 
��������� ����
-----------------------------------------------------------------------------------------------
����Ŭ ����
SELECT  e.employee_id, e.last_name, e.department_id, 
        j.job_id, j.job_title
FROM    employees e, jobs j
WHERE   e.job_id = j.job_id --e.job_id�� NULL�� ���� OUTER JOIN ����� �ʿ� ����
ORDER BY 1;

JOIN ON
SELECT  e.employee_id, e.last_name, e.department_id, 
        j.job_id, j.job_title
FROM    employees e JOIN jobs j --OUTER JOIN �����ص� ��
ON      e.job_id = j.job_id
ORDER BY 1;

JOIN USING
SELECT  e.employee_id, e.last_name, e.department_id, 
        job_id, j.job_title
FROM     employees e JOIN jobs j --OUTER JOIN �����ص� ��
USING   (job_id)
ORDER BY 1;

-----------------------------------------------------------------------------------------------











