package edu.kh.control.loop;

import java.util.Scanner;

public class ForExample {

	/*
	 * for문 -끝이 정해 저있는 (회수가 정해진)반복문
	 * 
	 * [작성법]
	 * 
	 * for(초기식; 조건식; 증감식){ 반복 수행할 코드 }
	 * 
	 * - 초기식 : for문을 제어하는 용도의 변수 선언 - 조건식 : for문의 반복 여부를 지정하는 식 (다음 반복 진행해?) 보통
	 * 초기식에 사용하는 변수을 이용하여 조건식 작성함
	 * 
	 * - 증감식 :초기식에 사용된 변수를 for문이 끝날때 마다 증가 또는 감소 조건식의 결과를 변하게 하는 식
	 * 
	 * 
	 */

	public void ex1() {
		// for문 기초 사용법1

		// -1부터 10까지 출력하기
		// ----> 1씩 증가 하며 출력

		for (int i = 1; i <= 10; i++) {
			// 1) 초기식 ; 2),5),8)조건식 ; 4),7) 증감식

			// 3),6)반복 수행할 코드
			System.out.println(i + "출력");

		}
	}

	public void ex2() {
		// for 기초 사용법2

		// 3에서 7까지 1씩 증가 하면서 출력
		// - >i의 값이 7이하일땨 T가 되는 조건식

		// 3 4 5 6 7
		for (int i = 3; i <= 7; i++) {
			System.out.println(i + " ");

		}
	}

	public void ex3() {

		// 2부터 15까지 1씩 증가 하며 출력

		for (int i = 2; i <= 15; i++) {
			System.out.println(i + " 배고파 ");

		}
	}

	public void ex4() {

		// 1부터 입력 받은 수까지 1씩 증가 하며 출력

		Scanner sc = new Scanner(System.in);

		System.out.print("끝번호 : ");
		int input = sc.nextInt();

		for (int i = 1; i <= input; i++) {
			System.out.println(i);

		}
	}

	public void ex5() {
		// *
		// 1부터 입력받은 수 까지 2씩 증가 하며 출력

		Scanner sc = new Scanner(System.in);

		System.out.print("끝번호 : ");
		int input = sc.nextInt();

		for (int i = 1; i <= input; i += 2) {
			// i = i + 2 -> i에 더하기 2 하고 i에 대입

			System.out.println(i + "출력");

		}
	}

	public void ex6() {

		// 1.0 부터 입력 받은 실 수까지 0.5씩 증가하며 출력

		Scanner sc = new Scanner(System.in);

		System.out.print("끝나는 실수  : ");
		double input = sc.nextDouble();

		for (double i = 1.0; i <= input; i += 0.5) {
			System.out.println(i);

		}
	}

	public void ex7() {

		// 알파베 a부터 z까지 한줄 출력
		// char 자료형은 문자형이지만 실제로는 정수(문자표 번호)를 저장한다.

		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.print((char) i); // 강제 형변환
		}

		System.out.println("\n======================");

		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
	}

	public void ex8() {

		// 10~ 1까지 1씩 감소

		for (int i = 10; i >= 1; i--) {
			System.out.println(i);
		}
	}

	public void ex9() {

		// for 문 응용 1 : 반복문을 이용한 값의 누적

		// 1부터 10까지 모든 정수의 누적

		int sum = 0; // 반복되어 증가하는 i 값의 합계를 저장할 변수
						// 0으로 시작하는 이유 : 아무것도 더하지 않음으로
						// 정확히 결과를 도출 할 수 있기 때문

		for (int i = 1; i <= 100; i++) {

			// sum + sum = i
			sum += i;
			// System.out.println("합계 :" +sum); //계속 반복 되며 출력
		}

		System.out.println("합계 :" + sum);

	}

	public void ex10() {

		// for문
		// ex)
		// 입력 1 : 10
		// 입력 2 : 20
		// 입력 3 : 30
		// 입력 4 : 40
		// 입력 5 : 50
		// 합계 : 150
		Scanner sc = new Scanner(System.in);

		int sum = 0; // for문 밖에 존재하는 변수로
						// 아래 for문이 끝나도 사용 가능

		for (int i = 1; i <= 5; i++) {
			System.out.println("입력 " + i + " :");
			int input = sc.nextInt();

			sum += input; // sum에 입력 받은 input 값 누적

			// System.out.println( input );
			// {}안 에서 생성된 변수는 {} 밖에서 사용 할 수 없다
			// {} -> {} 끝나는 시점에 사라지기 때문에

		}

		// System.out.println( input );
		// for문 안에서만 사용가능하기 때문 input 에러

		System.out.println("합계:" + sum);

	}

	public void ex11() {

		// 정수를 몇 번 입력 받을지 먼저 입력 받고
		// 입력된 정수의 합계를 출력

		// ex)
		// 입력 받을 정수의 개수 : 3
		// 입력 1 : 10
		// 입력 2 : 20
		// 입력 3 : 30
		// 합계 : 60

		// ex)
		// 입력 받을 정수의 개수 : 2
		// 입력 1 : 10
		// 입력 2 : 20
		// 합계 : 30
		Scanner sc = new Scanner(System.in);

		System.out.println("입력 받을 정수의 개수 :");
		int num = sc.nextInt();
		int sum = 0;

		for (int i = 1; 1 <= num; i++) {

			System.out.println("입력 " + i + " :");
			int input = sc.nextInt();

			sum += input;

		}

		System.out.println("합계 : " + sum);
	}

	public void ex12() {
		// 1~20까지 1씩 증가 하면서 출력
		// 단, 5의 배수에 ()를 붙여서 출력

		// 1 2 3 4 (5) 6 7 8 9 (10) 11..

		for (int i = 1; i <= 20; i++) {

			if (i % 5 == 0) { // i가 5의 배수가 아닌 경우
				System.out.print("(" + i + ")");

			} else { // i 가 5의 배수인 경우
				System.out.print(i + " ");

			}
		}
	}

	public void ex13() {
		// 1 부터 20까지 1씩 증가하면서 출력
		// 단, 입력 받은 수의 배수는 () 표시

		// ex)
		// 괄호를 표시할 배수 : 3
		// 1 2 (3) 4 5 (6) ...

		// 괄호를 표시할 배수 : 4
		// 1 2 3 (4) 5 6 7 (8) 9 ...

		Scanner sc = new Scanner(System.in);

		System.out.print("괄호를 표시할 배수 : ");
		int input = sc.nextInt();

		for (int i = 1; i <= 20; i++) {

			if (i % input == 0) { // i가 input에 저장된 값에 배수인 경우
				System.out.print("(" + i + ")");

			} else { // i 가 input에 저장된 값의 배수 가 아닌 경우
				System.out.print(i + " ");

			}
		}
	}

	
	  public void ex14() {
		// [구구단 출력]
	    // 2 ~ 9 사이 수를 하나 입력 받아
	    // 해당 단을 출력
	    // 단, 입력 받은 수가 2 ~ 9 사이 숫자가 아니면 "잘못 입력 하셨습니다" 출력
	      
		  Scanner sc = new Scanner(System.in);
		  
		  System.out.print("단 입력 : ");
		  int dan = sc.nextInt();
		  
		  if( dan >= 2 && dan <= 9 ) {   //dan이 2~9 사이 인 경우 
			  for(int i =1; i <= 9 ; i++) {
				  System.out.printf("%d X %d = %d\n", dan ,i, dan*i);  
			  }
		 
		  }else {						//dan이 2~9 사이가 아닌 경우
		  System.out.println("잘못입력하셨습니다");
		 
		  }
	  }

	  
	  public void ex15() {
			// [19단 출력기]
		    // 2 ~ 19 사이 단를 하나 입력 받아
		    // 1~*19 = 까지 출력  
		    // 단, 2 ~ 19 사이 단이 아니면 "잘못 입력 하셨습니다" 출력
		      
		  Scanner sc = new Scanner(System.in);
		  
		  System.out.print("단 입력 (2~19사이 정수): ");
		  int dan = sc.nextInt();
		  
		  if(dan >= 2 && dan <=19) {
			  for(int i = 1; i <= 19; i++ ) {
				  System.out.printf("%d X %d = %d\n", dan ,i, dan * i);
			  }
		  }else {		  
			System.out.println("잘못 입력하셨습니다");
	  		}	
		  
	  } 
		   
	  
	  

	  
	   //*** 중첩 반복문
	  public void ex16() {
		  //구구단 모두 출력하기
		  
		  for( int dan = 2 ; dan <= 9 ; dan++ ) {  //2~9단 까지 차례대로 출력
			 //안쪽 for문이 반복하면서 하나의 단으로 출력
			  for(int num= 1; num <= 9 ;num++ ) { //각 단에 곱해질 수 1~9까지 차례대로 증가 
				 
					  System.out.printf("%2d x %2d + %2d ", dan, num, dan, num);
				  }
				  
				  System.out.println();
				 }
	  }
	  
	  
	  public void ex17() {
		  //구구단 역순 출력 
		  
		  //9-> 2단까지 역방향 
		  //곱해지는 수는 1->9까지 정방향
	
		  for( int dan = 9 ; dan >= 2 ; dan-- ) {   //단이 9~2로 역방향 출력
			  
			  for( int num = 1 ; num <= 9 ; num++ ) {  //수는 1~9까지 정방향
				  System.out.printf("%2d x %2d + %2d ", dan, num, dan, num);
			  }//한 단의 출력 종료
			  System.out.println();	
		  }
	  }
	  
	  
	  public void ex18() {
		  //2중 for문을 이용하여 다음 모양 출력
		  
		  //12345
		  //12345
		  //12345
		  //12345
		  //12345
		  
		 for(int x = 1; x <= 5; x++) { //5바퀴 반복 for문 
			
			 for(int i = 1 ; i <= 5 ; i++) { //12345 한 줄 반복 for문
				 System.out.print(i);
				 
			 }
			 System.out.println();   //줄바꿈
		 }
		 
		 System.out.println("===================");
		 
		 
		 //54321
		 //54321
		 //54321
		 
		 for(int x = 1; x <= 3; x++) { //5바퀴 반복 for문 
			
			 for(int i = 5 ; i >= 1 ; i--) { //12345 한 줄 반복 for문
				 System.out.print(i);
			 }
			 System.out.println();   //줄바꿈
			 
		 }
		  
	  }
	  
	  
	  public void ex19() {
		  
		  //2중 for문을 이용 하여 다음 모양을 출력
		  
		  //1
		  //12
		  //123
		  //1234
		  for(int x = 1; x <= 4 ; x++) {  //줄 반복
		
			 for(int i = 1 ; i <= x ; i++ ) {  //출력반복
				 System.out.print(i);
				 
			 }
			 System.out.println();
		  }
		  
		  //x가 1일 때 i == 1
		  //x가 2일 때 i == 12
		  //x가 3일 때 i == 123
		  //x가 4일 때 i == 1234  ------- for문으로 변하는 x 값 변수 가져오기 
		  
		  
		  
		 System.out.println("=================");
		 
		 //4321
		 //321
		 //21
		 //21
		 //1
		 
		 for(int x = 4; x >= 1 ; x--) {  //줄 반복
				
			 for(int i = x ; i >= 1 ; i-- ) {  //숫자 출력 반복
				 System.out.print(i);
				 
			 }
			 System.out.println();
		  }
		 
		 //x가 4일 때 i == 4321
		 //x가 3일 때 i == 321
		 //x가 2일 때 i == 21
		 //x가 1일 때 i == 1--------------i의 시작 값 x
		
	  }
	  
	  
	  public void ex20() {
		  
		  //count ( 숫자세기 )
		  
		  //1부터 20까지 1씩 증가 
		  //3의 배수의 총 개수 출력
		  
		  //3 6 9 12 15 18: 6개
		  
		  int count = 0; //3의 배수에 갯수를 세기 위한 변수 
		  int sum =0;  //3의 배수의 합계를 구하는 변수 
		  
		  for (int i = 1; i <= 20 ; i++) {   
			  
			  if(i % 3 ==0) {    //3의 배수 
				  System.out.print(i + " ");
				  count ++;		//if문이 동작 할때 마다 1씩 증가
				  sum += i;   	//3의 배수 누적 
			  }
		  }
		  System.out.println(" : "+ count + "개");
		  System.out.println("3의 배수의 합계 : " + sum);
	  
	  }
	  
	  
	  public void ex21() {
		  //2중 for문과 count를 이용해서 아래 모양 출력
		  
		  //1  2  3  4 
		  //5  6  7  8
		  //9 10 11 12
		  int count = 1;
		  
		  for( int x = 1 ; x <= 3 ; x++) {   //3줄
			  
			  for ( int i = 1 ;  i <= 4 ; i++ ) {  //4칸
				  System.out.printf ("%3d", count);
				  count++;
			  }
			  System.out.println();
		  }
	  }
}  
		  
		  
		  
		  
 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  


