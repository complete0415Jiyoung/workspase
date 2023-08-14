package edu.kh.project.member.model.service;

import edu.kh.project.member.model.dto.Member;

// Service Interface 사용이유 

// 1. 프로젝트의 규칙성을 부여하기 위해서 

// 2. 클래스 간에 결합도를 약화 시키기 위해서(객체 지향적 설계)

// 3. Spring AOP 사용을 위해서


public interface MemberService {

	/** 로그인 서비스
	 * @param inputMember(email,pw)
	 * @return email, pw가 일치하는 회원정보 또는 null
	 */
	Member login(Member inputMember);

	
	/** 회원 가입 서비스 (비밀번호 암호화)
	 * @param inputMember
	 * @return result(성공 1/ 실패0)
	 */
	int signUp(Member inputMember);
	
}
