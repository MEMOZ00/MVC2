<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = (String)session.getAttribute("id");
if(id==null) {
	response.sendRedirect("MemberloginForm.me");
}
%> 
<form action="BoardWritePro.bo" method="post">
<table border="1">
<tr><td>글쓴이</td>
	<td><input type="text" name="name" value="<%=id %>" readonly></td></tr>
<tr><td>글제목</td>
	<td><input type="text" name="subject" value=""></td></tr>
<tr><td>글내용</td>
	<td><textarea name="content" rows="10" cols="20" ></textarea></td></tr>
</table>
<input type="submit" value="글쓰기">
<input type="button" value="돌아가기" onclick="location.href='MemberMain.me'">
</form>
</body>
</html>