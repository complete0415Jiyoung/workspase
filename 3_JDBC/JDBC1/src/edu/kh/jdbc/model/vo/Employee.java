package edu.kh.jdbc.model.vo;

import java.sql.Date;

public class Employee {
   
   private int empId; // 사번
   private String empName; //이름
   private String empNo; //주민등록번호
   private String email; //이메일
   private String phone; //전화번호
   private String deptCode; // 부서코드
   private String jobCode; //직급코드
   private String salLevel; //급여등급
   private int salary; // 급여
   private double bonus; //보너스율
   private int managerId; //관리자 사번
   private Date hireDate;// 입사일(java.sql.Date)
   private Date entDate; //퇴사일
   private char entYn; //퇴직여부

   public Employee() {}
   
   
   

   public Employee(int empId, String empName, String empNo, String email, String phone, String deptCode, String jobCode,
		int salary, double bonus) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.empNo = empNo;
	this.email = email;
	this.phone = phone;
	this.deptCode = deptCode;
	this.jobCode = jobCode;
	this.salary = salary;
	this.bonus = bonus;
   }




public Employee(int empId, String empName, String empNo, String email, String phone, String deptCode,
         String jobCode, String salLevel, int salary, double bonus, int managerId, Date hireDate, Date entDatel,
         char entYn) {
      super();
      this.empId = empId;
      this.empName = empName;
      this.empNo = empNo;
      this.email = email;
      this.phone = phone;
      this.deptCode = deptCode;
      this.jobCode = jobCode;
      this.salLevel = salLevel;
      this.salary = salary;
      this.bonus = bonus;
      this.managerId = managerId;
      this.hireDate = hireDate;
      this.entDate = entDatel;
      this.entYn = entYn;
   } //기본생성자

   public int getEmpId() {
      return empId;
   }

   public void setEmpId(int empId) {
      this.empId = empId;
   }

   public String getEmpName() {
      return empName;
   }

   public void setEmpName(String empName) {
      this.empName = empName;
   }

   public String getEmpNo() {
      return empNo;
   }

   public void setEmpNo(String empNo) {
      this.empNo = empNo;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getDeptCode() {
      return deptCode;
   }

   public void setDeptCode(String deptCode) {
      this.deptCode = deptCode;
   }

   public String getJobCode() {
      return jobCode;
   }

   public void setJobCode(String jobCode) {
      this.jobCode = jobCode;
   }

   public String getSalLevel() {
      return salLevel;
   }

   public void setSalLevel(String salLevel) {
      this.salLevel = salLevel;
   }

   public int getSalary() {
      return salary;
   }

   public void setSalary(int salary) {
      this.salary = salary;
   }

   public double getBonus() {
      return bonus;
   }

   public void setBonus(double bonus) {
      this.bonus = bonus;
   }

   public int getManagerId() {
      return managerId;
   }

   public void setManagerId(int managerId) {
      this.managerId = managerId;
   }

   public Date getHireDate() {
      return hireDate;
   }

   public void setHireDate(Date hireDate) {
      this.hireDate = hireDate;
   }

   public Date getEntDatel() {
      return entDate;
   }

   public void setEntDatel(Date entDatel) {
      this.entDate = entDatel;
   }

   public char getEntYn() {
      return entYn;
   }

   public void setEntYn(char entYn) {
      this.entYn = entYn;
   }

   @Override
   public String toString() {
      return "Employee [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", email=" + email
            + ", phone=" + phone + ", deptCode=" + deptCode + ", jobCode=" + jobCode + ", salLevel=" + salLevel
            + ", salary=" + salary + ", bonus=" + bonus + ", managerId=" + managerId + ", hireDate=" + hireDate
            + ", entDatel=" + entDate + ", entYn=" + entYn + "]";
   }
   
    
}