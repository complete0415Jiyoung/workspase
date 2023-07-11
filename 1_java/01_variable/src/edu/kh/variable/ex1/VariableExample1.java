package edu.kh.variable.ex1;

public class VariableExample1 {

	public static void main (String[]args) {
		/*변수(Variable) 
		 * -메모리(RAM)에 값을 기록하는 공간
		 * -> 공간에 기록되는 값(date)이 번할 수 있어서 변수라고 한다.
		 *
		 *- 변수는 여러 종류가 존재(저장되는 값의 형태, 크기가 다르다) 
		 *
		 * 변수 사용의 장점
		 * 1. 가독성증가(읽기 편히짐)
		 * 2. 재사용성 증가(한번 만든 병수를 계속 사용)
		 * 3. 코드 길이의 감소
		 * 4. 유지보수성 증가 (코드 수정이 간단해짐)
		 *
				 */
		
		
		System.out.println(2 * 3.141592653589793 * 10);
		System.out.println(3.141592653589793 * 10 * 10);
		System.out.println(3.141592653589793*10*10*20);
		System.out.println(4* 3.141592653589793*10*10);
		
		
		//변수사용
		double pi=3.141592653589793;//원주율
		int r=10;//반지름radius)
		int h= 20;//높이(height)
		
	
		System.out.println("----------------");
		System.out.println(2*pi*r);   //원의 둘레
		System.out.println(pi*r*r);   //원의 넓이
		System.out.println(pi*r*r*h);  //원기둥의 부피
		System.out.println(4*pi*r*r);  //구의 겉넓이
		
		/*변수의 선언 예(8가지 기본 자료형)
		 *- String 참조형으로 기본료형이 아님
		 *boolean 논리: 1byte
		 *byte, short, int, long 정수: 1/2/4/8byte
		 *float 실수 8자리, double 16자리
		 *char 문자:2byte
		 *String 문자열(참조형)
		 */
		
		
		

	}

}
