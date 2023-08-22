package edu.kh.test.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.test.member.model.dao.MemberDAO;
import edu.kh.test.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	
	@Override
	public Member login(Member member) {
		
		return dao.login(member);
	}
}
