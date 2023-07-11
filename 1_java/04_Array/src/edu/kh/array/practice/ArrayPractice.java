package edu.kh.array.practice;

import java.util.Arrays;

import java.util.Scanner;

public class ArrayPractice {

	public void practice1() {
		int arr[] = new int[9];
		int sum = 0;
		for(int i= 0 ; i < arr.length ; i++) {
			
			arr[i] = i+1;
			System.out.print(arr[i]+" ");
			if( i % 2 == 0) {
				sum += arr[i];
			}
		}
		System.out.println();
		System.out.println("짝수번째 인덱스의 합 : "+ sum);
	}
	
	public void practice2() {
		int arr[] = new int[9];
		int sum = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			
			arr[i]= arr.length - i;
			System.out.print(arr[i]);
			if( i % 2 == 1) {
				sum += arr[i];
			}
		}
		System.out.println();
		System.out.println("홀수번째 인덱스의 합 : "+ sum);
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		
		int arr[] = new int[input];
		
		for (int i = 0 ; i < arr.length ; i++) {
			arr[i]= i+1;
			System.out.print(arr[i]);
		}
		
	}
	
	public void practice4(){
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];

		for(int i = 0; i < arr.length ; i++){

			System.out.print("입력"+i+" : ");
			int input = sc. nextInt();
	
			arr[i] = input;
			
		}


		System.out.print("검색할 값 : ");
		int input2 = sc.nextInt();
		
		boolean flag = false;
		
		for(int i =0 ; i < arr.length ; i++) {
			if( arr[i]==(input2)) {
			
			System.out.println("인덱스 : "+ i);
			flag = true;
			}
		}
		if (!flag) {  //flag가 false인경우
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}
	}

	public void practice5(){

		Scanner sc = new Scanner(System.in);  
		
		System.out.print("문자열 : ");
		String input = sc. nextLine();
	
		char [] arr = new char[input.length()];// 입력 받은 문자열 길이 만큼 배열 생성
	
		for( int i = 0 ; i < arr.length ; i++){
			
			//입력 받은 문자열에서 i번째 인덱스 문자를 arr[i]에 대입 
			arr[i] = input.charAt(i);  //배열에 대입 
			
		}
		
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);   //입력 받은 문자열에서 0번 인덱스를 반환
		//			String -> char
	
		int count = 0; //input에 위치한 ch가 몇개가 있는지 확인하는 변수 
		
		//검색 + 카운트
		System.out.print(input+"에 "+ch+"가 존재하는 위치(인덱스) : ");
		
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i]==ch) { //검색 조건 
			System.out.print(i+ " ");
				count++;
			}
		}
		System.out.println();
		
		if(count > 0) {
		System.out.println(ch +"개수 : "+ count);
		}
	}
	
	public void practice6(){
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		int [] arr = new int[input];
		
		int sum = 0;
		
		for(int i = 0 ; i < arr.length; i++ ) {
			
			System.out.print("배열 "+ i +"번째 인덱스에 넣을 값 : ");
			int input2 = sc.nextInt();
			
			arr[i] = input2;
			
			sum += arr[i];
			
		}System.out.println();
		
		
		for(int i= 0 ; i < arr.length ;i++) {
			System.out.print(arr[i]);
		}System.out.println();
		//System.out.println(Arrays.toString(arr));
		
		System.out.println("총합 : "+ sum);
		
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.nextLine();
		
		char [] arr = new char [input.length()];
		
		
		for(int i = 0 ; i < arr.length; i++) {
			arr[i] = input.charAt(i);
			if(i < 8) {
				System.out.print(arr[i]);
			}else {
				System.out.print('*');
		
			}
		}
	}
	
	public void practice8() {
//		3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
//		중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
//		단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
//		다시 정수를 받도록 하세요.
		
		
//		[실행 화면]
//		정수 : 4
//		다시 입력하세요.
//		정수 : -6
//		다시 입력하세요.
//		정수 : 5
//		1, 2, 3, 2, 1
		
		
		Scanner sc =new Scanner(System.in);
		int input;
		int []arr;
		int num = 1;
		while(true) {
			System.out.print("정수 : ");
			input = sc.nextInt();
			
			if(input < 3 || input % 2 == 0) {
				System.out.println("다시 입력하세요");
				
			}else {
				arr = new int[input];
				
				for(int i = 0; i < arr.length; i++) {
					if(i < arr.length / 2 ) {
						
						arr[i] = num++;
					}else {
						arr[i] = num--;
					}
					if(i < arr.length - 1) {
						System.out.print(arr[i]+ ", ");
						
					}else{
						System.out.print(arr[i]);
					}
				}
			}		
			break;
		}	
	}
	
	public void practice9() {
//		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
//		1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
//		[실행 화면]
//		발생한 난수 : 9 7 6 2 5 10 7 2 9 6
		
		int[]arr = new int [10];
		
		System.out.print("발생한 난수 : ");
		for(int i = 0 ; i <arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			System.out.print(arr[i]+ " ");
		}	
	}
	
	public void practice10() {
//		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
//		1~10 사이의 난수를 발생시켜 배열에 초기화 후
//		배열 전체 값과 그 값 중에서 최대값과 최소값을 출력하세요.
//		[실행 화면]
//		발생한 난수 : 5 3 2 7 4 8 6 10 9 10 
//		최대값 : 10
//		최소값 : 2
		
		int[]arr = new int [10];
		int num;
		int max = 0;
		int min = 10;
		System.out.print("발생한 난수 : ");
		for(int i = 0 ; i <arr.length; i++) {
			arr[i]= (int)(Math.random()*10+1);
			if(max < arr[i]) {
				max=arr[i];
				
			}else if(min > arr[i]) {
				min = arr[i];
			}
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n최대값 : " + max);
		System.out.println("최소값 : " + min);
		
	}
	
	public void practice11() {
//		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
//		1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요.
//		[실행 화면]
//		4 1 3 6 9 5 8 10 7 2 
		
		int [] arr = new int[10];
		for (int i = 0 ; i <arr.length; i++) {
			arr[i]= (int)(Math.random()*10+1);
			for(int j =0; j < i ; j++) {
				if(arr[j] == arr[i]) {
					i--;
					break;
				}
			}
		}
		for(int i = 0; i <arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public void practice12() {
//		로또 번호 자동 생성기 프로그램을 만들기.
//		(중복 값 없이 오름차순으로 정렬하여 출력하세요.)
//		[실행 화면]
//		3 4 15 17 28 40
		int[]arr = new int [6];
		for( int i =0 ; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*45 +1);
			
			for(int j =0 ; j < i ; j++) {
				if(arr[j] ==arr[i]) {
					i--;
					break;
				}
			}
		}
		for(int i = 0; i <arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public void practice13() {
//		문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
//		문자의 개수와 함께 출력하세요.
//		[실행 화면]
//		문자열 : application
//		문자열에 있는 문자 : a, p, l, i, c, t, o, n
//		문자 개수 : 8
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String input = sc.next();
		
		char[] arr = new char[input.length()];
		int count = 0;
		
		
		System.out.print("문자열에 있는 문자 : ");
		
		for( int i = 0 ; i < arr.length ;i++ ) {
			arr[i] = input.charAt(i);
			boolean flag = true;
			
			for(int j=0; j < i; j++) {
				if(arr[j] == arr[i]) {
					
					flag = false;
				}
			}
			if(flag) {
				if(i == 0) {
					System.out.print(arr[i]);
				}else {
					System.out.print(", "+arr[i]);
				}
				count++;
				
			}
		}
		System.out.println("\n문자개수 : "+ count);
	}
	
	
//	 Scanner sc = new Scanner(System.in);
//     
//     System.out.print("문자열 : ");
//     String input = sc.nextLine();
//     
//     char[] arr = new char[input.length()];
//     
//     int count = 0; // 카운트용 변수
//     
//     System.out.print("문자열에 있는 문자 : ");
//     for(int i=0 ; i<arr.length ; i++) {
//        arr[i] = input.charAt(i); // 문자열 -> char배열에 옮겨 담기
//        
//        // 중복 검사 + flag
//        // application
//        //배열 : [a, p, p, l, i, c, a, t, i, o, n]
//        //화면 :  a, p, l, i, c, t, o, n
//        //개수 :  1  2  3  4  5  6  7  8
//        
//        boolean flag = true; // 신호용 변수
//        
//        for(int x=0 ; x<i ; x++) { // 중복 검사용 for문
//           if( arr[i] == arr[x] ) {
//              // 현재 대입된 문자가 앞서 대입된 문자와 같다면 == 중복
//              flag = false; // 신호용 변수의 값을 false로 변경
//              break; 
//           }
//        }
//        
//        if(flag) { // flag가 true인 경우 == 중복이 없었다라는 의미
//           
//           count++; // 카운트 1 증가
//           
//           if(i == 0) { // 첫 바퀴인 경우
//              System.out.print(arr[i]);
//              
//           }else { // 첫 바퀴가 아닌 경우
//              System.out.print(", " + arr[i]);
//           }
//           
//        }
//        
//     } // 바깥쪽 for문 끝
//     
//     System.out.println("\n문자 개수 : " + count);
//     
//  }
	
	
	public void practice14() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요: ");
		int num = sc.nextInt();
		String []arr = new String [num];
		
		int index = 0;

		
		while(true) {
			sc.nextLine();
			for(int i = index ; i < arr.length ; i++) {
				System.out.print(i+1+"번째 문자열 : ");
				
				arr[i] = sc.nextLine();
			}
			
			index = arr.length;
			
			System.out.print("더 값을 입력하시겠습니까?(Y/N): ");
			char input = sc.next().charAt(0);
			
			if(input == 'y'|| input =='Y') {
				
				System.out.print("더 입력하고 싶은 개수 : " );
				int num2 = sc.nextInt();
				String[] copyArr = new String [arr.length + num2]; //추가할 배열 만들기 
				
				System.arraycopy(arr, 0, copyArr, 0, arr.length); //깊은복사
				
				
				arr = copyArr; 
		
			}else if(input == 'n'||input=='n'){
				System.out.println(Arrays.toString(arr));
				
				break;
			}else {
				System.out.println("잘못 입력하셨습니다");
				continue;
			}
		}
	}
	
	public void practiceT14() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력 하세요: ");
		int size = sc.nextInt();
		 
		sc.nextLine(); //입력버퍼 개행 문자 제거
		 
		String []arr = new String[size]; //배열 선언 및 할당
		
		int start= 0; //while 내 for문의 초기식에 사용될 변수 
		while(true) {
			for( int i= start ; i < arr.length; i++) {
				System.out.print((i+1)+ "번째 문자열 :");
				arr[i] = sc.nextLine();

			}
			
			System.out.print("더 값을 입력하시겠습니까? (Y/N) : ");
			char input = sc.nextLine().charAt(0);
							//입력 받은 문자열 중 제일 앞 문자 하나만 얻어옴
			if( input == 'y'|| input =='Y') {
				start = arr.length;
				//추가 입력 받기 위한 추가 배열 부분의 시작 위치
				
				System.out.print("더 입력하고 싶은 개수 : ");
				int addSize = sc.nextInt();
				sc.nextLine(); //입력 버퍼 개행 문자 제거
				
				
				//증가된 크기의 배열을 생성하여 arr배열 깊은 복사 
				String [] copyArr = new String [ arr.length+ addSize];
				
				for( int i=0 ; i< arr.length; i++) {//기존 배열 크기 만큼만 반복
					copyArr[i] = arr[i];//복사 배열에 기존 배열 값을 같은 인댁스에 대입
				}
				
				//배열의 얕은 복사
				arr = copyArr;//arr이 참조하는 주소값을
							//copyArr의 주소값으로 바꿔서 
							//arr이 참조하는 배열의 크기가 증가한 것처럼 보이게 함
				
			
			}else {//y/n만 입력했다는 상황을 가정
				
				break; // while 반복 종료 
			}
		 
		}//while 끝
		System.out.println(Arrays.toString(arr));
	}
	
}
					
	