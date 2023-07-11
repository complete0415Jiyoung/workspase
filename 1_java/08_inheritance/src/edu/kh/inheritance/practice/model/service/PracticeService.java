package edu.kh.inheritance.practice.model.service;

import java.util.Scanner;

import edu.kh.inheritance.practice.model.vo.Employee;
import edu.kh.inheritance.practice.model.vo.Student;

public class PracticeService {
//	박보검 26 180.3 72.0 100000000 영업부
//	강동원 38 182.0 76.0 200000000 기획부
	
	public void homework() {
		
		Student[] stdArr = new Student[3]; 
		stdArr[0] = new Student("카리나",20, 168.2, 70.0, 1 ,"정보시스템공학과"); 
		stdArr[1] = new Student("정해인",21, 187.3, 80.0, 2 ,"경영학과"); 
		stdArr[2] = new Student("박서준",23, 179.0, 45.0, 4 ,"정보통신공학과");
		
		for(Student std : stdArr) {
			System.out.println(std);
		}
		
		// 최대 10명의 사원 정보를 기록할 수 있게 배열을 할당
		Employee[] empArr = new Employee[10]; 
		// 사원들의 정보를 키보드로 계속 입력 받고 --> while(true) 무한 반복문을 통해
		Scanner sc =new Scanner(System.in);
		int count=0;
		
		while (true) {
			
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("나이 : ");
			int age = sc.nextInt();
			System.out.print("신장 : ");
			double height = sc.nextDouble();
			System.out.print("몸무게 : ");
			double weight = sc.nextDouble();
			System.out.print("급여 : ");
			int salary = sc.nextInt();
			System.out.print("부서 : ");
			String dept = sc.next();
			
			
			empArr[count] = new Employee(name, age, height,weight,salary,dept );
			count++;
			// 계속 추가할 것인지 물어보고, 대소문자 상관없이 ‘y’이면 계속 객체 추가
			// 한 명씩 추가 될 때마다 카운트함
			// 2명 정도의 사원 정보를 입력 받아 객체 배열에 저장
			System.out.print("계속 입력하시겠습니까? (y/n) : ");
			char input= sc.next().toUpperCase().charAt(0);
			
			if(input == 'Y') {
				continue;
				
			}else{
				break;
				}
			}
		
		// 현재 기록된 사원들의 정보를 모두 출력
			for(int i = 0; i < count; i++) {
				System.out.println(empArr[i]);
		}
	}
}


