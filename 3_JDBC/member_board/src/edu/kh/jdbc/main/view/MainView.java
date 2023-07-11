package edu.kh.jdbc.main.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.board.view.BoardView;
import edu.kh.jdbc.member.model.vo.Member;
import edu.kh.jdbc.member.view.MemberView;

public class MainView { //메인메뉴 (메뉴 선택용 /입력화면)

	private Scanner sc = new Scanner(System.in);
	
	//로그인한 회원의 정보가 저장된 객체를 참조할 변수 
	private Member loginMember = null;
	
	//회원 관련 기능 화면을 모아둔 객체를 참조할 변수 
	private MemberView memberView = new MemberView();
	
	//게시판 관련 기능 화면을 모아둔 객체 참조할 변수
	private BoardView boardView = new BoardView();
	
	
	//alt +shift + j
	/**
	 * 메인 메뉴 출력 메소드
	 */
	public void displayMeun() {
		
		int meunNum = -1; //메뉴 선택 값 저장 변수 
		//초기값을 -1로 지정하여, 반복문 첫바퀴에서 오류 발생시 종료 되는 것을 방지 
		
		do {
			try {
				
				if(loginMember == null) { 	// 로그인이 되어 있지 않은경우
					System.out.println("\n******회원제 게시판 프로그램******");
					
					System.out.println("1. 로그인");
					System.out.println("2. 회원가입");
					System.out.println("0. 프로그램 종료");
					
					System.out.println("메뉴를 선택해 주세요>> ");
					
					meunNum = sc.nextInt(); // InputMismatchException 발생 가능성 있음
					sc.nextLine(); //입력 버퍼 개행 문자 제거
					System.out.println();// 개행 
					
					switch(meunNum) {
					case 1: loginMember= memberView.login(); break;
					case 2: memberView.sigUp(); break;
					case 0: System.out.println("------- 프로그램 종료 -------"); break;
					default : System.out.println("메뉴에 작성된 번호를 입력해주세요.");
					}
					
					
					
				} else {	//로그인이 되어 있는 경우
					
					
					System.out.println("\n*************회원 메뉴*************\n");
					// - 로그인한 회원 정보 조회
	                // - 회원 목록 조회
	                // - 회원 정보 수정(이름, 성별)
	                // - 비밀번호 변경
	                // - 회원 탈퇴
	                System.out.println("1. 내 정보 조회");
	                System.out.println("2. 가입된 회원 목록 조회");
	                System.out.println("3. 내 정보 수정(이름, 성별)");
	                System.out.println("4. 비밀번호 변경");
	                System.out.println("5. 회원 탈퇴");
	                
	                System.out.println("6. *게시판 메뉴 화면*");
	                
					System.out.println("9. 로그아웃");
					System.out.println("메뉴를 선택해 주세요 >> ");
					meunNum = sc.nextInt();
					sc.nextLine();
					
					switch(meunNum) {
					case 1 : memberView.myInfo(loginMember); break;
					case 2 : memberView.selectAll(); break;
					case 3 : memberView.updateMyInfo(loginMember); break;
					case 4 : memberView.updatePw(loginMember); break;
					
					case 5 : 
						int result = memberView.secession(loginMember);
						if(result > 0) loginMember = null; //로그아웃 
						break;
						
					case 6 : boardView.boardMeun(loginMember); break;
					
					case 9 : loginMember = null; break;
					default : System.out.println("메뉴에 작성된 번호를 입력해주세요.");
					}
				
				}
				
				
			} catch (InputMismatchException e) {
				System.out.println("\n입력 형식이 올바르지 않습니다. 다시 시도해주세요.");
				sc.nextLine(); // 입력 버퍼에 남은 잘못된 문자열 제거 
			}
			
		} while (meunNum != 0);
	}
}
