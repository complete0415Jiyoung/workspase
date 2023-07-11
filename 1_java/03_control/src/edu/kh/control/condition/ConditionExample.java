package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionExample {

	public void ex1() {
		//if문 
		//조건식이 true 일때만 내부코드, 수행
		
		/*
		 * [작성법]
		 * if(조건식){ 조건식에 부합할 때 수행
			}else if {조건식 아닐 때
			}else{둘다 아닐때	
			}
		 */
		
	
	
	 	Scanner sc = new Scanner(System.in);
		
		System.out.print("정수입력 :");
		int input = sc. nextInt();
		
		// 입력된 정수가 양수 인지 검사
		if(input > 0) {
			System.out.println("양수 입니다.");
			
			
		}else if(input <= 0) {
				System.out.println("양수가 아닙니다.");
		
		}

		
	
	
	}
	public void ex2() {
		
		//if - else 문 
		//-조건식의 결과가 true 이면 if문 수행
		//false 이면 else문 수행
		
		
		/*
		 *  if (조건문){
		 *  조건식이 t일때 수행 코드 구문
		 *  } else {f일때 수행 코드구문
		 *  }
		 *  
		 */
		
		Scanner sc = new Scanner(System.in);
		
		//홀짝 검사
		
		System.out.println("정수입력:" );
		int input = sc. nextInt();
		
		 if ( input % 2 != 0) {
			 System.out.println("홀수입니다");
			 
		 }else {                   //짝수 또는 0입력 시 수행
			 System.out.println("홀수가 아닙니다");
		
			 //**중첩 if문**
			 if (input == 0) {
			 System.out.println("0입니다");
		
			 }else {
			 System.out.println("짝수입니다");
		 }
	  	 }
	}
		  
		 
	public void ex3() {
		 
		Scanner sc = new Scanner(System.in);
		 
		 System.out.println("정수입력:" );
		 int input = sc. nextInt();
		 
		 if (input> 0 ) {                //input 양수일경우
			 System.out.println("양수입니다");
			 
		 }else if(input <0) {           //input이 음수일경우
			 //바로 위에 있는 if문이 만족되지 않는 경우 수행
			 System.out.println("음수입니다");
			 
		 }else{                        //모든 if/ else if 만조 안되는 경우
		 System.out.println("0입니다");
		 }
	}

		 


	public void ex4() {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.print("달 입력 :" );
		int month = sc.nextInt();
		
		 String season;

		 	//봄 : 3, 4, 5
		if(month == 3 || month == 4 || month == 5 ) {
			season = "봄";
			
			//여름 : 6, 7, 8
		}else if (month >= 6 && month <=8) {
			season = "여름";
			
			//가을 : 9,8,10, 11
		}else if (month >=9 && month <=11) {
				season = "가을";
				
			//겨울 : 12, 1, 2	
		}
		else if (month ==12||month ==1||month ==2) {
			season = "겨울";
			
		}else {
			//해당하는 계절이 없는 경우 "해당하는 계절이 없습니다." 출력
			//if,else if가 보두 f인경우
			season = "해당하는 계절이없습니다";
		}
		System.out.println(season);
	
	}
		
	
	

	public void ex5() {
		//나이를 입력 받아 
		//13세 이하면 "어린이입니다"
		//13세 초과 19세면 이하 면 :"청소년 입니다."
		//29세 초과 시 "성인입니다."
		
		/*Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 :" );
		int  age = sc.nextInt();
		
		//방법 1
		if(age<=13) {
			System.out.println("어린이입니다");
		
		}else if(age>=19){
			System.out.println("성인 입니다.");  
		
		}else { 
		
			System.out.println("청소년 입니다.");
		}*/
		
		
		
		//방법 2
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 :" );
		int  age = sc.nextInt();
		
		if(age<=13) {
			System.out.println("어린이입니다");
			
		}else if(age<=19){						
			System.out.println("청소년 입니다.");  //앞에서 13이하 걸러짐
		
		}else { 
			System.out.println("성인 입니다.");
		}
	}
	
	public void ex6() {
		// 점수(100점 만점)를 입력 받아
		// 90점 이상 : A
		// 80점 이상 90점 미만 : B
		// 70점 이상 80점 미만 : C
		// 60점 이상 70점 미만 : D
		// 60점 미만 : F
		// 0점 미만, 100 초과 : "잘못 입력하셨습니다"
		
		//방법1	-> 내 풀이
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 (0~100): " );
		int score = sc.nextInt();

		String result;
		
		if(score >= 90) {
			result= "A";
		
		}else if(score>=80){					
			result= "B";

		}else if(score>=70){						
			result= "C";	
		
		}else if(score>=70){						
			result= "D";
		
		}else if(score<60 && score>70){						
			result= "F";
		
		}else { 
			result= "잘못입력하셨습니다";
		}
		System.out.println(result);
		}

	
		
		//방법2   -> 선생님 풀이
		/*Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 (0~100): " );
		int score = sc.nextInt();
	   
	    String result; 
		
		  
		if(score < 0 || score > 100 ) {
			result= "잘못입력하셨습니다";
			
		}else if(score>=90){						
			result= "A";
			
		}else if(score>=80){						
			result= "B";
			
		}else if(score>=70){						
			result= "C";
			
		}else if(score>=60){						
			result= "D";
			
		}else { 
			result= "F";
		}
		
		System.out.println(result);
	}*/
			
		
		
	public void ex7() {
		// 놀이기구 탑승 제한 검사
	      
	    // 나이가 12세 이상, 키 140.0cm 이상 일 경우에만 "탑승 가능"
	    // 나이가 12미만인 경우 : "적정 연령이 아닙니다."
	    // 키가 140.0cm 미만 : "적정 키가 아닙니다."
	    // 나이를 0세 미만, 100세 초과 시 : "잘못 입력 하셨습니다."	
			
		
		//방법 1  -> 선생님 풀이
		Scanner sc = new Scanner(System.in);
			
			
		System.out.println("나이 입력 :" );
		int age = sc.nextInt();
		    
		System.out.println("키 입력 : " );
		double  height = sc.nextDouble();
		    
		String result; 
		    
		if(age < 0 || age < 100) {     
		result = "잘못 입력 하셨습니다";
		    	
		}else { 
		if (age >= 12) {
		    	result = "적정 연령이 아닙니다.";
			
		}else {
			if(height < 140.0) {
			result = "적정 키가 아닙니다.";
		
		}else {
		result = "탑승 가능";
		}
		}
		}System.out.println(result);
	}
			
		/*Scanner sc = new Scanner(System.in);
		
		System.out.println("나이 입력 :" );   //-> 선생님 풀이
	    int age = sc.nextInt();
	    String result; 
	    
	    if(age <= 0 || age < 100) {          
	    	result = "잘못 입력 하셨습니다";
	    
	    }else { 
	    	 System.out.println("키 입력 :" );
	    	 double  height = sc.nextDouble();
	    	
	    	if (age < 12) {
	    		result= "적정 연령이 아닙니다.";
	    		
	    	}else if(height<140.0) {
	    		result= "적정 키가 아닙니다.";
	    		
	    	} else{ 
		    	result= "탐승가능";
	    	}
	    	System.out.println(result);
	     }
		}*/

		
		
		
 public void ex8() {
	  // 놀이기구 탑승 제한 검사 프로그램
      // 조건 - 나이 : 12세 이상
      //     -  키 : 140.0cm 이상
      
      // 나이를 0~100세 사이로 입력하지 않은 경우 : "나이를 잘못 입력 하셨습니다."
      // 키를 0~250.0cm 사이로 입력하지 않은 경우 : "키를 잘못 입력 하셨습니다."
      // -> 입력이 되자 마자 검사를 진행하여 잘못된 경우 프로그램 종료
      
      // 나이 O , 키 X : "나이는 적절하나, 키가 적절치 않음";
      // 나이 X , 키 O : "키는 적절하나, 나이는 적절치 않음";
      // 나이 X , 키 X : "나이와 키 모두 적절치 않음";
      // 나이 O , 키 O : "탑승 가능"
	
		Scanner sc = new Scanner(System.in);     //-> 선생님 풀이
		
		System.out.println("나이 입력 :" );
		int  age = sc.nextInt();
		String result; 
		//double  height;
 	    	
		
 	    if(age<0 || age>100) {
	    	result= "나이를 잘못 입력 하셨습니다";
	    	
	 	 } else{
	 		System.out.println("키 입력 :" );
 		  	double height = sc.nextDouble();
 		  	
 		  	if (height < 0 || height>250.0) {
	    		result= "키를 잘못 입력 하셨습니다";
 		  
 		  	}else{ 
 		  		
 		  		if (age < 12 && height >= 140.0) {  //나이o,키o
 		  			result= "키는 적절하나 나이가 적절하지 않음.";
 		  		
 		  		}else if(age >= 12 && height < 140.0) {  //나이o, 키x
 	    			result= "나이는 적절하나 키가 적절하지 않음.";
 		  		
 		  		}else if(age < 12 && height < 140.0) {  //나이x, 키x
 	    		result= "나이와 키 모두 적절하지 않음.";
 		  		
 		  		} else{ 
 		    	result= "탑승가능";
	 	    	}
	 		  }
	 	   	}
 	   
			System.out.println(result);
	    	
	    	}
	    	}
	     
