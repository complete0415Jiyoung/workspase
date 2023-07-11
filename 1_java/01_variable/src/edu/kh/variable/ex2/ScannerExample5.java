package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		 // 1) next(): 한단어 (띄어쓰기, 엔터를 만나면 입력 종료)
		 //	nextLine(): 한 문장 (엔터를 만나면 입력 종료)
		
		
		
		System.out.print("입력 : ");
	 	//String str= sc. next();   //한 단어만
		String str= sc. nextLine(); //한 줄만
		
		System.out.print(str);  //next () : hello 
								//nextLine(): hello World
		
		
		// 2) 스케너 입력 버퍼와 nextXXX의 의미
		
		// 입력-> 입력 버퍼에 저장 -> nextXXX()통해 버퍼 내용을 읽어 온다
		
		//						입력버퍼      nextXXXX			후처리
		// nextLine() : hello World(엔터) -> hello World(엔터)-> 엔터제거
		// nextint() : 			100(엔터) -> 100		
		// next(), nextdouble(), nextInt() 등
		// :모두 입력 버퍼에서 (엔터)를 제거히고 내용만 읽어옴
		
		
		System.out.println("--------------");
		
		System.out.println("nextInt() : ");   //입력버퍼에 :[100(엔터)]
		int a= sc. nextInt();
		//100      // 입력버퍼에 : [(엔터)]
		
		//!문제해결!
		sc. nextLine(); //입력버퍼 [     ]   엔터가 사라짐
		
		
		System.out.println("nextLine() : "); //입력버퍼: [(a,b,c(엔터)
		String s = sc .nextLine();
	
		System.out.println("종료");
		
		//[문제점] nextline만 [(엔터)]남음
		//nextint ()이후 입력 버퍼에 남아있는 (엔터)를 읽어버리기 때문에 
		//다음 nextLine()수행 시 버퍼에 남아있는 (엔터)를 읽어버리기 때문에 
		//추가적으로 입력을 시도하지 못하고 다음 코드로 넘어가는 문제 
		
		//[해결방법]
		//입력을 위한 nextLine() 수행전 
		//입력버퍼 (엔터)를 제거
		//-> 빈공간에 nextLine() 구문을 작성하면 (엔터)가 제거됨 
		
	}

}
