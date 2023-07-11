package edu.kh.poly.ex2.model.vo;

public abstract class Animal {
	
	//추상클래스 (abstract class)
	//1. 미완선 메소드 (추상클래스)을 보유하고 있는 메소드 

	//(추상 메소드는 없지만) 객체로 만들면 안되는 클래스 
	
	//필드 
	private String type; //종/과 구분
	private String eatType; // 식성 (초식, 육식, 잡식)
	
	
	//생성자
	// - 추상클래스 new연사자을 이용해서 직접적인 객체 생성 불가능 하지만 
	//	 상속받은 객체 생성지 부모 부분이 생성된다
	//	 == super() 생성자
	
	public Animal() {
		super(); //생략시 컴파일러가 추가 
	} //기본생성자

	public Animal(String type, String eatType) {  //메개변수 생성자(오버로딩 적용)
		super();
		this.type = type;
		this.eatType = eatType;
	}
	
	
	//메소드
	//getter / setter
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEatType() {
		return eatType;
	}
	public void setEatType(String eatType) {
		this.eatType = eatType;
	}

	//toString() 오버라이딩
	@Override // 오버라이딩 되었음을 컴퍼일러에게 알려주는 어노테이션
	public String toString() {
		return type + " / "+ eatType; 
	}
	
	
	//동물의 공통점 추출
	//-> 공통적으로 먹고 숨쉬지만 어떤 동물이냐에 따라 방법이 다르다
	// --> 그럼 어떡할까?
	//	미완성 상태로 두어 상속 받은 자식이 해당 메소드를 정의 하도록 
	//	오버라이딩을 강제화 시킴 --> 추상 (abstract)메소드로 작성
	
	//먹다 
	public abstract void eat();
	
	//숨쉬다
	public abstract void breath();
	
}
