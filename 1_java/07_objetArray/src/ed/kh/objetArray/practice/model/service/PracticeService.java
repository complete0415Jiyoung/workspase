package ed.kh.objetArray.practice.model.service;

import java.util.Scanner;

import ed.kh.objetArray.practice.model.vo.Student;

public class PracticeService extends Student{

	public void start() {
		// 1) 최대 10명의 학생 정보를 기록할 수 있게 배열을 할당한다.
		Student [] std = new Student [10];
		// 2)while문을 사용하여 학생들의 정보를 계속 입력 받고
		// 한 명씩 추가 될 때마다 카운트함
		// 계속 추가할 것인지 물어보고, ‘y’이면 계속 객체 추가
		
		Scanner sc= new Scanner( System.in);
		int count =0;
		boolean flag = true;
		while(flag) {
			System.out.print("학년 : ");
	         int grade = sc.nextInt();
	         
	         System.out.print("반 : ");
	         int classroom = sc.nextInt();
	         
	         System.out.print("이름: ");
	         String name = sc.next();
	         
	         System.out.print("국어점수 : ");
	         int kor = sc.nextInt();
	         
	         System.out.print("영어점수 : ");
	         int eng = sc.nextInt();
	         
	         System.out.print("수학점수 : ");
	         int math = sc.nextInt();
	       
	         std [count] = new Student(grade, classroom, name ,kor ,eng ,math);
	         count++;
	         
	         while(true) {
	        	 System.out.print("계속 입력하시겠습니가? (y/n) :");
	        	 char input = sc.next().toUpperCase().charAt(0);
	        	 //.toUpperCase() 소문자를 대문자로 대문자로 소문자로 변환해 줌

	        	 // 3) 10명을 입력한 경우 모두 입력하거나, 계속 추가할 것인지 물어볼 때 ‘n’을 입력한 경우
	        	 // 학생 정보 입력을 멈춤
	        	 if( count == 10|| input =='N') {
	        		 flag = false;
	        		 break;
	        	 }
	         
	        	 // 4) 'y' 또는 'n'을 입력하지 않은 경우
	        	 // "잘못 입력하셨습니다. 다시 입력해 주세요" 출력 후
	        	 // 다시 계속 추가할지 여부를 물어봄.
	        	 if( input =='Y') {
	        		 break;
	        		 
	        	 }else { 
	        		 System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
	        	 }
	         
	        }
	        	 
	        }//while 끝
			for(int i=0; i < count; i++ ) {
				System.out.println(std[i]);
			}
			
		}
		
		// 5) 입력된 모든 학생들의 정보 + 평균 점수를 출력
		
		
		//================내가 한것====================
		/*Scanner sc = new Scanner(System.in);
		
		Student []stdArr = new Student[10];
		int count = 0; 
		
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int classroom = sc.nextInt();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		
	
		stdArr[0] = new Student(grade, classroom,name,
				kor,eng,math); //0번째 인덱스에 Student객체 참조 
		
		count = 1;
		boolean flag = true;	
		
		while(flag) {	
			
			System.out.print("계속 입력하시겠습니까?(y/n) : ");
			char input = sc.next().charAt(0);
				
			if(input == 'y' || input =='Y') {
				Student[] stdCopyArr =stdArr;	//얕은 복사
				for(int i=0; i < stdCopyArr.length; i++) {
					if(stdCopyArr[i] == null) {
						System.out.print("학년 : ");
						grade = sc.nextInt();
						System.out.print("반 : ");
						classroom = sc.nextInt();
						System.out.print("이름 : ");
						name = sc.next();
						System.out.print("국어점수 : ");
						kor = sc.nextInt();
						System.out.print("영어점수 : ");
						eng = sc.nextInt();
						System.out.print("수학점수 : ");
						math = sc.nextInt();
						stdCopyArr[i] = new Student(grade, classroom,name,
								kor,eng,math);
						count++;
						break;
					}else if(stdCopyArr[stdCopyArr.length-1]!= null) { //9번쨰 인덱스까지 입력했을 때 
						System.out.println(stdArr[i]toString());
						flag = false; 
					}
				} 
			}else if(input =='n'|| input =='N') {
		
				for(int i = 0 ; i < stdArr.length; i++) {
					
					if(stdArr[i] == null) {
						break;
					}else {
						System.out.println(stdArr[i].toString());
						flag = false; 
					}
				}
			}else {
				System.out.println("잘못 입력하셨습니다");
				continue;
			}
		}
	}*/
}



