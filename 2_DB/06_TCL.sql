/*TCL (TRANSACTION CONTOL LANGUGE) :트렌젝션 제어 언어 */
--COMMIT (트렉제션 종료후 저장) , ROLLBACK(트레제션 취소), SAVAPOINT (임시 저장)


-- DML : 데이터 조작 언어 삽입 수정, 삭제 
--> 트레젝션은 DML과 관련 되어 있다



/*TRANSACTION 이란 ?
- 데이터 베이스의 논리적 연산 단위 

- 데이터 변경사항은 묶어 하나의 트렉젝션에 담아 처리 

- 트렉젝션 대상이 되는 데이터 변경 사항 : INSERT, UPDATE, DELETE

 EX) INSERT 수행 -------------------------> DB반영(X)

        INSERT 수행 ---> 트렉젝션 추가 --> COMMIT --> DB반영(O)
        
        INSERT 10번 수행 -->1개 트렉젝션에 10개 추가-->ROLLBACK -->DB반영 안됨(X)         
    
        
    [ TCT 종류 ]
    1) COMMIT : 메모리 버퍼 (트레젝션)에 임시 저장된 데이터 변경 사항 DB반영 
        
    2) ROLLBACK: 메모리 버퍼(트레젝션)에 임시 저장된 데이터 변경 사항을 삭제하고 
                        마지막 COMMIT 상태로  돌아감
        
    3) SAVEPOINT :메모리 버퍼(트레젝션) 에 저장지점을 정의하여 
                        ROLLBACK 수행시 전체 작업을 삭제하는 것이 아닌 
                        저장 지점까지만 일부 ROLLBACK
        
        
    [SAVEPOINT 사용법]

    SAVEPOINT포인트 1;
    .....
    SAVEPOINT 포인트 2; 
    ......
    ROLLBACK TO 포인트 1; ---- 포인트 1 지점까지 데이터 변경 사항 삭제
    

*/
CREATE TABLE DEPARTMENT2 AS SELECT * FROM  DEPARTMENT2; 
--DEPARTMENT2 현재 상태 확인
 SELECT * FROM  DEPARTMENT2;
 
 --D0 , 경리부 ,L2 삽입
INSERT INTO DEPARTMENT2 VALUES ( 'D0', '경리부', 'L2');
INSERT INTO  DEPARTMENT2  (DEPT_ID, DEPT_TITTLE , LOCATION_ID) VALUSE ('D0', '경라부 ', 'L2');

 SELECT * FROM  DEPARTMENT2;
 
 ROLLBACK;

--롤백 후 확인 
  SELECT * FROM  DEPARTMENT2;
  
  --다시 INSERT후 COMMIT 
  INSERT INTO DEPARTMENT2 VALUES ( 'D0', '경리부', 'L2');
  COMMIT;
  
  --롤백 수행후 경리부 삭제 조회 
ROLLBACK;
SELECT * FROM  DEPARTMENT2;

------------------------------------------------------------------------------------------------

DELETE FROM DEPARTMENT2 WHERE DEPT_ID='D0';

--D0삭제 시전에서 SAVEPOIN지정 
SAVEPOINT SP1; -- Savepoint이(가) 생성되었습니다.

--D9 삭제 
DELETE FROM DEPARTMENT2 WHERE DEPT_ID='D9';
SELECT * FROM  DEPARTMENT2;

-- 일반 ROLLBACK시 D9, D0복구 됨 
ROLLBACK;
SELECT * FROM  DEPARTMENT2;

--SP1까지 ROLLBACK
ROLLBACK TO SP1;
SELECT * FROM  DEPARTMENT2;

ROLLBACK;
SELECT * FROM  DEPARTMENT2;






























