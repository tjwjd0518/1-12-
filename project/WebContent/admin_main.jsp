<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="test.MemberDto"%>
<%
	ArrayList<MemberDto> memberList = (ArrayList<MemberDto>)request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>Name</th>
			<th>Point</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<%
			for(MemberDto dto : memberList) {
		%>
		<tr>
			<td><%=dto.getId() %></td>
			<td><%=dto.getPw() %></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getPoint() %></td>
			<td><button>수정</button></td>
			<td>삭제</td>
		</tr>
		<%} %>
	</table>
</body>
</html>