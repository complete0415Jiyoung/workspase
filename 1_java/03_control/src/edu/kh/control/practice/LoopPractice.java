package edu.kh.control.practice;

import java.util.Scanner;

import javax.print.attribute.SetOfIntegerSyntax;

public class LoopPractice {

	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
			if ( input == 0) { 
				System.out.println("1 이상의 숫자를 입력하세요");
				
			}else {
				for(int i = 1; i <= input; i++ ) {
					System.out.print(i + " ");
			}
		}
	}
	
	public void practice2() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println(" 1이상의 숫자를 입력하세요 :");
		int input = sc.nextInt();
		
		if ( input == 0) { 
			System.out.print("1 이상의 숫자를 입력하세요");
			
		}else {
			for(int i = 1; i <= input && i>=1 ; input-- ) {
				System.out.print(input + " ");
			}
		}
	}

	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력하세요 :");
		int input = sc.nextInt();
		
		int sum = 0 ;
		
		for(int i = 1; i <= input ; i++ ) {
			sum += i;
			if (i == input) {
				System.out.print( i + " " + "=" + " " );
			}else {
				System.out.print( i + " " + "+" + " " );
			}
		} 
		System.out.println(sum);
	}

	public void practice4() {

		Scanner sc= new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 :");
		int input1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 :");
		int input2 = sc.nextInt();
		
		if ( input1 < 1 || input2 < 1) { 
			System.out.print("1 이상의 숫자를 입력하세요");
			
		}else if(input1 > input2) {
			for (int i = input2 ; i<= input1 ; i++){
	            System.out.print(i + " ");
			}
		}else{
	    	for(int i = input1 ; i <= input2; i++){
	            System.out.print(i + " ");
			}	
	    }
		
//		Scanner sc = new Scanner(System.in);
//        
//	      System.out.print("첫 번째 숫자 : ");
//	      int num1 = sc.nextInt();
//	         
//	      System.out.print("두 번째 숫자 : ");
//	      int num2 = sc.nextInt();
//	         
//	      if(num1 < 1 || num2 < 1) {
//	         System.out.println("1 이상의 숫자를 입력해주세요.");
//	        
//	      } else if(num1 < num2) {
//	         for(int i = num1; i<= num2; i++ ) {
//	            System.out.print(i + " ");
//	         }
//	      }else {
//	         for(int i = num2; i<= num1; i++ ) {
//	            System.out.print(i + " ");
//	         }
//	      }
		
	}
	
	public void practice5() {
		//사용자로 부터 입력 받은 숫자의 단을 출력하세요 
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		
		System.out.println("====="+ input + "단=====");
		
		for(int dan = 0 ; dan <= input ; dan++) {
			 if( input == dan) {
				 for (int i =1 ; i <= 9 ; i++) {
					System.out.printf("%d x %d = %d", dan, i, dan *i);
					System.out.println();
				
				}
			}
		}
	}

	public void practice6() {
		//사용자로 부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
		//단, 2~9를 사이가 아닌 수를 입력하면 "2~9 사이 숫자만 입력해 주세요"를 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int input = sc.nextInt();
	
		if(input >= 2 && input <= 9 ) {
			for ( int dan = input ; dan <= 9 ; dan++ ){
				System.out.println("======"+dan+"단======");
				
				for(int time = 2 ; time <= 9; time++ ) {
					System.out.printf("%d x %d =%d\n", dan, time, dan * time );
				}
			}	
		}else {
			System.out.println("2~9사이의 숫자만 입력해주세요");
			
		}
	}
	
	public void practice7() {
		//다음과 같은 실행 예제를 구현하세요
		
		// ex)
		//정수 입력 : 4
		//*
		//**
		//***
		//****
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int x = 1 ; x <= input ; x++) {
			for(int star = 1 ; star <= x; star++) {
				System.out.print("*");
			}
			System.out.println();}
	}
	
	public void practice8() {
		
		////다음과 같은 실행 예제를 구현하세요
		
		// ex)
		//정수 입력 : 4
		//****
		//***
		//**
		//*
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
	
		for(int x = input ; x >= 1 ; x--) {	
			for(int star = x; star >= 1 ; star--) {
				System.out.print("*");
			}
			System.out.println();
			
			
			}
		
		}
	
	public void practice9() {
		//다음과 같은 실행 예제를 구현하세요
		
		// ex)
		//정수 입력 : 4
		//    *
		//   **
		//  ***
		// ****
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("정수 입력 : ");
//		int input = sc.nextInt();
//		
//		for(int x = 0; x <= input; x++){
			
			/*
			 * // 1)for문 하나더 작성 
			 * // * 1개 출력 전 띄어쓰기 3번 
			 * // * 2개 출력 전 띄어쓰기 2번 
			 * // * 3개 출력 전 띄어쓰기 1번
			 * // * 4개 출력 전 띄어쓰기 0번
			 * 
			 * // y == 3,2,1,0
			 */
			/* for (int y = input -x ; y >= 1; y--) {
			 System.out.println(" "); }
			  
			 for(int i = 0; i < input - i; i++){ 
			  		System.out.print(" "); 
			 
			 for(int star = 0; star <= x; star++){
			 	System.out.print("*"); 
			 } 
			  System.out.println();
			 }
		}
*/
			/*// 2) for + if else
			for (int i = 1 ; i <= input ; i++) {
				if( i <= input - x) {
				System.out.println(" ");
				}else {
				System.out.println("*");
			}
			System.out.println();//줄바꿈
			}
		}*/
		
		Scanner sc = new Scanner(System.in);
		 
		 System.out.print("정수 입력 : ");
		 int input = sc.nextInt();
		 
		 for (int x = 1 ; x <= input ; x++) {
			 for(int star = 1 ; star <= x; star++) {
				 System.out.print("*"); 
				 } 
			 System.out.println(); }
	}
	
	public void practice10() {
		//다음과 같은 실행 예제를 구현하세요
		
		//ex)
		//정수 입력 : 3
		//*
		//**
		//***
		//**
		//*
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		
		//위쪽 삼각형
		for (int x = 1 ; x <= input ; x++) {
			for(int star = 1 ; star <= x; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//아랫쪽 삼각형
		for (int x = input-1 ; x >= 1 ; x--) {
			for (int star = 1; star <= x; star++) {
				System.out.print("*");
				
			}
		System.out.println();// 줄바꿈 
		}
	}
	
	
	
	
	public void practice11() {
		//다음과 같은 실행 예제를 구현하세요
		
		//ex)
		//정수 입력 : 4
		
		//   *		//" "3개, "*"1개  
		//  ***		//" "2개, "*"2개,"*"1개  
		// *****	//" "1개, "*"3개,"*"2개   
		//*******	//" "0개, "*"4개,"*"3개   -> 2개씩 감소 or 증가
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수입력 : ");
		int input = sc.nextInt();
		
		for(int x = 1 ; x >= input; x++) {//d이력 받은 input 만큼 줄 출력
			//공백 출력 for문
			for(int i = input-x ; i >= 1; i--) {
				System.out.print(" ");
				
			}
			// * 출력 for 문
			// 1, 3, 5, 7, 9
			for(int star = 1 ; star <= 2 * x - 1; star++) {
				System.out.print("*"); 
			}
			System.out.println();
			
		}
		
		/*==============내가 푼 풀이===========
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * System.out.print("정수 입력 : "); int input = sc.nextInt();
		 * 
		 * for (int x = 1 ; x <= input ; x++) { for(int star = 1 ; star <= x; star++) {
		 * System.out.print("*"); } System.out.println(); } for (int x = input-1 ; x >=
		 * 1 ; x--) { for (int star = x; star >= 1; star--) { System.out.print("*");
		 * 
		 * } System.out.println(); }
		 */
	   
	   
		
	}
	
	public void practice12() {
		//다음과 같은 실행 예제를 구현하세요
		
		//ex)
		//정수 입력 : 5
		
		//*****   1) 다섯 줄 반복 
		//*   *  	2) 첫 번째 줄과 마지막 줄 input값 만큼 * 출력 
		//*   *		3) 아닐 경우  
		//*   *			input 값의 -2 만큼 " "(띄어쓰기 출력)
		//*****			
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		//row :행 (줄)
		//col (colum) : 열 칸
		
		for(int row =1; row <= input ; row++) {
			
			for( int col =1 ; col <= input ; col++) {
				//row 또는 cold이 1 또는 input인경우 * 출력 
				//== 테두리 
				if( 1 == row || col == 1 || col == input || row == input) {
					System.out.println("*");
					
				}else { //내부 
					System.out.println(" ");
					
				}
				System.out.println();//줄바꿈
			}
		}
		
		
		
//		==========내가 푼것===============		
//		System.out.print("정수 입력 : ");
//		int input = sc.nextInt();
//		//줄 반복 
//		for( int x = 1 ; x <= input ; x++ ) {
//			//첫번째 줄과 마지막줄 별 input 수 만큼 출력
//			if( x == 1 || x == input ) {   
//				for (int star = 0 ; star <= input-1 ; star++ ) {
//					System.out.print("*");
//				}
//			
//			// 첫번째 줄과 마지막 줄이 아닌 경우 
//			}else {
//				System.out.print("*");
//				//" "(띄어쓰기) 반복출력
//				for(int i = 1 ; i <= input-2; i++ ) {
//					System.out.print(" ");
//				}
//				
//				System.out.print("*");
//			}
//			System.out.println();
//		}
	}
	


	
	public void practice13() {	
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("자연수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		
		int conut = 0;
		
		for(int i = 1 ; i <= input ; i++ ) {
			if( i % 2 == 0 || i % 3 == 0 ) {
				System.out.print(i+ " ");
					if (i % 2 == 0 && i % 3 == 0 ) {
						conut++;
					}
				}
		}
		System.out.println();
		System.out.print("count : "+ conut);
	}

}
	
	

	
	
	
	
