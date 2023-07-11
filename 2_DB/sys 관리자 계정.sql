-- 한줄주석
/*범위주석*/

--SQL 실행장법: SQL문에 커서를 두거나, 블럭처리후 CTRL+ENTER

select username from dba_users;
--18C버전은 일반 사용자를 구분할 때 ID앞에 C##을 붙여야하는데 
--이를 무시하고 11g와 호환 되는 SQL문을 작성하는 SQL을 수행

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER ljy IDENTIFIED BY ljy1234;
--생성한 자용자 계정 권한 부여 
GRANT CONNECT, RESOURCE TO  ljy;
-- CONNECT :DB 연결권한 ROLE
-- RESOURCE :DB 기본객체 생성 권한 ROLE

-- 객체(테이블 등)가 생성될 수 있는 공간 할당량 지정
ALTER USER ljy DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;

