package edu.kh.community.member.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import edu.kh.community.common.MyRenemePolicy;
import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/myPage/profile")
public class MyPageProfileServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 메인페이지에서 프로필 클릭했을 때
		// 마이페이지에서 프로필 클릭했을 때
		
		String path="/WEB-INF/views/member/myPage-profile.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 프로필 이미지 업로드 -> 변경
			
			//System.out.println(req.getParameter("profileImage")); //null
			
			// 파라미터가 얻어와지지 않는 이유
			// 1. enctype="multipart/form-data"-> 인코딩이 안되어 있어서 파라미터가 인지 되지 않음
			// 2. input type="file"-> 파일형태 데이터 
			
			// --> multipart/form-data 형식의 요청을 처리할 수 있는 전용 request 객체가 필요
			
			// --> MultipartRequest  (cos.jar 라이브러리 이용 -  http://www.servlets.com/)
			//						파일 업로드 라이브러리
			
			//****************MultipartRequest 사용을 위한 준비 단계****************
			
			// 1. 업로드 되는 파일 크기의 전체 합을 지정한다(byte지정)
			int maxSize = 1024* 1024 * 20;
			//	  1KB 	1MB		20MB
			// 2. 업로드 되는 파일이 어디에 저장될지 경로 지정
			//		-> 서버 컴퓨터 내부의 풀더(절대 경로)
			
			// 2-1. 서버 옵션을 확인 
			// servers-> 서버 설정 선택 -> Overview -> server option
			// -> Server Modules Without publishing 체크
			//  (업로드 되는 파일이 webapp폴더 내부에 저장될 수 있음)
			
			// 2-2. memberProfile 폴더까지의 절대 경로 얻어오기
			HttpSession session= req.getSession(); // session 얻오는 것은 지장없음(사용가능)
			
			//최상위 경로("/" == webapp 폴더)의 컴퓨터 상의 실제 경로를 얻어옴
			String root = session.getServletContext().getRealPath("/");
			//C:\workspace\5_Server\community\src\main\webapp\WEB-INF
			
			// 실제 파일이 저장되는 폴더의 경로
			String folderPath = "/resources/images/memberProfile/";
			
			//memberProfile 폴더 까지의 절대 경로
			String filePath = root + folderPath;
			
			// 3. 저장되는 파일의 파일명을 중복 방지를 위한 파일명 변경 규칙
			// -> cos.jar 에서 제공하는 FileRonamePolicy 인터페이스 상속 클래스 생성
			// --> myRenamePolicy 클래스 생성 완료 
			
			// 4. 파일 이외의 파라미터들을 문자 인코딩 지정
			String encoding = "UTF-8";
			
			// 5. MultipartRequest생성
			// ******(중요)******
			// MultipartRequest 객체가 생성됨과 동시에 지정된 경로에 
			// 지정된 파일명 변경 정책에 맞게 이름이 바뀐 파일이 저장(서버에 업로드)된다
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenemePolicy());
			
		
			// 프로필 이미지 변경 Service 호출시 필요한 값
			// 1) 로그인한 회원의 회원 번호
			Member loginMember = (Member)(session.getAttribute("loginMember"));
			int memberNo = loginMember.getMemberNo();
			
			// 2) 업로드된 프로필 이미지의 웹 접근 경로(folderPath + 변경된 파일명)
			
			// getOriginalFileName("input type= 'file'의 name 속성값")
			// -> 원본 파일명
			System.out.println( mpReq.getOriginalFileName("profileImage"));
			
			//getFilesystemName("input type ='file'의 name속성값")
			// -> 변경된 파일명
			System.out.println(mpReq.getFilesystemName("profileImage"));
			
			//DB에 삽입될 프로필이미지 경로
			//단,  X버튼이 클릭된 상태면 null을 가지게 한다
			
			String profileImage = folderPath + mpReq.getFilesystemName("profileImage");
			
			// *****프로필 이미지 삭제****
			// 1) "delete" input type="hidden" 태그의 값 (파라미터) 언어오기
			//	(주의) multipart/form-data 형식의 요청이기 때문에 
			//	request를 이용해서 파라미터를 얻어올 수 었다
			//		->mpReq을 이용하면 가능하다!
			
			int delete = Integer.parseInt(mpReq.getParameter("delete"));
			
			// 2) delete 의 값이 1(눌러진경우) 이면 profileImage의 값을 null로 변경
			if(delete == 1) {
				profileImage = null;
			}
			
			//프로필 이미지 변경 service호출후 결과 반환 받기
			MemberService service = new MemberService();
			
			int result = service.updateProfileImage(memberNo, profileImage);
			
			if(result > 0) { //성공
				session.setAttribute("message", "프로필 이미지가 변경되었습니다.");
				
				//DB에 프로필 정보는 변경되었으나
				// session에 저장된 로그인 정보중 프로필 이미지는 벼경되지 않음
				// -> 동기화 작업 (내 정보수정)
				loginMember.setProfileImage(profileImage); // 세션의 값이 변경됨
				
			}else { //실패
				session.setAttribute("massage","프로필 이미지 변경에 실패했습니다.");
			}
			
			// 성공/실패 관계 없이 프로필 화면 재요청(redirect)
			// /member/myPage/profile (Post)
			 resp.sendRedirect("profile"); //상대 경로 (GET)
			//resp.sendRedirect( req.getContextPath() + "/member/myPage/profile");
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
	
	}
	
}
