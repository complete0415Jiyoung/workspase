package edu.kh.variable.ex2;


import java.util.Scanner;

public class ScannerExampele2 {

	public static void main(String[] args) {
	
		
		
		Scanner sc = new Scanner (System.in);
		
		
		
		//사칙연산 계산기 
		//->두 실수를 입력 받아서 사칙 연산 계산기를 모두 출력
		System.out.print("실수 1 입력 : ");
		double input1 = sc. nextDouble();
		
		
		//nextDouble(): 입력 받은 다음 실수를 읽어옴
		System.out.print("실수 2 입력 : ");
		double input2 = sc. nextDouble();

		//ctrl + alt + 방향키 위 또는 아래 : 한 줄 라인 복사
		System.out.printf("%.2f +%.2f= %f\n", input1, input2,  input1+input2);
		 //소수점 두번째 자리까지 
		
		
		System.out.printf("%.2f +%.2f= %f\n", input1, input2,  input1+input2);
		
		System.out.printf("%.2f -%.2f= %f\n", input1, input2,  input1 - input2);
		
		System.out.printf("%.2f *%.2f= %f\n", input1, input2,  input1 * input2);
		
		System.out.printf("%.2f /%.2f= %f\n", input1, input2,  input1 / input2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	}

}
