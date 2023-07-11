package edu.kh.inheritance.model.service;

import java.util.Scanner;

import edu.kh.inheritance.model.vo.Employee;
import edu.kh.inheritance.model.vo.Person;
import edu.kh.inheritance.model.vo.Student;

public class InhearitanceService {
	
	
	public void ex1() {
		//상속확인 
		//person을 상속 받은 Student가 person의 필드,메소드를 사용할 수 있는가

		Person p =new Person();
		 
		//p.name ="홍길동"; //private 때문에 직접접근 불가 
		 
		//홍길동 ,25 대한민국
		p.setName("홍길동");
		p.setAge(25);
		p.setNationality("대한민국");	
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getNationality());
		 
		System.out.println("-------------------------");
		 
		//Student객체 생성
		Student std =new Student();
		 
		//Student 만의 고유한 메소드
		std.setGrade(3);
		std.setClassroom(5);
		 
		System.out.println(std.getGrade());
		System.out.println(std.getClassroom());

		//Person으로 부터 상속받은 메소드 
		std.setName("고아라");
		std.setAge(19);
		std.setNationality("대한민국");
		 
		 
		//Student가 Person에 메소드 뿐만 아니라 필드도 상속 받았는지 확인 
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
		 
		 
		System.out.println("------------------------");
		  
		Employee emp = new Employee();
		 
		emp.setCompany("KH정보교육원");

		emp.setName("다나카");
		emp.setAge(35);
		emp.setNationality("일본");
		
		System.out.println(emp.getCompany());
		System.out.println(emp.getName());
		System.out.println(emp.getAge());
		System.out.println(emp.getNationality());
	
		System.out.println("-------------------------");
		
		//추가된 breath()메소드 확인 
		p.breath();
		std.breath();
		emp.breath();
	}

	
	
	public void ex2() {
		//super() 생성자 사용방법
		
		//Student매개변수 5개짜리 생성자 
		Student std1 = new Student("이지영",27,"대한민국",1,3);
		
		System.out.println(std1.getName());
		System.out.println(std1.getAge());
		System.out.println(std1.getNationality());
		System.out.println(std1.getGrade());
		System.out.println(std1.getClassroom());
		
	}
	
	public void ex3() {
		//오버라이딩 확인 예제
		
		Student std = new Student();
		Employee emp = new Employee();
	
		std.move(); // 오버라이딩 X  -> Person 메소드 수행
		emp.move(); // 오버라이딩 o  -> Employee 메소드 수행 
	
	}
	
	public void ex4() {
		
		// 모든 클래스는 Object클래스의 후손이다 
		// == 모든 클래스의 최상의 부모는 Object 
		
		// 1) Object 상속여부확인
		Person p = new Person(); //Object를 상속 받은 Person객체 생성 
		
		Student std = new Student(); //Person을 상속 받은 Student 객체 생성		
		//Object -> Person -> Student 
	
		Scanner sc = new Scanner(System.in);
		
		String str ="abc";
		
		
		//*** Object 상속과 단계적인 상속 확인
		System.out.println(p.hashCode()); //Object에서 물려 받은 hashCode()
		
		System.out.println(std.getAge()); //Person에서 물려 받은 getAge()
		
		System.out.println(std.hashCode()); //Person이 Object에서 물려 받은 hashCode를 
		//Student가 물려 받아서 사용
		
		//상속의 상속의 상속의 .....상속 가능
		
		
		//*Object 가 모든 클래스의 최상의 부모인지 확인 
		System.out.println(sc.hashCode());
		//Object의 상속을 받은 hashCode()
		System.out.println(str.hashCode());
		//String -> hashCode()
		// -> String이 Object에게 물려 받은 hashCode을 오버라이딩 함 
		
	}
	
	public void ex5() {
		
		Person p = new Person("박보검", 28, "한국");
		
		System.out.println(p.toString()); //박보검 / 28 / 한국 
		System.out.println(p); //박보검 / 28 / 한국 
		
		
		//print 구문 수행시 참조변수명을 작성하면 
		//자동으로 to.String() 메소드 출력
		System.out.println("----------------------------");
		
		Student std = new Student("윈터", 27, "미국", 2,6);
		
		//1) Student 클래스 toString()오버라이딩 전 
		//Person으로 부터 상속받은 오버라이딩 된 toString()을 수행
		System.out.println(std.toString()); 
		
		//2) Student 클래스 toString 오버라이딩 후 
		
		System.out.println(std);
		
		Employee emp = new Employee("김근로",26, "한국", "oo증권");
		System.out.println(emp);
		
		
	}
}



