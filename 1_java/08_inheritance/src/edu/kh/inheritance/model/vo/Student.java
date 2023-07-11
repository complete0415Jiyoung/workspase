package edu.kh.inheritance.model.vo;

public class Student extends Person {
	// Student class에 Person클래스 내용을 연장한다 
	// == Student 클래스에 Person클래스 내용(필드, 메소드)을 추가하여 확장한다
	
	//***상속***
	//extends :확장하다 연장하다+
	
	//필드 
	private int grade;
	private int classroom;
	
	
	//기본생성자
	public Student () {
		//Student()객체 생성시 
		//내부에 상속 받은 Person 객체를 생성 받기 위한 
		//Person 생성자 호출코드가 필요하다!
		
		//super: 상위 <-> sub하위
		//super == person
		
		super(); //super()생성자 
		//부모의 생성자를 호출하는 코드 
		//반드시 자식 생성자 최상단에 작성되어야한다!!
		
		//*super()생성자 때문에 
		//자식객체 내부에 부모 객체가 생성 된다
		
		//*super()생성자 미작성시 
		//컴파일러가 컴파일 단계에서 자동으로 추가해줌 
	}
	
	//매개변수생성자
	public Student (String name,int age,String nationality,
			int grade,int classroom) {
		//전달 받은 값중 name,age, nationality
		//부모필드에 세팅 
		
		//this.name = name;  //(x)
		//상속 받은 부모의 필드(name)를
		//자식의 필드처럼 사용하려고 하니 안보임 
		
		//왜?부모의 필드에 
		//private 접근제한자가 있어서 
		//아무리 부모 자식이라도 다른 객체이기 때문에 직접 접근 불가 
		//-> 간접접근 방법사용
		
		//setName(name);
		//setAge(age);
		//setNationality(nationality);
		//부모의 setter을 이용하면 되지만 비효율적
		
		super(name, age, nationality);  //부모 매개변수 생성자 호출
		
		this.grade = grade; 
		this.classroom = classroom;
	}
	
	//메소드
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassroom() {
		return classroom;
	}
	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}


	//toString ()오버라이딩
	@Override
	public String toString() {
		return  super.toString() +" / "+ grade + " / " + classroom;
	}
	
}
