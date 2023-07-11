package edu.kh.oarr.model.service;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;

public class MemberService {
	
	private Scanner sc = new Scanner (System.in);

	//Member 5칸 짜리 객체 배열 선언 및 할당
	private Member[] memberArr = new Member[5];
	
	//현재 로그인한 회원의 정보를 저장할 변수 선언
	private Member loginMember = null;
	
	public MemberService() { //기본 생성자
	
	//memberArr배열 0,1,2 인덱스 초기화 
	memberArr[0] =new Member("user01", "pass01","고경표", 30, "서울");
	memberArr[1] =new Member("user02", "pass02","카즈하", 22, "경기");
	memberArr[2] =new Member("user03", "pass03","카리나", 37, "강원");
	}
	public void displayMeun() { // 메뉴화면 출력기능

		int meunNum = 0; // 메뉴 선택용 변수

		do { // 한번은 무조건 반복
			System.out.println("====회원정보 관리프로그램 v2======");
			System.out.println(" 1. 회원가입");
			System.out.println(" 2. 로그인");
			System.out.println(" 3. 회원정보 조회");
			System.out.println(" 4. 회원정보 수정");
			System.out.println(" 5. 회원 검색(지역)");
			System.out.println(" 0. 프로그램 종료");

			System.out.print("메뉴입력 >> ");
			meunNum = sc.nextInt(); // 필드에 작성된 스캐너 sc 사용
			sc.nextLine(); // 입력버퍼에 남은 개행문자 미리 제거

			switch (meunNum) {
			case 1: System.out.println(singUp()); break;
			// 같은 클래스 내부에 있는 필드, 메소드는 이름만 불러도 호출가능!
			// singUp() 메소드를 호출하여 수행 후 반환 값을 출력!

			case 2: System.out.println(login()); break;
			case 3: System.out.println(selectMember());break;
			case 4: 
				int result = updateMember();//-1,0,1,

				if(result == -1) {
				System.out.println("로그인 후 이용해 주세요");
				
				}else if (result ==0 ) {
				System.out.println(" 회원 정보 수정 실패 (비밀번호 불일치)");
				
				}else {// result == 1
				System.out.println("회원정보가 수정 되었습니다");
				}
				
				break;
				
			case 5: searchRegion(); break;
			
			case 0: System.out.println("프로그램을 종료합니다..");break;

			default:System.out.println("잘못입력하셨습니다. 다시입력해 주세요");
				break;
			}
		} while (meunNum != 0);
	}
	
	//회원 관리 메서드 
	public String singUp() {
		
		System.out.println("\n========회원가입=========");
		
		
		//객체 배열(memberArr)에 가입한 회원 정보 저장 
		//-> 새로운 회원 정보 저장할 공간 확인 
		//	빈 공간에 인덱스 번호 얻어오기 --> 새로운 메소드 작성
		
		int index = emptyIndex(); //memberArr배열에서 비어있는 인덱스를 반환 받음
		
		
		System.out.println("현재회원 수 :"+ index );
		
		if( index == -1) { // 비어있는 인덱스가 없는 경우
			return "회원가입 불가합니다 (인원수 초과)";
		}
		
		System.out.print("아이디 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		
		System.out.print("비밀번호 확인: ");
		String memberPw2 = sc.next();
				
		System.out.print("이름 : ");
		String memberName = sc.next();
		
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
				
		System.out.print("지역 : ");
		String region = sc.next();
		
		//비밀번호, 비밀번호 확인 일치시 회원가입 
		if(memberPw.equals(memberPw2)) {
			
			//member객체를 생성해서 할당된 주소를 memberArr비어있는 인덱스에 대입 
			memberArr[index] = new Member(memberId, memberPw, memberName, memberAge, region);
			return "회원가입 성공";
		}else {
			return "회원가입 실패 ㅠㅠ(비밀번호 불일치)";
		}
	}
	
	//memberArr에 비어있는 인덱스 번호를 반환하는 메소드 
	//단, 비어있는 인덱스가 없으면 -1 반환
	public int emptyIndex() {
		
		//memberArr배열을 0번 인덱스부터 끝까지 접근해서 
		//참조하는 값이 null인 경우 인덱스 반환 
		for(int i = 0 ; i < memberArr.length; i++) {
			if (memberArr[i] == null) {
				return i;	//현재 메소드를 종료하고 호출한 곳으로 i 값을 가지고 돌아감	
			}
		}
		
		//for문을 수행했지만 return이 되지않을 경우 해당 위치의 코드가 수행된다
		//--> for문에서 return이 되지않았다 == 배열에 빈칸이 없다
		// == -1 반환
		return -1;
	}
	
	public String login() {
		
		System.out.println("\n=========로그인========");
	
		System.out.print("아이디 입력 : ");
		String memberId =sc.next();
		
		System.out.print("비밀번호 입력 : ");
		String memberPw=sc.next();
		
		//1)memberArr배열 내 요소를 순서대로 접근하여 null이 아닌지 확인
		for (int i =0 ; i < memberArr.length; i++) {
			
			if( memberArr[i] != null) { // 회원 정보가 있을 경우 
			
				//2) 회원정보(memberArr[i])의 아이디, 비밀번호와
				//	입력 받은 아이디(memberId) , 비밀번호(memberPw) 같은지 확인 
				if(memberArr[i].getMemberId().equals(memberId) && 
					memberArr[i].getMemberPw().equals(memberPw)) {
					
					//3) 로그인 회원 정보 객체(Member)를 참조하는 loginMember에 
					//현제 접근 중인 memberArr[i]요소에 저장된 주소를 얕은 복사 
					loginMember = memberArr[i];
					break;  //더이상 같은 아이디와 비밀 번호가 없기 때문에 for문 종료
				}
			}
		}
		//4) 로그인 성공/실패 여부에 따라서 결과값 반환 
			if( loginMember == null) { //로그인 실패
				return "아이디 또는 비밀번호가 일치하지 않습니다";
				
			}else { //로그인 성공 
				return loginMember.getMemberName()+"님 환영합니다";
			}
		
	
	
	}
	//회원정보 조회 메소드 
	public String selectMember() {
		System.out.println("\n=======회원정보 조회=========");
	
		//1)로그인 여부 확인 -> 필드 loginMember가 참조하고 있는 객체와 같은지 확인 
		//로그인이 안되있으면 "로그인후 이용 해주세요 "반환
		if(loginMember == null) {
			return "로그인후 이용해 주세요";
		}
		
		//2)로그인이 되어 있는 경우
		//	회원정보를 출력할 문자열 만들어 반환(return)
		//	(단, 비밀번호 제외)
		
		//이름: 유저일
		//아이디: user01
		//나이: 25
		//지역 : 서울
		
		String str = "\n 이름 :" + loginMember.getMemberName();
		str += "\n아이디 :" + loginMember.getMemberId();
		str += "\n나이 :" + loginMember.getMemberAge()+"세";
		str += "\n지역 :" + loginMember.getRegion();
		
		return str;
		
	
	}
	//회원정보 수정 메소드 
	 public int updateMember() {
		 
		 System.out.println("\n=======회원정보 수정=========");
		 
		 //1) 로그인 여부 판별 
		 //	로그인이 되어 있지 않으면 -1 반환 
		 if(loginMember==null) {
			 return -1;
		 }
		 //2) 수정할 회원 정보 입력 받기 (이름,나이,지역)
		 System.out.print("수정할 이름 :");
		 String inputName = sc.next();
		 System.out.print("수정할 나이 :");
		 int inputAge = sc.nextInt();
		 System.out.print("수정할 지역 :");
		 String inputRegion = sc.next();
	
		 //3) 비밀번호를 입력받아서 
		 //	  로그인한 회원의 비밀번호가 일치하는지 확인 
		 System.out.print("비밀번호 :");
		 String memberPw = sc.next();
		 
		 //4) 비밀번호가 같을 경우 
		 //	로그인한 회원의 이름, 나이, 지역 정보를 입력 받은 값으로 변경후 
		 //	1반환
		 if(memberPw.equals(loginMember.getMemberPw())) {
			
			 loginMember.setMemberName(inputName);
			 loginMember.setMemberAge(inputAge);
			 loginMember.setRegione(inputRegion);
			 return 1;
			 
		 }else {
		//5) 비밀번호가 다를 경우 0 반환 
			 return 0;
		 }
	 }
	 
	 //회원 검색(지역) 메소드  
	 public void searchRegion() {
		 
		 System.out.println("\n==========회원 검색()============");
		 
		 System.out.print("검색할 지역 입력: ");
		 String inputRegion = sc.next();
		 
		 //1)memberArr배열의 모든 요소 순차 접근	
		 
		 boolean flag = true; //결과 검색 신호용 변수
		 
		 for( int i = 0 ; i <memberArr.length ; i++) {
			 
			 //2) member[i]요소가 null인 경우 반복 종료 
			 if(memberArr[i] == null) {
				 break;
			 }
			 
			 //3) memberArr[i] 요소에 저장된 지역(getRegion())이 
			 // 입력 받은 지역(inputRegion)과 같은 경우, 회원의 아이디, 이름을 출력
			 if( memberArr[i].getRegion().equals(inputRegion)) {
				 
				 System.out.printf("아이디 :%s, 이름 : %s \n",
					memberArr[i].getMemberId(),memberArr[i].getMemberName());
			 
				 flag = false;
			 } 
				 
		 }
		 //4) 검색 결과가 없을 경우 "일치하는 검색 결과가 없습니다" 출력 
		 if(flag) {
			 System.out.println("일치하는 검색 결과가 없습니다"); 
			 
		 }
	}
}
