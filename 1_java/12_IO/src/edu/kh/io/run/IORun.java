package edu.kh.io.run;

import edu.kh.io.model.service.IOService;

public class IORun {

	public static void main(String[] args) {
		
		IOService service = new IOService();
		
		//service.output(); //바이트 기반 스트림 Output 확인 예제
		service.output2(); //문자 기반 스트림 Output 확인 예제
		//service.input1(); //바이트 기반 스트림 input 확인 예제
		//service.input2(); //문자 기반 스트림 input 확인 예제
		//service.ObjectOutput(); //객체 출력 보조스트림 ObjectOutput 확인 예제 //직열화
		//service.Objectinput(); //객체 입력 보조스트림 Objectinput 확인 예제 //역직렬화
		//service.listOutput();
		//service.listinput();
		
		
	}

}
