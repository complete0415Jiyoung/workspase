package edu.kh.community.common;

public class Util {
	
	// 개행문자를 "<br>"로 변경하는 메서드
	public static String newLineHandling(String content) {
		
		return content.replaceAll("\r\n|\n|\r|\n\r", "<br>");
		//textarea의 엔터 : \r\n
		// \r : 캐리지 리턴 (첫번째로 돌아가기)-> 현재는 개항문자로 인식
		// \n : 다음줄로 이동(다음줄로 이동)
	}
	
	
	// XSS : 관리자가 아닌 이용자가 악성 스크립트를 삽입해서 공격할 수 있다
	
	// Cross Site Scripting(XSS 크로스 사이트 스크립팅) 공격 방지 처리 메소드
	public static String XSSHandling(String content) {
		// <,>, &, "문자를 HTML코드가 아닌 문자 그대로 보이도록 변경 
		
		if(content != null) {
			// <h1>
			content = content.replaceAll("&", "&amp;"); // <h1>;
			content = content.replaceAll("<", "&lt;");  // &lt;h1>
			content = content.replaceAll(">", "&gt;");  // &lt;h1&gt;
			content = content.replaceAll("\"", "&quot;");  // &lt;h1&gt;
		}
		return content;
	}
}
