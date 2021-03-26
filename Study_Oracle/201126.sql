-- 무결성 계약조건 (INTEGRITY CONSTRAINT) - 정확성, 무결성을 보장하기 위해
-- 테이블에 잘못된 데이터 입력을 막기 위해 일정한 규칙을 주는 것
-- 제약조건명은 30자까지 지정 가능

-- NOT NULL, DEFAULT, CHECK, UNIQUE, PRIMARY KEY, FOREIGN KEY
-- 제약조건은 테이블 생성 시에도 정의할 수 있고,
-- 생성 후에도 추가/제거 가능

-- 1. NOT NULL : 데이터 값이 반드시 들어있어야 한다.
-- 테이블 생성 시 지정할 때는 컬럼 레벨 정의 방식으로만 정의
-- - 컬럼 레벨 정의
-- 컬럼명 데이터타입(크기) NOT NULL
-- 컬럼명 데이터타입(크기) CONSTRAINT 제약조건명 NOT NULL
CREATE  TABLE emp000 (
  empno NUMBER(4) PRIMARY KEY,
  ename VARCHAR2(15) NOT NULL,
  job   VARCHAR2(15) UNIQUE
);

-- 테이블 레벨 정의
-- NOT NULL을 정의할 수 없다
CREATE  TABLE emp000 (
  empno NUMBER(4),
  ename VARCHAR2(15) NOT NULL,
  job   VARCHAR2(15),
  
  PRIMARY KEY(empno),
  UNIQUE(job)
);

-- 테이블 생성 후 NOT NULL 지정/해제
-- ALTER TABLE 테이블명
-- MODIFY(컬럼명 데이터타입(크기) [NOT] NULL);

-- 2. DEFAULT : 데이터 입력/수정 시 값 미지정 시 기본 입력값 지정
-- 테이블 생성 시 정의할 때 컬럼 레벨 정의 방식으로만 정의
-- gender CHAR(3) DEFAULT '남'

-- 테이블 생성 시 DEFAULT 지정
-- - 컬럼 레벨 정의 방식
-- 컬럼명 데이터타입(크기) DEFAULT '값'

-- - 테이블 레벨 정의 방식
-- DEFAULT를 정의할 수 없음

-- 테이블 생성 후 DEFAULT 정의
-- ALTER TABLE 테이블명
-- MODIFY(컬럼명 데이터타입(크기) DEFAULT '값');

-- 3. CHECK - 컬럼에 미리 지정된 조건에 맞는 값만 저장하는 제약 조건 - NULL 허용
-- 테이블 생성 시 CHECK 지정
-- - 컬럼 레벨 정의 방식
-- 컬럼명 데이터타입 CHECK(컬럼명 조건식);
-- 컬럼명 데이터타입 CONSTRAINT 제약조건명 CHECK(컬럼명 조건식);

-- - 테이블 레벨 정의 방식

-- 테이블 생성 후 CHECK 지정
-- ALTER TABLE 테이블명
-- ADD CHECK(컬럼명 조건식)
-- ADD CONSTRAINT 제약조건명 CHECK(컬럼명 조건식)

-- 제약조건 삭제
-- ALTER TABLE 테이블명
-- DROP CONSTRAINT 제약조건명
-- CHECK 제약조건은 변경 불가능. 삭제 후 다시 추가해야 함

-- 제약 조건 이름 변경
-- ALTER TABLE 테이블명
-- RENAME CONSTRAINT 기존제약조건명 TO 변경제약조건명

-- 4. UNIQUE - 데이터가 중복되지 않도록 유일성을 보장하는 조건
-- NULL 중복 허용, NOT NULL도 함께 사용 가능
-- 컬럼레벨, 테이블레벨 모두 정의 가능, 복합키도 사용 가능
-- 복합키 : 여러 개의 컬럼을 하나로 묶어서 제약조건 지정한 것

-- 5. PRIMARY KEY : 데이터 행을 대표하도록 유일하게 식별하기 위한 조건
-- 데이터의 무결성 유지
-- NOT NULL + UNIQUE
-- 여러 컬럼으로 기본키 지정 가능 (최대 32개)


-- 6. FOREIGN KEY : 부모테이블의 컬럼을 참조하는 자식테이블의 컬럼
-- 참조 데이터 무결성 보장 > 참조관계에 있는 테이블의 데이터 추가, 삭제,
-- 수정을 통제할 수 있다.

-- '관계'에 대한 제약조건이 복잡
-- 참조하는 테이블이 먼저 생성되어 있어야 함
-- 외래키가 참조하는 컬럼은 참조하는 테이블의 기본키이어야 함

-- ★ VIEW
-- 실제로 데이터가 존재하는 객체는 아니다.
-- 테이블의 데이터를 뷰를 통해 접근한다.
-- 1. 보안 - 접근 권한
-- 2. 복잡한 쿼리문을 단순한 쿼리문으로 사용할 수 있다.
-- 뷰를 사용하면 테이블처럼 사용 가능하며, SELECT 절에서만 쿼리 가능
-- INSERT, DELETE, UPDATE가 불가능

-- 연속적인 일련 번호를 만들어주는 기능을 가진 객체
-- : SEQUENCE
