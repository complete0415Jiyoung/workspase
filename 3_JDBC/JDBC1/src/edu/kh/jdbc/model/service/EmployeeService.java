package edu.kh.jdbc.model.service;

import java.util.List;

import edu.kh.jdbc.model.vo.Employee;
import edu.kh.jdbc.modle.dao.EmployeeDAO;


//Service : 요청에 맞는 기능를 수행하여 결과를 제공
//- 전달 받은 데이터 또는 DAO 수행 결과 데이터를 필요한 형태로 가공처리

public class EmployeeService {

	private EmployeeDAO dao = new EmployeeDAO();
	
	/**
	 * 전체 사원 정보 조회 서비스
	 */
	public List<Employee>slectAll() {
		
		//별도로 가공할 내용이 없으면 바로DAO 호출 
		List<Employee>empList =dao.selectAll();
		
		
		return empList;
	}

	
	/**
	 * 사번으로 사원 조회 서비스 
	 *
	 */
	public Employee selectOne(int input) {
	
		Employee emp = dao.selectOne(input);
		
		
		return emp; //DAO 호출 결과 바로 View 반환
	}

	/**
	 * 입력받은 급여 이상으로 받는 모든 직원 service
	 * 
	 *
	 */
	public List<Employee> selctSalary(int input){
		

		List <Employee> empList = dao.selctSalary(input);
		
		return empList;
	}

	/**
	 *새로운 사원 정보 추가 서비스 
	 */
	public int insertEmployee(Employee emp) {
		
		int result = dao.insertEmployee(emp);
		
		return result ; //INSERT 수행 결과 반환
	}
	
	
	/**
	 * 사번으로 사원 정보 삭제 서비스
	 */
	public int deleteEmployee(int input) {
		
		  int result = dao.deleteEmployee(input);
		
		return result ; //INSERT 수행 결과 반환
	}

	/**
	 * 사번으로 사원 정보 수정 서비스
	 */
	public int updateEmployee(Employee emp) {
		
		//int result = dao.updateEmployee(emp);//PreparedStatement 사용
		
		int result = dao.updateEmployee2(emp); //Statement 사용+
		
		return result ;
	}

	/**
	 * 부서의 보너스를 모두 수정하는 서비스
	 */
	public int updateBonus(Employee emp) {
		
		//int result = dao.updateBonus(emp); //Statement
		int result = dao.updateBonus2(emp); //preparedStatement
		
		return result;
	}

}
