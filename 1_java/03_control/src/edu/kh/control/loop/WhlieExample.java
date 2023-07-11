package edu.kh.control.loop;

import java.util.Scanner;

public class WhlieExample {

	
	/*While문 
	 * - 별도의 초기식, 증감식이 존재하지 않고
	 * 	반복 종료 조건을 자유롭게 설정하는 반복문  
	 * 
	 ***확실히 언제 끝날지는 모르지만 
	 *언젠간 반복 조건 false가 되는 경우 반복을 종료함 
	 *
	 * 
	 * [작성법]
	 * while(조건식){
	 * 	조건식이 true일 때 반복수행할 구문
	 * } 
	 * 
	 */
	
	public void ex1() {
		
		Scanner sc = new Scanner(System.in);
		int input =0;
		
		while(input != 9) {
			
		
			System.out.println("====메뉴 선택=======");
			System.out.println("1. 돈까스");
			System.out.println("2. 김치찌개");
			System.out.println("3. 삼겹살");
			System.out.println("9. 종료");
			
			
			System.out.print("메뉴선택>>");
			input = sc. nextInt();
					
			//input 따라서 case 선택
			switch(input) {
			case 1 : System.out.println("돈까스를 주문했습니다"); break;
			case 2 : System.out.println("김치찌개를 주문했습니다"); break;
			case 3 : System.out.println("삼겹살를 주문했습니다"); break;
			case 9 : System.out.println("메뉴 선택을 종료합니다"); break;
			
			default :System.out.println("잘못입력하셨습니다");
			}
		}
		
	}
	
	public void ex3() {
		//입력 되는 모든 정수의 합 구하기
		//단, 0이 입력 되면 반복 종료 후 결과 출력
		//-> 0이 입력 되지 않으면 반복
		
		Scanner sc = new Scanner(System.in);
		int input = 0 ;  //입력 받을 값을 저장할 변수 
		
		int sum = 0;  //모든 정수의 핪을 저장하는 변수
		
		//2) while문을 최소 한번 수행하는 반복문
		//		-> do ~ while문
		do {
		
			System.out.print("정수입력 : ");
			input = sc.nextInt();
			
			sum += input; //입력 받은 값을 sum에 누적
		
		}while (input != 0);
				
			System.out.println("합계 : "+ sum);
	}
	
	
	
	public void ex2() {
		//입력 되는 모든 정수의 합 구하기
		//단, 0이 입력 되면 반복 종료 후 결과 출력
		//-> 0이 입력 되지 않으면 반복
		
		Scanner sc = new Scanner(System.in);
		int input = -1 ;  //입력 받을 값을 저장할 변수 
		// 1)0이 아닌 값을 대입하여 while문이 처음에 수행 될 수 있도록 함
		
		int sum = 0;  //모든 정수의 핪을 저장하는 변수
		
		while (input != 0) {
			
			System.out.print("정수입력 : ");
			input = sc.nextInt();
			
			sum += input; //입력 받은 값을 sum에 누적
		
		}
		
		System.out.println("합계 : "+ sum);
	}
	
}
