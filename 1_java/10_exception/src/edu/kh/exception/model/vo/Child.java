package edu.kh.exception.model.vo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Child extends Parent{
	
	@Override
	public void method() throws FileNotFoundException{
		System.out.println("오버라이딩된 자식 메소드");
	}

}
