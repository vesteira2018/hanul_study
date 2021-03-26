-- tblBook 테이블 생성
CREATE TABLE tblBook(
	num			NUMBER primary key not null,
	title		VARCHAR2(30),
	company	VARCHAR2(20),
	name		VARCHAR2(10),
	cost		NUMBER
);

-- 임의의 레코드 삽입
INSERT INTO tblBook
	VALUES(1, 'JAVA', '한빛', '신용권', 24000);
  
INSERT INTO tblBook
	VALUES(2, 'JSP', '혜지원', '오정원', 33000);
	
-- 전체레코드 검색
SELECT 	*
FROM		tblBook;
	
-- 테이블 확정
COMMIT;