package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service	// Service Layer 
			// 비지니스 로직(데이터 가공, DAO호출, 트렌젝션 제어) 처리하는 클래스 명시
			// + Bean 등록하는 어노테이션
public class MemberServiceImpl implements MemberService {
	
	//예전에는 이렇게 사용했음 -> @Repository로 객체 생성 되었기 때문에 
	//private MemberDAO dao= new MemberDAO();

	//@Autowired : 작성된 필드와 
	// Bean으로 등록된 객체중 타입이 일치하는 Bean을 
	// 해당 필드에 자동으로 주입(Injection)하는 어노테이션 
	// DI(의존성 주입)
	// 	-> 객체를 만들지 않고 Spring이 만들걸 주입함(Spring에 의존)
	@Autowired
	private MemberDAO dao;
	
	@Autowired // bean으로 등록된 객체 중 타입이 일치하는 객체를 DI
	private BCryptPasswordEncoder bcrypt;
	
	@Override
	public Member login(Member inputMember) {
		
		//암호화 추가 예정
		System.out.println("암호화 확인 :"+ bcrypt.encode(inputMember.getMemberPw()));
		
		// bcrypt 암호화는 salt가 추가 되기 때문에 
		//계속 비밀번호를 바꿔주게 되어 DB에서 비교 불가능!!
		// -> 별도로 제공해 주는 matches(평문, 암호문)을 이용해 비교
		
		// dao 메소드 호출
		Member loginMember = dao.login(inputMember);
		
		
		if(loginMember != null) { //아이디가 일치하는 회원이 조회된 경우 
			
			//입력한 pw, 암호화된 pw가 같은 지 확인
			
			//같을 경우
			if(bcrypt.matches(inputMember.getMemberPw(), 
					loginMember.getMemberPw())) { 
				
				// 비밀번호를 유지 하지 않기 위해서 로그인 정보에서 제거 
				loginMember.setMemberPw(null);
				
			}else { // 다를 경우
				loginMember = null; //로그인 실패처럼 만듦
			}
			
		}
		
		return loginMember;
	}
	
	
	//@Transactional(rollbackFor = {Exception.class})
	// 예외가 발생하면 rollback 
	// 발생 안하면 Service 종료시 commit
	//AOP 서비스에서 controller로 넘어가는 시점에서 자동으로 트렌젝션 처리 AOP
	
	// 회원가입서비스
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int signUp(Member inputMember) {
		
		// 비밀번호를 BCrypt를 이용하여 암호화 후 다시 inputMember에 세팅 
		String encPw = bcrypt.encode(inputMember.getMemberPw());
		inputMember.setMemberPw(encPw);
		
		// DAO 호출
		int result = dao.signUp(inputMember);
		
		return result;
	}
	
}
