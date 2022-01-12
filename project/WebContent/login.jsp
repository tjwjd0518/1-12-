<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Controller?command=login_check" method="post">
		ID : <input type="text" name="id"><br/>
		PW : <input type="password" name="pw"><br/>
		<input type="submit" value="로그인"><br/> 
		<input type="submit" value="회원가입" onclick="register.jsp">
	</form>
</body>
</html>