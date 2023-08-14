package edu.kh.project.myPage.model.service;

import edu.kh.project.member.model.dto.Member;

public interface MyPageService {

	
	/** 내정보 수정 메소드 
	 * @param updateMember
	 * @return result
	 */
	int updateInfo(Member updateMember);

}
