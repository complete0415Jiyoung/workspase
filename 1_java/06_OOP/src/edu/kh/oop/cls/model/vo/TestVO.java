package edu.kh.oop.cls.model.vo;

 class TestVO {

//접근 제한자 (default):같은 패키지 내에서만 import가 가능함을 나타냄
	 
// Student와 같은 패키지 
	 //-> public, protected, (default) 3개만 접근
	 
	 
	 public void ex() {
		 System.out.println("같은 패키지"); //학생 객체 생성
		 
		 Student std =new Student();
		 
		 
		 System.out.println(std.v1);
		 System.out.println(std.v2);
		 System.out.println(std.v3);
		 //System.out.println(std.v4);
		 //v4는 private이기 때문 다른 패키지 직접 접근 불가능 
		 
		 
	 }
	 
	 
}
