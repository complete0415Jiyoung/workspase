package edu.kh.op.ex;

import java.util.Scanner;
public class OpExample { //예제 코드 작성용 클래스

	
	//ex() 메소드 
	//-> OpExample 이 가지고 있는 기능 ex1()이라는 기능
	public void ex1() {
		
		//syso 작성 후 ctrl +space
		System.out.println("Op Eaxmple 클래스의 ex1()기능 수행");
		System.out.println("클래스 테스트 ");
		System.out.println("println 자동 완성 해봤어요~");
	}
	
	//ex2()  메소드(기능)
	public void ex2() {
		
		Scanner sc =new Scanner (System.in);
		
	
		System.out.print("정수 입력 1: ");
		int input1 = sc. nextInt(); //다음 입력하는 정수를 읽어 옴

		System.out.println("정수 입력 2: ");
		int input2 = sc. nextInt();
				
		System.out.printf("%d/ %d = %d\n", input1, input2, input1/ input2 );
		System.out.printf("%d/ %d = %d\n", input1, input2, input1% input2 );
		
	
	}

	public void ex3(){
	// 증감(증가 혹은 감소) 연산자:++,--
    // -> 피의연산자(값)를 1증가 또는 감소 시키는 연산자

		int iNum1 =10;
		int iNum2 =10;
		
		iNum1++;   //iNum1 1증가
		iNum2--;   
		
		System.out.println("iNum1 : " + iNum1);
		System.out.println("iNum2 : " + iNum2);
	
		
		// 전위 연산 : ++3 ,--2 연산자가 앞 쪽에 배치	
		// 다른 연산자 보다 먼저 증가 / 감소
		int temp1 = 5;
		System.out.println(++temp1 + 5);
		                 //++5     +5
		                 //6       +5     ==11

		
		System.out.println("temp1 :" + temp1); //6
		
		
		// 후위 연산자 10++,6-- 연산자가 뒤쪽에 배치
		// 다른 연산자 보다 나중에 증가 /감소
		int temp2 = 3;
		System.out.println(temp2-- + 2);
        				//3--  +2   ==5
						//temp2 = 2; (1감소)
        System.out.println("temp2 : " + temp2); //2
        

        
        int a = 3;
        int b = 5;
        int c = a++ + --b;       //7
        
        //    (a)3++ + --5(b)
        //c = (a)3++ + 4(b)
        //c = 7
        
        //미뤄놨던 a 후위연산 a++ == 3+1 ==4
        
        //최종적으로 a b c는 각각 얼마인가?
        
       System.out.printf("%d/ %d/ %d\n", a, b, c );
        
	}
	
	public void ex4() {
		//비교연산자 :>, <, <=, >=, =, !=
		//-비교연산자의 결과는 항상 논리값이다.(True/false)
		//- 등호(=)가 포함된 연산자에서 등호는 항상 오른쪽!
		//같다 기호는 =, == 어떤것?
		// -> ==
		//왜? 등호 1개 (=) 대입연산자로 사용 
		//		--> 두분을 위해서 두개(==)를 같다는 의미로 사용
	
		
		int a = 10;
		int b = 20;
		
		System.out.println(a > b); 					//false
		System.out.println(a < b);	 				//true
		System.out.println(a != b); 				//true
		System.out.println(a == b); 				//false
		System.out.println((a == b) == false); 		//false
		
		
		System.out.println("----------------");
		
		int c = 4;
		int d = 5;
		
		System.out.println(c < d);    //t
		System.out.println(c+1 <= d);    //t
		System.out.println((++c != d)==(--c != d));    //f
		   					//(++4 = 5) -> f
							//				(--5 !=5)-> t
							// f      ==     t 
						    // ->f
		
		System.out.println("------------------");
	
		
		int temp = 723;
		
		System.out.println("temp는 짝수인가?" + (temp % 2 == 0 ));
		System.out.println("temp는 짝수인가?" + (temp % 2 != 0 ));

		
		System.out.println("temp는 짝홀인가?" + (temp % 2 != 1 ));
		System.out.println("temp는 짝홀인가?" + (temp % 2 != 1 ));
		
		
		System.out.println("temp는 3배수인가?" + (temp % 3 == 0  ));
		System.out.println("temp는 4배수인가?" + (temp % 4 == 0  ));
		System.out.println("temp는 5배수인가?" + (temp % 5 == 0  ));
		
	}
	
	public void ex5() {
		
		//논리 연산자 :&&(and), ||(or)
		//&&연산자 :둘다 t이면 t,나머지 f
		// 와, 그리고(~이고) ,~이면서 ,~부터, ~까지, ~사이
		//ex)사과와 바나나, 사과 그리고 바나나, 사과 이면서 바나나
				
		int a= 100;
				
		//a는 100이면서 짝수인가?
		//a는 100이상인가?
		System.out.println(a >= 100); //a는 100이상인가
		System.out.println(a %2 == 0); //a는 짝수이상인가
		
		System.out.println(a>=100&&a%2==0); //a는 짝수면서 100이상인가

		int b = 5;
		//b는 1부터 10까지 숫자범위에 포함되어있는가?
		//(b는 1부터 10 사이의 숫자인가)
		//(b는 1보다 크거나 같으면서 10 보다 작은가)
	
		System.out.println(b >= 1); //b는 1이상인가?
		System.out.println(b <= 10); //b는 10이하인가?
		System.out.println(b >= 1 && b <= 10); //b는 10이하인가?

		
		
		System.out.println("-------------------"); 
	
	
		// ||(or)연산자 둘다 f이면 f값 나머지는 t (and)반대
		//~또는, ~거나, ~이거나
		
		int c=10;

		//c는 10을 초과했거나 짝수인가?
		
		System.out.println(c > 10 || c % 2 == 0);
		
		
		
		
	}
	public void ex6() {
		
	
		// 논리부정연산자:!
		// -> 논리값을 반대로 바꾸는 연산자
		
		boolean bool1 = true;
		boolean bool2 = ! bool1; //false
			
		System.out.printf("bool1: ", bool1);
		System.out.printf("bool2: ", bool2);
	
		
		System.out.println("----------------");
		
		Scanner sc = new Scanner(System.in);
		
		//정수를 하나 입력했을 때 
		//1) 해당 정수가 1부터 1~100사이 값이 아닌지 확인
		//2) (반대) 1부터 100사이 값이 아닌지 
		
		
		System.out.print("정수 입력 : ");
		int input  =  sc. nextInt();
		
						//1 <=       input    <= 100
		boolean result  = 1 <= input && input <=100 ;
		
		System.out.printf("%d은 /는 1이상,100이하의 정수인가 : %b\n" ,result);

		
		
	                        //1미만 100초과
		boolean result2 = (input<1)||(input> 100);
		System.out.printf("%d는 1 미만, 100 초과 정수인가?  %b\n", input, result2 );
		
		
	
		boolean result3 = !(1<= input && input <=100);
		System.out.printf("%d는 1 미만, 100 초과 정수인가? %b / %b\n", input, result2, result3 );
		

	}
	
	public void ex7() {
		//복합대입 연산자 : +=, -=, *=, %=, /=
		//->피연산자가 자신과 연산 후 결과를 자신에게 대입
		
		int a=10;
		//a를 1증가
		a++; //a=a=1, a+=1
		System.out.println("a를 1증가 :"+a);//11

		
		a+=4;
		
		System.out.println("a를 4증가 :"+a);//11+4 =15

		
		//a를 10 감소 
		a-=10;
		System.out.println("a를 10감소 :"+a);//5
		//a를 3배증가 
		a*=3;
		System.out.println("a를 3배 증가 :"+a ); //15
		
		//a를 6으로 나눴을때 몫

		a /= 6;
		System.out.println("a를 6으로 나누었을 때 몫 :"+a); //2

		//a를 2로 나눴을때 나머지 
		a %= 2;
		System.out.println("a를 2로 나눴을때 :"+a);//0
		
	
	}
	
	public void ex8() {
		//삼항 연산자 : 조건식 ? 식1 : 식2
		
		//- 조건식의 결과가 t, 식1
		//조건식의 결과가 f, 식2 을 수행
		
		//* 조건식: 연산 결과가 t/f인식
//					(비교, 논리, 논리부정 연산자 포함)
		
		int num =30;
		//num이 30보다 크면(초과) "num은 30 보다 큰 수이다"
//		아니면 "num은 30이하의 큰 수 이다" 출력
		String str1 = "num은 30 보다 큰수 이다";
		String str2 = "num은 30 이하의 수 이다";
		
		
		String result =num > 30 ? str1 : str2;
		 
		 
		 			//조건식 ? 식1 :식2 
		 			//        t  : F
		//num값이 30을 초과하면  t
		//num값이 30을 초과하지 못하면   식2
		//result 변수에 저장

		 
		System.out.println(result);
		System.out.println("=============");
				 
				 
		//입력 받은 정수가 음수인지 양수인지 구분
		//단,0은 양수 처리
			
		//ex)
		//정수 입력: 4
		//양수입니다
			 		
			 		
		//정수 입력: -5
		//정수입니다 
		 
		Scanner sc = new Scanner(System.in);
		 
		System.out.println("정수입력 :");
		 
		int input = sc.nextInt();
		String str3  = "양수입니다";
		String str4  = "음수입니다"; //코드 간소화

		String result2 = input >= 0? str3  : str4;
		System.out.println(result2);
		
	}


}
