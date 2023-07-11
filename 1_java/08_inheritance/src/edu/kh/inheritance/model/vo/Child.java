package edu.kh.inheritance.model.vo;

public class Child extends Parent{ //자식 클래스
					//Parent상속중
	//The type Child cannot subclass the final class Parent
	//(final 클래스인 Parent는 Child클래스를 자식으로 오버라이딩 할 수 없다.) 
	
	@Override
	public void method() {
		System.out.println("오버라이딩 성공");
	
		//Cannot override the final method from Parent
	}
}
