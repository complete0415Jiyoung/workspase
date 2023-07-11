package edu.kh.inheritance.model.vo;

public class Person extends Object{
	//클래스 명에 상속 구문이 없다면 컴파파일러가 자동으로 extends Object 구문을 추가 
	
	//필드
	private String name;
	private int age;
	private String nationality;
	
	//기본생성자
	public Person() {}	
	
	//매개변수 생성자
	public Person(String name,int age,String nationality) {	
		
		this.name =name;
		this.age =age;
		this.nationality =nationality;
	}
	
	//메소드
	//getter / setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	//상속의 특징 - 코드 추가 및 수정이 용이 
	//(세로운 메소드를 Person에 추가 하여 Student와 Employee가 사용 가능한지 확인) 
	public void breath() {
		System.out.println("사람은 코나 입으로 숨을 쉰다");
	}
	
	public void move() {
		System.out.println("사람은 움직일수 있다");
	}
	
	//Object.toString() 메소드 오버라이딩 Overriding
	//to.String ()는 객체가 가지고 있는 모든 값(필드)을 
	//- 하나의 문자열로 반환 하는 용도의 메소드
	
	@Override
	public String toString() {
		return name + " / " +age + " / " + nationality;
		//박보검 / 28 / 한국 
	
	}
}
