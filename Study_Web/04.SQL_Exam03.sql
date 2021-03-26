--tblPanme 테이블 생성
CREATE TABLE tblPanme(
    code VARCHAR(10),
    part VARCHAR(20),
    price NUMBER
);

--레코드 입력
INSERT INTO tblPanme (code, part, price) VALUES ('001', 'A영업부', 3000);
INSERT INTO tblPanme VALUES ('002', 'B영업부', 6000);
INSERT INTO tblPanme VALUES ('003', 'A영업부', 2000);
INSERT INTO tblPanme VALUES ('004', 'B영업부', 5000);
INSERT INTO tblPanme VALUES ('005', 'C영업부', 1000);
INSERT INTO tblPanme VALUES ('006', 'D영업부', 4000);

--전체 레코드 검색
SELECT * FROM tblPanme;

--저장완료
COMMIT;

--각 부서별(GROUP BY)로 판매금액(PRICE)의 총합(SUM)을 구하여 출력
select part, sum(price) from tblPanme group by part;
select part, sum(price) as total from tblPanme group by part;

--각 부서별로 판매금액의 총합을 구하여 부서의 오름차순으로 정렬(ORDER BY)하여 출력
select part, sum(price) as total from tblPanme group by part order by part asc;

--부서명을 출력
select part from tblPanme;
select all part from tblPanme;

--부서명을 출력(단, 중복된 부서는 한번만 출력 : DISTINCT)
select distinct part from tblPanme;

--부서명을 출력(단, 중복된 부서는 한번만 출력하고 부서명의 내림차순으로 출력)
select distinct part from tblPanme order by part desc;

--부서가 총 몇개(count) 부서인지 출력
select count(part) from tblPanme;

--부서가 총 몇개(count) 부서인지 출력(단, 중복된 부서는 한번만 출력)
select count(distinct part) from tblPanme;

--부서가 총 몇개(count) 부서인지 출력(단, 중복된 부서는 한번만 출력하되 컬럼명 변경)
select count(distinct part) as partcount from tblPanme;

--각 부서별로 판매금액의 총합을 구하여 부서의 오름차순으로 정렬하여 출력
--단, 부서가 2개 이상 있는 부서만 대상으로 하시오 ▶ A영업부, B영업부
select part, sum(price) as total from tblPanme
    group by part having count(part) >= 2 order by part asc;