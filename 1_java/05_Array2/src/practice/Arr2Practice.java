package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Arr2Practice {
	
	public void practice1() {
		
		char [][]arr = new char [3][3];
		
		for (int row = 0; row < arr.length ; row++ ) {
			for (int col = 0 ; col < arr[row].length; col++) {
				if(row <= 2 && col <= 2) {
					//arr[row][col] = "("+ row + col+")";
					System.out.print(arr[row][col]);
					//배열에 저장 
				
				}
			}
			System.out.println();
		}
	}
	
	public void practice2() {
		
		int [][]arr = new int [4][4];
		int num = 1;
		for( int row = 0 ; row < arr.length ; row++) {
			for(int col = 0 ; col <arr[row].length; col++) {
				arr[row][col] = num++;
				System.out.printf("%3d", arr[row][col]);
			}
			System.out.println();
		}
		
		
	}
	
	public void practice3() {
		
		int [][] arr = new int [4][4];
		int num = 16;
		for( int row = 0 ; row < arr.length; row++) {
			for(int col = 0 ; col <arr[row].length; col++) {
				
				arr[row][col] = num--;
				System.out.printf("%3d", arr[row][col]);
			}
			System.out.println();
		}
	}
	
	public void practice4() {
		
		int [][]arr = new int [4][4];
		
		for ( int row = 0 ; row < arr.length-1 ; row++) { //행의 길이
			int rowSum = 0;
			
	
			for( int col = 0; col < arr[row].length ; col++ ) {  //row번째 열의 길이
				if( row < 3 && col < 3) {
					arr[row][col] = (int)(Math.random()*10+1);
					rowSum += arr[row][col];
					System.out.printf("%3d", arr[row][col]);;
				}else if (row <= 3 && col==3){
	               arr[row][col] = rowSum;
	               System.out.printf("%3d", arr[row][col]);
	
				}
			}	
			System.out.println();
		}	
		
		for (int col = 0 ; col < arr[0].length; col++) {
			int sum = 0;
			for (int row = 0; row < arr.length ; row++) {
				
				sum += arr[row][col];
				arr[row][col]= sum;
			}
			System.out.printf("%3d", arr[3][col]);
		}
				
				
//		arr[3][0] = arr[0][0]+ arr[1][0] + arr[2][0];
//		arr[3][1] = arr[0][1]+ arr[1][1] + arr[2][1];
//		arr[3][2] = arr[0][2]+ arr[1][2] + arr[2][2];
//		System.out.println(arr[3][0]);
//		System.out.println(arr[3][1]);
//		System.out.println(arr[3][1]);
		
	}

	
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("행의 크기 : ");
		int input1 = sc.nextInt();
		while ( input1 <= 0){
			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다");
			System.out.print("행의 크기 : ");
			input1 = sc.nextInt();
			
		}
		System.out.print("열의 크기 : ");
		int input2 = sc.nextInt();
		while ( input2 <= 0){
			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다");
			System.out.print("열의 크기 : ");
			input2 = sc.nextInt();
			
//	=======While 한개로 만들어 보기 가능?===========		
//		while (true){
//			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다");
//			System.out.print("행의 크기 : ");
//			input1 = sc.nextInt();
//			System.out.print("열의 크기 : ");
//			input2 = sc.nextInt();
//			
//		}
		
		
			char[][] arr= new char[input1][input2];
			
			for( int row = 0; row < input1 ; row++ ) {
				for(int col = 0 ; col < input2 ; col++) {
					
					arr[row][col] = (char)(Math.random()*26+65);
					System.out.printf("%3s", arr[row][col]);
				}
				System.out.println();
			}
		}
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("행의 크기 : ");
		int input1 = sc.nextInt();
		
		char [][] arr = new char[input1][];
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.print(i+"열의 크기 : ");
			int input2 = sc.nextInt();
			
			arr[i] = new char [input2];
		}
		
		char ch = 'a';
		
		for(int row = 0 ; row < arr.length ; row++) {
			for(int col = 0 ; col < arr[row].length ; col++) {
				
				arr[row][col] = ch++;
				System.out.printf("%3s", arr[row][col]);
			}
			System.out.println();
		}
	}
	
//===================선생님 풀이============================		
	public void practice4_() {
			
		int [][]arr = new int [4][4];
		//상수 사용법 : 변하지 않는 특정 값에 이름을 붙여줌
		//			명명규칙 대문자 사용
		final int ROW_LAST_INDEX = arr.length-1;
		final int COL_LAST_INDEX = arr[0].length-1;
		
		
		for ( int row = 0 ; row < arr.length ; row++) { //행의 반복
			
			for( int col = 0; col < arr[row].length ; col++ ) {  //열의 반복 
				
				if(row != ROW_LAST_INDEX && col != COL_LAST_INDEX) {
					
					int random = (int)(Math.random()*10 +1);  //1~10 사이 난수 생성
					
					arr[row][col] = random;
			

					//각행의 마지막 열에 난수를 누적
					arr[row][COL_LAST_INDEX] += arr[row][col];

					//arr[0][3] = arr[0][0] + arr[0][1] + arr[0][2]
					//arr[1][3] = arr[1][0] + arr[1][1] + arr[1][2]
					//arr[2][3] = arr[2][0] + arr[2][1] + arr[2][2]
					
					

					//각 열의 마지막 행에 난수를 누적
					arr[ROW_LAST_INDEX ][col] += arr[row][col];
					
					//arr[3][0] = arr[0][0] + arr[1][0] + arr[2][0]
					//arr[3][1] = arr[0][1] + arr[1][1] + arr[2][1]
					//arr[3][2] = arr[0][2] + arr[1][2] + arr[2][2]
					
					

					//생성된 모든 난수 마지막 행과 열에 누적 (총합)
					arr[ROW_LAST_INDEX][COL_LAST_INDEX] += arr[row][col];
					
					
					
				}
				
				System.out.printf("%4d", arr[row][col]);
			}//열 반복 끝 
			System.out.println();
		}//행 반복 끝
	}
	
	
	
	
//	=================선생님 풀이=========================
	public void practice5_() {
		Scanner sc = new Scanner(System.in);
		
		//무한 반복으로 수행되서 아래 코드 수행 할 수 없음
		while(true) {
			
			System.out.print("행의 크기 : ");
			int row = sc.nextInt();
			System.out.print("열의 크기 : ");
			int col = sc.nextInt();
			if(row < 1 || row > 10 ||col < 1 || col > 10) { //1~10사이의 숫자가 아닌 경우 
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다");
				
			}else {
				int [][] arr= new int [row][col];
				
				for(int i = 0 ; i < row ;i++) {
					
					for (int j = 0 ; j < col ; j++) {
					
						arr[i][j] = (int)(Math.random() * 26);
						
						
						char result = (char) (arr[i][j]+65);
						System.out.print(result +" ");
					}
					System.out.println();
				}
				break;
			}
		}
		
			
		}
		
	
	public void practice6_() {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("행의 크기 : ");
		int input = sc.nextInt();
		char result ='a';
		
		char[][] arr = new char [input][];
		
		//열 크기 정하는 for문
		for ( int i = 0 ; i < arr.length ; i++) {
			
			System.out.print(i + "열의 크기 : ");
			int col = sc.nextInt();
			
			arr[i] = new char [col];
			
		}
		//출력용 for문 
		for( int row =0 ; row <arr.length ; row++) {
			
			for(int col = 0 ; col < arr[row].length; col++) {
				
				arr[row][col] = result++;
				System.out.print(arr[row][col] +" ");
			}
		}
		
		
	}

	
	// 작성된 코드가 틀린 이유와 출력 값이 왜 저렇게 나오는지 이유
	// 2열 2행까지 구하는 값에 대한 if문 조건식을 만들고  
	// 복합연산자 사용해서 마지막 행과 열에 누적해야함
	// 해결 방법 
	public void homeWork() {
	      int[][] arr = new int[4][4];
	      
	      //final 상수 
	      int rowsum = arr.length-1; //3
	      int colsum = arr[0].length -1; //3
	      
	      for(int row=0; row < arr.length; row++) { //행의 반복 
	         for(int col=0; col < arr[row].length; col++) { //열의 반복 
	        	 //if문 사용 2열 2행까지의 조건문을 만들기
	        	 if(row != rowsum && col != colsum) {

		        	arr[row][col] = (int)(Math.random()*10+1);
		            //1~10사이의 난수을 생성하고 2열 2행 까지 생성된 난수 대입 
		        	
		        	//각 열의 마지막 행에 난수를 누적
		            arr[rowsum][col] += arr[row][col];
	               //arr[3][0] = arr[0][0] + arr[1][0] + arr[2][0]
	               //arr[3][1] = arr[0][1] + arr[1][1] + arr[2][1]
	               //arr[3][2] = arr[0][2] + arr[1][2] + arr[2][2]

	
		            //각 행의 마지막 열에 난수를 누적 
		            arr[row][colsum] += arr[row][col];
	               //arr[0][3] = arr[0][0] + arr[0][1] + arr[0][2]
	               //arr[1][3] = arr[1][0] + arr[1][1] + arr[1][2]
	               //arr[2][3] = arr[2][0] + arr[2][1] + arr[2][2]

		            
		           //생성된 모든 난수 마지막 행과 열에 누적 (총합)
		           // 복합대입연산자 += 사용 
		           arr[rowsum][colsum] += arr[row][col];
	        	 }
	        	 System.out.printf("%3d" , arr[row][col] );
	         }
	         System.out.println();
	      } 
	   }
	
	
	public void practice9(){
//		String 2차원 배열 6행 6열을 만들고 행의 맨 위와 제일 앞 열은 각 인덱스를 저장하세요.
//		그리고 사용자에게 행과 열을 입력 받아 해당 좌표의 값을 “X”로 변환해 2차원 배열을 출력하세요.
//		[실행 화면]
//		행 인덱스 입력 : 4
//		열 인덱스 입력 : 2
//		0 1 2 3 4
//		0 
//		1
//		2
//		3
//		4 X
		
		
		
		Scanner sc = new Scanner(System.in);
		
		String [][] arr= new String[6][6] ;
		
		System.out.print("행 인덱스 입력: ");
		int rowIndex = sc.nextInt();
		
		System.out.print("열 인덱스 입력: ");
		int colIndex = sc.nextInt();
		
		int num1= 0;
		int num2= 0; 
		
		for(int row =0 ; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				
				if(row ==0 && col!=0) {
					arr[row][col] = num1++ +" ";
					
				}else if(col ==0 && row != 0) {
					arr[row][col] = num2++ + " "; 
					System.out.println();
				}else {
					arr[row][col]="  ";
					arr[rowIndex][colIndex+1] ="X";
				}
				System.out.print(arr[row][col]);
			}
		}System.out.println();
		
	}
	
	public void practice9_0() {
		Scanner sc = new Scanner(System.in);
		
		String[][] arr = new String[6][6];

		System.out.print("행 인덱스 입력 : ");
		int rowNum = sc.nextInt();
		System.out.print("열 인덱스 입력 : ");
		int colNum = sc.nextInt();
		
		arr[rowNum][colNum] = "X";
			
		System.out.println("  0 1 2 3 4");
		for (int row = 0; row < arr.length - 1; row++) {
			System.out.print(row + " ");
			for (int col = 0; col < arr[col].length - 1; col++) {
				if (arr[row][col] == arr[rowNum][colNum])
					arr[row][col] = "X";
				else
					arr[row][col] = " ";
				System.out.print(arr[row][col] + " ");
			}
			
			System.out.println();
		}

	}
	
	public void practice10(){
//			메소드 명 : public void practice10(){}
//			실습문제9와 내용은 같으나 행 입력 시 99가 입력되지 않으면 무한 반복이 되도록 구현하세요.

			
			
			
	
		Scanner sc = new Scanner(System.in);
		System.out.print("행 인덱스 입력: ");
		int rowIndex=0;
		int colIndex =0;
		
		while(true) {
			rowIndex = sc.nextInt();
			String [][] arr= new String[6][6] ;
			
			
			if(rowIndex == 99) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.print("열 인덱스 입력: ");
				colIndex = sc.nextInt();
				
				int num1= 0;
				int num2= 0; 
				
				for(int row =0 ; row<arr.length; row++) {
					for(int col=0; col<arr[row].length; col++) {
						
						if(row ==0 && col!=0) {
							arr[row][col] = num1++ +" ";
							
						}else if(col ==0 && row != 0) {
							arr[row][col] = num2++ + " "; 
							System.out.println();
						}else {
							arr[row][col]="  ";
							arr[rowIndex][colIndex+1] ="X";
						}
						System.out.print(arr[row][col]);
					}
				}System.out.println();
				
		
				System.out.print("행 인덱스 입력 >> ");
				System.out.println();
			}
		}
	}
	
	public void bingGoGame(){

		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("빙고판 크기 지정 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		// 1차원 배열로 빙고판에 입력될 값 생성 + 중복 제거 진행
		int[] tempArr= new int[num*num]; //1차원 배열 생성 
		//num*num -->빙고판의 크기는 가로, 세로의 곱만큼의 공간이 필요함 
		
		//중복값 제거하면서 랜덤값 넣기 
		for(int i =0; i<tempArr.length; i++) {
			tempArr[i] =(int)(Math.random()*(num*num))+1;
			
			//중복 제거 
			for(int j=0; j<i; j++) {
				if(tempArr[i] == tempArr[j]) {
					i--;
					break;
				}
			}
		}
		
		//위에서 만들어진 중복 제거한 1차원 배열--> 2차원 배열에 넣기
		//String 배열로 변경해서 대입 진행
		//왜 String 뱅열? 빙고가 된 부분을 "★"로 변경하기 위해서 
		String[][] binggoBoard = new String[num][num];
		
		int index =0 ;//1차원 배열 인덱스 지정을 위한 변수
		
		for( int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				//1차원 배열은 0번 부터 num*num까지 반복진행
				
				binggoBoard[i][j] = tempArr[index] + "";
				index++;
			}
		}
						
		//---------------------------------------------------------
		
		//램덤 비치된 빙고판 최초 1회 출력 
		for(int i=0; i<binggoBoard.length; i++) {
			for(int j =0; j<binggoBoard[0].length; j++) {
				System.out.printf("%4s", binggoBoard[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("============빙고 게임 시작============");
		while(true) {
			System.out.println("정수를 입력하세요: ");
			String input =sc.nextLine();
			
			boolean flag = true; //검색된 값이 빙고판에 있는지 확인( 잘못입력 확인
			
			for(int i = 0; i <binggoBoard.length; i ++) {
				for(int j=0; j < binggoBoard[0].length; j++) {
					
					//입력된 값과 일치하는 ★ 형태로 변환
					if( binggoBoard[i][j].equals(input)) {
						binggoBoard[i][j] ="★";
						flag = false;
					}
					System.out.printf("%4s",binggoBoard[i][j]);
				}
				System.out.println();
			}
			if(flag) {
			System.out.println("잘못입력하셨습니다 다시입력하세요");
			continue;
			}
			//빙고 판의 크기에 따라 
			//빙고 기준이 되는 문자열 생성
			//ex) 5*5 크기 빙고 -> 한 줄이 "★ ★ ★ ★ ★"이면 빙고 
			String bingoLine="";
			for(int i= 0; i<num; i++) {
				bingoLine +="★";
				
			}
			
			//빙고 검사 
			int bingCount = 0; //빙고 수를 저장 할 변수 
			
			//가로(행) 또는 세로(열) 문자열을 더하여 하나의 문자열로 저장
			//--> 저장된 문자열의 모양이"★ ★ ★ ★ ★"이면 빙고
			//--> binggoCount 증가 
			
			for(int i=0; i<binggoBoard.length;i++) {
				//매 반복 시 마다 row 와 col을 빈 문자열로 초기화 
				//-->바깥쪽 for문이 반복 될 때마다 검사하는 행과 열이 이동하무로 
				// 빙고 여부를 검사하기 위해 row,col을 빈 문자열로 초기화 해야함
				String row ="";
				String col ="";
				for(int j=0; j<binggoBoard.length;j++) {
					row += binggoBoard[i][j]; //현재 행의 문자를 모두 더함 
					
					//i,j(행렬)를 반대로하여 열의 모둔 문자를 더함
					col += binggoBoard[j][i];
				
				}
				if(row.equals(bingoLine)) {
					bingCount++; //가로 빙고가 존재할 경우
				}
				if(col.equals(bingoLine)) {
					bingCount++; //세로 빙고가 존재할 경우
				}
			}
			
			// 대각선 빙고 여부
			// 대각선 : diagonal
			
			// 대각선은 빙고판에 2개만 존재 
			//--> 대각선 문자를 더해서 저장할 변수 선언 및 빈 문자열로 초기화 
			String dia1= "";
			String dia2= "";
			
			for(int i =0; i< binggoBoard.length; i++) {
				dia1 += binggoBoard[i][i]; //죄상 우하
				
				dia2 += binggoBoard[binggoBoard.length-1 -i][i]; //우상 좌하  
			
			}
			if(dia1.equals(bingoLine)) {
				bingCount++;
			}
			if(dia2.equals(bingoLine)) {
				bingCount++;
			}
			
			//빙고 카운트 출력
			System.out.println("현재 "+ bingCount +"빙고");
			if(bingCount >= 3) { //빙고 개수가 3개 이상인 경우
				System.out.println("*************BINGO!!!**********");
				break;
			}
		}// while 종료
		
	}
}



