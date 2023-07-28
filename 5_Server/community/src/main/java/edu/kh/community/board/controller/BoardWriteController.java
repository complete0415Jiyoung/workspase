package edu.kh.community.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import edu.kh.community.board.model.service.BoardService;
import edu.kh.community.board.model.vo.BoardDetail;
import edu.kh.community.board.model.vo.BoardImage;
import edu.kh.community.common.MyRenemePolicy;
import edu.kh.community.member.model.vo.Member;

//컨트롤러 : 요청에 따라 알맞은 서비스를 호출하고 결과에 따라 응답을 제어
@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String mode =req.getParameter("mode"); //insert인지 /update인지 구분

			//insert는 별도의 처리 없이 jsp로 위임

			//update는 기존 게시글 내용을 조회하는 처리가 필요함
			if(mode.equals("update")) {

				int boardNo = Integer.parseInt(req.getParameter("no"));

				// 게시글 상세조회 서비스를 이용해서 기존의 내용을 조회
				// ( new BoardService(0 객체를 생성해서 변수에 저장 X --> 일회성사용 )
				BoardDetail detail = new BoardService().selectBoardDetail(boardNo);

				// 개행문자처리 해제 (<br> -> /n)
				detail.setBoardContent(detail.getBoardContent().replaceAll("<br>", "\n"));

				req.setAttribute("detail",detail);// jsp에서 사용할 수 있도록 req에 값 세팅

			}

			String path = "/WEB-INF/views/board/boardWriteForm.jsp";
			req.getRequestDispatcher(path).forward(req, resp);


		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// insert/update 구분 없이 전달 받은 파라미터 모두 꺼내서 정리하기

			// ****enctype="multipart/form-data" 인코딩 미지정 형식****
			// -> httpServletRequest로 파라미터 얻어오기 불가능!
			// --> MultipartRequest를 이용(cos.jar라이브러리 제공)
			// ---> 업로드 최대용량, 저장 실제 경로, 파일명 변경 정책, 문자 파라미터 인토딩 설정 필요

			int maxSize = 1024 * 1024 * 100; // 업로드 최대 용량(100MB)

			HttpSession session= req.getSession(); // session 얻오는 것은 지장없음(사용가능)
			String root = session.getServletContext().getRealPath("/"); //webapp폴더까지 경로
			String folderPath = "/resources/images/board/";//파일을 저장할 멤버 경로
			String filePath = root + folderPath;

			String encoding = "UTF-8"; //파라미터 중 파일을 제외 파라미터(문자열)의 인코딩 지정

			// ** MultipartRequest 객체 생성**
			// -> 객체가 생성됨과 동시에 파라미터로 전달된 파일이 지정된 경로에 저장(업로드)된다***
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenemePolicy());

			// MultipartRequest.getFileNames()
			// - 요청 파라미터 중 모든 file 타입 태그의 name 속성 값을 얻어와서
			//   Enumeration 형태로 반환(interator의 과거 버전)
			//   --> 해당 객체에 여러 값이 담겨 있고 이를 순서대로 얻어오는 방법을 제공
			//	 	(보통 순서가 없는 (Set과 같은 경우) 에서 하나씩 꺼낼 때 사용)

			Enumeration<String> files = mpReq.getFileNames();
			// file 타입의 name 속성 0,1,2,3,4가 순서가 없는 상태로 얻어와짐

			// * 업로드된 이미지의 정보를 모아둘 List 생성
			List<BoardImage> imageList = new ArrayList<BoardImage>();

			while(files.hasMoreElements()) { //다음요소가 있으면 true
				String name = files.nextElement();  // 다음 요소(name속성값)을 얻어옴

				//System.out.println("name: "+ name);
				// file 타입 태그의 name속성 값이 얻어와짐
				// + 업로드가 되지 않은 file 타입 태그의 name 도 얻어와짐
				String rename = mpReq.getFilesystemName(name);
				String original = mpReq.getOriginalFileName(name);

				//System.out.println("rename: "+ rename);
				//System.out.println("original: "+ original);

				if(rename != null) { // 업로드 되는 파일이 있을 경우 ==
					// 현재 files에서 얻어온 name속성을 이용해서
					// 원본 또는 변경을 얻어왔을 때 그 값이 null이 아닌 경우
					// 이미지 정보을 담은 객체(BoardImage)를 생성
					BoardImage image = new BoardImage();

					image.setImageOriginal(original); //원본명(다운로드시 사용)
					image.setImageReName(folderPath+rename); // 변경된 이름
					image.setImageLevel(Integer.parseInt(name)); //이미지 위치(0은썸네일)

					imageList.add(image); //리스트에 추가 

				}//if문 끝

			}//wile문 끝

			// * 이미지를 제외한 게시글 관련 정보 *
			String boardTitle = mpReq.getParameter("boardTitle");
			String boardContent = mpReq.getParameter("boardContent");
			int boardCode = Integer.parseInt( mpReq.getParameter("type") ); // hidden에서 얻어옴

			Member loginMember = (Member)session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();//회원번호

			// 게시글 관련 정보를 하나의 객체에 담아서(BoardDeail)에 담기
			BoardDetail detail = new BoardDetail();

			detail.setBoardTitle(boardTitle);
			detail.setBoardContent(boardContent);
			detail.setMemberNo(memberNo);
			// boardCode눈 별도의 매개 변수로 저장 예정

			//게시글 작성에 필요한 기본 파라미터 얻어오기 끝 ------------------

			BoardService service = new BoardService();
			// 모드 (insert/update)에 따라서 추가 파라미터 얻어오기 및 서비스 호출
			String mode = mpReq.getParameter("mode"); // hidden

			if(mode.equals("insert")){//삽입

				//게시글 삽입 서비스 호출 후 결과 반환 받기
				// -> 반환된 게시글 번호를 이용해서 상세조회로 redirect 예정
				int boardNo = service.insertBoard(detail,imageList, boardCode);

				String path = null;

				if(boardNo>0) {//성공
					session.setAttribute("message", "게시글이 등록되었습니다.");
					//detail?no=2000&type=2
					path = "detail?no="+boardNo+"&type="+boardCode;

				}else {//실패
					session.setAttribute("message", "게시글이 등록 실패.");

					// 
					path ="write?mode="+ mode + "&type="+ boardCode;
				}

				resp.sendRedirect(path); //리다이렉트

			}
			if(mode.equals("update")){ // 수정
				// 앞선 코드는 동일(업로드된 이미지 저장, imageList생성, 제목/ 내용 파라미터 동일)

				//+update일 때 추가된 내용
				//어떤 게시글 수정? -> 파라미터no
				//나중에 목록으로 버튼을 만들 때 사용할 현제 페잊 -> 파라미터 cp
				// 이미지 중 x버튼을 눌러서 삭제할 이미지 레벨 목록 -, 파라미터 deleteList
				int boardNo =Integer.parseInt(mpReq.getParameter("no"));
				int cp= Integer.parseInt(mpReq.getParameter("cp"));
				String deleteList =mpReq.getParameter("deleteList");

				// 게시글 수정 서비스 호출후 결과 반환
				// imageList, detail, boardNo, deleteList
				detail.setBoardNo(boardNo);

				//  detail,imageList,deleteList
				int result = service.updateBoard(detail,imageList,deleteList);

				String message =null;
				String path= null;

				if(result> 0) { //성공
					//상세 화면 
					//detail?no=1000&type=1&cp=20
					path =  "detail?no="+boardNo+ "&type="+boardCode+"&cp="+cp;
					message ="게시글이 수정되었습니다.";

				}else { //실패
					//수정화면으로 이동
					//write?mode=update&type=1&cp=20&no=1525

					//상세조회 -> 수정 -> (성공)상세조회
					//			    -> (실패)수정화면
					
					path=req.getHeader("referer");
					//HTTP요청흔적 (요청 바로 이전 페이지 주소) 

					message ="게시글 수정 실패.";

				}
				session.setAttribute("message", message);
				resp.sendRedirect(path);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}







	}
}
