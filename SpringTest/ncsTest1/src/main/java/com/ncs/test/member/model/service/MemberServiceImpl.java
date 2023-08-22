package com.ncs.test.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ncs.test.member.model.dao.MemberDAO;

import com.ncs.test.member.model.vo.Member;

@Service

public class MemberServiceImpl implements MemberService {

@Autowired

private MemberDAO memberDAO;

@Override

public Member loginMember(Member member) {

return memberDAO.loginMember(member);

}

}
