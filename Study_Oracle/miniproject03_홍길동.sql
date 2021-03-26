----------------------------------------------------------------------------------------------------
--1. �Է����̺� : ȸ���������̺� ���� �� ���̺� ���� Ȯ��
  CREATE  TABLE member (
      id  VARCHAR2(50) PRIMARY KEY NOT NULL,
password  VARCHAR2(50) NOT NULL,
    name  VARCHAR2(20) NOT NULL,
   phone  VARCHAR2(13),
   email  VARCHAR2(50),
joindate  DATE NOT NULL
);

DESCRIBE member;

SELECT * FROM member;

----------------------------------------------------------------------------------------------------

--2. ���õ����� �Է� �� COMMIT �ϰ� �� �� ȸ������ ��ȸ

--1)ȫ�浿 �Է�
INSERT INTO member
  VALUES('hong', 'hong1234', 'ȫ�浿', '062-1234-5678',
  'hong@naver.com', '2020-01-10');

--2)��û �Է�
INSERT INTO member
  VALUES('sim', 'simsim', '��û', '',
  'sim@daum.net', '2020-01-12');

--3)�ڹ��� �Է�
INSERT INTO member
  VALUES('park', 'park', '�ڹ���', '010-5678-1234',
  'park@naver.com', '2020-01-12');

--4)����ġ �Է�
INSERT INTO member
  VALUES('jeon', 'jeon9876', '����ġ', '010-4252-9876',
  'jeon@gmail.com', '2020-01-14');

--5)���ڹ� �Է�
INSERT INTO member
  VALUES('java', 'park', '���ڹ�', '032-8520-3697',
  'java@hrd.co.kr', '2020-01-14');
  
----------------------------------------------------------------------------------------------------

--3. �������� �� COMMIT �ϰ� �� �� ȸ�� ���� ��ȸ
UPDATE member
SET    phone='02-4567-3210', email='sim02@daum.net'
WHERE  id = 'sim';
  
UPDATE member
SET    phone='', email='jeon@naver.com'
WHERE  id = 'jeon';

COMMIT;

----------------------------------------------------------------------------------------------------

--4. �������� �� COMMIT �ϰ� �� �� ȸ�� ���� ��ȸ
DELETE  member
WHERE   id = 'java';

COMMIT;
----------------------------------------------------------------------------------------------------

--5. ��ȸ

--1) ������ ȫ�浿�� ȸ�������� ��ȸ�ϴ� SQL�� �ۼ�
SELECT  *
FROM    member
WHERE   name LIKE 'ȫ�浿';

--2) ��ȭ��ȣ�� ���� ȸ�������� ��ȸ�ϴ� SQL�� �ۼ�
SELECT  *
FROM    member
WHERE   phone IS NULL;


--3) naver �̸����� ����ϴ� ȸ�������� ��ȸ�ϴ� SQL�� �ۼ�
SELECT  *
FROM    member
WHERE   email LIKE ('%naver.com');


--4) ���� �ֱٿ� ������ ȸ�������� ��ȸ�ϴ� SQL�� �ۼ�
SELECT  *
FROM    member
WHERE   joindate = (SELECT MAX(joindate) FROM member);


--5) �������ں��� ������ ȸ������ �ľ��� �� �ֵ��� ��������, ȸ������ ��ȸ�ϴ� SQL�� �ۼ� 
SELECT    joindate, COUNT(*) su
FROM      member
GROUP BY  joindate;

----------------------------------------------------------------------------------------------------