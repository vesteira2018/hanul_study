10. 무결성 제약조건(INTEGRITY CONSTRAINT) - 정확성, 정합성, 무결성을 보장하기 위해 둠.
- 테이블에 잘못된 데이터의 입력을 막기 위해 일정한 규칙을 지정하는 것
- 제약 조건명은 30자까지 지정가능

- NOT NULL, DEFAULT, CHECK, UNIQUE, PRIMARY KEY, FOREIGN KEY 6가지 있음
- 제약조건은 테이블 생성시에 정의할 수 있고, 테이블 생성 후 추가/제거 할 수도 있음.


--제약조건선언 - COLUMN 레벨, TABLE 레벨
-----------------------------------------------------------------------------------------------
DROP TABLE emp000 PURGE;
DROP TABLE dept PURGE; 
-----------------------------------------------------------------------------------------------
   ******** 
1. 컬럼레벨의 제약조건 기술 방법
-----------------------------------------------------------------------------------------------
☞ 컬럼명 데이터타입 CONSTRAINT 제약조건경(테이블명_컬럼명_약어) 제약조건
-----------------------------------------------------------------------------------------------
CREATE TABLE 테이블명
  컬럼명 데이터타입 CONSTRAINT 제약조건명(테이블명_컬럼명_약어) 제약조건,
  ....
  ....
);
-----------------------------------------------------------------------------------------------
CREATE TABLE emp000 (
  empno  NUMBER(4)    CONSTRAINT emp000_empno_pk   PRIMARY KEY,
  ename  VARCHAR2(15) CONSTRAINT emp000_ename_nn   NOT NULL,
  job    VARCHAR2(15) CONSTRAINT emp000_job_un     UNIQUE,
  deptno NUMBER(2)    CONSTRAINT emp000_deptno_fk  REFERENCES dept(deptno), --REFERENCES 부모테이블 ( 참조되는컬럼명 )
  gender VARCHAR2(3)  CONSTRAINT emp000_gender_ck  DEFAULT '남' CHECK( gender IN('남','여') ) 
); 
--REFERENCE dept(deptno) 로 부모테이블과 부모테이블 컬럼의 PK가 필요하여 아래의 샘플처럼
--dept테이블 생성후 deptno컬럼에 PK지정 
-----------------------------------------------------------------------------------------------
CREATE TABLE dept AS --CTAS ☞ NOT NULL 이외의 제약조건(Primary 키 등)은 복사되지 않는다.
  SELECT  department_id deptno, department_name deptname, manager_id, location_id
  FROM    departments;

DESC dept;

--제약조건 추가
ALTER TABLE dept
ADD CONSTRAINT dept_deptno_pk PRIMARY KEY (deptno);

--제약조건 제거
ALTER TABLE dept
DROP CONSTRAINT dept_deptno_pk; --제약조건 제거

DESC dept;

   ***********
2. 테이블 레벨의 제약조건 기술방법
--※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※
--*복합키 지정을 할 때는 반드시 테이블 레벨로 제약조건을 지정해야 한다.
--*제약조건을 추가할 때도 테이블 레벨로 제약조건을 지정해야 한다.
--※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※
CONSTRAINT 제약조건명(테이블명_컬럼명_약어) 제약조건

CREATE TABLE 테이블명
  컬럼명 데이터타입(크기),
  ....
  CONSTRAINT 제약조건명(테이블명_컬럼명_약어) 제약조건,
  ....
);
-----------------------------------------------------------------------------------------------
DROP TABLE emp000 PURGE;
DROP TABLE dept PURGE; 
-----------------------------------------------------------------------------------------------
CREATE TABLE dept AS
  SELECT  department_id deptno, department_name deptname, manager_id, location_id
  FROM    departments;

ALTER TABLE dept
ADD CONSTRAINT dept_deptno_pk PRIMARY KEY (deptno);

DESC dept;

CREATE TABLE emp000 (
  empno  NUMBER(4),
  ename  VARCHAR2(15) CONSTRAINT emp000_ename_nn NOT NULL,
  job    VARCHAR2(15),
  deptno NUMBER(2),
  gender VARCHAR2(3) DEFAULT '남', --테이블 생성시 DEFAULT 지정 ☞ 컬럼 레벨 정의 방식으로만 정의, CONSTRAINT 제약조건명 사용 불가
  CONSTRAINT emp000_empno_pk  PRIMARY KEY(empno),
  CONSTRAINT emp000_job_un    UNIQUE(job),
  CONSTRAINT emp000_deptno_fk FOREIGN KEY(deptno) REFERENCES dept(deptno), --REFERENCES 부모테이블 ( 참조되는컬럼명 )
  CONSTRAINT emp000_gender_ck CHECK( gender IN('남','여') )
); 


※ 테이블 생성시 제약 조건
-----------------------------------------------------------------------------------------------
      제약조건               | 기능 
-----------------------------------------------------------------------------------------------
- NOT NULL(컬럼 레벨에서만,  | NULL 값 입력 금지, 테이블 생성시 컬럼 레벨 정의 방식으로만 정의 
         NULL 값 입력 금지)  | 컬럼 레벨만 ☞ id VARCHAR2(20) NOT NULL
-----------------------------------------------------------------------------------------------
- DEFAULT(컬럼 레벨에서만,   | 데이터 입력(수정)할 때 값 미지정시 기본값 지정, 
           기본값 지정)      | 테이블 생성시 컬럼 레벨 정의 방식으로만 정의
                             | 컬럼 레벨만 ☞ gender CHAR(3) DEFAULT '남'
-----------------------------------------------------------------------------------------------
- CHECK(설정값만 허용)       | 조건으로 설정된 값만 입력 허용 
                             | 컬럼 레벨   ☞ gender VARCHAR2(3) CHECK( gender IN('남','여') )
                             | 테이블 레벨 ☞ CHECK ( gender IN ('남','여') )
-----------------------------------------------------------------------------------------------                             
- UNIQUE(개체무결성,         | 중복값 입력 금지 (NULL 값은 중복입력 가능), NOT NULL 과 함께 사용도 가능
         중복값 입력 금지)   | 컬럼 레벨   ☞ job VARCHAR2(15) UNIQUE, 
                             | 테이블 레벨 ☞ UNIQUE(job)
                             | 2개 이상의 컬럼을 이용하여 기본키 지정(복합키)
-----------------------------------------------------------------------------------------------
- PRIMARY KEY(개체무결성,    | NOT NULL + UNIQUE, 2개 이상의 컬럼을 이용하여 기본키 지정(복합키)
       NOT NULL + UNIQUE)    | 컬럼 레벨   ☞ id NUMBER(8) PRIMARY KEY, 
                             | 테이블 레벨 ☞ PRIMARY KEY( id )
-----------------------------------------------------------------------------------------------
- FOREIGN KEY(참조무결성,    | 다른 테이블의 컬럼을 조회해서 무결성 검사
    다른 테이블의 컬럼 참조) | 컬럼 레벨   ☞ dept_id NUMBER(4) REFERENCES departments( department_id )
                             | 테이블 레벨 ☞ FOREIGN KEY ( dept_id ) REFERENCES departments( department_id )
-----------------------------------------------------------------------------------------------

* 제약조건에 이름 지정하기(관리 목적으로 생성)
- 이름을 지정하지 않으면 자동으로 생성됨
- 나중에 제약조건을 비활성화하거나 삭제하는 등의 관리를 위해서는 
  제약조건에 이름을 지정해주는 것이 좋다. 
-----------------------------------------------------------------------------------------------

DDL 정리

1. 제약 조건 생성 ☞ CREATE
-----------------------------------------------------------------------------------------------
CREATE TABLE 테이블명(
  컬럼명1 데이터타입 CONSTRAINT 제약조건명 NOT NULL,
  컬럼명2 데이터타입 DEFAULT '값',
  컬럼명3 데이터타입 CONSTRAINT 제약조건명 CHECK (컬럼명3 조건식),
  컬럼명4 데이터타입 CONSTRAINT 제약조건명 UNIQUE,
  컬럼명5 데이터타입 CONSTRAINT 제약조건명 PRIMARY KEY,
  컬럼명6 데이터타입 CONSTRAINT 제약조건명 REFERENCES 부모테이블 (PK인컬럼),
  CONSTRAINT 제약조건명 CHECK (컬럼명3 조건식),
  CONSTRAINT 제약조건명 UNIQUE (컬럼명4),
  CONSTRAINT 제약조건명 PRIMARY KEY (컬럼명5),
  CONSTRAINT 제약조건명 FOREIGN KEY (컬럼명6) REFERENCES 부모테이블 (PK인컬럼)
);
-----------------------------------------------------------------------------------------------



2. 제약 조건 추가, 즉, 구조 변경 ☞ ALTER
-----------------------------------------------------------------------------------------------
① 테이블 생성후 NOT NULL 지정/제거 - NULL 값 입력 금지

ALTER TABLE 테이블명
MODIFY ( 컬럼명 [데이터타입] [NOT] NULL ); --NOT NULL 이어야 (데이터가 존재해야) NOT NULL 지정 가능
NOT NULL : NOT NULL 지정, NULL : NULL 지정

ALTER TABLE 테이블명 -- NOT NULL 지정
ADD CONSTRAINT 제약조건명 CHECK( 컬럼명 IS NOT NULL );

ALTER TABLE 테이블명 -- NOT NULL 제약조건명 제거 
DROP CONSTRAINT 제약조건명( ☜ NOT NULL제약조건명)


-----------------------------------------------------------------------------------------------
② 테이블 생성 후 DEFAULT 추가 - 데이터 입력(수정)할 때 값 미지정시 기본값 지정 ☞ gender VARCHAR2(3) DEFAULT '남'

ALTER TABLE 테이블명
MODIFY (컬럼명 [데이터타입] DEFAULT '값');
  ☞ gender VARCHAR2(3) DEFAULT '남'


-----------------------------------------------------------------------------------------------
③ 테이블 생성 후 CHECK 추가 - 조건으로 설정된 값만 입력 허용 ☞ CHECK(gender IN ('남','여'))

ALTER TABLE 테이블명
ADD CONSTRAINT 제약조건명 CHECK ( 컬럼명 조건식 );
  ☞ CHECK(gender IN ('남','여'))


-----------------------------------------------------------------------------------------------
④ 테이블 생성 후 UNIQUE 추가 - 중복값 입력 금지 (NULL 값은 중복입력 가능), 
                                NOT NULL 과 함께 사용도 가능, 
                                2개 이상의 컬럼을 이용하여 기본키 지정(복합키)

ALTER TABLE 테이블명
ADD CONSTRAINT 제약조건명 UNIQUE ( 컬럼명 );
  ☞ UNIQUE(email)


-----------------------------------------------------------------------------------------------
⑤ 테이블 생성 후 PRIMARY KEY 추가 - 식별자, 기본키, 주키, PK : NOT NULL + UNIQUE
                                     2개 이상의 컬럼을 이용하여 기본키 지정(복합키) 가능
ALTER TABLE 테이블명 
ADD CONSTRAINT 제약조건명 PRIMARY KEY ( 컬럼명 );
  ☞ PRIMARY KEY (id);


-----------------------------------------------------------------------------------------------
⑥ 테이블 생성 후 FOREIGN KEY 추가 - 외래키, 참조키, FK : NULL 허용, 부모테이블의 PK 인 컬럼을 참조
                                     다른 테이블의 컬럼을 조회해서 무결성 검사

ALTER TABLE 테이블명
ADD CONSTRAINT 제약조건명 FOREIGN KEY ( 컬럼명 ) 
                          REFERENCES 부모테이블 ( PK인컬럼 );


-----------------------------------------------------------------------------------------------
⑦ 제약조건 삭제

ALTER TABLE 테이블명
DROP CONSTRAINT 제약조건명
-----------------------------------------------------------------------------------------------




