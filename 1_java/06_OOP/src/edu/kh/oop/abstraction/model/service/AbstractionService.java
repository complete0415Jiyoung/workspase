package edu.kh.oop.abstraction.model.service;

import edu.kh.oop.abstraction.model.vo.People;

//Service : 특정기능을 제공하는 클래스 

public class AbstractionService {
	//해당 클래스가 객체가 되면 아래 가능을 수행 할 수 있다.
	
	public void ex1() {
		// 국민객체 만들기
		
		People p1 = new People();
		//People p1 : People 객체의 주소를 저장하여 참조하는 변수 p1 
		//new People () : 새로운 People객체를 Heap영역에 생성
		
		
		//***클래스 이름이 자료형 처럼 사용 되어짐!
		// == 클래스를 "사용자 정의 자료형"이라고 한다! ***
		
		
		
		People p2 = new People();
		
		//만들어진 객체는 추상화가 적용 되어있어서 누구인지 알수 없음
		// -> 속성 (데이터)를 추가 하여 누구인지 알 수 있게 함(구체화)
		
		
//		p1.name ="다나카"; //The field People.name is not visible
//		직접 접근 방법
		
		
		p1.setName("다나카");
		//p1.age = 27; 
		p1.setAge(27);
		
		//p1.gender ='남';
		p1.setGender('남');
		
		//p1.phone = "010-1234-1234";
		p1.setPhone("010-1234-1234");
		//p1.pNo ="002022-12345678";
		p1.setpNo("002022-12345678");
		
		//p1.address = "서울시 강남구 어쩌고 저쩌고";
		p1.setAddress("서울시 강남구 어쩌고 저쩌고");
		
		
		System.out.println("p1의 name : "+ p1.getName());
		System.out.println("p1의 age : "+ p1.getAge());
		System.out.println("p1의 gender : "+ p1.getGender());
		System.out.println("p1의 phone : "+ p1.getPhone());
		System.out.println("p1의 pNo : "+ p1.getpNo());
		System.out.println("p1의 address : " + p1.getAddress());

		
		
		System.out.println("===========================");
		
		
		
		p2.setName ("이지영");
		p2.setAge (27); 
		p2.setGender ('여');
		p2.setPhone ("010-6245-2031");
		p2.setpNo ("970415-2123456");
		p2.setAddress("집에 가고 싶어용 집집");
		
		
		System.out.println("p2의 name : "+ p2.getName());
		System.out.println("p2의 age : "+ p2.getAge());
		System.out.println("p2의 gender : "+ p2.getGender());
		System.out.println("p2의 phone : "+ p2.getPhone());
		System.out.println("p2의 pNo : "+ p2.getpNo());
		System.out.println("p2의 address : " + p2.getAddress());
	
		
		
		
		p1.tax();
		p1.vote();
		p2.tax();
		p2.vote();
	
	}

	
	
}
