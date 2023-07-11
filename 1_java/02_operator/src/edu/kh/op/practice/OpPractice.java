package edu.kh.op.practice;

import java.util.Scanner;

public class OpPractice {
	
	public void practice1(){
		
		Scanner sc = new Scanner(System.in);
		
		int personNum; //290
		int candyNum;  //100
		
		System.out.print("인원 수 : ");
		personNum = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		candyNum = sc.nextInt();
		
		System.out.println();
		
		int result1 = personNum /= candyNum;
		int result2 = candyNum %=  personNum; 
	
		System.out.println("1인당 사탕 개수 : " + result1); //2
		System.out.println("남는 사탕 개수 : " +  result2); //13
		
	}
	
	
	public void practice2(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");  //홍길동
        String name = sc.nextLine();
        
        System.out.print("학년(정수): ");  //3
        int grade = sc.nextInt();
        
        System.out.print("반(정수): ");   //4
        int classNum = sc.nextInt();
        
        System.out.print("번호(정수): ");  //15  
        int studentNumber = sc.nextInt();
       
        sc.nextLine();     // 입력버퍼 비우기
        
        System.out.print("성별 (남학생/ 여학생): "); //남학생
        String gender = sc.nextLine();
        
        System.out.print("성적(소수점 아래 둘째 자리까지): ");  //85.75
        double score = sc.nextDouble();
        
        System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다.\n",grade,classNum,studentNumber,name,gender,score);
        
	}
	
	
	public void practice3(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
		System.out.println((num % 2 == 0)? "짝수입니다" : "홀수입니다");
	
	}
	
	
	public void practice4(){
		
		 Scanner sc = new Scanner(System.in);
		
		 
		 System.out.print("국어 : ");  //60
		 int korScore = sc.nextInt();
		 
		 System.out.print("영어 : ");  //80
		 int engScore = sc. nextInt(); 
		 
		 System.out.print("수학 : ");  //40
		 int mathScore = sc. nextInt(); 
		 
		 System.out.println();
		 
		 int sum = korScore+ engScore+mathScore;
		 System.out.println("합계 :"+ sum);  //180
		 
		 
		 double average = sum/3.0;
		 System.out.println("평균 : "+ average);  //60.0
		 
		 System.out.println(korScore >= 40 && engScore >= 40 && mathScore >= 40 && average >= 60 ? "합격" : "불합격");
		 
	}

}
