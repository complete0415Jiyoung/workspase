package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample4 {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		
		System.out.print("입력1 : ");
		String input = sc. next()+ " ";//띄어 쓰기 추가
					//안녕_
		
		System.out.println(input);
				
	
		System.out.print("입력2 : ");
		input = input + sc.next() + " ";
					//안녕_반가워_
		
		//대입연산자: 오른쪽에 작성된 값을 왼쪽 변수에 대입
		System.out.println(input);
		
		System.out.print("입력 3 : ");
		input = input + sc.next() + " ";
		
		
		System.out.println(input);
		
		///예제 3번과 동일한 결과값 변수 하나만 사용하였음
		//누적효과 (변수의 재사용성)

	}

}
