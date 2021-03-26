--[DDL : ������ ���Ǿ�]
--tblMember ���̺� ����
CREATE TABLE tblMember(
    num NUMBER,
    name VARCHAR2(10),
    age NUMBER,
    addr VARCHAR2(50),
    tel VARCHAR2(20)
);

--tblMember ���̺� phone �ʵ� �߰�
alter table tblMember add phone varchar2(10);

--tblMember ���̺��� phone �ʵ��� ũ�� ����
alter table tblMember modify (phone varchar2(20));

--tblMember ���̺��� phone �ʵ��� �̸��� mobilephone ����
alter table tblMember rename column phone to mobilephone;

--tblMember ���̺��� mobilephone �ʵ� ����
alter table tblMember DROP COLUMN mobilephone;

--tblMember ���̺� ����
drop table tblMember;

--[DML : ������ ���۾�]
--������ ���ڵ带 ����
INSERT INTO tblmember (num, name, age, addr, tel)
    VALUES (1, 'ȫ�浿', 30, '���ֽ� ���� �󼺵�', '010-1111-1111');

INSERT INTO tblmember (tel, addr, age, num, name)
    VALUES ('010-2222-2222', '���ֽ� ���� ���̵�', 27, 2, '��浿');

INSERT INTO tblmember
    VALUES (3, '�ڱ浿', 47, '���ֽ� �ϱ� �����', '010-3333-3333');

INSERT INTO tblmember (num, name, age) VALUES (4, '�̼���', 55);

--4�� ���ڵ��� ������ ����(����)
UPDATE tblMember
	SET addr = '���ֽ� ���걸 �Ű���', tel = '010-4444-4444'
		WHERE num = 4;

--3�� ���ڵ��� �ּҸ� ����(���ֽ� �ϱ� ����� �� ����� ������ ȭ�)
update tblMember
    set addr = '����� ������ ȭ�'
        where num = 3;

--4�� ���ڵ��� ������ ����
DELETE FROM tblMember WHERE num = 4;

--��ü���ڵ� ����
DELETE FROM tblmember;

--��ü���ڵ� �˻�
select all * from tblMember;

select num, name, age, addr, tel from tblMember;

select * from tblMember;

--��ȣ, �̸�, �ּҸ� ���
select num, name, addr from tblMember;

--�̸��� ��浿�� ȸ���� ���
select * from tblMember where name = '��浿';

--�̸��� ��浿�� ȸ���� �̸�, ����, �ּҸ� ���
select name, age, addr from tblMember where name = '��浿';

--���̰� 40�� �̻��� ȸ���� ���(�񱳿�����)
select * from tblMember where age >= 40;

--���̰� 40�� �̻��� ȸ���� �̸�, �ּ�, ��ȭ��ȣ ���
select name, addr, tel from tblMember where age >= 40;

--���̰� 30~50�� ������ ȸ���� ���
select * from tblMember where age >= 30 and age <= 50;
select * from tblMember where age between 30 and 50;

--�ּҿ� Ư�� ���ڰ� ���Ե� ȸ���� ���(LIKE ������)
select * from tblMember where addr like '%����%'; --������ ���Ե� ���ڵ� ���
select * from tblMember where addr like '��%'; --������ �����ϴ� ���ڵ� ���
select * from tblMember where addr like '%��'; --������ ������ ���ڵ� ���
/*
[���, �������, ��ݱ�, ��ġ, ��ġ�, �Ѱ���ġ, �ı�ġ]
�� ��% : ���, ��ġ, ��ġ�
�� %�� : ��ݱ�
�� %��ġ% : ��ġ, ��ġ�, �Ѱ���ġ, �ı�ġ
*/

--�����Լ�(count, sum, avg, max, min)
select count(name) from tblMember; --name �ʵ��� ����
select count(name) as nameCnt from tblMember; --count(name)��namecnt�� �ʵ����
select sum(age) from tblMember;  --age�� �հ�
select avg(age) from tblMember;  --age�� ���
select max(age) from tblMember;  --age�� �ִ밪
select min(age) from tblMember;  --age�� �ּҰ�
select age + 2 from tblMember;  --�Էµ� age ���� 2�� ���� �� ���
select sum(age) from tblMember where addr like '%����%';

--��Ÿ����
select * from tblMember where num in(1,3);  --num���� 1 �Ǵ� 3�� ���ڵ� �˻�
select * from tblMember where num = 1 or num = 3;
select sysdate from dual;  --DBMS�� ����� ��¥ ���
select to_char(sysdate, 'YYYY/MM/DD') from dual;

--����Ϸ�
commit;