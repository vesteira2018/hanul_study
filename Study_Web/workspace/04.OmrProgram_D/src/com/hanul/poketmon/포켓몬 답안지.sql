CREATE TABLE poketmon (
  num NUMBER,
  answer VARCHAR2(10)
);

INSERT INTO poketmon(num, answer)
VALUES (1,'피카츄');
INSERT INTO poketmon(num, answer)
VALUES (2,'라이츄');
INSERT INTO poketmon(num, answer)
VALUES (3,'파이리');
INSERT INTO poketmon(num, answer)
VALUES (4,'꼬부기');
INSERT INTO poketmon(num, answer)
VALUES (5,'버터풀');
INSERT INTO poketmon(num, answer)
VALUES (6,'야도란');
INSERT INTO poketmon(num, answer)
VALUES (7,'피죤투');
INSERT INTO poketmon(num, answer)
VALUES (8,'또가스');
INSERT INTO poketmon(num, answer)
VALUES (9,'리자몽');
INSERT INTO poketmon(num, answer)
VALUES (10,'거북왕');

COMMIT;

SELECT *
FROM poketmon;

desc poketmon;