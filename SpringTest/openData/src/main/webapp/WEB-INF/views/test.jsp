<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>

	<button id="btn"></button>
	<table>
		<thead>
			<tr>
				<td>sido_name</td>
				<td>sigungu_name</td>
				<td>remarks</td>
				<td>shel_nm</td>
				<td>address</td>
				<td>lon</td>
				<td>lat</td>
				<td>shel_av</td>
				<td>lenth</td>
				<td>shel_div_type</td>
				<td>height</td>
			</tr>		
		</thead>
		<tbody id="result"></tbody>		
	
	
	</table>




	<script>
		$(function(){
			$("#btn").click(function(){
				$.ajax({
				
					url: "shelter" , 
					data:  {}, 
					success : function(result) {
						
						const itemArr = $(result).find("row");
						
						
						
						
					},
					error : function(){
						console.log("삐빅-! 에러")
					}
						
					
					
					
					
					
					
				})
				
				
				
				
				
				
				
				
				
			})
			
			
			
		})
		
		
	
	
	
	
	
	
	</script>




</body>
</html>