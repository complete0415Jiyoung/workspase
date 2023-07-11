package edu.kh.jdbc.board.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.service.BoardService;
import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.board.model.vo.Reply;
import edu.kh.jdbc.member.model.vo.Member;


//게시판 메뉴 전용 화면
public class BoardView {

	//필드
	private Scanner sc = new Scanner(System.in);
	
	private BoardService service = new BoardService();
	
	
	
	/**게시판 전용 메뉴 화면 
	 * @param loginMember (로그인한 회원 정보)
	 */
	public void boardMeun(Member loginMember) {
		int meunNum = -1;
		
		do {
			try {
			   System.out.println("\n********** 게시판 메뉴 **********\n");
	            
	            System.out.println("1. 게시글 목록 조회");
	            System.out.println("2. 게시글 상세 조회(게시글 번호 입력)");
	            //게시글 작성자와 로그인한 회원이 같을 때 
	            //게시글 수정 (update), 게시글 삭제(delete)
	            
	            System.out.println("3. 게시글 작성(INSERT)");
	            System.out.println("4. 게시글 검색(제목/내용/제목+내용/작성자)");
	            
	            System.out.println("0. 회원 메뉴로 돌아가기");
				
	            System.out.println("메뉴 선택해 주세요>>");
	            meunNum =sc.nextInt();
	            sc.nextLine(); //개행 제거
	            System.out.println();//줄바꿈
	            
	            
	            switch (meunNum) {
				case 1: selectAll();	break;
				case 2:	selectOne(loginMember); break;
				//상세 조회시 게시글 수정 / 삭제 (게시글 == 로그인한 회원과 비교)
				//	- 댓글 (누가 작성?) /작성자가 수정, 삭제 확인
				//	-> loginMember 메개 변수로 전달
				case 3: insertBoard(loginMember.getMemeberNum()); break;
				case 4:	searchBoard(); break;
				case 0: System.out.println("회원 메뉴로 돌아갑니다..");	break;

				default:System.out.println("메뉴에 작성된 번호를 입력해 주세요"); break;
				}
	            
			} catch (InputMismatchException e) {
				System.out.println("\n입력 형식이 올바르지 않습니다 . 다시 입력해 주세요.");
				sc.nextLine(); //입력버퍼 남은 문자열 제거
			}
			
		}while(meunNum != 0);
		
	}



	/**게시글 검색
	 * 
	 */
	private void searchBoard() {
		System.out.println("\n[게시글 검색]\n");	
		
		int menuNum = -1;
		
		do {
			try {
				
				System.out.println("---검색 조건을 선택해 주세요----");	
				System.out.println("1.  제목");
				System.out.println("2.  내용");
				System.out.println("3.  제목+내용");
				System.out.println("4.  작성자");
				System.out.println("0.  돌아가기");
				
				System.out.println();
				menuNum = sc.nextInt();
				sc.nextLine();
				
				switch (menuNum) {
				case 0: System.out.println("\n 게시판 메뉴로 돌아갑니다..\n"); break;
				case 1:  case 2: case 3: case 4: 
					//공통적으로 검색어 입력 ->Service 호출 
					
					System.out.println( "검색어 : ");
					String keyword = sc.nextLine();
					
						
					List<Board> boardList = service.searchBoard(menuNum, keyword);
					
					if( boardList.isEmpty()) {//검색 결과가 없음 
						System.out.println("\n검색 결과가 없습니다.\n");
						
					}else {//검색 결과가 있음 
						System.out.println("------------------------------------------------------------------------");
		                  System.out.printf("%3s  %13s%12s   %7s%3s %7s%2s %s\n",
		                           "글번호", "제목", "", "작성자", "", "작성일", "" , "조회수");
		                  System.out.println("------------------------------------------------------------------------");
		                  
		                  // 향상된 for문
		                  for(Board b : boardList) {
		                     
		                     System.out.printf("%3d  %20s [%d]  %10s  %s %3d\n",
		                           b.getBoardNo(), b.getBoardTitle(), b.getReplyCount(),
		                           b.getMemberName(), b.getCreateDate().toString(), b.getReadConut());
		                  }
						
						
					}
					
					break;

				default: System.out.println("\n메뉴에 작성된 번호를 입력해 주세요.\n");	break;
				}
				
			}catch (InputMismatchException e) {
				System.out.println("\n입력형식이 올바르지 않습니다 다시 입력해 주세요");
				sc.nextLine();
				e.printStackTrace();
			}catch(Exception e) {
				System.out.println("\n<게시글 검색 중 예외 발생>\n ");
				e.printStackTrace();
				break; //검색 반복문 종료
			}
			
			
			
		} while (menuNum!=0);
		
		
		
	}



	/** 게시글 작성 
	 * @param memeberNum
	 */
	private void insertBoard(int memeberNum) {
		System.out.println("\n[게시글 작성]\n");
		
		System.out.println("게시글 제목 : ");
		String boardTitle =sc.nextLine();
		
		System.out.println("\n게시글 내용 (종료 시 @exit입력)\n");
		//회원 번호 , 게시글 번호, 댓글 내용-> 하나의 reply객체에 저장
		String boardContent = inputContent();
		
		Board board = new Board();
		board.setMemberNo(memeberNum);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
	
		try {
			//댓글 삽입 (insert)service 호출 후 반환 
			
			int result = service.insertBoard(board);
			
			if(result > 0 ) {
				System.out.println("\n게시글 작성되었습니다\n");
			}else {
				System.out.println("게시글 작성 실패");
			}
			
		} catch (Exception e) {
			System.out.println("\n<게시글 작성 중 예외 발생>\n");
			e.printStackTrace();
		}
		
		
	}



	/**
	 * 게시글 목록 조회
	 */
	private void selectAll() {
		
		System.out.println("[게시글 목록 조회]");
		
		try {
			//게시글 목록 조회 Service 호출후 반환 받기
			List<Board> boardList=	service.selectAll();
		
			if(boardList.isEmpty()) {//조회 결과가 없는 경우 
				System.out.println("\n<조회된 게시글이 없습니다>\n");
				
			}else {
				System.out.println("------------------------------------------------------------------------");
	            System.out.printf("%3s  %13s%12s   %7s%3s %7s%2s %s\n",
	                     "글번호", "제목", "", "작성자", "", "작성일", "" , "조회수");
	            System.out.println("------------------------------------------------------------------------");
	            
	            // 향상된 for문
	            for(Board b : boardList) {
	               
	               System.out.printf("%3d  %20s [%d]  %10s  %s %3d\n",
	                     b.getBoardNo(), b.getBoardTitle(), b.getReplyCount(),
	                     b.getMemberName(), b.getCreateDate().toString(), b.getReadConut());
	            
				}
			}
				
		} catch (Exception e) {
			System.out.println("\n<게시글 목록 조회 중 예외 발생>\n");
			e.printStackTrace();
		}
	}
	
	
	
	/**게시글 상세조회
	 * @param loginMember
	 */
	private void selectOne(Member loginMember) {
		System.out.println("[게시글 상세 조회]"); 
		
		System.out.println("조회할 게시글 번호 입력 : ");
		
		int boardNo = sc.nextInt();
		sc.nextLine();
		
		//게시글 상세 조회 Service 호출 후 결과 반환(게시글 1개의 정보 == Board)
		try {
			Board board = service.selectOne(boardNo);
			
			if(board != null) {//조회된 게시글이 있을 경우
				
				// 상세 조회 출력
	            System.out.println("\n------------------------------------------------------------");
	            System.out.printf("번호 1: %d     |  제목 : %s\n", board.getBoardNo(), board.getBoardTitle());
	            System.out.println("------------------------------------------------------------");
	            System.out.printf("작성자 : %s\n"
	                        + "작성일 : %s\n"
	                        + "조회수 : %d\n", 
	                        board.getMemberName(), board.getCreateDate(), board.getReadConut());
	            System.out.println("------------------------------------------------------------");
	            System.out.printf("\n%s\n\n", board.getBoardContent());
	            System.out.println("------------------------------------------------------------");
	            
	            // 댓글 목록 조회
	            System.out.println("\n[댓글]");
	            for( Reply r : board.getReplyList() ) {
	               System.out.printf("<%d> | %s | %s\n", 
	                     r.getReplyNo(), r.getMemberName(), r.getCreateDate());
	               
	               System.out.println(r.getReplyContent());
	               System.out.println(".............................................................\n");
	            }
				
	        // -------------------------------------------
            // 상세 조회용 메뉴 출력
            
            System.out.println("===== 상세 조회 메뉴 =====");
            
            System.out.println("1. 댓글 삽입"); //어떤 회원이든 가능 
            
            //댓글 번호 입력 받아서 
            //댓글을 작성한 번호 == 로그인 회원 번호 
            //-> 수정 /삭제
            
            System.out.println("2. 댓글 수정"); 
            System.out.println("3. 댓글 삭제");   
            //댓글 번호 입력 받아 
            //댓글 작성한 화원번호 == 로그인한 회원 번호
            //-> 수정 / 삭제
            
            
            //상세 게시글의 회원 번호 == 로그인한 회원 번호 
            //-> 게시글 수정/ 삭제
            if(board.getMemberNo() == loginMember.getMemeberNum()) {
            	
            	System.out.println("4. 게시글 수정");
            	System.out.println("5. 게시글 삭제");
            }
         
            
            System.out.println("0. 게시판 메뉴로 돌아가기");
            
            System.out.print("메뉴 선택 >> ");
            int menuNum = sc.nextInt();
            sc.nextLine();
            
            
            switch (menuNum) {
            case 0: System.out.println("\n게시판 메뉴로 돌아갑니다...\n"); break;
			case 1: insertReply(loginMember,boardNo); break;
			case 2: case 3: 
			
			String temp = menuNum ==2 ? "\n[댓글 수정]\n": "\n[댓글 삭제]\n"; //삼항연산자 
			
			System.out.println(temp);
			System.out.println("댓글 번호 입력 :");
			int inputNo =sc.nextInt();
			sc.nextLine();
			
			
			//입력 받은 댓글번호가 댓글 목록에 있는지 확인
			Reply reply = null; //확인된 댓글 참조 할 변수
			for(Reply r: board.getReplyList()) { //반복접근
				
				if(r.getReplyNo() == inputNo) {//입력 받은 번호와 일치하는 댓글이 있다면
					
					reply=r;
					break;
				}
			}
			
			if (reply ==null) {//같은 댓글 번호가 목록에 없는 경우
				System.out.println("\n해당 댓글이 존재하지않습니다\n");
			
			}else {//같은 댓글 번호가 목록에 있을 경우 
				
				//해당 댓글의 회원 번호가 목록에 있는 경우 
				//로그인한 회원의 번호가 같은지 확인
				//-> 같은 경우 로그인 한 사람의 댓글 
			if(loginMember.getMemeberNum() == reply.getMemberNo()) {
					if(menuNum ==2) updateReply(inputNo); //댓글 수정
					else 			dateReply(inputNo); //댓글 삭제
					
				}else {
					System.out.println("\n현재 로그인한 회원의 댓글이 아닙니다\n ");
				}
			
				
				
				
			}
			break;
			
			case 4: case 5: 
				System.out.println();
				//게시글 작성자 번호가 로그인 회원번호이면 4,5번 실행 
				if(board.getMemberNo() == loginMember.getMemeberNum()) {
					
					//4번 게시글 수정
					if(menuNum == 4 ) {
						updateBoard(boardNo);//수정용 메소드
					}else {//5번 게시글 삭제
						deleteBoard(boardNo);
						
					}
					
				}else {
					 System.out.println("메뉴에 표시된 번호만 입력해 주세요"); 
				}
				
				break;
				
			default: System.out.println("메뉴에 표시된 번호만 입력해 주세요"); break;
			}
	            
	            
	            
			}else {//board==null 조회된 게시글이 없을 경우
				System.out.println("\n존재하지 않는 게시글 번호입니다\n");
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println("\n<게시글 상세 조회 중 예외 발생>\n");
			e.printStackTrace();
		}
		
		
	}







	/**댓글 삭제
	 * @param inputNo
	 */
	private void dateReply(int inputNo) {
		System.out.println("\n[댓글 삭제]\n");

		char ch = ' '; //Y/N 저장
		while(true) {
			System.out.print("정말 삭제하시겠습니까 (Y/N) :");
			ch = sc.next().toUpperCase().charAt(0);
			
			
			if(ch=='Y'|| ch =='N') { //YN인 경우 추가입력 안하고 반복 종료
				break;
			}else {
				System.out.println("Y또는 N입력해 주세요");
				
			}
			
		}
		
		if(ch =='Y') { //삭제할 경우 
			//보안 문자 생성
			String cap = capcha();
			System.out.print("다음 보안문자를 입력해 주세요>> "+ cap);
			
			System.out.print("보안문자 입력 : ");
			String input =sc.next();
			sc.nextLine();
			
			if(input.equals(cap)){//입력 받은 문자열과 보안 문자가 같을 때
				//삭제 Service 호출
				
				Reply reply = new Reply();
				reply.setReplyNo(inputNo);
				try {
					
					int result = service.deleteReply(reply);
					
					
					if( result > 0) {// 삭제 성공
						System.out.println("\n["+ reply.getReplyNo()+"번 댓글이 삭제 되었습니다]\n");
					
					}else {//삭제 실패 
						System.out.println("\n[댓글 삭제 실패]\n");
					}
					
				} catch (Exception e) {
					System.out.println("\n<댓글 삭제 중 예외 발생>\n");
					e.printStackTrace();
				}
				
				
			}else {
				//취소
				System.out.println("\n보안문자가 일치하지 않습니다(삭제취소)\n");
				
			}
		}else {
			System.out.println("\n삭제를 취소했습니다\n");
		}
		
	}



	/**댓글 수정
	 * @param inputNo
	 */
	private void updateReply(int inputNo) {
		System.out.println("수정할 내용 입력 (종료시 @exit  입력)");
		
		String replyContent = inputContent();
		
		//Reply객체 생성 
		Reply reply = new Reply(); 
		
		reply.setReplyNo(inputNo);
		reply.setReplyContent(replyContent);
		
		try {
			int result = service.updateReply(reply);
					
			if( result > 0) {
				System.out.println(reply.getReplyNo() + "번 댓글이 수정되었습니다\n");
			}else {
				System.out.println("댓글 수정실패\n");
			}
			
		} catch (Exception e) {
			System.out.println("\n<댓글 수정 중 예외 발생>\n");
			e.printStackTrace();
		}
	}



	/** 게시글 수정
	 * @param boardNo
	 */
	private void updateBoard(int boardNo) {
		
		System.out.println("\n[게시글 수정]\n");
		
		System.out.println("수정할 제목 : ");
		String boardTitle = sc.nextLine();
		
		System.out.println("\n수정할 내용 (종료시 @exit 입력)\n");
		
		String boardContent = inputContent(); //내용 입력 메소드를 호출한 후 결과 반환
	
		
		// 게시글 번호 / 수정한 제목  + 내용 한번에 저장할 Board객체 생성 
		Board board = new Board();
		
		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		try {
			int result = service.updateBoard(board);
					
			if( result > 0) {
				System.out.println(boardNo+"번 개시글이 수정되었습니다");
			}else {
				System.out.println("수정실패");
			}
			
		} catch (Exception e) {
			System.out.println("\n<게시글 수정 중 예외 발생>\n");
			e.printStackTrace();
		}
	}

	
	/**댓글 작성
	 * @param loginMember
	 * @param boardNo
	 */
	private void insertReply(Member loginMember, int boardNo) {

		System.out.println("\n[댓글 작성]\n");
		
		System.out.println("댓글 내용 입력 (종료시@exit입력) \n");
		String replyContent = inputContent();
		
		
		 //회원 번호 , 게시글 번호, 댓글 내용-> 하나의 reply객체에 저장
		Reply reply = new Reply();
		reply.setMemberNo(loginMember.getMemeberNum());
		reply.setBoardNo(boardNo);
		reply.setReplyContent(replyContent);
	
		try {
			//댓글 삽입 (insert)service 호출 후 반환 
			
			int result = service.insertReply(reply);
			
			if(result > 0 ) {
				System.out.println("\n댓글 작성되었습니다\n");
			}else {
				System.out.println("댓글 작성 실패");
			}
			
		} catch (Exception e) {
			System.out.println("\n<댓글 작성 중 예외 발생>\n");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	/*String (객체)
	 * -불변성(immutable) <-> 가변성 (mutable)
	 * 
	 * ->한번 생성된 String 겍체에 저장된 문자열은 변하지 않는다
	 * 
	 * ex) Sting str = "abc"; //Heap 영역에 String 객체가 생성되고 
	 * 						  //생성된 객체에 "abc" 문자열 저장
	 * 
	 * 		str = "123";	//Heap영역에 새로운String 객체가 생성되고 
	 *						//생성된 객체의 "123"문자열 저장 후 
	 *						//객체 주소를 str에 대입
	 * 
	 * ex) String str = "abc";
	 * 		
	 * 		str += "123";  //"123"이 저장된 String객체 생성 후 
	 * 
	 *	//"abc"와 "123"이 합쳐진 String 객체가 추가로 별도 생성
	 *	//그후 "abc123"객체를 String이 참조 
	 *
	 * **String의 문제점**
	 *  //- String 에 저장된 값을 바꾸거나 누적하려고 할때 마다 
	 *	String객체가 무분별하게 생성된 -->메모리 낭비(메모리 누수)
	 *
	 * **해결 방법 ** 
	 * -  StringBeffer / StringBuilder (가변성)
	 * 		클래스를 자바에서 제공함
	 * 
	 *    StringBeffer / StringBuilder 사용방법 차이 없음
	 * -> 차이점은 동기/ 비동기 차이 없음 
	 * 
	 * 
	 * */
	
	
	/**게시글 댓글 / 내용 입력 메소드 
	 * @return content
	 */
	private String inputContent() {
		StringBuffer  content = new StringBuffer();
		String input =null;
		
		while(true) { //@exit가 입력 될 때까지 무한히 문자열 입력 받아 
			  //하나의 변수에 누적 == 게시글 내용
			input = sc.nextLine();
			if( input.equals("@exit")) { //만약에 @exit가 입력 된 경우 
				break;
			}else{
				//content += input+ "\n";//줄바꾸면서 누적
				
				content.append(input);
				content.append("\n");
				//StringBeffer 에 저장된 문자열의 제일 뒤에 input 을 추가 (누적)
				//append (제일 뒤에) 덧붙이다, 추가하다, 첨부하다
				
				//->하나의 StringBeffer객체에 문자열이 계속 누적 ==(가변)
				//	(추가적인 Sting객체 생성이 없다)
			}
		}
		return content.toString(); //StringBeffer에 오버라이된toSting() 
								   //->저장된 문자열을 String형태로 반환 
	}


	/**게시글 삭제
	 * @param board
	 */
	private void deleteBoard(int boardNo) {
		//"정말 삭제하시겠습니까 (Y/N) --제대로 입력 될 때까지 무한 반복"
		//-> 'Y' 입력시 
		//-> 보안문자 생성 
		//-> 보안문자가 일치하는 경우에 삭제 진행
		System.out.println("\n[게시글 삭제]\n");

		char ch = ' '; //Y/N 저장
		while(true) {
			System.out.println("정말 삭제하시겠습니까 (Y/N) :");
			ch = sc.next().toUpperCase().charAt(0);
			
			
			if(ch=='Y'|| ch =='N') { //YN인 경우 추가입력 안하고 반복 종료
				break;
			}else {
				System.out.println("Y또는 N입력해 주세요");
				
			}
			
		}
		
		if(ch =='Y') { //삭제할 경우 
			//보안 문자 생성
			String cap = capcha();
			System.out.println("다음 보안문자를 입력해 주세요>> "+ cap);
			
			System.out.println("보안문자 입력 : ");
			String input =sc.next();
			sc.nextLine();
			
			if(input.equals(cap)){//입력 받은 문자열과 보안 문자가 같을 때
				//삭제 Service 호출
				
				try {
					
					int result = service.deleteBoard(boardNo);
					
					if( result > 0) {// 삭제 성공
						System.out.println("\n["+ boardNo+"번 게시글이 삭제 되었습니다]\n");
					
					}else {//삭제 실패 
						System.out.println("\n[게시글 삭제 실패]\n");
					}
					
				} catch (Exception e) {
					System.out.println("\n<게시글 삭제 중 예외 발생>\n");
					e.printStackTrace();
				}
				
				
			}else {
				//취소
				System.out.println("\n보안문자가 일치하지 않습니다(삭제취소)\n");
				
			}
		}else {
			System.out.println("\n삭제를 취소했습니다\n");
		}
	
	
	}



	/**보안 문자 생성 메소드(렌덤 영어 소문자 5개)
	 * @return cap
	 */
	private String capcha() {

		String cap ="";
		for(int i =0; i <5;i++) {
			cap += (char)(Math.random()* 26 +'a');
				//int 형변환 : 97 ~ 122
				//char 형변환 :'a' ~ 'z'
		}
		
		return cap;
	}

}
