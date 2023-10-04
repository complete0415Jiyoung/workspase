<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<script src="https://code.jquery.com/jquery-3.4.0.js"></script>



<!--

1. 텍스트 입력창과 바로 옆에 결과를 출력할 Span 태그를 준비한다.

> 텍스트 입력 창의 ID 는 email

> Span 태그의 ID는 result

-->

<input type="text" id="email"><span id="result"></span>



<!-- 2. 텍스트 입력창에는 사용자 입력을 감지하는 이벤트를 적용한다.  입력 이벤트가 발생하면 , 현재까지 입력된 내용에 대하여 email 형식에 맞는지 검증한다.-->
<script>
$("#email").on("input",function(){

var email = $("#email").val();

var regex = "/\w+@\w\.\w/$\";

if(regex.exec(email) == null){

// 3. email 형식에 맞지 않다면 span 태그에 "이메일 형식에 맞지 않습니다." 를 출력하고 return 한다.

$("#result").text("이메일 형식에 맞지 않습니다.");

return;

}

//  4. 만약 email 형식에 맞는다면, Controller의 CheckEmail Method 으로 {email : "입력값"} 을 비동기 전송한다.

$.ajax({

url:"/CheckEmail",

data:{email: $("#email").val()},


success:function(resp){

// 10. 서버로 보낸 비동기 요청에 따른 응답이 돌아오면 그 결과값을 span 태그에 출력한다.

$("#result").text(resp);


}

})

})

</script>

</body>

</html>

---------------- Servlet : CheckEmail

@ResponseBody

@RequestMapping("/CheckEmail")

public class CheckEmail(HttpServletRequest request) {

MemberDAO dao = new MemberDAO();

response.setContentType("text/html;charset=utf-8");

PrintWriter resp = response.getWriter();

// 5. 클라이언트로 부터 넘어오는 email 값을 받고 MemberDAO 클래스의 isEmailExist 함수에 인자값으로 전송받은 email 을 전달한다.

String email = request.getParameter("email");

try {

boolean result = dao.isEmailExist(amail);

if(result) {

// 7. DAO 로 부터 반환받은 값이 true 라면 클라이언트에게 "이미 사용중인 email 입니다." 라고 클라이언트에게 반환한다.

resp.print("이미 사용중인 email 입니다");

}else {

// 8. DAO 로 부터 반환받은 값이 false 라면 클라이언트에게 "사용 가능한 email 입니다." 라고 클라이언트에게 반환한다.

resp.print("사용 가능한 email 입니다.");

}

}catch(Exception e) {

e.printStackTrace();

// 9. 만약 true 도 false 도 아닌 예외가 발생했다면, "조회하는 도중 오류가 발생했습니다." 라고 클라이언트에게 반환한다.

  e.printStackTrace();
        
    resp.print("조회하는 도중 오류가 발생했습니다.");



}

}

---------------- MemberDAO

public class MemberDAO {

public Connection getConnection() throws Exception{

Class.forName("oracle.jdbc.driver.OracleDriver");

String url = "jdbc:oracle:thin:@localhost:1521:xe";

String id = "kh";

String pw = "kh";

return DriverManager.getConnection(url,id,pw);

}

public boolean isEmailExist(String email) throws Exception{

String sql = "select email from members where email=?";

try(Connection con = this.getConnection();

PreparedStatement pstat = con.prepareStatement(sql);

){

pstat.setString(1, email);

try(ResultSet rs = pstat.executeQuery();){

//6. isEmailExist 함수는 전달받은 email이 member 테이블 내에 존재하는지 검사하고 그 결과를 boolean 형으로 반환한다.

return rs.next();
 
}

}

}

}