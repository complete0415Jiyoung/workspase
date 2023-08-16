package edu.kh.project.myPage.model.service;

import edu.kh.project.member.model.dto.Member;

public interface MyPageService {

	
	/** 내정보 수정 메소드 
	 * @param updateMember
	 * @return result
	 */
	int updateInfo(Member updateMember);

	/** 비밀번호 변경 서비스
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 */
	int changePw(String currentPw, String newPw, int memberNo);

	/** 회원 탈퇴 
	 * @param memberNo
	 * @param memberPw 
	 * @return result
	 */
	int secession(int memberNo, String memberPw);
}
