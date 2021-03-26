-- Plug-in org.eclipse.datatools.sqltools.result.ui was unable to load class
-- org.eclipse.datatools.sqltools.result.internal.ui.view.ResultsView.
-- ▶ 오류발생 → eclipse 종료
-- \workspace\.metadata\.plugins\org.eclipse.datatools.sqltools.result
-- 폴더 내 모든 파일을 삭제 > eclipse 재시작
-- 코드 실행 > Progress Tab : stop

-- 테이블 생성
CREATE TABLE Member(
	name	VARCHAR2(20),
	id		VARCHAR2(20),
	pw		VARCHAR2(20),
	age		NUMBER,
	addr	VARCHAR2(50),
	tel		VARCHAR2(20)
);

-- 전체 레코드 검색
SELECT	*
FROM		Member;