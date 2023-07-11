/* SELECT (DML 또는 DQL) :조회

    -  데이터를 조회 (SELSECT)하면 조건에 맞는 행들이 조회됨
        이때 조회된 행들의 집합을 "RESULT SET"이라고 한다.

    -  RESULT SET 에는 0개 이상이 포함 될 수 있다. 
        왜 0개? 조건에 맞는 행이 없을 수도 있기 때문에
        
*/

-- EMPLOEE 테이블에서 모든 사원의 정보를 조회
-- ' * ' : ALL , 모든, 정보 
SELECT * FROM EMPLOYEE;

-- [SELECT 컬럼명 FROM 테이블명]
-- EMPLOYEE 테이블의 모든 사원의 이름만 조회 
SELECT EMP_NAME FROM EMPLOYEE; 

-- [SELECT 컬럼명, 컬럼명 ,... FROM 테이블명]
-- EMPLOYEE테이블에서 모든 사원의 사번, 이름, 전화 번호 조회
SELECT EMP_ID, EMP_NAME,PHONE FROM EMPLOYEE; 

--EMPLOYEE 테이블에서 모든 사원의 사번 , 이름 ,이메일,입사일 조회
SELECT EMP_ID, EMP_NAME, EMAIL,HIRE_DATE FROM EMPLOYEE; 

--DEPARTMENT 테이블에 있는 모든 행 조회
SELECT * FROM DEPARTMENT;

----------------------------------------------------------------------------------------------------
--<컬럼값 산술 연산>
--컬럼값 : 테이블의 한칸 (==한 셀)에 작성된 값 (DATA)

--SELECT 문 작성시 컬럼명에 산술연산을 작성하면 
--조회 되는 결과 값에 산술 연산이 반영된다 

--EMPLOYEE 테이블에서 모든 사원의 사번, 이름, 급여 조회 + 100만 조회
SELECT EMP_ID, EMP_NAME, SALARY , SALARY + 1000000  
FROM EMPLOYEE;

--EMPLOYEE 테이블에서 모든 사원의 이름 급여, 연봉 (급여*12)을 조회
SELECT EMP_ID, EMP_NAME, SALARY , SALARY * 12
FROM EMPLOYEE;

-----------------------------------------------------------------------------------

--(중요) < 오늘 날짜 조회>
SELECT SYSDATE FROM DUAL;

-- SYSDATE : 시스템상의 현재 날짜 
--           (년월일시,분 초 단위까지 표현 가능 하지만 
--           디벨로퍼의 날짜 표기 방법이 년/월/일로 지정되어 있는 것이다.)

--DUAL (DUmmy TAbLe) : 가짜 테이블 ( 임시테이블, 단순 조회 테이블)
--도구> 환경설정 > 데이터 데이스> NLS >날짜형식 YYYY/MM/DD HH24:MI:SS

-- ** DB는 날짜 데이터의 연산(+, -)가 가능하다 (일 단위) **
SELECT  SYSDATE ,  SYSDATE + 1,  SYSDATE -1 FROM DUAL;

--EMPLOYEE 테이블에서 이름 , 입사입, 오늘까지 근무한 날짜 조회
SELECT EMP_NAME, HIRE_DATE,(SYSDATE - HIRE_DATE) / 365
FROM EMPLOYEE;

--------------------------------------------------------------------------------

--< 컬럼별칭 지정>
-- SELECT 조회 집합안 RESULT SET에 컬럼명 지정

/*
1) 컬럼명 AS 별칭 : 띄어쓰기 X , 특수 문자X, 문자 O
2) 컬럼명 별칭 : 1) AS만 생략 한 것 

3) 컬럼명 AS "별칭" : 띄어 쓰기 O, 특수문자O, 문자 O
4) 컬럼명 "별칭" : 3) AS만 생략 한 것

*/

--EMPLOYEE 테이블에서 
--사번, 이름, 급여 (원) ,근무일수를 모두 조회
SELECT EMP_ID AS 사번,
         EMP_NAME AS 이름,
        SALARY AS "급여(원)",
        SYSDATE -  HIRE_DATE "근무일수"    
FROM EMPLOYEE;

-------------------------------------------------------------------------------------------

--리터럴 : 값 자체 

--DB에서의 리터럴 : 임의로 지정한 값을 기존 테이블에 존재하는 값처럼 사용 
--> 리터럴 표기법 ' '(홑따음표) 

SELECT EMP_NAME, SALARY ,'원' AS 단위
FROM EMPLOYEE;

---------------------------------------------------------------------------------------------

--DISTINCT :조회시 컬럼에 포함된 중복 값을 한번 만 표시할때 사용

--(주의사항) 
--1) DISTINCT는 SELECT문에 딱 한 번만 작성할 수 있다. 
--2) DISTINCT는 SELECT문 가장 앞에 작성 되어야함 

--EMPLOYEE테이블에 저장된 직원들이 속해 있는 부서 코드 종류 조회
SELECT DISTINCT EMP_NAME, DEPT_CODE FROM EMPLOYEE;

---------------------------------------------------------------------------------------------

--WHERE절
--테이블에서 조건을 가진 행만 조회하고 할때 사용

--비교연산자: >,< ,= , <=,>=, =(같다) , !=, <>(같지않다) 

--EMPLOYEE테이블에서 급여가 3백만원 초과인 직원의
--사번, 이름, 급여, 부서코드 조회
/*해석 순서 */
/*3)*/SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE
/*1) 어떤 테이블에서 가져올 껀지*/FROM EMPLOYEE
/*2) 조건*/WHERE SALARY >3000000;

--EMPLOYEE테이블에서 
--부서 코드가 'D9'인 직원의 
--사번, 이름, 부서코드, 전화번호 조회

SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE,PHONE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9'; --데이터 베이스에서는 ' '사용

--------------------------------------------------------------------------------------

--논리연산자 (AND, OR)

--EMPLOYEE 테이블에서 급여가 200만 이상이고 
--부서 코드가 'D6'인 직원의 
--이름 , 급여, 부서코드 조회
SELECT  EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE SALARY >= 2000000 
AND DEPT_CODE ='D6'; 


--EMPLOYEE테이블에서 
--급여가 300만 이상, 500만 이하인 직원의 
--사번, 이름, 급여 조회

SELECT   EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000 AND SALARY <= 5000000;

--EMPLOYEE테이블에서 
--부서 코드가 'D6 또는 'D9' 인 사원의 
--사번 , 이름, 부서코드 조회

SELECT   EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE ='D6' 
OR DEPT_CODE = 'D9';

-------------------------------------------------------------------------------

--컬럼명 BETWEEN A AND B : 컴럼 값이 A이상 B 이하인 경우 

--EMPLOYEE테이블에서 
--급여가 300만 이상, 500만 이하인 직원의 
--사번, 이름, 급여 조회

SELECT   EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3000000 AND 5000000;

--컬럼 명  NOT BETWEEN A AND B : 컬럼 값이A이상B이하가 아닌경우 
                                        --컬럼 값이 A미만 ,B 초과인 경우 
                                        
--EMPLOYEE테이블에서 
--급여가 200만 미만, 500만 초과인
--직원의 사번, 이름 급여 조회

SELECT   EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY NOT BETWEEN 2000000 AND 5000000;

--BETWEEN 을이용한 날짜 비교 
--EMPLOYEE 테이블에서
--입사일 1990/01/01~ 1999/12/31/인 (90년도 입사자) 
--직원의 사번, 이름, 입사일 조회

SELECT EMP_ID , EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '1990/01/01' AND '1999/12/31' ;

/*** '1990/01/01' 날짜를 문자열로 형식으로 작성하게 되면 
    DB가 알아서 판단하여 날짜타입 (DATE)으로 형변환을 진행함***/
    
---------------------------------------------------------------------------------

/* LIKE 

-비교하려는 값이 특정한 패턴을 만족시키면 조회하는 연산자 

[작성법]
WHERE 컬럼명 LIKE '패턴'

--LIKE 패턴( 와일드 카드) : ' %' (포함) ' _ ' (글자수)

' % '  예시 
1) 'A%' :  문자열이 A로 시작하는 모든 컬럼값
2) '%A' : 문자열이 A로 끝나는 모든 컬럼값
3) '%A% :' 문자열에 A가 포함되어 있는 모든 컬럼값



' _ ' 예시 
1) 'A_' : A뒤에 아무거나 한글자
2) '___A' : A 앞에 아누거나 세글자 (4글자 문자열이면서 4번째 글자A)

*/

--EMPLOYEE 테이블에서 성이 '이'씨인 직원 사번 ,이름 조회
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE  EMP_NAME LIKE '이%';

--EMPLOYEE테이블
--이름에 '하'가 포함된 사원의 사번, 이름 조회
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

--EMPLOYEE테이블에서 
--전화번호가 010으로 시작하는 사번, 이름 , 전화번호 조회
SELECT EMP_ID, EMP_NAME,PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '010%';

SELECT EMP_ID, EMP_NAME,PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '010________';

--010으로 시작하지 않는 사람들 조회 하기 
--> NOT LIKE (LIKE결과 부정) 
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

--EMPLOYEE테이블에서 
--이메일의 _ 앞글자 세글자인 사원 사번, 이름, 이메일 조회
SELECT EMP_ID ,EMP_NAME ,EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___%_';


--문제점 : 와일드 카드 문자 (_) 와 패턴에 사용되는 일반 문자(_) 의 모양이 같아서 문제 발생 
--해결방법 : ESCAPE OPTION 을 이용하여 일반문자로 처리할 '_',"%' 앞에 아무 특수 문자 나 붙임 
SELECT EMP_ID ,EMP_NAME ,EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___$_%' ESCAPE '$'; --보통 ' $ '나 ' #'  포시 
                                            --> $ 된 한글자 만( _)을 한글자만 일반 문자 취급 
                                        
--연습문제 
--1.EMPLOYEE테이블에서  이름 끝이 '연'으로 끝나는 사원의 이름 조회
SELECT EMP_NAME 
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

--2. EMPLOYEE테이블에서 전화번호가 처음 3자리 가 010이 아닌 사원 이름, 전화번호 조회
SELECT EMP_NAME ,PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

--3. EMPLOYEE테이블에서 이메일 주소 '_' 의 앞이 4 이면서 DEPT_CODE가 'D6'도는 'D9'이고 
--고용일이 90/01/01 ~ 00/ 12/01 이거, 급여가 270만 이상인 사원의 전체 를 조회
SELECT * FROM EMPLOYEE
WHERE EMAIL LIKE '____$_%' ESCAPE '$'
AND ( DEPT_CODE ='D9' OR DEPT_CODE = 'D6')
AND HIRE_DATE BETWEEN '1990/01/01' AND '2000/12/01'
AND SALARY >= 2700000 ;

-- 연산자 우선순위
/*
1. 산술연산자
2. 연결연산자
3. 비교연산자
4. IS NULL / IS NOT NULL, LIKE, IN / NOT IN
5. BETWEEN AND / NOT BETWEEN AND
6. NOT(논리연산자)
7. AND(논리연산자) --  AND 연산자가 OR연산자 보다 우선 순위가 높음 
8. OR(논리연산자)
*/

-----------------------------------------------------------------------------------------------------

/*IN연산자 
- 비교하려는 값과 목록에 비교하려는 것이 있으면 조회하는 연산자 
--> OR연산을 연달아 작성한 횩과 

[작성법]
컬럼명 IN (값1 , 값2 값3,....)

*/
--EMPLOYEE 테블에서 
--부서 코드가 D1 또는 D6 또는 D9인 사원의 사번, 이름, 부소코드 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
--WHERE DEPT_CODE = 'D1' OR DEPT_CODE ='D6' OR DEPT_CODE = 'D9';
WHERE DEPT_CODE IN('D1', 'D6', 'D9');

--사번이 200, 205, 210인 사원의 사번 이름 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE EMP_ID IN(200, 205, 210);

--사번이 200, 205, 210이 아닌 사원의 사번 이름 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE EMP_ID NOT IN(200, 205, 210);

---------------------------------------------------------------------------------------------

-- 연결연산자 ( || )

-- 어러 값을 하나의 컬럼 값으로 연결하는 연산자 
--(자바의 문자열 + (이어쓰기) 효과)
SELECT EMP_NAME ||  '의 급여는 ' || SALARY  || '원 입니다.' AS 결과
FROM EMPLOYEE;

-----------------------------------------------------------------------------------------------

/*NULL 처리 연산자 
--JAVA에서 NULL참조하는 객체가 없다 
--DB에서 NULL : 컬럼 값이 없다. 

1)  IS NULL 컬럼 값이 NULL인 경우 조회 
2) IS NOT NULL : 컬럼 값이 NULL 이 아닌 경우 조회

*/

--EMPLOYEE테이블에서 전화번호가 없는 사원의 사번 이름, 전화 번호 조회
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE IS NULL;

--EMPLOYEE테이블에서 보너스를 받는 사람의 이름 , 보너스  조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE BONUS IS  NOT NULL;


----------------------------------------------------------------------------------------------

/* ORDER BY 절 
- SELECT 문의 조회 결과 (RESULT SET) 를 정렬할 때 작성하는 구문 

-*********SELECT 문 가장 마지막에 해석************

[작성법] 해석순서 
3 : SELECT 컬럼명 AS 별칭 , 컬럼명, 컬럼명 .....
1 : FROM 테이블명 
2 : WHERE 조건식
4 : ORDER BY 컬럼명 | 별칭 | 컬럼 순서   [정렬 방식 [오름 / 내림]       [NULL FIRST  |  LAST]

*/
----EMPLOYEE 테이블에서 급여 "오름차순 "으로 이름, 급여 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY ASC ; --( ASENDING : 오름차순)

----EMPLOYEE 테이블에서 급여 "내림차순 "으로 이름, 급여 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC ; --( DSENDING : 내림차순)

----EMPLOYEE 테이블에서 급여가 200만 사원을 오름차순 정렬 
SELECT * FROM EMPLOYEE
WHERE SALARY >= 2000000
ORDER BY SALARY /*ASC*/ ; --( ASENDING : 오름차순)
-- ORDER BY 정렬은 기본적으로 오름차순 ASC 생략가능

--***정렬은 숫자 , 문자, 날짜 모두 사용 가능

--이름 오름차순
SELECT EMP_NAME 
FROM EMPLOYEE
ORDER BY EMP_NAME ASC ; --( ASENDING : 오름차순)
-- ORDER BY 정렬은 기본적으로 오름차순 ASC 생략가능

--고용일 내림차순
SELECT EMP_NAME, HIRE_DATE 
FROM EMPLOYEE
--ORDER BY HIRE_DATE DESC ; --> 컬럼명 
ORDER BY 2 DESC; --> 컬럼 순서로 내림차순 

--연봉 내림차순 
SELECT EMP_NAME ,SALARY*12 AS 연봉
FROM EMPLOYEE
WHERE SALARY*12 >= 5000000
--WHERE 연봉 >= 5000000 --> 해석 순서가 별칭 해석 전이기 때문에 오류 발생 
--ORDER BY SALARY *12  DESC ; --> 컬럼명 (가능)
--ORDER BY 2  DESC ; --> 컬럼 순서 (가능)
ORDER BY 연봉 DESC; --> 별칭 (가능)


--보너스 정렬 
SELECT EMP_NAME ,BONUS
FROM EMPLOYEE
--ORDER BY BONUS ; --NULLS LAST 기본값 
--ORDER BY BONUS DESC; --NULLS FIRST 기본값
ORDER BY BONUS NULLS FIRST;

--오름차순 정렬 시 NULLS LAST가 기본값 
--내림차순 정렬시 NULLS FRIST 가 기본값

/*정렬 중첩(큰 분류를 먼저 정렬하고 내부의 작은 분류를 정렬)*/
--EMPLOYEE 테이블에서 부서코드 오름차순 후 
--부서별 급여 내림차순 정렬
SELECT EMP_NAME, DEPT_CODE, SALARY 
FROM EMPLOYEE
ORDER BY DEPT_CODE, SALARY DESC;













