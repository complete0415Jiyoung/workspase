package edu.kh.basicE1;

//(한줄) 주석: 컴파일러가 해석하지 않는 부분, 주로 코드 설명 작성

//컴파일러(compiler): 코드를 2진수(0,1)로 변환하는 번역기

/*범위 주석
 * 주석 */

//java코드 실행 순서 :코드작성 -> ctrl + f11 (컴파일러가 2진수로 번역-> jvm이 실행)
//한줄 삭제: ctrl + D
//줄 바꾸기 : shift + Eanter

public class JavaTest {
	//class:자바코드가 작성 되는 영역
	
	
	public static void main(String[] args) {
		//main method(메서드): 자바 애플리케이션(프로그램)을 실행하기 위해 반드시 필요한 메소드
		
		System.out.println("Hello World!");
		System.out.println("1234");
		System.out.println("첫날 어떠셨나요?");
		
		
		/*숫자연산*/
		System.out.println("----------------");
		
		System.out.println("1+2");
		//""안에 작성된 코드는 단순 문자열로 인식
		System.out.println(1+2);
		//""안에 작성 되지 않은 코드는 숫자 혹은 변수로 인식

		
		System.out.println(50-23);
		System.out.println(12*13);
		System.out.println(327/3);
		
		//"(문자열)" + 숫자 함께 작성
		System.out.println("14*19="+266);
		System.out.println("14*19="+14*19);
		
		
		System.out.println("90+70+65="+(90+70+65));
		
		//+ 기호의 역할 
		//-> 숫자 + 숫자 = 덧셈의 연산 결과 
		//->문자열 + 숫자 또는 
		// 문자열 + 문자열 ---> 이어쓰기
		
		//자바는 사칙연산의 우선순위를 그대로 따른다!

	
	}
}
