package edu.kh.test.member.controller;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.test.member.model.service.MemberService;
import edu.kh.test.member.model.vo.Member;

@Controller
@SessionAttributes("loginMember")
public class MemberController2 {
	
	@Autowired 
	MemberService service;
	
	
	@PostMapping("/login")
	public String MemberController(@ModelAttribute Member member
								, Model model
								, HttpServletRequest request) {
								
		System.out.println(member.getMemberId());
		System.out.println(member.getMemberPwd());
		
		Member loginMember = service.login(member);
		
		HttpSession session = request.getSession();
		
	
		
		if(loginMember == null) {
			
			model.addAttribute("msg", "로그인실패");
			return "errorPage";
			
		}else{
			model.addAttribute("loginMember", loginMember);
			
			return "redirect:/";
			
		}
		
	
	}
}
