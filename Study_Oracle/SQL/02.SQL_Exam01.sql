--tblMember ���̺� ����
CREATE TABLE tblMember(
    num NUMBER,
    name VARCHAR2(10),
    age NUMBER,
    addr VARCHAR2(50),
    tel VARCHAR2(20)
);

--tblMember ���̺� ���� ����
DESCRIBE tblMember;

--���ڵ� ����
INSERT INTO tblmember(num, name, age, addr, tel)
    VALUES(1, 'ȫ�浿', 30, '���ֽ� ���� �󼺵�', '010-1111-1111');
    
INSERT INTO tblmember
    VALUES(2, '��浿', 27, '���ֽ� ���� ���̵�', '010-2222-2222');
    
--��ü���ڵ� �˻�
SELECT num, name, age, addr, tel FROM tblmember;

SELECT * FROM tblmember;

--�޸𸮿� �Էµ� ������ ���������� ����(DB�� �ݿ�)
COMMIT;