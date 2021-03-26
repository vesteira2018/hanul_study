--tblPanme ���̺� ����
CREATE TABLE tblPanme(
    code VARCHAR(10),
    part VARCHAR(20),
    price NUMBER
);

--���ڵ� �Է�
INSERT INTO tblPanme (code, part, price) VALUES ('001', 'A������', 3000);
INSERT INTO tblPanme VALUES ('002', 'B������', 6000);
INSERT INTO tblPanme VALUES ('003', 'A������', 2000);
INSERT INTO tblPanme VALUES ('004', 'B������', 5000);
INSERT INTO tblPanme VALUES ('005', 'C������', 1000);
INSERT INTO tblPanme VALUES ('006', 'D������', 4000);

--��ü ���ڵ� �˻�
SELECT * FROM tblPanme;

--����Ϸ�
COMMIT;

--�� �μ���(GROUP BY)�� �Ǹűݾ�(PRICE)�� ����(SUM)�� ���Ͽ� ���
select part, sum(price) from tblPanme group by part;
select part, sum(price) as total from tblPanme group by part;

--�� �μ����� �Ǹűݾ��� ������ ���Ͽ� �μ��� ������������ ����(ORDER BY)�Ͽ� ���
select part, sum(price) as total from tblPanme group by part order by part asc;

--�μ����� ���
select part from tblPanme;
select all part from tblPanme;

--�μ����� ���(��, �ߺ��� �μ��� �ѹ��� ��� : DISTINCT)
select distinct part from tblPanme;

--�μ����� ���(��, �ߺ��� �μ��� �ѹ��� ����ϰ� �μ����� ������������ ���)
select distinct part from tblPanme order by part desc;

--�μ��� �� �(count) �μ����� ���
select count(part) from tblPanme;

--�μ��� �� �(count) �μ����� ���(��, �ߺ��� �μ��� �ѹ��� ���)
select count(distinct part) from tblPanme;

--�μ��� �� �(count) �μ����� ���(��, �ߺ��� �μ��� �ѹ��� ����ϵ� �÷��� ����)
select count(distinct part) as partcount from tblPanme;

--�� �μ����� �Ǹűݾ��� ������ ���Ͽ� �μ��� ������������ �����Ͽ� ���
--��, �μ��� 2�� �̻� �ִ� �μ��� ������� �Ͻÿ� �� A������, B������
select part, sum(price) as total from tblPanme
    group by part having count(part) >= 2 order by part asc;