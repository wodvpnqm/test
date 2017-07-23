DROP TABLE TBL_USER CASCADE CONSTRAINTS ;
DROP TABLE TBL_DEP CASCADE CONSTRAINTS ;

CREATE TABLE TBL_DEP (
    DEPID VARCHAR2(20)  PRIMARY KEY,
    NAME  VARCHAR2(20)
);
CREATE TABLE TBL_USER (
    USERID VARCHAR2(20)  PRIMARY KEY,
    NAME VARCHAR2(20) ,
    DEPID VARCHAR2(20) ,
    SEX VARCHAR2(10) ,
    CONSTRAINT TBL_USER_FK FOREIGN KEY(DEPID)
    REFERENCES TBL_DEP(DEPID)
);



INSERT INTO TBL_DEP VALUES('01','总公司');
INSERT INTO TBL_DEP VALUES('0101','一分公司');
INSERT INTO TBL_DEP VALUES('0102','二分公司');
INSERT INTO TBL_DEP VALUES('010101','开发部');
INSERT INTO TBL_DEP VALUES('010102','测试部');
INSERT INTO TBL_DEP VALUES('010201','开发部');
INSERT INTO TBL_DEP VALUES('010202','客服部');
INSERT INTO TBL_USER VALUES('user0001','张三1','010101','男');
INSERT INTO TBL_USER VALUES('user0002','张三2','010101','男');
INSERT INTO TBL_USER VALUES('user0003','张三3','010102','男');
INSERT INTO TBL_USER VALUES('user0004','张三4','010201','男');
INSERT INTO TBL_USER VALUES('user0005','张三5','010201','男');
INSERT INTO TBL_USER VALUES('user0006','张三6','010202','男');
COMMIT;