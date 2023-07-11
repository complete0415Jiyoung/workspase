package edu.kh.collection.model.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.model.vo.Member;

public class SetService {
	//Set (집합):
	// - 순서를 유지하지 않음(==인덱스 없음) 
	// - 중복을 허용하지 않음 (+null도 중복 안됨, 1개만 저장 가능)

	//**Set이 중복 확인하는 방법***
	//-> 객체가 가지고 있는 필드 값이 모두 같으면 중복으로 판단
	//--> 이때 필드 값이 모두 같은지 비교하기 위해서 
	//객체에 "equals()"가 반드시! 오버라이딩 되어 있어야한다 

	
	
	public void ex1() {
		Set<String > set =new HashSet <String>();
		
		//인터페이스라서 참조 변수로만 사용 가능/ 객체 생성 불가능 
		//HashSet : Set의 대표적인 자식 객체
		//사용 조건 1: 저장되는 객체에 equals()오버라이딩 필수
		//사용 조건 2: 저장되는 객체에 hashCode()오버라이딩 필수
		
		//*참고* Hash라는 단어가 붙은 컬렉션은 
		// 반드시 저장되는 객체에 equals(), hashCode()를 오버라이딩 해야함
		
		//Set.add(String e) : 추가
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add(null);
		set.add(null);
		set.add(null);

		//toString()오버라이딩 되어 있음
		System.out.println(set);
		//확인할 것 : 1. 순서, /2. 중복/3. null 중복 X
		//[null, 배달의민족, 카카오, 네이버, 쿠팡, 라인]
		
		//size():저장된 데이터의 갯수 반환 
		System.out.println("저장된 데이터의 수 : "+ set.size());
	
		//remove(String e) : set에 저장된 객체 중에서 매개 변수e와 
		//				 	 필드 값이 같은 개체를 제거
		//				+ Hash라는 단어가 포함된 Set이면 hashCode()도 같이 해야함
		System.out.println(set.remove("라인"));  // 지우려는 거 있으면 true,
		System.out.println(set.remove("야놀자")); // 없으면 false
		System.out.println(set); //제거확인
		
		//Set은 순서가 없어서 저장된 객체 하나를 얻어 올 수 있는 방법이 없음 
		// -> 대신 Set전체의 데이터를 하나씩 반복적으로 얻어 올 수 있다. 
		
		//1. Iterator(반복자) 
		//- 컬렉션에서 제공하는 컬렉션 객체 반복 접근자 
		// (컬렉션에 저장된 데이터를 임의적으로 하나씩 반복적으로 꺼내는 역할)
		
		//Iterator가 얻어온 데이터의 타입은 모두 String
		Iterator<String> it = set.iterator();
		
		//set.Iterator () : Set을 Iterator 하나씩 꺼낼 수 있는 모양으로 변환
		
		while(it.hasNext()) { //하나씩 꺼냈을 때 다음에 값이 없는 경우 == 끝 
			// -> 다음 값이 있으면 반복 해야한다
			
			//it.hasNext() : 다음 값이 있으면 true반환 
			//it.next() : 다음 값(객체)을 얻어옴
			
			String temp = it.next();
			System.out.println(temp);
			
		}
		
		System.out.println("-------------------------------");
		
		
		//2. 향상된 for문 사용 
		//for(하나씩 꺼내서 저장할 변수 : 컬렉션 )
		for(String temp : set) {
			System.out.println(temp);
		}
		
		
	}
	
	public void ex2() {
		//Object 의 equals(), hashCode() 오버라이딩
		
		//A.equals(B) :A와 B가 가지고 있는 필드 값이 모두 같으면 true, 아니면 false
		
		//Hash 함수 : 입력된 단어를 지정된 길이의 문자열로 변환하는 함수 (중복X)
		//ex)	입력 111 -> "asdfg"(5글자)
		//ex)	입력 1234567 -> "qwert"(5글자)
		
		//hashCode(): 필드 값이 다르면 중복되지 않는 숫자를 만드는 메소드 
		
		//-> 왜? 빠른 데이터 검색을 위해서 (객체가 어디 있는지 빨리 찾기 위해서)
		
		//HashSet() :중복 없이 데이터를 저장 Set하고 데이터 검색이 빠름(Hash)
		
		Member mem1 = new Member("use01", "pass01", 30);
		Member mem2 = new Member("use01", "pass01", 30);
		Member mem3 = new Member("use02", "pass02", 30);
		
		//mem1 과 mem2가 같은지 비교 
		System.out.println(mem1 == mem2); //주소를 비교 주소 다름 false
										//얕은 복사를 한 경우가 아니라면 다 false
		
		//mem1과mem2가 가지고 있는 필드 값이 같은지 비교 
		if( mem1.getId().equals(mem2.getId())) {//아이디가 같을 경우 
			
			if( mem1.getPw().equals(mem2.getPw())) {
				
				if( mem1.getAge() == mem2.getAge()){
					System.out.println("같은 객체 입니다 (true)");
					
				}
			}
		}
		//-> 매번 이렇게 비교하기 힘들다 ... 비교 코드를 하나 작성해서 재활용하자 
		// == equals()메소드 오버라이딩 
		
		System.out.println("--------------------------------");
		System.out.println(mem1.equals(mem2));//mem1 mem2의 필드 같은가?
		System.out.println(mem1.equals(mem3));//mem1 mem3의 필드 같은가?
		
		// 서로 다르지만 필드 값이 같다 == 동등
		// 비교하려는 것이 정말 같은 하나의 객체이다 == 동일 
		
		
		
	}
	public void ex3() {
		//equals() 가 오버라이딩 된 Member를 Set에 저장
		
		//[Key Point] : 중복이 제거가 되는가?
		Set<Member>memberSet = new HashSet<Member>();
		memberSet.add(new Member("user01","pass01",30));
		memberSet.add(new Member("user02","pass02",40));
		memberSet.add(new Member("user03","pass03",20));
		memberSet.add(new Member("user04","pass04",25));
		memberSet.add(new Member("user04","pass04",25));
		
		for(Member mem : memberSet) {
			System.out.println(mem);
		}
		
		//hashCode()오버라이딩 전 
		//-> equals()가 오버라이딩 되어 있지만 중복제거 되지 않음 ㅜㅜ
		//-> 왜? HashSet은 hashCode()도 오버라이딩 해야함
		
		Member mem1 = new Member("uaer01", "pass01",30);
		Member mem2 = new Member("uaer01", "pass01",30);
		Member mem3 = new Member("uaer01", "pass01",31);
		
		System.out.println(mem1.hashCode());
		System.out.println(mem2.hashCode());
		System.out.println(mem3.hashCode());
		
	}
	 
	public void ex4() {
		//Wrapper클래스 : 기본 자료형 -> 객체로 포장하는 클래스
		
		//-컬렉션에 기본자료형 값을 저장할때 사용
		//-기본 자료형에 없던 추가 기능, 값을 이용하고 싶을 때 사용
		
		
		//<Wrapper Class의 종류>
		// int   -> integer
		//double -> Double
		//Boolean ,Byte, Short, Long, Float, Character
		
		int iNum =10;
		double dNum = 3.14;
		
		Integer w1 = new Integer(iNum); //int -> integer
		Double w2 = new Double(dNum);
		
		//Wrapper 활용
		System.out.println("int 최댓값 : "+ w1.MAX_VALUE);
		System.out.println("double 최소값 : "+ w2.MIN_VALUE);
							//기울어진 글씨 == Static
							//static은 클래스명.필드명 / 클래스명. 메소드명으로 호출 가능
		System.out.println("w1 값 : "+ w1);
		System.out.println("w2 값 : "+ w2);
		
	
		System.out.println("------------------------------");
		//따로 변수 선언하지 않아도 알수 있음 
		//따라서 Wrapper의 Integer/Double 객체 의 최소 최대값을 알 수 있음
		System.out.println("Static 방식으로 Wrapper 클래스 사용하기");
		
		System.out.println("int 최소값 :" + Integer.MIN_VALUE);
		System.out.println("double 최대값 :" + Double.MAX_VALUE);
		
		//******************************************************
		//parsing : 데이터의 형식을 변환 
		
		//! String 데이터를 기본 자료형으로 변환 
		
		int num1 = Integer.parseInt("100");// 문자열 "100" 을 int형식으로 변환
		double num2 = Double.parseDouble("1.23456");// 문자열 "1.23456"을 double형식으로 변환
		
		System.out.println(num1+num2);
		//******************************************************
		
		
		
		
	}
	
	public void ex5() {
		//Wrapper 클래스의 AutoBoxing / AutoUnBoxing
		
		Integer w1= new Integer(100);
		// 삭제선 == deprecated == 해당 구문은 삭제될 예정
		// ==> 사용을 권장하지 않는다.
		
		Integer w2 = 100;
		Integer w3 = 100;
	 //(Integer)     (int -> Integer)자동 포장
					//AutoBoxing

		//w2 와 100은 원래 연산이 안되여야 하지만 
		//Integer는 int의 포장 형식이라는 것을 자바가 인식하고 있어서 
		//위와 같은 int를 Integer로 자동 포장 해준다.
		
		
		System.out.println("w2 + w3 ="+ (w2 + w3));
		
		//w2 (Integer객체)
		//w3 (Integer객체)
		// w2+w3 == 객체 + 객체 --> 원래는 불가능
		
		//하지만 Integaer는 int의 포장 형태라는걸 자바가 인식 하고 있어서 
		//+ 연산시 포장을 자동으로 벗겨냄 
		
		//integer + Integer -> int + int (자동 포장 해제)
								//AutoUnBoxing
		}
	
	public void lotto() {

		//로또 버전 생성기 버전2
		
		//Set <int> lotto = new HashSet<int>();
		//int로 타입을 제한 할 수 없다 
		//-> 왜? int로 기본자료형이기 때문에 객체만 저장하는 컬렉션에 들어 갈수 없다 
		
		//-> 해결 방법 : Wrapper Class를 이용해서 기본 자료형을 객체로 포장한다.
	
		
		//Set<Integer>lotto =new HashSet<Integer>();
		//Set<Integer>lotto =new LinkedHashSet<Integer>();
		Set<Integer>lotto =new TreeSet<Integer>();
		
		//Integer는 equals() hashCode() 오버라이딩 상태 
		
	
		while(lotto.size() < 6) {
			//lotto에 저장된 값이 6개 값이 미만이면 반복
			int random = (int) (Math.random() * 45 + 1); //1~45사이 난수 
			
			lotto.add(random); //
			//int 값이 자동으로 Integer로 포장 (AutoBoxing )되어 lotto에 추가
			
			System.out.println(random);
		}
		System.out.println("로또 번호 : "+ lotto);
	}	
}
