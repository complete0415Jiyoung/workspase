package edu.kh.array2.ex;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArryExample2 {
	
	
	
	/*2차원 배열 \
	 * - 자료형이 같은 1차원 배열을 묶음으로 다루는 것
	 * -> 행,열 개념 추가
	 * 
	 */

	public void ex1() {
		
		//2차원 배열 선언
		int [][] arr;
		//int 2차원 배열을 참조하는 참조 변수 선언
		//(참조형 == 참조변수 == 레퍼런스 == 레퍼런스 변수)
	
		
		
		//2차원 배열 할당
		//new 자료형 [행크기] [열크기]
		
		arr = new int[2][3];
		//heep영역에 int 2차원 배열 2행 3열 공간을 할당(생성)
		
		
		//2차원 배열 초기화
		
		//1)행, 열 인덱스를 이용해 직접 초기화
		/*arr[0][0] = 10;
		arr[0][1] = 20;
		arr[0][2] = 30;
		
		arr[1][0] = 40;
		arr[1][1] = 50;
		arr[1][2] = 60;
		*/
		
		//이중 for문 이용한 초기화 
		int num= 10;  //배열 요소 초기화에 사용할 변수 
		
		//* 배열의 길이 
		//-> 배열명 .length는 변수가 직접 참조하고 있는 배열의 길이를 반환
		
		System.out.println(arr.length); //2(행의 길이)
		//arr이 참조하고 있는 2차원 배열의 행의 길이 
		System.out.println(arr[0].length); //3(열의 길이)
		//arr[0] 행이 참조하고 있는 1차원 배열(열)의 길이
		System.out.println(arr[1].length); //3(열의 길이)
		//arr[1] 행이 참조하고 있는 1차원 배열(열)의 길이
		
		
		
		for(int row = 0 ; row < arr.length; row++) {   //행 반복(0,1)
			
			for (int col= 0 ; col < arr[row].length ; col++ )	{//열 반복 (0,1,2)
				
				arr[row][col] = num;
				
				num += 10; // 10씩 증가 
				
				
				System.out.print(arr[row][col]);
			}
		System.out.println();
		}
		
		//Arrays.toString(배열명) : 참조하고 있는 1차원 배열의 값을 문자열로 반환
		System.out.println(Arrays.toString(arr));
		
		//Arrays.deepToString(배열명)
		//- 참조하고 있는 배열의 데이터가 나오는 부분까지 파고 들어가서 
		//  모든 값을 문자열로 반환
		System.out.println(Arrays.deepToString(arr));
		
		
		
	}
	
	public void ex2() {
		//2차원 배열 선언과 동시에 초기화
		
		//3행 3열 까지 선언과 동시에 
		//1~9까지 초기화 
		
		
		int [][] arr = { {1,2,3},
						 {4,5,6},
						 {7,8,9}  };
		
		
		//행 별로 합 출력
		
		for( int row = 0 ; row < arr.length ; row++ ) { //행 반복
			int sum =0;
			
			for(int col =0 ; col < arr[row].length ; col++) { //열 반복
				
				sum += arr[row][col]; //현재 행의 모든 열 값을 누적
				
			}
			System.out.printf("%d행의 합 : %d \n", row ,sum);
			
		}
		System.out.println("========================");
		
		//열별로 합 출력 
		// -> 열 부터 지정 후 각 행의 값 누적
		// -->  완전한 사각형의 상태를 지닌 2차원 배열은
		//		모든 열의 길이가 같다
	
		
		for( int col =0 ; col < arr[0].length; col++){//열 반복
			int sum = 0; 
			
			for(int row =0;row < arr.length; row++){
				
				sum += arr[row][col];
				//			0    0
				//			1	 0
				//	  		2	 0
				// 			0	 1
				//			1	 1
				//			2	 1
				//			0	 2
				//			1	 2
				//			2	 2

			
			}
			System.out.printf(" %d 열의 합 : %d \n", col, sum);
		
		}
		
		System.out.println("========================");
		
		int sum = 0;
		for (int row = 0 ; row < arr.length ; row++) { //행 반복 
			for( int col = 0 ; col < arr[row].length; col++) { //열 반복 

				sum += arr[row][col];
		
			}
		}
		System.out.println("전체 합 : "+ sum);
		
	}
	
	public void ex3() {
		//가변 배열 
		// -2차원 배열 생성시 마지막 배열 차수(열)를 지정하지 않고
		// 나중에 서로 크기가 다른 1차원 배열을 생성하고 참조하는 배열
		
		
		char[][] arr = new char [4][];
					//char 2차원 배열 생성시 행 부분 만 생성 
		arr[0] = new char [3]; //0행에 3열 짜리 1차원 배열을 생성하여 주소 값을 저장 
		arr[1] = new char [4]; //1행에 4열 짜리 1차원 배열을 생성하여 주소 값을 저장 
		arr[2] = new char [5]; //2행에 5열 짜리 1차원 배열을 생성하여 주소 값을 저장 
		arr[3] = new char [2]; //3행에 2열 짜리 1차원 배열을 생성하여 주소 값을 저장 
		
		//각 배열 요소에 'a'부터 차례대로 대입
		
		
		char ch = 'a';
		for( int row = 0 ; row < arr.length; row++) { //행
			for( int col =0 ; col < arr[row].length; col++) { //열
				arr[row][col] = ch++;
						System.out.print(arr[row][col]);
			}
			System.out.println();
		}
		
		}
		//System.out.println(Arrays.deepToString(arr));
}


















