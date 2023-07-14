package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/selectOne")
public class SelectOneServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 파라미터 얻어오기
		String memberEmail = req.getParameter("memberEmail");
		try {
			MemberService service = new MemberService();
			
			//회원 정보 조회 Service호출후 결과 (member)반환 받기
			Member member= new Member();
			
			member=service.selectOne(memberEmail);
			
			// 조회 결과를 응답용 스트림으로 출력

			//resp.getWriter().print(member);
			// print 매개변수로 참조형 변수가 작성되면
			// 해당 참조형 변수의 toString()메소드를 자동 호출해서 출력
			
			// ***JAVA객체를 Javascript 객체로 변환하여 응답 출력****
			
			//JAVA 객체 -> Javascript 객체 형태의 문자열(JSON)->Javascript 객체
			
//			(JSON)은 JAVA용어(자바스크립트 형식의 문자열)를 Javascript 용어로 바꿔 주는 것 
			//escape 문자 사용하여 Key와 value에 "" 넣어 주기!! 
			
			// 1) Json 직접 작성 -> 오타가 너무 많이 난다....
//			String str="{\"memberNickname\" : \""+member.getMemberNickname()+"\"}";
//			resp.getWriter().print(str);
			
			
			//2) JOSN-Simple 라이브러리에서 제공하는 JSONObject
			//					JSON은 Map형식의 객체 
			/*if(member !=null) { // Map형식의 객체
				JSONObject obj = new JSONObject();
				
				obj.put("memberEmail", member.getMemberEmail());
				obj.put("memberNickname", member.getMemberNickname());
				obj.put("memberTel", member.getMemberTel());
				obj.put("memberAddress", member.getMemberAddress());
				obj.put("enrollDate", member.getEnrollDate());
				
				// JSONObject의 toString()메소드는 
				// JSON형태로 출력될 수 있도록 오버라이딩이 되어있다!
				resp.getWriter().print(obj.toString());
				
			}else {
				resp.getWriter().print(member); //null
			}
			*/
			
			// 3) GSON 라이브러리를 이용한 JAVA객체 -> JSON변환
			// new Gson().toJson(객체, 응답스트림)
			// -> 매개 변수에 작성된 객체를 JSON형태로 변환한 후 스트림을 통해서 출력
			
			new Gson().toJson(member, resp.getWriter());
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
				
	
	}
}
