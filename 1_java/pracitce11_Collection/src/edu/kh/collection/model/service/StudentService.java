package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Student;

public class StudentService {
	
	//필드 
	private Scanner sc = new Scanner(System.in);
	
	//학생 정보를 저장할 List(객체 배열 업그레드 버전)
	
	//java.util.List 인터페이스 :List에 반드시 필요한 필수기능을 모아둔 인터페이스 
	//인터 페이스는 참조 변수로만 사용 가능 
	
	//private List<Student> studentList = new ArrayList<Student>();
	//	-> 검색(조회)에 효율적 
	private List<Student> studentList = new LinkedList<Student>();
	//	-> 추가, 수정, 삭제에 효율적이다
	
	
	//********제네릭*******
	//제네릭 < > : 컬렉션에 저장되는 객체 타입을 한가지로 제한 
	// <Student>
	//Student로 저장되는 타입이 제한된 리스트 생성 
	// == Student만 저장 가능 == 모든게 Student 
	// == Student임을 검사할 필요가 없음
	
	public StudentService() {  //기본메서드 
		studentList.add(new Student("박서준", 25, "서울시 중구", 'M', 90)); 
		studentList.add(new Student("정해인", 22, "서울시 강남", 'M', 80)); 
		studentList.add(new Student("박보영", 27, "경기도 안산", 'F', 90)); 
		studentList.add(new Student("이지영", 27, "수원시", 'F', 100)); 
		studentList.add(new Student("박보검", 27, "서울시", 'M', 60)); 
	}
	
	
	public void ex() {
		//List 테스트 
		//List.add(Object e) : 리스트에 객체를 추가
		// * 매개 변수 타입이 Object == 모든 객체를 매개변수로 전달할 수 있음 
		// Object==초상위 부모가 참조 변수 
		// == 모든 클래스에서 생성한 자식 객체들은 다향성이 적용 되어 있는 상태 
		
		studentList.add(new Student()); //0번째 인덱스에 Student 객체
//		studentList.add(sc); //1번째 
//		studentList.add("문자열"); //2번째
//		studentList.add(new Object); //3번째
		
		//컬렉션의 특징 : 여러타입의 데이터를 저장할 수 있다 
		//단, 현재 클래스는 제네릭으로 <Student>객체만 저장 가능
		
		
		//Object List.get(index i) : 리스트에서 i번째 인덱스에 있는 객체(Object)를 반환한다 
		//반환형 Object == 모든 객체 반환할 수 있다.
		
		System.out.println(studentList.get(0).toString());
		
		//Student 이름 만 얻어오기 
		//Student 객체가 맞는지 확인하고 다운 캐스팅을 해야
		//Student 기능을 사용할 수 있다 
		if(studentList.get(0) instanceof Student) {
			System.out.println(((Student)studentList.get(0)).getName());
		}
		
		//길고 복잡 -> 컬렉션의 장점인 여러객체 저장이 코딩에 방해됨 
		//*****제네릭으로 <Student>한가지 객체만 저장하도록 만들어 검사를 필요없게 만들자!
		System.out.println(((Student)studentList.get(0)).getName());
		
	}
	
	public void displayMenu() {
		int meunNum = 0;
		
		do {
			System.out.println("\n ============학생관리프로그램=================");
			
			System.out.println("1. 학생 정보 추가 ");
			System.out.println("2. 학생 전체 조회 ");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			System.out.println("5. 이름으로 검색 (일치) ");
			System.out.println("6. 이름으로 검색 (포함)");
		
			System.out.println("0. 프로그램 종료 ");

			
			System.out.print("\n 메뉴 번호 선택 >> ");
			
			try {
				meunNum = sc.nextInt();
				System.out.println();//줄바꿈
				
				switch(meunNum) {
				case 1 : System.out.println(addStudent());break;
				case 2 : selectAll(); break;
				case 3 : System.out.println(updateStudent());break;
				case 4 : System.out.println(removeStudent());break;
				case 5 : searchName1(); break;
				case 6 : searchName2(); break;

				case 0 :  System.out.println("<프로그램 종료>"); break;
				default : System.out.println("메뉴에 작성된 번호만 입력해 주세요.");
				
				}
			}catch(InputMismatchException e) {
				System.out.println("\nerror : 입력 형식이 유효하지 않습니다. 다시 시작해주세요");
				sc.nextLine(); //입력버퍼에 남아 있는 문자 제거 
				
				meunNum =-1;
			}
				
		}while(meunNum != 0);
		
	}
	
	
	public String addStudent() throws InputMismatchException{
		
		System.out.println("============학생정보 추가==============");
	
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine(); //입력버퍼 개행 제거
		
		System.out.print("사는 곳 : ");
		String region = sc.nextLine();
		
		System.out.print("성별(M/f) : ");
		char gender = sc.next().toUpperCase().charAt(0);
		//String -> char
		
		System.out.print("점수 : ");
		int score = sc.nextInt();//InputMismatchException 발생할 수 있는 오류 

		//Student 객체 생성 후 List에 추가 
		if(studentList.add(new Student(name, age, region, gender, score))) {
			//boolean java.util.List.add(Student e)
			//.add() 반환형이 boolean
			return "성공";
		}else {
			return "실패";
		}
		
	}

	public void selectAll() {
		// List 는 인덱스가 있다 (0번 부터 시작) 
		// List에 저장된 데이터의 개수를 얻어오는 방법 : int List.size()
		// -> 배열명.length 대신 사용
		
		//List가 비어 있는지 확인하는 방법 :
		//boolean java.util.List.isEmpty() : 비어 있으면 true를 반환 
		
		System.out.println("===========학생 전체 조회==========");
		
		//studentList가 비어있는 경우 "학생 정보가 없습니다 " 출력
		if(studentList.isEmpty()) {
			System.out.println("학생 정보가 없습니다");
			
			return;
		}
		

		//향상된 for문 ( for each문 )
		//- 컬렉션, 배열의 모든 요소를 순차적으로 반복 접근할 수 있는 for문
		//( 순차적 : 0~마지막 요소까지 인데스를 1씩 증가)
		
		//[작성법]
		//for( 컬렉션 또는 배열에서 꺼낸  한개의 요소를 저장할 변수 : 컬렉션명 배열명 ){}
		
		int index = 0;
		for(Student std :studentList) {
			System.out.println(index + "번 : "+ std);
			
		}	
		
	}
	//학생정보 수정
	public String updateStudent() throws InputMismatchException{
		//studentList.set(int index, Student e)
		//		-> List의 i번째 요소를 전달 받은 e로 변경 
		//		-> 반환값 Student == 변경전 Student 객체가 담겨져 있음 
		
		System.out.println("===========학생정보수정=============");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		//1)학생정보가 StudentList에 있는가?
		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다";
			//2) 입력된 숫자가 0보다 작은가?(음수검사)
		}else if(index < 0){
			return "음수를 입력할 수 없습니다";
			
			//3) 만약 문자열을 입력한 경우  -> throws 예외처리
			//4) 입력 받은 숫자가 Student List범위 내 인덱스 번호인가? 
		}else if(index > studentList.size()) {
			return "범위를 넘어선 값은 입력할 수 없습니다";
		}else {
			//수정코드 작성 
			System.out.println(index + "번째 인덱스에 저장된 학생 정보");
			System.out.println(studentList.get(index));
			
			System.out.print("이름 : ");
	        String name = sc.next();
	         
	        System.out.print("나이 : ");
	        int age = sc.nextInt();
	        sc.nextLine(); // 입력 버퍼 개행 문자 제거
	         
	        System.out.print("사는곳 : ");
	        String region = sc.nextLine();
	         
	        System.out.print("성별(M/F) : ");
	        char gender = sc.next().charAt(0);
	                  // String -> char
	         
	        System.out.print("점수 : ");
	        int score = sc.nextInt();
	        
	      //입력 받은 index번째에 새로운 학생 정보 세팅 == 수정
	      //이때 index 번째에 있던 기존 핵생 정보 반환된다
	        Student temp = studentList.set(index, new Student(name, age, region, gender, score));
	        return temp.getName()+ "의 정보가 변경되었습니다.";
	        
		}
		

	}
	public String removeStudent() throws InputMismatchException{
		//studentList.remove(int index)
		//리스트에서 index번째 요소 제거 
		//이때 제거된 요소가 반환 된다. 
		
		// List는 중간에 비어 있는 인덱스가 없게 하기 위해서 
		//remove()동작 시 뒤쪽 요소를 한칸 씩 당겨온다 
		
		System.out.println("===========학생 정보 제거========");
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		//1)학생정보가 StudentList에 있는가?
		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다";
			//2) 입력된 숫자가 0보다 작은가?(음수검사)
		}else if(index < 0){
			return "음수를 입력할 수 없습니다";
			
			//3) 만약 문자열을 입력한 경우  -> throws 예외처리
			//4) 입력 받은 숫자가 Student List범위 내 인덱스 번호인가? 
		}else if(index > studentList.size()) {
			return "범위를 넘어선 값은 입력할 수 없습니다";
		}else {
			System.out.println("정말 제거하시겠습니가?(Y/N)");
	        char ch = sc.next().toUpperCase().charAt(0);
			
			if(ch =='Y') {
				Student temp = studentList.remove(index);
				return temp.getName()+ "의 정보가 제거되었습니다.";
				
			}else {
				return "취소";
			}
	  
		}	
	}
	
	public void searchName1() throws InputMismatchException{
		
		System.out.println("=========학생검색(일치)=========");
		
		System.out.print("검색할 이름 : ");
		String input = sc.next();
		
		boolean flag = true;
		for(Student std : studentList) {
			if( input.equals(std.getName())) {
				System.out.println(std);
				flag = false;
			}
		}
		if(flag) {
			System.out.println("검색 결과가 없습니다.");
		}
		
		
	}
	
	public void searchName2() throws InputMismatchException{
		//contains 포함 
		//boolean String. contains(문자열) : String에 문자열이 포함 되어 있으며 true로 반환 
		
		System.out.println("=========학생검색(문자열 포함)=========");
		
		System.out.print("이름에 포함되는 문자열 : ");
		String input = sc.next();
		
		for( Student std : studentList) {
			if(std.getName().contains(input)) {
				System.out.println(std);
				
			}else {
				System.out.println("검색 결과 없음");
			}
		}
		
	}
	
}
