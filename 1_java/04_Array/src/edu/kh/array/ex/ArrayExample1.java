package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample1 {

	/*배열 (Array)
	 * -같은 자료형의 변수를 하나의 묶음으로 다루는 것(자료구조)
	 * 묶여진 변수들은 하나의 배열명으로 불러지고
	 * 구분은 Index를 이용 함 (index는 0부터 시작하는 정수)
	 * 
	 */
	

	public void ex1() {
		
		//변수 vs 배열
		
		//1-1. 변수 선언 
		int num;
		//stack영역에 int자료를 저장할 수 있는 공간 4바이트를 생성(할당)하고
		//그 공간에 num이름을 부여 
		//1-2. 변수 대입 
		num = 10;
		//생성된 num이라는 변수 공간에 10을 대입
		
		//1-3. 변수 사용 
		System.out.println("num에 저장된 값 = " + num);
		//num이 작성된 자리에 num에 저장된 값을 읽어와서 출력
		//===========================================
		
		//2-1. 배열 선언 
		int [] arr;
		//stack 영역에 int [] (int 배열) 자료형 8byte을 할당하고
		//그 공간에 arr이라는 이름을 부여
		//***해당 변수는 참조형으로 주소값 (8byte)만을 저장할 수 있다
		
		//2-2. 배열 할당 
		arr = new int [3];
		
		//new :"new연산자"라고 하며 
		//		Heep메모리 영역에 새로운 공간 (배열, 객체)을 할당 
		
		//int[3] : int 자료형 변수3개를 하나의 묶음으로 나타내는 배열
		
		//new int [3] : heep 영역에 int3 칸 짜리 int[]을 생성(할당)
		//				**생성된 int[]에는 시작 주소가 지정 !!
		
		//arr     =  new int[3];
		//(int[])	 (int[]) -> 같은 자료형 == 연산가능
		
		//Heep영역에 생성된 int[]의 시작주소를
		//stack영역에 생성된 arr 변수에 대입 
		
		//-> arr변수가 int[]참조하게 됨!
		//		(그래서 arr을 참조형이라고 한다)
		
		
		//2-3. 배열 요소 값 대입
		//arr은 int[] 참조형 변수 이지만
		//arr[]0 int 자료형 변수기 때문에 정수 값을 대입할 수 있다.
		//(int [])arr = (int [])10;  //형변환은 기본형끼리만 가능 
		arr[0] = 10;
		arr[1] = 50;
		arr[2] = 100;
		
		
		//2-4. 배열 요소 값 읽어오기
		System.out.println(arr[0]);//arr이 참조하고 있는 배열의 0번 indexd의 값을 읽어옴 
		System.out.println(arr[1]);//arr이 참조하고 있는 배열의 1번 indexd의 값을 읽어옴 
		System.out.println(arr[2]);//arr이 참조하고 있는 배열의 2번 indexd의 값을 읽어옴 
		
		System.out.println("arr의 주소 = "+arr);
		
	}
	
	
	
	public void ex2() {
		
		//배열의 선언 및 할당 
		int[]arr = new int[4];
		//선언과 할당을 한줄로 할 수 있음.
		
		//1) stack영역에 int[]자료형 참조변수 arr선언
		//2) Heep영역에 int자료형 4개를 다루는 int []할당
		//3) 생성된 int[]의 주소을 arr에 대입하여
		// 	참조하는 형태를 만든다.
	
		
		//배열의 길이 (몇칸인가?) : 배열명, lenght
		System.out.println("배열의 길이 : "+ arr.length);
		
		arr[0]=100;
		arr[1]=200;
		arr[2]=500;
		arr[3]=1000;
		
		//배열과 for문
		//i == index
		for(int i = 0 ; i < arr.length; i++) {
			//0 ~ arr 배열 길이 미만
			System.out.printf("arr[%d]에 저장된 값 :%d\n", i, arr[i]);
		}
		//참고지만 알고 있는게 좋음 
		
		//비어있다 : stack영역에 선언된 변수에 값이 대입 되지 않음 
		
		//null: 참조형 변수가 선언 되었으나 아무것도 참조 하지 않음
		//				(빈칸아님!!)
		
		//0 :int 자료형 0(확실히 존재한 값)
		
		//" " :String 자료형이지만 내용 없음(빈 문자열)
	}
	
	
	
	public void ex3() {
	
		// 5명의 키(cm)를 입력 받고 평균 구하기
		      
		// 1번 키 입력 : 170.5
		// 2번 키 입력 : 165.7
		// 3번 키 입력 : 184.3
		// 4번 키 입력 : 190.2
		// 5번 키 입력 : 174.4
		  
		// 입력 받은 키 : 170.5  165.7  184.3  190.2  174.4
		// 평균 : 177.02cm
		
		Scanner sc = new Scanner(System.in);
		
		double [] height = new double[5];
		
		//double[]자료형 참조 변수 height를 stack영역에 생성하고
		//Heep 영역에 새로 생성된 double 5칸 자리를 double[]의 시작 주소를 대입 height에 대입
		
		for (int i =0 ; i < height.length; i++ ) {
		System.out.print((i+1)+"번키 입력  : ");	
		//height = sc.nextDouble();
		//ype mismatch: cannot convert from double to double[] 
		//		-> 배열은 참조형임으로 형변환이 되지않음
		
		height[i] = sc.nextDouble();
		//각 인덱스에 입력 받은 값을 대입 (초기화)
		}
		System.out.println();//줄바꿈
		
		
		
		// 평균 합계 / 합계에 더해진 값 수
		double  sum= 0; 
		System.out.println("입력 받은키  : ");
		
		for( int i=0; i < height.length; i++) {
			System.out.printf(height[i]+ " ") ;
		
		sum  += height[i]; //배열에 저장된 값을 sum에 누적
		
		}
		System.out.printf("\n 평균 : %2f\n ", sum / height.length);
		
		
		
		
		
	}
	public void ex4() {
		// 입력 받은 인원 수 만큼의 점수를 입력 받아 배열에 저장
		// 입력이 완료되면 점수 합계, 평균, 최고점, 최저점 출력
		  
		// ex)
		// 입력 받을 인원 수 : 4
		// 1번 점수 입력 : 100
		// 2번 점수 입력 : 80
		// 3번 점수 입력 : 50
		// 4번 점수 입력 : 60
		  
		// 합계 : 290
		// 평균 : 72.50
		// 최고점 : 100
		// 최저점 : 50
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 받을 인원수 : ");
		int input = sc.nextInt();
		
		//배열 선언 및 할당
		//할당할 배열의 크기는 입력 받은 크기 만큼 ( input)
		int[] score = new int [input];
		int  sum=0 ;  //합계 저장 변수 
		
		for( int i = 0; i < score.length ; i++ ) {
			System.out.print((i +1)+ "번 점수 입력 : " );
			score[i] = sc.nextInt();
			sum += score[i];   //점수 받자마자 sum에 입력
			
			
		}
		//최고 최저점 구하기 
		int max = score[0]; 
		int min = score[0];
		
		//아래의 for문을 이용해 score 배열에 있는 모든 값과 max, min을 비교 
		
		//이 때,
		//score[i]값이 max보다 크면 max에 대입 
		//score[i]값이 min보다 작으면 min에 대입
		
		for(int i= 0; i <score.length; i++) {
			if ( score[i] > max ) {//최고점 비교 
				max = score[i];
			}else if( score[i] < min ) { //최저점 비교
				min = score[i];
			}
			
		}
		System.out.println("합계 : "+ sum);
		System.out.printf("평균 : %.2f \n", (double)sum/ score.length);
		System.out.println("최고점 : "+ max);
		System.out.println("최고점 : "+ min);
		
	}

	public void ex5() {
	
	//배열 선언과 동시에 초기화 
	char []arr= new char[5];
	
	//char []arr이 참조하는 배열 요소 A,B,C,D,E 대입 
	for(int i= 0 ; i < arr.length ; i++) {
		arr[i]= (char) ('A' + i);
		 
		//A ==65
		//B ==66
		//C ==67
		//char : 문자열이 숫자로 저장 됨!
	}
	
	//**Arrays클래스 
	//-> 자바에서 제공하는 배열과 관련된 기능을 모아둔 클래스
	int[] arr2 = new int [4];
	System.out.println(arr2); //[I@6f2b958e -> 주소
	
	
	
	//Arrays. toString (배열명) 모든 요소 값을 출력 
	System.out.println(Arrays.toString(arr2));  //-> 인덱스에 대입 안함 
	System.out.println(Arrays.toString(arr));   //-> 인덱스에 for 문으로 대입 안함 
	
	
	//배열 선언과 동시에 (할당 및 )초기화
	char[] arr3 = {'A','B', 'C', 'D', 'E'};
	
	// char [] 참조변수 arr3선언하고
	// heep 영역에 char 5칸짜리 char[]을 생성하고
	// 각각 'A','B', 'C', 'D', 'E'로 초기화 후 주소를 arr3에 대입  
	
	//{} (중괄호)는 배열의 리터럴 표기법
	
	System.out.println("arr3 길이 :" + arr3.length);
	System.out.println(Arrays.toString(arr3));
	
	
	}
	
	public void ex6() {
		
		//점심 메뉴 뽑기 프로그램 
		
		String []arr = {"김밥", "서브웨이" , "햄버거", "백반" , "국밥" , "파스타"};
		//0 ~ (배열의 길이 -1 ) 사이의 난수 발생
		System.out.println("오늘의 점심 메뉴 : " + arr[(int)(Math.random() * 6)]);
		
		//0.0 <= x < 1.0 
		//0.0 <= x*6 <6.0
		//0<= (int)(x*6) <6
		//->1,2,3,4,5
		
	}
	
	public void ex7() {
		
		//배열을 이용한 검색 
		
		// 입력 받은 정수가 배열에 있는지 없는 지 확인
		// 만약 있다면 몇번 인덱스에 존재하는지 출력
		
		
		int []arr = {100, 200, 300, 400, 500, 600, 700, 800, 900, 100}; 
	
		
		Scanner sc = new Scanner(System.in);
		System.out.print( "정수입력 : ");
		int input = sc.nextInt();
		
		
		//신호를 나타내기 위한 변수 
		//flag ==false : 일치하는 값이 존재하지 않음 
		//flag ==true : 일치하는 값 존재
		
		boolean flag = false;   //검사 전에는 없다고 가정 
		
		
		//arr 배열 요소 순차접근(반복 접근)
		
		for (int i = 0 ; i < arr.length; i++) {
			
			//arr[i]에 저장 된 값과 input이 같을 경우
			if (input == arr[i]) {
				System.out.println(i + "번째 인덱스에 존재 " );
		
				flag = true; //일치하는 값이 있으므로 true로 변경 
			}
		} 
		
		//flag 상태를 검사	
		if ( !flag) {   //false 부정은 true
			System.out.println("존재하지 않음");
		}
	}
		
	
	
	public void ex8() {
		//입력받은 값과 일치하는 값이 있으면 인덱스번호 출력
		//없으면 존재하지 않음 출력"
		
		String []arr = {"사과", "딸기", "바나나", "키위", "멜론", "아보카도 "};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("과일 입력  : ");
		String input = sc.next();
		
		
		boolean flag = false;  
		
		for( int i = 0 ; i < arr.length ;i++) {
			
			if( arr[i].equals(input)) {
				System.out.println(i + "번째 인덱스 번호에 존재");
				flag = true; 
			}
		}
		
		if (!flag) {  //flag가 false인경우
			System.out.println("존재하지 않음");
		}
	
	}
	
	
	
	public void ex9() {
		
		// 1. 문자열을 입력 받아서 한글자씩 잘라내어 char배열에 순서대로 저장
		// 2. 문자하나를 입력 받아서 일치하는 문자가 char배열에 몇개 존재하는 지 확인
		// 3. 단, 일치하는 문자가 없을 경우 "존재하지 않습니다" 출력
		
		// [사용 해야하는 기술, 기능]
		//1) 배열 검색 
		//2) String. lenght(): 문자열의 길이
		//		ex. "Hellow"  .length()-> 5
		//3)String .charAt(index): 문자열에서 특정 인덱스에 위치한 문자를 하나 얻어옴
		//  	ex)"Hellow".charAt(1)-> 'e'
		// 			01234 (인덱스 번호)
		//4) count (숫자세기)
		
		Scanner sc = new Scanner (System.in);
		System.out.print("문자열 입력 : ");
		String input = sc.nextLine();	//띄어쓰기를 포함한 한줄 입력 받기 
		 
		
		// 1. 문자열을 입력 받아서 한글자씩 잘라내어 char배열에 순서대로 저장
		char [] arr = new char [input.length()];
		 
		for( int i = 0 ; i < arr.length ; i++) {
			
			arr[i] = input.charAt(i);
			//arr[i]에 입력 받은 문자열 중 i번째에 대입 

			
		}
		//중간 검사
		//System.out.println(Arrays.toString(arr)) ;
		
		
		//2. 문자하나를 입력 받아서 일치하는 문자가 char배열에 몇개 존재하는지 확인
		System.out.print("검색할 문자 입력 : ");
		char ch = sc.nextLine().charAt(0);
					//String. charAt(0) : 문자열 제일 앞 문자 얻어오기
		
		int count = 0; //같은 글자 갯수를 세기 위한 변수
	
		for(int i = 0; i < arr.length; i++ ) {
			
			if( arr[i] == ch) { // int == char 기본형으로 == 부등호 사용
				//arr[i]값과 검색할 문자 ch가 같을 경우 
				//-> 카운트 
				
				count++;
			}
		}
		
		//결과 출력 
		if(count > 0) {
			System.out.println(count +"개 있음");
		}else {
			System.out.println("존재하지 않습니다");
		}
		//3. 단, 일치하는 문자가 없을 경우 "존재하지 않습니다" 출력
	}
	
	

//	내가 다시 풀어 보는 것	
		public void ex91() {
			
			// 1. 문자열을 입력 받아서 한글자씩 잘라내어 char배열에 순서대로 저장
			// 2. 문자하나를 입력 받아서 일치하는 문자가 char배열에 몇개 존재하는 지 확인
			// 3. 단, 일치하는 문자가 없을 경우 "존재하지 않습니다" 출력
			
			// [사용 해야하는 기술, 기능]
			//1) 배열 검색 
			//2) String. length(): 문자열의 길이
			//		ex. "Hellow/"  .length()-> 5
			//3)String .charAt(index): 문자열에서 특정 인덱스에 위치한 문자를 하나 얻어옴
			//  	ex)"Hellow".charAt(1)-> 'e'
			// 			01234 (인덱스 번호)
			//4) count (숫자세기)
			
			Scanner sc =new Scanner (System.in);
			System.out.print("문자열 입력 : ");
			String input = sc.nextLine();	//띄어쓰기를 포함한 한줄 입력 받기
			
			int count=0;
			
			// 1. 문자열을 입력 받아서 한글자씩 잘라내어 char배열에 순서대로 저장 
			char [] arr = new char [input.length()];
			for( int i = 0 ; i < arr.length ;i++) {
				
				arr[i] = input.charAt(i);
				
			}
			
			System.out.print("검색할 문자 입력 : ");
			char ch = sc. nextLine().charAt(0);
			// 2. 문자하나를 입력 받아서 일치하는 문자가 char배열에 몇개 존재하는 지 확인
			for (int i =0 ; i < arr.length ; i++) {
				if(arr[i] == ch) {
					count++;
				}
			}
		
			
			// 3. 단, 일치하는 문자가 없을 경우 "존재하지 않습니다" 출력
			
			if( count > 0 ) {
				System.out.println(count +"개 있습니다");
			}else {
				System.out.println("존재하지 않습니다");
			}
	}
}
	
