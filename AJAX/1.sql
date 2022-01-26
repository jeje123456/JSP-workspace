USE demo;
DROP TABLE IF EXISTS EMP;
CREATE TABLE IF NOT EXISTS EMP (
  id INT AUTO_INCREMENT,
  name VARCHAR(50),
  PRIMARY KEY(id)
);

SELECT * FROM emp;

INSERT INTO emp(name) VALUE ("펭수");
INSERT INTO emp(name) VALUE ("길동");
INSERT INTO emp(name) VALUE ("라이언");
INSERT INTO emp(name) VALUE ("마틸다");
INSERT INTO emp(name) VALUE ("골드");