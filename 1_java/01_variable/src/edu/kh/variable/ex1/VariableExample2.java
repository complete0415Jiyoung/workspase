package edu.kh.variable.ex1;

public class VariableExample2 {
	
	public static void main (String[]args) {
		
		
		/*자바기본자료형 8가지 
		 * 
		 * 논리형 : boolean(1byte)
		 * 정수형 : byte(1byte), short(2byte), int(4byte)m,long(8byte)
		 * 실수형 : float(4byte), double(8byte)
		 * 문자형 : char(2byte, 유니코드)
		 * 
		 */
		
		//변수선언: 메모리에 저장할 공간을 할당하는 것
		//변수 값 대입(집어 넣기) : 변수에 값을 집어 넣는 것
		
		//* 카멜(낙타)표기법
		//연결되는 두 단어 중 후속 단어의 첫 문자를 대문자로 표기
		
		
		boolean booleanData;
		//메모리에 논리값(F/T)을 저장할 공간을 1byte 할당하고
		//할당된 공간을  booleanData라고 부르겠음.
		
		booleanData= true; //boolean 변수에true값 집어넣기
		System.out.println("booleanData: "+booleanData);
		
		
		byte bytenumber=127;   //(short, byte는 옛날코드의 잔재)
		//메모리의 정수값을 저장할 공간을 1byte할당하고 
		//할당된 공간을 byteNumber라고 부르겠음.
		//선언된 byteNumber 변수에 처음으로 127을 집어넣음
		//--> 초기화: 처음 변수에 값을 대입
		
		short shortNumber=32767;  //변수 선언 및 초기화
	//  자료형  변수명      = 리터럴 
		
		//**리터럴 : 변수에 대입되거나 작성 되어지는 값 자체
		//+ 자료형에 따라 리터럴 표기법이 다름
		
		
		//정수 자료형의 기본형!
		int intNumber=2147483647; //변수의 선언 및 초기화

				
		long longNumber = 10000000000L;  //또는 소문자 l
		//The literal 10000000000 of type int is out of range 
		//
		
		float floatNume = 1.2345F;
		//Type mismatch: cannot convert from double to float
		
		
		double doubleNumber = 3.141592;
		// double이 실수형 중에서 기본형
		//(리터럴 표기 법이 없는 실수는 double로 인식)
		
		//문자형 리터럴 표기법: ''(홀따음표)
		//-> 문자 하나
		char ch = 'A'; //65
		char ch2=66;
		//**char 자료형에 숫자가 대입될 수 있는 이유
		//- 컴퓨터에는 문자표가 존재하고 있음
			//숫자에따라 지정된 문자 모양이 매핑 되어 있고,
			//'B'문자 그대로가 대입이 되면 변수에 66로로 변화되어 저장
			//-> 반대로 생각하면 변수에 애초에 66이라는 숫자를 저장하는 것이 가능
		
		System.out.println("ch:"+ch);
		System.out.println("ch2 :"+ch2);
		
		//변수 명명 규칙
		//1. 대소문자구분, 길이제한 X
		int abcdefghijkimnopqrsyuvwxyz;
		int abcdefghijkimnopqrsyuvwxyZ;//Z만 다름
		
		//2. 예약어 사용이 X
		//double double;
		
		//3. 숫자로 시작 X
		//char 1abc;
		
		//4.특수문자의 경우 $,_만 사용 가능
		int $intNimber;    //사용에 문제는 없지만 개발자가 사용하지 않음
		int _intNumber;    //자바는 카멜표기법 사용 
		 					//_ 작성 표기법은 DB에서 사용
		//5. 카멜표기법 
		//-> 변수명 작성시 여러 단어를 이어서 작성하는 경우 
		// 띄어 쓰지 않고 후속 단어를 첫 글자를 대문자로 작성
		// 단, 첫 시작 글자는 소문자로 시작하는 것이 관례
		char helloWorldAppleBananaTomato;
		
		//6. 변수 명은 언어를 가리지 않은
		int 정수1번;
		double 실수2번 =3.14;
		System.out.println(실수2번);
		
		//================================================"
		
		int number = 10;
		System.out.println("number: "+ number);
		
		number=20;
		System.out.println("number: "+number);
		
		/* 상수 (항상 같은 수):
		 * - 변수의 한 종류 
		 * -한번 값이 대입되면 다른 값을 대입 할 수 없음
		 * - 자료형 앞에 final 키워드를 작성(마지막으로 대입되는 값)
		 * 
		 * - 상수 명명 규칙 : 모든 대문자, 여러단어 작성시 "_" 사용
		 * 
		 * -상수를 사용하는 경우
		 * 1) 변하면 안 되는 고정 값을 저장할 때 
		 * 
		 * 
		 * 
		 * */
	
		final double PI_VALUE = 3.14;
		//PI_VALUE = 3.32222; //에러! 대입불가
	
		final int LEFT_MOVE =-1;
		final int RIGHT_MOVE = 1;
		
	
	
	
	
	
	}

}
