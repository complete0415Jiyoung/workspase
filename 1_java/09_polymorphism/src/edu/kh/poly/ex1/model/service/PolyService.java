package edu.kh.poly.ex1.model.service;

import edu.kh.poly.ex1.model.vo.Car;
import edu.kh.poly.ex1.model.vo.Spark;
import edu.kh.poly.ex1.model.vo.Tesla;

public class PolyService {
	
	public void ex1() {
		//다향성 확인 예제 
		
		//car 객체 생성
		Car car = new Car();
		//부모 타입 참조 변수 Car로 부모객체 참조
		
		//Tesla 객체 생성
		Tesla tesla= new Tesla();
		//자식타입 참조변수 = 자식 객체
		
		
		////*******************다향성(업캐스팅)*********
		Car car2 = new Tesla(); //-> 오류 발생 안함 
		//Tesla객체를 참조하는 객체을 참조하는 변수의 타입이 Car(부모) 이기 때문에 
		//Tesla객체가 Car(부모) 개체로 변화함
		
		
		Car car3 = new Spark();
		//부모타입 참조변수 = 자식객체
		//다향성 업캐스팅 
		
		//*******다향성 업캐스팅 작성법******
		
		//1) 자식 객체가 부모 객체로 변하였기 때문에 
		// 자식 만의 고유한 필드, 메소드를 사용할 수 없다 
		
		//1-1) car (부모= 부모) 
		car.setEngine("v6 6기통 엔진");
		car.setFuel("휘발유");
		car.setWheel(4);
		//car 메소드 활용 가능 
		
		//1-2) tesla( 자식= 자식)
		
		tesla.setEngine("전기모터");
		tesla.setFuel("전기");
		tesla.setWheel(4);
		tesla.setBetterCapacity(1000000);
		
		
		//1-3 ) car2 (부모 = 자식 (Tesla)
		car2.setEngine("전기모터");
		car2.setFuel("전기");
		car2.setWheel(4);
		//car2.setBetterCapacity(1000000); //오류발생
		//The method setBetterCapacity(int) is undefined for the type Car
		
		//1-4) car3 (부모 = 자식 Spark))
		car3.setEngine("경차엔진");
		car3.setFuel("휘발유");
		car3.setWheel(4);
		//car3.setDiscountOff(0.5);  //오류발생
		//The method setDiscountOff(double) is undefined for the type Car
		
		//----------------------------------------------
		
		
		
		//2) 다향성을 이용한 객체배열
		//객체배열 : 같은 자료형의 객체를 하나의 묶음으로 다루는 것
		//+ 다향성 적용 -> 부모타입자료형의 참조변수릏 하나의 묶음으로 다루는것 
		
		Car[]arr = new Car[3];//부모 타맂 참조변수 배열 선언 및 할당
							//각 배열요소가 Car타입 참조변수
		
		arr[0] = car; //Car주소 == Car객체가 
		// Car 참조변수 
		arr[1] = car2; //Tesla 주소 ==Tesla 객체
		//Car 참조변수 
		arr[2] = car3; //Spark 주소 == Spark객체
		//Car 참조변수 
		
		//상속 + 다향성 
		//상속의 특징 : 일렬이 클래스에 대한 공통적인 규약을 정의
		//			-> Car상속 클래스는 모두 getEngin()객체를 참조
		
		//다향성 업캐스팅 : 부모타입 참조변수 arr[i]로 자식 객체 참조 
		
		for (int i = 0 ; i <arr.length; i++) {
			System.out.println(i +"번째 인덱스에 엔진 : "+ arr[i].getEngine());
		}
		
	}
	public void ex2() {
		//3) 다향성 업캐스팅을을 이용한 매개변수 사용법
		Tesla t = new Tesla("전기모터", "전기",4 ,10000000);
		Spark s = new Spark("경차엔진", "휘발유",4 ,0.5);
		Car c = new Car("경유엔진", "경유",12);

		printCar(t);
		printCar(s);
		printCar(c);
		
		System.out.println("==========================================");

		//4) 다향성을 이용한 반환형 사용법
		
		//Car[] arr = { new Car(), new Tesla(), new Spark()};
		
		Car[] arr = {createCar(1), createCar(2), createCar(3)};
						//car		//car	    //car
						//car		//(Tesla)	 //(Spark)
		
		//arr[0]; //Car 
		//arr[1]; //Tesla 
		//arr[2]; //Spark 
		
		//instenceof 연산자: 객체의 자료형을 검사하는 연산자
		// -> 참조하는 객체의 특정 자료형이거나 부모 쪽 상속 관계인지 확인
		
		//arr[1]이참조하는 객체가 Tesla이면 T, 아니면 F
		System.out.println(arr[1] instanceof Tesla); //true
		//arr[1]이참조하는 객체가 Spark이면 T, 아니면 F
		System.out.println(arr[1] instanceof Spark); //false
		//arr[1]이참조하는 객체가 Car이면 T, 아니면 F
		System.out.println(arr[1] instanceof Car); //ture 
		
		System.out.println("-----------------------------------");
	
		for(int i =0 ; i < arr.length ; i++) {
			if( arr[i] instanceof Tesla) {
				System.out.println("Tesla객체입니다");
			}else if( arr[i] instanceof Spark) {
				System.out.println("Spark객체입니다");
			}else{
				System.out.println("Car객체입니다");
			}
		}
	
	}
	
	//전달 받은 Car또는 자식 객체의 엔진 , 연료 , 바퀴를 출력하는 메소드
	//메개변수의 부모타입 참조변수를 작성하면 모든 자식 객체를 전달 받을 수 있다
	public void printCar(Car temp) { 
		//매개변수에 작성된 참조형 변수에는 주소가 저장된다 (얕은 복사)
		//메서드 내부 변수 + 매개변수  ==지역변수( Local Variable)
	
		 System.out.println("엔진 : "+temp.getEngine());
		 System.out.println("연료 : "+temp.getFuel());
		 System.out.println("바퀴 개수: "+temp.getWheel()+"개");
		 System.out.println();
	}
	
	//전달받은 매개변수에 따라서 Car또는 자식 객체를 생성하고
	// 생성된 객체를 반환 
	public Car createCar(int num) {
		Car result = null ;
		//null ==아무것도 참조하기 않음 
		
		switch (num){
		case 1 : result = new Car() ; break; 
		case 2 : result = new Tesla() ; break; 
		case 3 : result = new Spark() ; break; 
		}
		
		//반환형이 Car이지만 
		//case가 2,3번이면 Car 자식 객체의 주소가 반환된다
		return result;
	}
	
	public void ex3() {
		
		//*********다향성 중 다운캐스팅*************
		//다운캐스팅이란?
		//부모 타입 참조변수가 자식 객체를 참조하는 
		//업캐스팅 상태에서만 진행할 수 있는 기술
		
		//부모타입을 자식타입으로 "강제형변환"해서
		//자식 객체의 본래 필드, 메소드를 사용 가능하게 한다
		
		Car c1 = new Tesla("전기모터", "전기", 4 , 50000);
		
		System.out.println(((Tesla)c1).getBetterCapacity());
		//주의!!! "." 연산자가 
		//		 (Tesla) 형변환 연산자 보다 우선 순위가 높음
		
		
		//<효율적인 다운캐스팅 방법> 
		// - 얕은 복사를 이용
		Tesla t1 = (Tesla)c1;
		System.out.println(t1.getBetterCapacity());
		
		
	}
	
	public void ex4() {
		
		//!!!!다운캐스팅 주의사항!!!!!
		Car c1 = new Tesla();
		
		//Spark s1 = (Spark)c1; //다운 캐스팅 
		
		//java.lang.ClassCastException (형변환 예외) 
		//-> c1이 참조하는 객체 Tesla인데 
		//	 Spark참조변수로 Tesla를 참조하려고 해서 문제 발생
		
		
		//@@@해결방법 : instanceof와 같이 사용!@@@
		if(c1 instanceof Spark) {
			Spark s1 = (Spark) c1;  //다운캐스팅 
			System.out.println("성공");
			
		}else {
			System.out.println("실패(스타크타입아님)");
		}
	}
	
	public void ex5() {
		//바인딩(Binding)
		//실제 실행하는 코드와 호출하는 코드를 연결시키는 것 
		Car c1 = new Car("경유엔진", "경유", 8);
		
		System.out.println(c1.getEngine());
		//Car객체에 있는 getEngine() 메소드 호출  == 바인딩
		
		
		// 프로그램 "실행 전"
		// - 컴파일러는 getEngin()메소드가 Car에 있는 걸로 인식 해서 
		//		c1,getEngin() 호출 코드와 
		//		String edu.kh.poly.ex1.model.vo.Car.getEngine() 메소드 코드를 연결
		//  --> [정적바인딩]		
	
		System.out.println(c1.toString());
		//String edu.kh.poly.ex1.model.vo.Car.toString()
		//Car 참조변수 c1을 이용해서 
		//Car 객체에 있는 오버라이딩 된 toString() 메소드를 호출 
		
		
		//**다향성 적용시 바인딩***
		Car c2 = new Spark("경차엔진 ", "휘발유", 4, 0.5);
		//업캐스팅 적용 -> 부모 부분만 참조 가능한 상태 
		
		System.out.println(c2.toString());
		//String edu.kh.poly.ex1.model.vo.Car.toString()
		//참조변수 c2가 Car타입이므로 
		//toString ()도 Car의 toString ()을 호출 - 정적 바인딩
		
		// 하지만 실행해 보면 자식(Spark)의 toString이 호출 되는 것을 확인 가능!
		//-> 컴파일 시에는 부모(Car) 와 바인딩 == [정적 바인딩]
		// -"실행 시"에는 자식(Spark)의 오버라이딩된 메소드와 바인딩 == [동적바인딩]
	
	//**동적바인딩 활용 방법***
		Car [] arr = {
				new Car("경유엔진", "경유", 12),
				new Tesla("전기모터", "전기", 4,50000),
				new Spark("경차엔진", "무연", 4, 0.3)
				};
		//arr 배열 요소가 참조하는 모든 객체의 필드값 출력

		for(int i =0 ; i < arr.length; i++) {

			System.out.println(i+"번째 요소 :"+ arr[i].toString());
			//실행전 String edu.kh.poly.ex1.model.vo.Car.toString() - 정적바인딩
			//실행후 : 각 객체에 오버라이딩된 toString()이 호출됨 - 동적바인딩 
		}
		
		//** 동적 바인딩 장접**
		//- 업캐스팅된 참조변수를 
		//	별도의 다운 캐스팅 없이 
		//	자식의 오버라이딩된 메소드를 수행할 수 있다.
	
	}
}
