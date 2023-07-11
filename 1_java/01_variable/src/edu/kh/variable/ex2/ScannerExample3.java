package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); 
	
	//문자열(String) 입력
		
	//문자열을 3번 입력 받아서 한줄로 출력하기
		
		//ex)
		//입력 1 : 안녕?
		//입력 2 : 반가워!
		//입력 3 : 밥먹자
		//입력 4 : 반가워! 밥먹자

	
		System.out.printf("입력 1 :");
		String input1 = sc. next();
		//next() : 입력된 한 단어를 읽어옴
		
		System.out.printf("입력 2 :");
		String input2 = sc. next();
		
		System.out.printf("입력 3 :");
		String input3 = sc. next();
	
		System.out.printf("입력 4 :");
		String input4 = sc. next();
	
	
	
		System.out.printf("%s %s %s %s \n",input1,input2,input3, input4);
		
	}
}
