-- tblMember Table 제거
DROP TABLE tblMember;

-- tblMember Table 생성
CREATE TABLE tblMember(
  num   NUMBER primary key not null,
  name  VARCHAR2(10),
  age   NUMBER,
  addr  VARCHAR2(50),
  tel   VARCHAR2(20)
);

-- 임의의 레코드 삽입
INSERT INTO tblMember(num, name, age, addr, tel)  -- 모든 변수에 값을 할당할 경우 괄호 생략 가능
  VALUES(1, '홍길동', 30, '광주시 서구 농성동', '010-1111-1111');

INSERT INTO tblMember VALUES(2, '박문수', 33, '광주시 남구 봉선동', '010-2222-2222');

-- 전체 레코드 검색
SELECT  *
FROM    tblMember;

-- COMMIT 명령 : DML(INSERT, DELETE, UPDATE) 명령 실행 후 저장
COMMIT;