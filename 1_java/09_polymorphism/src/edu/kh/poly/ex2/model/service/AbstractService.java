package edu.kh.poly.ex2.model.service;

import edu.kh.poly.ex2.model.vo.Animal;
import edu.kh.poly.ex2.model.vo.Fish;
import edu.kh.poly.ex2.model.vo.Person;

public class AbstractService  {

	public void ex1() {
		
		//추상 클래스는 객체로 만들 수 있을까? (x)
		
		//Animal a1 = new Animal();
		//Cannot instantiate the type Animal(객체화 할 수 없다)
		
		//클래스 : 객체의 속성과 기능을 정의한것 (일종의 설계도)
		//추상 클래스 : 미완성 매소드를 포함한 클래스 (미완성 설계도)
		//-> 미완성 설계도로는 객체를 만들수 없다!!!-> 오류 발생
		
		//해결 방법 : Animal을 상속 받아서 미완성된 부분을 구현하는 클래스를 이용해 객체 생성
		
		//*추상 클래스를 상속 받은 자식 객체 생성하기 
		Person p1 = new Person();
		
		p1.setName("공유");
		
		//상속 받은 기능 호출
		p1.setType("척추동물");
		p1.setEatType("잡식");
		
		
		//오버라이딩한 메소드 호출 
		p1.eat();
		p1.breath();
		
		Fish f1 =new Fish();
		
		f1.eat();
		f1.breath();
		
	}
	
	public void ex2() {
		
		// * 추상 클래스와 다향성 + 바인딩 
		
		//추상 클래스는 객체로 만들수 없다 
		//---> 하지만 "참조변수"로는 사용할 수 있다!!!!
		
		//ex) 동물 -> 사람? 물고기?
		// Animal a1 =new Animal();(x)
		//사람 -> 동물?					/ 물고기 -> 동물? 
		//Animal a1 = new Person; 		/ Animal a2 = new fish(); 	(o)
		
		Animal[] arr= new Animal[2];
		//Animal 참조변수 배열 선언 및 할당
		
		arr[0] = new Person ("사람", "잡식", "김사랑");
		//Animal  부모 = Person 자식 (다향성중 업캐스팅)
		arr[1] = new Fish ("물고기", "잡식");
		//Animal 부모 = Fish 자식 (다향성중 업캐스팅)
		
		//바인딩 확인
		for(int i=0 ; i < arr.length ; i++) {
			//arr[i] == Animal 참조변수 
			arr[i].eat();
			arr[i].breath();
			System.out.println(arr[i]);
			//void edu.kh.poly.ex2.model.vo.Animal.eat() - 정적 바인딩 
			//프로그램 실행시 
			//참조하고 있는 자식 객체의 오버라이딩 된 eat()메소드 실행 
			// -> 동적 바인딩
			//(부모 타입 참조변수로 메소드를 호출하지만 
			//자식 타입의 오버라이딩된 메소드 수행)
			
			//******************무조건 암기******************
			//업캐스팅 상태(부모 참조 = 자식객체)에서
			//부모 메소드 호출시, 오버라이딩 된 자식 메소드 수행
			//*********************************************
			System.out.println("===================");
		}
		
		
	}
}
