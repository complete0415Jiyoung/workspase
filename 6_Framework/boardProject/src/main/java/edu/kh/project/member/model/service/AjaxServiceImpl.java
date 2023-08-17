package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.AjaxDAO;

@Service // 서비스임을 명시 + bean등록
public class AjaxServiceImpl implements AjaxService{
	
	@Autowired // DI
	private AjaxDAO dao;
	
	// 이메일로 닉네임 조회dao
	@Override
	public String selectNickname(String email) {

		return dao.selectNickname(email);
	}

	// 닉네임으로 전화번호 조회
	@Override
	public String selectMemberTel(String nickname) {
		return dao.selectMemberTel(nickname);
	}
	
	// 이메일 중복검사
	@Override
	public int dupCheckEmail(String email) {
		return dao.dupCheckEmail(email);
	}
	
	//닉네임 중복검사 
	@Override
	public int dupCheckNickname(String nickname) {
		return dao.dupCheckNickname(nickname);
	}
}
