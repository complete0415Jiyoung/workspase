package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {


	public void practice1(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 한개를 입력하세요 : ");
		int num = sc.nextInt();
		
		String result;
		
		if(num<=0) {
			result = "양수만 입력해 주세요";
		
		}else if (num%2==0){
			result = "짝수입니다";
			
		}else{
			result = "홀수입니다";
		}
		
		System.out.print(result);
	}
	
	public void practice2(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int korScore = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int engScore = sc.nextInt();
		
		System.out.print("수학점수 : ");
		int mathScore = sc.nextInt();

		int sum = korScore + engScore + mathScore;
		double average = sum/3;
	
		
		if(korScore>=40 && engScore >= 40 && mathScore >= 40) {
			if(sum >= 60) {
				System.out.println("국어 : " + korScore);
				System.out.println("영어 : " + engScore);
				System.out.println("수학 ; " + mathScore);
				System.out.println("합계: "  + sum);
				System.out.println("평균: "  + average);
				System.out.println("축하합니다, 합격입니다!");
				
			}else{
				System.out.print("불합격입니다");
			}
		}
	}
	
	public void practice3(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		int day;
		
		switch(month) {   
		
		case 1 : case 3 : case 5 : case 7 : case 8 : case 10: case 12 : day = 31  ;  
		System.out.print(month +"월은 "+ day + "일까지 있습니다");
		break;
		case 2 : day = 28 ;
		System.out.print(month +"월은 "+ day + "일까지 있습니다");
		break;
		case 4   : case 6  : case 9  : case 11 : day = 30 ; 
		System.out.print(month +"월은 "+ day + "일까지 있습니다");
		break;
		
		default   : System.out.print(month +"월은 잘못 입력된 달입니다");
	
		}
	}
	
	public void practice4(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키(m)를 입력해 주세요 : ");
		double heigth = sc.nextDouble();
		
		System.out.print("몸무계(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		double BMI = weight /(heigth * heigth);
		System.out.println("BMI 지수 : " + BMI );
		
		if(BMI<0 ||BMI > 30) {
			System.out.println("고도비만");
		}else if(BMI >= 25) {
			System.out.println("비만");
		}else if(BMI >= 23) {
			System.out.println("과체중");
		}else if(BMI >= 18.5) {
			System.out.println("정상체중");
		}else {
			System.out.println("저체중");
		}
	}
			
	public void practice5(){
			
		Scanner sc = new Scanner(System.in);
		
	
		System.out.print("중간고사점수 : ");
		double middleScore = sc.nextInt();
		
		System.out.print("기말고사점수 : ");
		double finnalScore = sc.nextInt();
		
		System.out.print("과제 점수 : ");
		double projetScore = sc.nextInt();
		
		System.out.print("출석 횟수 점수 : ");
		double attendScore = sc.nextInt();
		
		System.out.println("=============결과================");
		
		
		if( attendScore <= 20 * (1 - 0.3) ) {  //30% 이상 결석 <-> 70% 미만 출석
		System.out.println("[fail 출석 횟수 부족 ("+ (int) attendScore + ")/20]");
		
		} else { 
			middleScore *= 0.2;
			finnalScore *= 0.3;
			projetScore *= 0.3;
			attendScore *= 5 * 0.2;
			
			//합계
			double sum =middleScore + finnalScore + projetScore + attendScore;
		
			System.out.printf("중간고사 점수(20) : %.1f\n", middleScore);
			System.out.printf("기말고사 점수(30) : %.1f\n", finnalScore);
			System.out.printf("과제 점수   (30) : %.1f\n", projetScore);
			System.out.printf("출석 점수   (20) : %.1f\n", attendScore);
			System.out.printf("총점            : %.1f\n", sum);
			
			if(sum>= 70) {
				System.out.println("Pess");
			}else {
				System.out.println("Fail[점수미달]");
			}
		}
		
		
		
		
//		=====================내가 한것 수정 필요============================
//		if( attendScore >= 70 && total > 70) { 
//			
//			System.out.println("중간 고사 점수(20) : "+ middleScore * 0.2);
//			System.out.println("기말 고사 점수(30) :" + finnalScore * 0.3);
//			System.out.println("과제 점수    (30) :" + projetScore * 0.3);
//			System.out.println("출석 점수    (20) :" + attendScore * 20 * 0.2 );
//			System.out.println("총점 : "+ total);
//			System.out.println("pass");
//			
//			if( attendScore < 70 || attendScore*0.2 <30) {
//				System.out.println("Fail [출석 횟수 부족 ("+ attendScore+ "/ 20]");
//	
//			}else if(total < 70  ) {
//				
//				System.out.println("중간 고사 점수(20) : "+ middleScore * 0.2);
//				System.out.println("기말 고사 점수(30) :" + finnalScore * 0.3);
//				System.out.println("과제 점수    (30) :" + projetScore * 0.3);
//				System.out.println("출석 점수    (20) :" + attendScore * 20 * 0.2 );
//				System.out.println("총점 : "+ total);
//				System.out.println("Fail [점수미달]");	
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}