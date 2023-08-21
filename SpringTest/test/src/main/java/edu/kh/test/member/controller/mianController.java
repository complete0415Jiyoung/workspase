package edu.kh.test.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.test.member.model.vo.Member;

@Controller
public class mianController {

	@RequestMapping("/")
	public String MainController() {
		
		
		return "index";
	}
}
