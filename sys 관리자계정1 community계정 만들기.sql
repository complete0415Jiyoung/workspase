ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER community_ljy IDENTIFIED BY community1234;

ALTER USER community_ljy DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;

GRANT CONNECT, RESOURCE, CREATE VIEW TO community_ljy;


--암호화된 비밀번호 업데이트 
UPDATE MEMBER 
SET MEMBER_PW ='aBN5hiegXlvAovJLipPoPd5LB+xjPrAeu1tcAVg0p5MKGocvo6l825SD+ZMCOcHBFeGB7MnzH31SAnDzYYsSdg=='
WHERE MEMBER_PW='pass01!';

--MEMBER 테이블 비밀번호 컬럼의 크기 변경
ALTER TABLE MEMBER
MODIFY MEMBER_PW VARCHAR2(100);

--암호화된 비밀번호로 업데이트
UPDATE MEMBER 
SET MEMBER_PW ='aBN5hiegXlvAovJLipPoPd5LB+xjPrAeu1tcAVg0p5MKGocvo6l825SD+ZMCOcHBFeGB7MnzH31SAnDzYYsSdg=='
WHERE MEMBER_NO=1;

commit;

--회원정보 수정
UPDATE MEMBER
SET MEMBER_NICK=?,
MEMBER_TEL=?,
MEMBER_ADDR=?
WHERE MEMBER_NO=?;

--비밀범호 수정 
UPDATE MEMBER
SET MEMBER_PW = ?
WHERE MEMBER_NO =?
AND MEMBER_PW = ?;


--회원탈퇴
UPDATE MEMBER SET
SECESSION_FL='Y'
WHERE MEMBER_NO=?
AND MEMBER_PW=?;




--이메일 중복 검사 
-- 중복되면 1, 아니면 0 
SELECT COUNT(*) FROM MEMBER
WHERE MEMBER_EMAIL='user01@kh.or.kr'
AND SECESSION_FL='N';



