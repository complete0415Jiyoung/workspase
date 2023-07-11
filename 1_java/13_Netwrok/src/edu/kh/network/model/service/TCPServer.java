package edu.kh.network.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

public class TCPServer {
//	Server		: 서비스를 제공하는 프로그램 또는 컴퓨터 
//	Client 		: 서버에 서비스를 요청하여 사용하는 프로그램 또는 컴퓨터 
//	TCP Socket	: 프로그래밍 
//	TCP  		: 데이터 전달의 신뢰성을 최대한 보장하기 위한 방식 (연결지향형 통신)		
//	 			  순차적으로 데이터를 전달하고 확인 및 오류 시 재전송
//	Socket 		: 프로세스의 통신에 사용되는 양 끝단.
//	 			서버와 클라이언트가 통신을 하기 위한 매개체 
//	 				
//	ServerSoket: 서버용 소캣
//		- Port와 연결되어 외부 요청을 기다리는 역할 
//		-> 클라이언트가 사용 할 수 있는 소캣을 생성
//		-----> 서버 소캣과 클라이언트 소캣이 연결되어 데이터 통신이 가능해짐
	
	
	public void serverStart() {
		
//		1. 서버의 포트번호 정함
		int port = 8500; //port 번호는 0~ 65535 사이 지정 가능
							//단, 1023번 이하는 이미 사용 중인 경우가 많으니 제외
		
		//*사용 변수 미리 선언*
		ServerSocket serverSocket = null; 	//서버 소켓 저장 변수 
		Socket clientSocket = null;			//클라이언트 소켓 저장 변수 
		
		InputStream is = null; 				//클라이언트 -> 서버 입력용 변수 
		BufferedReader br = null; 			//입력용 보조스트림 변수 
		
		OutputStream os = null;				//서버 -> 클라이언트 출력용 스트림 변수 
		PrintWriter pw = null;	 			//입력용 보조스트림 변수 
		
		try {
//		2. 서버용 소켓 객체 생성
			serverSocket = new ServerSocket(port);//서버용 소캣 생성하여 포트 결합
			
//		3. 클라이언트 쪽에서 접속 요청이 오길 기다림
			// - 서버용 소캣은 클라이언트 요청이 올때 까지 
			//   다음 코드를 수행하지 않고 있음
			
			System.out.println("[Server]");
			System.out.println("클라이언트 요청 기다리고 있습니다.");
			                       
//		4. 접속 요청이 오면 요청 수락 후 해당 클라이언트에 대한 소켓 객체 생성
			//요청을 수락하면 자동으로 Socket객체가 얻어와 진다.
			clientSocket = serverSocket.accept();
			
			//접속한 클라이언트에 IP를 얻어와서 출력
			String clientIP = clientSocket.getInetAddress().getHostAddress();
			System.out.println(clientIP+ "가 연결을 요청함");
			
//		5. 연결된 클라이언트와 입출력 스트림 생성
			is = clientSocket.getInputStream();
			os = clientSocket.getOutputStream();
			
//		6. 보조 스트림을 통해 성능 개선
			br = new BufferedReader(new InputStreamReader(is));
			//InputStreamReader : 문자기반스트림과 바이트기반스트림 연결에 사용되는 스트림
			
			pw= new PrintWriter(os);
			
//		7. 스트림을 통해 읽고 쓰기
			
			// 7-1 ) 서버 -> 클라이언트 에게 출력 (메시지 전송)
			Date now = new Date(); //생성된 시간을 기록하고 있는 시간 관련 객체 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			
			String time = sdf.format(now); //now에 저장된 시간 포멧물 변경
			
			pw.println(time + "[서버 접속 성공]");
			pw.flush(); //스트림에 있는 내용을 모두 밀어냄

			// 7-2) 클라이언트 -> 서버에게 입력 메시지 전송 받기
			String message=br.readLine(); //클라이언트 메시지 한줄 읽어옴 
		
			System.out.println(clientIP+ "가 보낸 메세지 : "+ message);

		} catch (IOException e) {
			e.printStackTrace();//예외 추적
			
		}finally {
//		8. 통신 종료
			//사용한 소캣 , 스트림 자원 모두 반환 (close);
			try {
				// 보조스트림 close 시 연결된 기반 스트림 (is, os)도 같이 close
				if(pw != null) 		pw.close();
				if(br != null)		br.close();
				
				if(serverSocket != null) serverSocket.close();
				if(clientSocket != null) clientSocket.close();
				
				//if문에 {}을 사용 안하면 다음 한줄 (; 기준) 이 if문 내부 코드가 된다.
			} catch (IOException e) {
				e.printStackTrace();
			
			}
			
		}
		
		
		
	}

}
