package edu.kh.test.member.controller;

import javax.management.loading.PrivateClassLoader;

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
@RequestMapping("/")
@SessionAttributes("loginMember")
public class MemberController2 {
	
	@Autowired 
	MemberService service;
	
	
	@PostMapping("login")
	public String MemberController(@ModelAttribute Member member
								, Model model
								, RedirectAttributes ra) {
								
		System.out.println(member.getMemberId());
		System.out.println(member.getMemberPwd());
		
		Member loginMember = service.login(member);
		
		String message = null;
		
		if(loginMember == null) {
			
			message= "로그인이 실패 되었습니다.";
			ra.addFlashAttribute("message", message);
			
		}
		model.addAttribute("loginMember", loginMember);
		
		return "redirect:/";
		
		
	}
}
