package edu.kh.poly.ex2.run;

import edu.kh.poly.ex2.model.service.AbstractService;
import edu.kh.poly.ex2.model.service.Calculator;
import edu.kh.poly.ex2.model.service.JHSCalculator;
import edu.kh.poly.ex2.model.service.LJYCalculator;

public class AbstractRun {

	public static void main(String[] args) {

		
		AbstractService service = new AbstractService();
		
		//service.ex1();
		//service.ex2();
		
		// Calculator 임폴트
		// import edu.kh.poly.ex2.model.service.Calculator;
		      
		// 각자 만든 xxxCalculator 임폴트
		// import edu.kh.poly.ex2.model.service.JHSCalculator;
		//Calculator cal = new LJYCalculator();
		//Calculator cal = new LJYCalculator();
		Calculator cal = new JHSCalculator();  
		
		//인터페이스 == 미완성 설계도 == 객체 생성이 불가능
		// -> 추상 클래스 처럼 참조 변수로 사용이 가능 
		
		//코드의 큰 수정 없이
		//객체 생성 코드만 바꾸면 새로운 클래스 코드를 수행할 수 있다
		
		      
		System.out.println("합 : " + cal.plus(20, 15));
		System.out.println("차 : " + cal.minus(20, 15));
		System.out.println("곱 : " + cal.multiple(20, 15));
		System.out.println("몫 : " + cal.divide(20, 15));
		
		
		//인터페이스의 특징 
		//1) 인터페이스를 부모 참조 변수로 사용하면
		//	 다향성의 업캐스팅이 적용 되서 
		//	 상속 받은 모든 클래스를 자식 객체로 참조할 수 있다
		
		//	->이를 이용하여 중요한 메인 코드의 수정을 최소화한다
		//	ex) Run에 작성된 합, 차, 곱, 몫을 출력하는 코드의 수정없이 
		//		객체 생성 코드 한줄만 수정하여 다르게 작성된 기능을 수행할 수 있다
		
		//2) 자식 클래스에 공통된 매소드 구현을 강제하기 때문에 
		//	 모든 자식 클래스가 동일한 형태를 띄게 된다.
		//	-> 이를 이용하여 공동작업(팀 프로젝트)에 필요한
		//		개발 환경을 조성할 수 있다. 
		
		//
		
	}

}
