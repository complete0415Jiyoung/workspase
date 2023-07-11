package edu.kh.jdbc.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.model.service.EmployeeService;
import edu.kh.jdbc.model.vo.Employee;


//View :입력 출력을 담당하는 클래스 
//-사용자 담당 인터페이스 요소로 사용자의 요청과 응답을 보여주는 화면



public class EmployeeView {
	
	private Scanner sc = new Scanner(System.in);
	
	//공통적으로 호출할 Service 객체를 필드에 생성
	private EmployeeService service = new EmployeeService();
	
	
	
	
	/**
	 * @author 이지영
	 *  메인 메뉴
	 */
	public void displayMenu() {
		
		int meunNum = -1 ;
		do {
			try {
				
				System.out.println();
	            System.out.println("====================================");
	            System.out.println("[사원 관리 프로그램]");
	            System.out.println("1. 전체 사원 정보 조회");
	            System.out.println("2. 사번으로 사원 정보 조회");
	            System.out.println("3. 새로운 사원 정보 추가");
	            System.out.println("4. 사번으로 사원 정보 수정");
	            System.out.println("5. 사번으로 사원 정보 삭제");
	            System.out.println("6. 입력 받은 급여 이상으로 받는 모든 직원 조회");
	            System.out.println("7. 부서 코드, 보너스율을 입력 받아 해당 부서의 보너스를 모두 수정");
	           
	            System.out.println("0. 프로그램 종료");
				System.out.println("====================================");
				
				System.out.print("메뉴선택 : ");
				meunNum = sc.nextInt();
				System.out.println();
				
				switch(meunNum) {
				case 1 : selectAll(); break;
				case 2 : selectOne(); break;
				case 3 : insertEmployee(); break;
				case 4 : updateEmployee(); break;
				case 5 : deleteEmployee(); break;
				case 6 : selectSalary(); break;
				case 7 : updateBonus(); break;
				case 0 : System.out.println("프로그램을 종료합니다...");break;
				
				default: System.out.println("잘못입력하셨습니다 다시입력해주세요"); 
				}
				
				
			}catch (InputMismatchException e) {
				System.out.println("입력 형식이 잘못되었습니다. 다시 시작해주세요");
				//meunNum = -1; 
				sc.nextLine();//입력 버퍼에 남아있는 잘못된 문자열 제거
			}
			
		}while(meunNum !=0);
		
	}
	
	
	/**
	 * 전체 사원 정보 조회
	 */
	public void selectAll() {
		System.out.println("[전체 사원 정보 조회]");
		
		//DB에서 조회해온 사원 리스트를 출력
		
		//전체사원의 정보를 반환하는 서비스 메서드 호출
		List <Employee> empList = service.slectAll();
		
		//2) 서비스 호출 결과를 출력용 메소드를 이용해서 출력 
		printList(empList);
		
		
	}

	
	/**
	 * Employee List 출력용 view
	 */
	public void printList(List<Employee> empList) {
		//Employee로 타입 제한된 리스트 Employee ==Employee만 담긴 List
		
		if(empList.isEmpty()) {//empList가 비었있을 경우 == 조회 결과가 없을 경우
			System.out.println("조회결과가 없습니다");
		
		
		}else {//비어있지 않은 경우
			
			for( Employee emp : empList) {
				System.out.println(emp);
			}
			
		}
		
	}
	
	
	/**
	 *  사번 입력용 view(2,4,5번 메뉴에 필요)
	 * @param empList
	 */
	public int inputEmpId () {

		System.out.print("사번을 입력하세요 : ");
		int empNum = sc.nextInt();
		sc.nextLine();
		
		return empNum;
	
	}
	
	/**
	 *사번으로 사원 정보 조회 view
	 *
	 */
	public void selectOne() {
		System.out.println("[사번으로 사원 정보 조회]");
		
		//사번 입력 받기
		int input = inputEmpId();
		
		Employee emp = service.selectOne(input);
		
		List<Employee>empList = new ArrayList<Employee>(); 		
		//emp가 참조하고 있는 객체가 있는지 확인  == 조회결과가 있는지
		
		if(emp != null) {
			empList.add(emp);
			
		}
		printList(empList);
	}
	
	/**
	 * 입력 받은 급여 이상으로 받는 모든 직원 view
	 */
	public void selectSalary() {
		System.out.println("입력 받은 급여 이상으로 받는 모든 직원 조회 ]");

		System.out.println("급여를 입력하세요: ");
		int input = sc.nextInt();
		sc.nextLine();
		
		
		List <Employee> empList = service.selctSalary(input);
		
		printList(empList);
		
		System.out.println("총인원 : "+ empList.size()+ "명");
	}
	
	
	/**
	 * 새로운 사원 정보 추가 view
	 */
	public void insertEmployee() {
		
		System.out.println("[새로운 사원 정보 추가]");
		
		System.out.print("사번 : ");
		int empId = sc.nextInt(); 
		
		System.out.print("이름 : ");
		String empName = sc.next(); 
		
		System.out.print("주민등록번호 : ");
		String empNo = sc.next(); 
		
		System.out.print("이메일 : ");
		String email= sc.next(); 
		
		System.out.print("전화번호 : ");
		String phone = sc.next(); 
		
		System.out.print("부서 코드(D1 ~D9) : ");
		String deptCode = sc.next(); 
		
		System.out.print("직급코드 (J1 ~J7) : ");
		String jobCode = sc.next(); 
		
		System.out.print("급여 : ");
		int salary= sc.nextInt(); 
		
		System.out.print("보너스율 : ");
		double bonus = sc.nextDouble(); 
		sc.nextLine();
		
		//입력 받은 값을 employee객체에 저장		
		Employee emp = new Employee(empId, empName, empNo, email, phone, deptCode, jobCode, salary, bonus);
		
		
		//사원 정보 삽입 서비스 호출 
		int result = service.insertEmployee(emp);
		
		if( result > 0 ) { //삽입성공
			System.out.println("사원 정보가 추가 되었습니다.");
		}else {
			System.out.println("사원 정보 추가 실패");
		}
	}
	
	/**
	 * 사번으로 정보 삭제 view
	 */
	public void deleteEmployee() {
		
		//employee2 테이블에서 
		// 사번을 입력 받고  일치하는 사번을 가진 사원 정보 삭제 (DELETE) 
		
		//조건 1: preparedStatement 사용 
		//조건 2: 삭제 성공 시 --> 삭제 되었습니다 
		//			삭제 실패시 --> "일치하는 사번의 사원이 없습니다" 
		
		System.out.println("[사원으로 사원 정보 삭제]");
		
		int input =inputEmpId ();
		
		//DELETE (DML) 수행시 결과 행의 자료형 반환
		int result = service.deleteEmployee(input);
		
		if( result > 0 ) { 
			System.out.println("삭제 되었습니다");
		}else {
			System.out.println("일치하는 사원이 없습니다.");
		}
		
	}
	
	/**
	 * 사번으로 정보 수정 view
	 */
	public void updateEmployee() {
		System.out.println("[사원으로 사원 정보 수정]");
		
		int input =inputEmpId (); //사번 입력 받는 메소드 후출 후 결과 반환 받기
		
		//이메일, 전화번호, 급여 입력 받기 
		System.out.print("변경된 이메일 입력: ");
		String email= sc.next(); 
		
		System.out.print("변경된 전화번호 입력 : ");
		String phone = sc.next(); 
		
		System.out.print("변경된 급여 입력: ");
		int salary= sc.nextInt(); 
		sc.nextLine(); // 입력 버퍼 개행문자 제거
		
		//입력된 내용을 Employee 객체 생성하여 저장 
		Employee emp = new Employee();
		
		//setter 이용해서 세팅
		emp.setEmpId(input);
		emp.setEmail(email);
		emp.setPhone(phone);
		emp.setSalary(salary);
		
		//수정 == UPDATE(DML)== 성공한 행의 개수 반환
		int result = service.updateEmployee(emp);
		
		if( result > 0 ) { 
			System.out.println("수정하였습니다");
		}else {
			System.out.println("일치하는 사원이 없습니다.");
		}
		
	}
	/**
	 * 부서 코드, 보너스율을 입력 받아 해당 부서의 보너스를 모두 수정
	 */
	public void updateBonus() {
		System.out.println("[부서의 보너스를 모두 수정]");
		//메소드명 : updateBonus()
        //[실행화면 ]
		// 부서코드를 입력하세요  : D1
        // 보너스율을 입력하세요 : 0.3
        
        // (성공 시) : D1 부서 코드의 보너스율이 0.3으로 변경 되었습니다
        // (실패 시) : 일치하는 부서 코드가 없습니다.
        // 출력 
        
        //DAO 작성시 Statement 사용 
		// +(PreparStatement)
		System.out.print("부서 코드를 입력하세요: ");
		String deptCode= sc.next(); 
		
		System.out.print("보너스율을 입력하세요  : ");
		double bonus = sc.nextDouble(); 
		sc.nextLine(); // 입력 버퍼 개행문자 제거
		
		//입력된 내용을 Employee 객체 생성하여 저장 
		Employee emp = new Employee();
		//setter 이용해서 세팅
		emp.setDeptCode(deptCode);
		emp.setBonus(bonus);
	
		int result = service.updateBonus(emp);
		
		if( result > 0 ) { 
			System.out.printf(" %s 부서의 보너스율이 %.1f 으로 변경 되었습니다 \n",deptCode ,bonus);
		}else {
			System.out.println("일치하는 부서코드가 존재하지 않습니다.");
		}
				
		
	}

}
