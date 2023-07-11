package edu.kh.poly.ex2.model.vo;

public class Fish extends Animal{
	
	
	//생성자 
	//-> 생성자 미 작성시 컴파일러가 자동으로 기본생성자를 추가해준다 
	public Fish() {
		super();
	}
	
	public Fish(String type , String eatType) {
		super(type, eatType);
	}
	
	//추상 메소드는 상속 받으면 오버라이딩이 강제
	@Override
	public void eat() {
		System.out.println("입을 뻐끔 거리면서 먹는다");
	}

	@Override
	public void breath() {
		System.out.println("아가미 호흡을 한다");		
	}
	
	 
	//toString 
	@Override
	public String toString() {
		return "Fish : " + super.toString(); 
	}
	

}
