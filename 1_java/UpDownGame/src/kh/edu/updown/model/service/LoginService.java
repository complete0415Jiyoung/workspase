package kh.edu.updown.model.service;

import java.util.List;
import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class LoginService {
	
	private Scanner sc = new Scanner(System.in);

	// 업다운 게임 시작
	// 1 ~ 100 사이 숫자 중 랜덤하게 한 숫자를 지정하고 업/다운 게임을 진행
	// 맞춘 횟수가 현재 로그인한 회원의 최초 또는 최고 기록인 경우 회원의 highScore 필드 값을 변경
	public void startGame(Member loginMember) {
		
		System.out.println("[Game Start...]");
		int random = (int)(Math.random()*100+1);

		boolean flag =true;
		int count = 1;

	
		while(flag) {
			loginMember.getHighScore();
			System.out.print(count+"번째 입력 : ");
			int input = sc.nextInt();
			sc.nextLine();
			if(input > random) {
				count++;
				System.out.println("--DOWN--");
				
			}else if(input < random){
				count++;
				System.out.println("--UP--");
				
			}else {
				System.out.println("정답!");
				System.out.println("입력시도 횟수 : "+ count);
				


				if(loginMember.getHighScore() == 0 ||loginMember.getHighScore() > count  ){ //최초기록
					System.out.println("***최고기록달성 ***");
					loginMember.setHighScore(count); 
					System.out.println("최고점수 : " + loginMember.getHighScore());
				
					loginMember.setHighScore(count);
				
				}

				break;
			}
		}	
	}

	
	// 내 정보 조회
	// 로그인한 멤버의 정보 중 비밀번호를 제외한 나머지 정보만 화면에 출력
	public void selectMyInfo(Member loginMember) {
		
		System.out.println("[내 정보 조회]");
		System.out.println("이름 : "+ loginMember.getMemberName());
		System.out.println("아이디 : " + loginMember.getMemberId());
		System.out.println("최고점수 : " + loginMember.getHighScore());
	}

	// 전체 회원 조회
	// 전체 회원의 아이디, 이름, 최고점수를 출럭
	public void selectAllMember(List<Member> members) {
		
		System.out.println("[전체 회원 조회]");
		for(Member m : members ) {
			System.out.println(m);
		}
	}

	// 비밀번호 변경
	// 현재 비밀번호를 입력 받아 
	// 같은 경우에만 새 비밀번호를 입력 받아 비밀번호 변경
	public void updatePassword(Member loginMember) {
		
		System.out.println("[비밀번호 변경]");
		
		System.out.print("현재 비밀번호 : ");
		String memberPw =sc.next();
		if(loginMember.getMemberPw().equals(memberPw)) {
			System.out.print("새로운 비밀번호를 입력하세요 : ");
			String newMemberPw = sc.next();
			
			loginMember.setMemberPw(newMemberPw);
			System.out.println(loginMember.getMemberName()+"의 비밀번호를 변경하였습니다");
		}
		
		
	}

	
	
}
