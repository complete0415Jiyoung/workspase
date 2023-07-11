package edu.kh.oop.metho.run;

import edu.kh.oop.metho.model.service.MemberService;

public class MemberRun {

	
	public static void main(String[] args) {
	//[접근제한자][예약어] 반환형 메소드명 ([매개변수])
		
		
		MemberService service = new MemberService();
		//MemberService의 기본 생성자가 작성 되어 있지 않지만 
		//문제 없이 사용 가능 
		
		//왜? 컴파일러가 코드를 번역할 때 
		//클래스 내부에 생성자가 하나도 없다면 
		//자동으로 기본 생성자를 추가해줌
		
		//(주의) 생성자가 하나라도 있으면 자동 생성을 안해줌
		//		그래서 기본 생성자를 처음에 꼭 만들어 줌 
		//The constructor MemberService() is undefined
		
		service.displayMeun();
		
		
		
		
		
	}
}
