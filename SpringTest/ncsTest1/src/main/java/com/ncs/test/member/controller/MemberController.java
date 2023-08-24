package com.ncs.test.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncs.test.member.model.service.MemberService;

import com.ncs.test.member.model.vo.Member;

@Controller
public class MemberController { 

	@Autowired
	private MemberService memberService;

	@RequestMapping("login")

	public String memberLogin(Member member, Model model, HttpServletRequest request) {

		Member loginMember = memberService.loginMember(member);

		HttpSession session = request.getSession();

		if(loginMember == null) {

			model.addAttribute("msg", "로그인 실패");

			return "common/errorPage";

		}else {

			session.setAttribute("loginMember", loginMember);

			return "redirect:/";

		}
		
		

	}

}
