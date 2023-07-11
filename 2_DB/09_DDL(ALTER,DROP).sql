-- DDL(Data Definition Language) : 데이터 정의 언어로
-- 객체를 만들고(CREATE), 수정하고(ALTER), 삭제하는(DROP) 구문

-- ALTER(바꾸다, 변조하다)
-- 수정 가능한 것 : 컬럼(추가/수정/삭제), 제약조건(추가/삭제)
--                  이름변경(테이블, 컬럼, 제약조건)

-- [작성법]
-- 테이블을 수정하는 경우
-- ALTER TABLE 테이블명 ADD|MODIFY|DROP 수정할 내용;

--------------------------------------------------------------------------------
-- 1. 제약조건 추가 / 삭제

-- * 작성법 중 [] 대괄호 : 생략할 수 도, 안할 수 도 있다.

-- 제약조건 추가 : ALTER TABLE 테이블명 
--                 ADD [CONSTRAINT 제약조건명] 제약조건(컬럼명) [REFERENCES 테이블명[(컬럼명)]];

-- 제약조건 삭제 : ALTER TABLE 테이블명
--                 DROP CONSTRAINT 제약조건명;


--SUBQUERY 이용해서 DEPARTMENT테이블 복사 
CREATE TABLE DEPT_COPY AS 
SELECT * FROM DEPARTMENT;

--DEPT_COPY 테이블에 PK추가 
ALTER TABLE DEPT_COPY ADD 
PRIMARY KEY (DEPT_ID);

-- DEPT_COPY 테이블에 DEPT_TITLE 컬럼에 UNIQUE 제약조건 추가 (제약조건명 : DEPT_TITLE_U)
ALTER TABLE DEPT_COPY
ADD CONSTRAINT DEPT_TITLE_U UNIQUE (DEPT_TITLE);

-- DEPT_COPY 테이블에 DEPT_LOCATION_ID 컬럼에 CHECK 제약조건 추가
-- 컬럼에 작성 할 수 있는 값은 L1,L2,L3,L4,L5
-- 제약조건명 : LOCATION_ID_CHK
ALTER TABLE DEPT_COPY
ADD CONSTRAINT LOCATION_ID_CHK CHECK(LOCATION_ID IN ( 'L1','L2','L3','L4','L5'));


--DEPT_COPY 테이블에 DEPT_TITLE 칼럼에 NOT NULL제약 조건 추가
--**** NOT NULL 제약 조건은 다루는 방법이 다름 ***
--NOT NULL을 제외한 제약조건은 추가적인 조건으로 인식됨 (ADD/DROP)
--NOT NULL은 기본 컬럼의 성질을 변경하는 것으로 인식됨(MODIFY)
ALTER TABLE DEPT_COPY
MODIFY DEPT_TITLE NOT NULL; --NOT NULL은 MODIFY 사용!!!(꼭 기억!!!!!!!!!!)

--------------------------------------------------------------------

--DEPT_COPY에 추가한 제약조건 중 PK만 빼고 삭제하기
ALTER TABLE DEPT_COPY DROP CONSTRAINT DEPT_TITLE_U;
ALTER TABLE DEPT_COPY DROP CONSTRAINT LOCATION_ID_CHK;
ALTER TABLE DEPT_COPY DROP CONSTRAINT SYS_C007570; --NOT NULL

--NOT NULL 제거시 MODIFY 사용--
ALTER TABLE DEPT_COPY 
MODIFY DEPT_TITLE CONSTRAINT SYS_C007571 NULL;

-------------------------------------------------------------------------

-- 2. 컬럼 추가/수정/삭제 

--컬럼 추가 : ALTER TABLE 테이블명 ADD(컬럼명 데이터 타입 [DEFAULT '값']);

--컬럼 수정 : ALTER TABLE 테이블명 MODIFY 컬럼명 데이터 타입; -- (데이터 타입 변경)
--          ALTER TABLE 테이블명 MODIFY 컬럼명 DEFAULT '값'; ( 기본 값 변경)

-->***데이터타입 수정시 컬럼에 저장된 데이터 크기의 미만으로는 변경할 수 없다. 

--컬럼 삭제 : ALTER TABLE 테이블명 DROP(삭제할 컬럼명);
--          ALTER TABLE 테이블명 DROP COLUMN 삭제할 컬럼명 ;

-->** 테이블에는 최소 1개 이상의 컬럼이 존재하여야 하기 때문에 모든 컬럼 삭제할수 없다
--테이블이란? 행과 열로 이루어진 데이터베이스의 가장 기본적인 객체 

--(추가)
-- DEPT_COPY 테이블에 CNAME VARCHAR2 (20) 컬럼 추가
-- ALTER TABLE 테이블명 ADD (컬럼명 데이터 타입 [DEFAULT '값']);
ALTER TABLE DEPT_COPY 
ADD(CNAME VARCHAR2(20));

SELECT * FROM DEPT_COPY; --> CNAME 컬럼추가 확인


--DEPT_COPY 테이블에 LNAME VARCHAR2 (30) 기본 값 '한국' 컬럼 추가
ALTER TABLE DEPT_COPY 
ADD (LNAME VARCHAR2 (30) DEFAULT '한국');
 
SELECT * FROM DEPT_COPY;--LNAME 컬럼이 추가되어 있고, 컬럼값이 모두 '한국'으로 되어 있음


--(수정) 
--DEPT_COPY 테이블에 DEPT_ID 컬럼의 데이터 타입을 CHAR(2) -> VARCHAR2(3)으로 변경 
-- ALTER TABLE 테이블명 MODIFY 컬럼명 데이터 타입; -- (데이터 타입 변경)
ALTER TABLE DEPT_COPY 
MODIFY DEPT_ID VARCHAR2(3);
 
 --(수정시 에러 상황)
--DEPT_COPY 테이블에 DEPT_TITLE 컬럼의 데이터 타입을 VARCHAR2(10)으로 변경 
SELECT * FROM DEPT_COPY;--'인사관리부' == 15BYTE (한글 3BYTE)

ALTER TABLE DEPT_COPY 
MODIFY DEPT_TITLE VARCHAR2(10); 
--ORA-01441: 일부 값이 너무 커서 열 길이를 줄일 수 없음 
 
--(기본값 수정)
--LNAME기본 값을 '한국'에서 '대한민국'르로 변경 
--ALTER TABLE 테이블명 MODIFY 컬럼명 DEFAULT '값'; 
ALTER TABLE DEPT_COPY
MODIFY LNAME DEFAULT '대한민국'; 

SELECT * FROM DEPT_COPY; --> 기본 값을 변경했다고 해서 기존에 저장된 값이 변경 되지 않음

UPDATE DEPT_COPY 
SET LNAME = '대한민국'; 

UPDATE DEPT_COPY SET LNAME = DEFAULT; --DEFAULT이용한 데이터 수정 방법

ROLLBACK;

--(삭제) 
--DEPT_COPY 테이블에 추가한 컬럼 (CMNAME, LNAME) 삭제
--ALTER TABLE 테이블명 DROP (삭제할 컬럼명);
ALTER TABLE DEPT_COPY DROP  (CNAME);
SELECT * FROM DEPT_COPY;

--ALTER TABLE 테이블명 DROP COLUMN(삭제할 컬럼명);
ALTER TABLE DEPT_COPY DROP COLUMN LNAME;
SELECT * FROM DEPT_COPY;


--(컬럼 삭제 문제점) 
--DEPY_COPY 테이블의 모든 컬럼 삭제 
SELECT * FROM DEPT_COPY; --컬럼 3개 확인
ALTER TABLE DEPT_COPY DROP(DEPT_TITLE);
ALTER TABLE DEPT_COPY DROP(LOCATION_ID);

SELECT * FROM DEPT_COPY; --컬럼 1개 확인 

ALTER TABLE DEPT_COPY DROP(DEPT_ID); --삭제 실패
--ORA-12983: 테이블에 모든 열들을 삭제할 수 없습니다

ROLLBACK;--트렌젝션(DML 을 이용한 데이터 변경사항을 저장)을 삭제하고 마지막 COMMIT상태로 돌아감 

SELECT * FROM DEPT_COPY;
--> ROLLBACK 안됨!
--왜? CREATE/ ALTER/ DROP 같은 DDL은 ROLLBACK대상이 아님

--* DDL/ DML 혼용해서 사용할 경우 문제점
--DML을 수행하여 트렌젝션에 변경사항이 저장된 상태에서 
--COMMIT/ ROLLBACT없이 DDL구문을 수행하게 되면 
--DDL 수행과 동시에 선행 DML이 자동으로 COMMIT되어버림

--결론 : DML/ DDL혼용해서 사용하지 말자


INSERT INTO DEPT_COPY VALUES ('D0'); --'D0' 삽입
SELECT * FROM DEPT_COPY;
ROLLBACK; -- 트렌잭션에 담긴 'D0' INSERT 내용 삭제 
SELECT * FROM DEPT_COPY;


INSERT INTO DEPT_COPY VALUES ('D0'); --'D0' 삽입
SELECT * FROM DEPT_COPY;

ALTER TABLE DEPT_COPY MODIFY DEPT_ID VARCHAR2(4);-- DDL수행
ROLLBACK;
SELECT * FROM DEPT_COPY; --'D0' 사라지지 않음

--------------------------------------------------------------------

--3. 테이블 삭제 
--[작성법] DROP TABLE [CASCADE COMSTRAINTS];

CREATE TABLE TB1(
    TB1_PK NUMBER PRIMARY KEY,
    TB1_COL NUMBER
);

CREATE TABLE TB2(
    TB2_PK NUMBER PRIMARY KEY,
    TB2_COL NUMBER REFERENCES TB1 -- TB1 테이블의 PK 값을 참조
    
);

--일반 삭제 (DEPT_COPY)
DROP TABLE DEPT_COPY; --Table DEPT_COPY이(가) 삭제되었습니다.

--**관계가 형성된 테이블 중 부모 테이블(TB1) 삭제 **
DROP TABLE TB1;
--ORA-02449: 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다

--해결방법 1: 자식 테이블 -> 무모 테이블 
--(참조하고 있는 테이블이 없으면 삭제 가능)
DROP TABLE TB2;
DROP TABLE TB1;--삭제 성공

--해결방법2: CASCADE CONATRAINTS 옵션 삭제 
--> 제약 조건 까지 삭제
-- = FK 제약 조건으로 인해 삭제가 블가능 하지만 , 제약 조건을 없애 버려서 FK관계 해제
DROP TABLE TB1 CASCADE CONSTRAINTS; --삭제 성공 
DROP TABLE TB2;

---------------------------------------------------------------
--4. 컬럼, 제약 조건 , 테이블이름 변경 (RENAME)

--테이블 복사 
CREATE TABLE DEPT_COPY AS SELECT * FROM DEPARTMENT;

--복사한 테이블에 PK제약조건 추가 
ALTER TABLE DEPT_COPY ADD CONSTRAINTS PK_DCOPY PRIMARY KEY(DEPT_ID); 

--1) 컬럼명 변경 : ALTER TABLE 테이블명 RENAME COLUMN 컬럼명 TO 변경명;
ALTER TABLE DEPT_COPY RENAME COLUMN DEPT_TITLE TO DEPT_NAME;
SELECT * FROM DEPT_COPY;

--2) 제약조건명 변경 : ALTER TABLE 테이블명 RENAME CONSTRAINT 제약조건명 TO 변경명;
ALTER TABLE DEPT_COPY RENAME CONSTRAINT PK_DCOPY TO DEPT_COPY_PK;

--3) 테이블명 변경 : ALTER TABLE 테이블명 RENAME TO 변경명;
ALTER TABLE DEPT_COPY RENAME TO DCOPY;
SELECT * FROM DCOPY;
SELECT * FROM DEPT_COPY; --이름이 변경 되어서 DEPT_COPY 테이블명으로 조회 불가










