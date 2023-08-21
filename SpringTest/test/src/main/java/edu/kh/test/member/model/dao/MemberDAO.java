package edu.kh.test.member.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.test.member.model.vo.Member;

@Repository
public class MemberDAO {

	@Autowired
	//sqlSessionTemplate sqlTemple;
	
	public Member login(Member member) {
		//return sqlTemple.selectOne("memberMappar.login", member) ;
		return null;
	}

	

}
