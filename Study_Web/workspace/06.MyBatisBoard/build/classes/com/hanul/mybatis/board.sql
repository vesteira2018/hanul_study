-- 테이블 생성
CREATE TABLE tblBoard (
  b_num       NUMBER PRIMARY KEY NOT NULL,
  b_subject   VARCHAR2(50),
  b_pwd       VARCHAR2(20),
  b_content   VARCHAR2(2000),
  b_writer    VARCHAR2(20),
  b_date      VARCHAR2(20),
  b_readcount NUMBER
);
-- DTO 변수 이름과 동일

-- 전체 레코드 검색
SELECT   *
FROM     tblBoard
ORDER BY b_num DESC;

-- 자동증가값 설정 : b_num → b_num_sequence 변수
CREATE sequence b_num_seq START WITH 1;

-- 임의 레코드 삽입
INSERT INTO tblBoard
  VALUES(b_num_seq.NEXTVAL, 'subject', 'pwd', 'content',
        'writer', SYSDATE, 0);

-- 전체 레코드 삭제
DELETE FROM tblBoard;

-- 테이블 제거
DROP TABLE tblBoard;

-- 자동증가값 삭제(해제)
DROP sequence b_num_seq;


COMMIT;