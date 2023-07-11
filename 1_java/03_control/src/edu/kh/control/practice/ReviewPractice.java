package edu.kh.control.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ReviewPractice {
	
	public void practicea5() {
		//사용자로 부터 입력 받은 숫자의 단을 출력하세요 
		//ex.
		// 숫자 :4
		//====4단====
		//4 * 1 = 4
		//...
		//4 * 9 = 36
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		
		for(int i = 2 ; i <= dan ; i++ ) {
			if(i ==dan) {
				System.out.println("======="+dan+"단========");			
				for (int time = 1 ; time <= 9 ; time ++) {
					System.out.printf("%d x %d = %d\n", i , time , i * time );
				}
			}
		}
	}
	
	public void practicea6() {
		//사용자로 부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
		//단, 2~9를 사이가 아닌 수를 입력하면 "2~9 사이 숫자만 입력해 주세요"를 출력
		
		//숫자 : 4					숫자 : 10 
		//=====4단=====				2 ~ 9 사이 숫자만 입력해 주세요.
		//=====5단=====
		//=====6단=====
		//=====7단=====
		//=====8단=====
		//=====9단=====
		//(해당 내용 길이상 삭제)
		
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
	
	public void practicea7() {
		//다음과 같은 실행 예제를 구현하세요
		
		// ex)
		//정수 입력 : 4
		//*
		//**
		//***
		//****
	
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 : ");
		int input = sc.nextInt();
		
		for (int x = 1; x <= input ; x++) {
			for (int star = 1 ; star <= x ; star++) {
				System.out.print("*");
				
			}
			System.out.println();
		}
		
	}
	
	public void practicea8() {
		
		////다음과 같은 실행 예제를 구현하세요
		
		// ex)
		//정수 입력 : 4
		//****
		//***
		//**
		//*
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 : ");
		int input = sc.nextInt();
		
		
		for(int x = input ; x >= 1 ; x--) {
			for(int star = x; star >= 1; star--) {
				System.out.print("*");
			}
			System.out.println();	
		}
	}
	
	public void practicea9() {
		//다음과 같은 실행 예제를 구현하세요
		
		// ex)
		//정수 입력 : 4
		//    *
		//   **
		//  ***
		// ****
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int x = input ; x >= 1 ; x--) {
			for (int i = x; i >= 1; i--) {
				System.out.print(" ");
				
			} // 띄어쓰기 
			for (int star = 1 ; star <= input-x+1; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	public void practicea10() {
		//다음과 같은 실행 예제를 구현하세요
		
		//ex)
		//정수 입력 : 3
		//*
		//**
		//***
		//**
		//*
		Scanner sc = new Scanner (System.in) ;
		System.out.print("정수입력 : ");
		int input = sc.nextInt();
		
		
		for (int x = 1 ; x <= input ; x++) {
			for(int star = 1 ; star <= x; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int x = input-1 ; x >= 1 ; x--) {
			for (int star = x; star >= 1; star--) {
				System.out.print("*");
				
			}
		System.out.println();
		}
	
	}
	
	public void practicea11() {
		//다음과 같은 실행 예제를 구현하세요
		
		//ex)
		//정수 입력 : 4
		
		//   *		//" "3개, "*"1개  
		//  ***		//" "2개, "*"3개  
		// *****	//" "1개, "*"5개  
		//********	//" "0개, "*"7개  -> 2개씩 감소 or 증가
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수입력 : ");
		int input = sc.nextInt();
		
		for(int x = input ; x >= 1; x--) {
			for(int i = x-1 ; i >= 1; i--) {
				System.out.print(" ");
				
			}
			for(int star = 1 ; star <= input-x+1; star++) {
				System.out.print("*"); //왼쪽 별 증가 
			}
			for(int star = 1 ; star <= input-x; star++) {
				System.out.print("*"); //오른쪽 별 증가 
			}
			System.out.println();
			
		}
		
	}
	
	public void practicea12() {
		//다음과 같은 실행 예제를 구현하세요
		
		//ex)
		//정수 입력 : 5
		
		//*****   1) 입력값 만큼 줄 반복 
		//*   *  	2) 첫 번쨰 줄과 마지막 줄 input값 만큼 * 출력 
		//*   *		3) 아닐 경우  
		//*   *			입력 값의 -2 만큼 " "(띄어쓰기 출력)
		//*****			
	
		Scanner sc = new Scanner (System.in);
		
		System.out.print("정수입력 : ");
		int input = sc.nextInt();
		
		for(int x = 1 ; x <= input ; x++ ) {
			if(x == 1 || x == input) {
				for(int star = 1; star <= input; star++) {
					System.out.print("*");
				}
			
			}else {
				System.out.print("*");
				for(int i = 1; i <= input-2 ; i++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
		System.out.println();
		}
	}
	
	public void practicea13() {
		//연산 기호를 포함한 계산기
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 입력 : ");
		int input1 = sc.nextInt();
		
		System.out.print("두번째 정수 입력 : ");
		int input2 = sc.nextInt(); 
		
		System.out.print("연산기호 입력 : ");
		char op = sc.next().charAt(0); 
		
		int result = 0;
		
		switch(op) {
		case '+' : result = input1 + input2 ; break;
		case '-' : result = input1 - input2 ; break;
		case '*' : result = input1 * input2 ; break;
		case '/' : 
			 if (input2 != 0) {
				 result = input1 / input2 ;
				 
			 }else {
				 System.out.println("0으로 나눌 수 없습니다");
			 }
			 break;
		
		case '%' : result = input1 % input2 ; break;
		default : System.out.println("입력하신 연산은 없습니다 .프로그램을 종료합니다");
		return;
		}
		
		System.out.printf("%d %c %d = %d\n", input1, op,input2, result);
	}	
	
	
	public void RSPGame() {
		 // 가위 바위 보 게임
		   
	   // 몇판? : 3
	   
	   // 1번째 게임
	   // 가위/바위/보 중 하나를 입력 해주세요 :  가위
	   // 컴퓨터는 [보]를 선택했습니다.
	   // 플레이어 승!
	   // 현재 기록 : 1승 0무 0패
	   
	   // 2번째 게임
	   // 가위/바위/보 중 하나를 입력 해주세요 :  보
	   // 컴퓨터는 [보]를 선택했습니다.
	   // 비겼습니다.
	   // 현재 기록 : 1승 1무 0패
	   
	   // 3번째 게임
	   // 가위/바위/보 중 하나를 입력 해주세요 :  가위
	   // 컴퓨터는 [바위]를 선택했습니다.
	   // 졌습니다ㅠㅠ
	   // 현재 기록 : 1승 1무 1패
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇판? : ");
		int round = sc.nextInt();
		
		int win = 0;
		int drow = 0;
		int lose = 0;
		
	
		for(int i = 1 ; i <= round ; i++) {
			System.out.println(round+"번째 게임");
			System.out.print("가위/바위/보 중 하나를 입력해 주세요 : ");
			String rsp = sc.next();
			
			int random = (int )(Math.random() * 3 + 1); 
			//math.random() 0.0~ 0.1미만  난수
			//실수를 정수로 형변환 
			//0에서 3사이 난수 생성 
			
			String com = null;
			
			switch(random) {
			case 1 : com = "가위" ; break;
			case 2 : com = "바위" ; break; 
			case 3 : com = "보" ; break;
			}
			System.out.println("컴퓨터는 ["+ com +"]를 선택했습니다.");
			
			
			if (rsp.equals(com)) {
				System.out.println("비겼습니다.");
				drow++;
			}else {
				// 이겼을 때의 변수 선언 
				boolean win1 = rsp.equals("가위") && com.equals("보");
				boolean win2 = rsp.equals("바위") && com.equals("가위");
				boolean win3 = rsp.equals("보") && com.equals("바위");
				
				if(win1 || win2 || win3 ) {
					System.out.println("플레이어 승!");
					win++;
					
				}else {
					System.out.println("졌습니다ㅜㅜㅜ");
					lose++;
				}
			}
			
			System.out.printf("현재기록 : %d 승 %d 무 %d 패 \n", win, drow, lose);
		}
	
	
	}
	public void RSPGame2() {
		 // 가위 바위 보 게임
		   
	   // 몇판? : 3
	   
	   // 1번째 게임
	   // 가위/바위/보 중 하나를 입력 해주세요 :  가위
	   // 컴퓨터는 [보]를 선택했습니다.
	   // 플레이어 승!
	   // 현재 기록 : 1승 0무 0패
	   
	   // 2번째 게임
	   // 가위/바위/보 중 하나를 입력 해주세요 :  보
	   // 컴퓨터는 [보]를 선택했습니다.
	   // 비겼습니다.
	   // 현재 기록 : 1승 1무 0패
	   
	   // 3번째 게임
	   // 가위/바위/보 중 하나를 입력 해주세요 :  가위
	   // 컴퓨터는 [바위]를 선택했습니다.
	   // 졌습니다ㅠㅠ
	   // 현재 기록 : 1승 1무 1패
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇판 ? : ");
		int round = sc.nextInt();
		
		int win = 0;
		int drow = 0;
		int lose = 0;
		
		
		for(int i = 1 ; i <= round ; i++) {
			System.out.println();
			System.out.println(i + "번째 게임");
			System.out.print("가위/바위/보 중 하나를 입력하세요 : ");
			String input = sc.next();
			
			int random = (int)Math.random()*3+1;
			
			String com = null; 
			
			switch (random) {
			case 1 : com = "가위"; break;
			case 2 : com = "바위"; break;
			case 3 : com = "보"; break;
			
			}
			System.out.println("컴퓨터는 ["+com+"]를 선택했습니다.");
			
			
			if (input.equals(com)) {
				System.out.println("비겼습니다");
				drow++;
				
			}else {
				boolean win1 = input.equals("가위")&& com.equals("보");
				boolean win2 = input.equals("보")&& com.equals("바위");
				boolean win3 = input.equals("바위")&& com.equals("가위");
				
				if(win1 || win2 || win3) {
					System.out.println("플레이어 승");
					win++;
					
				}else {
					System.out.println("졌습니다ㅜㅜㅜ");
					lose++;
					
				}
				
			}
			System.out.printf("현재기록 : %d승 %d패 %d무\n", win, lose, drow);
		}
	}
	
	
		//배열 : 같은 자료형의 변수를 하나의 묶음으로 다루는 것 
		//배열은 저장된 값 마다 인덱스 번호가 0부터 시작하여 설정
		
		//[배열 선언하기]
		//자료형[] 배열명;
		//자료형 배열명[];
		
		//[배열 할당]
		//자료형 []배열명 = new 자료형[배열크기];
		//자료형 배열명[] = new 자료형[배열크기];
		//ex) int[] arr = new int[3];
		//	  int arr[] = new int[3];   -> 선언과 할당 동시 가능
		
		//인덱스를 이용한 초기화 
		//arr[0] = 1;
		//arr[1] = 2;
		
		//for문을 이용한 초기화
		//for(int i =0;i < arr.length; i++){
		//	arr[i] = i;
		//}   -> 초기화 할 값이 규칙적일 경우 
		//		반복문을 통해 배열 초기화
	
		//선언과 동시에 초기화
		//int[]arr = {1,2,3,4,5};
		//int[]arr = new int[]{1,2,3,4,5};
		//String fruit[] = {"사과", "포도", "참외"};
		
	public void Arrpreview1() {	
		//배열 선언 : stack 공간 생성, 주소 값을 가지고 있음.
		boolean [] booleanArr; //논리형 배열 선언
		
		//배열 할당 :heap에 공간 생성, 진짜 데이터를 가지고 있음.
		double[] doubleArr = new double[2];
		
		//배열 초기화 
		//인덱스 이용
		doubleArr[0] =	100.123456;
		doubleArr[1] =	Math.random();
		
		//0 <= Math.random() < 1
		//1부터 10까지의 정수값은 
		//0*10+1 <=(int)(Math.random()*10)+1< 1*10+1
		
		//선언과 동시에 초기화
		String [] strArr = {"치킨", "피자", "족발"}; //크기가 3인 공간 생성, 값 초기화 
		char[] charArr = new char[] {'a', 'b', 'c', 'd', 'e'};
	
		//for문을 이용한 초기화 
		int[] intArr = new int[6];
		for( int i = 0 ; i < intArr.length; i++) {
			intArr[i] = i;
		}
		
		
		//출력 
		//하나씩 접근해서 출력하는 방법
		for(int i = 0 ; i < doubleArr.length; i++ ) {
			System.out.println(doubleArr[i]);
		}
		for(int i = 0 ; i < intArr.length; i++) {
			System.out.println(intArr[i]);
		}
		
		//전체를 출력- String 자체로 뽑이오는 것
		System.out.println(Arrays. toString(strArr));
		System.out.println(Arrays. toString(charArr));
	} 
	//[배열 복사] 
	//얇은 복사 : 객체의 주속 값만 가져와서 참조형 변수에 저장하고 하나의 객체를 두변수가 참조 선언
		
	public void Arrpreview2() {
		
		int [] score= {79,88,91,33,100,55,95};
		
		int max = score[0];
		int min = score[0];
		
		for(int i = 1; i < score.length; i++) {
			if (score[i] >max) {
				max =score[i];
						
			}else if (score[i]< min ){
				min = score[i];
				
			}
		}
		
	}
		
		
		
	
}
