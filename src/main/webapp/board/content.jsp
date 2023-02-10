<%@page import="board.boardDTO"%>
<%@page import="board.boardDAO"%>
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
int num = Integer.parseInt(request.getParameter("num"));
String id = (String)session.getAttribute("id");
boardDAO dao = new boardDAO();
boardDTO dto = dao.getBoard(num);
%>
<h1>글 내용 [로그인 : <%=id %>]</h1>
<table border="1">
	<tr><td>글번호</td><td><%=dto.getNum() %></td></tr>
	<tr><td>작성자</td><td><%=dto.getName() %></td></tr>
	<tr><td>글쓴날짜</td><td><%=dto.getDate() %></td></tr>
	<tr><td>조회수</td><td><%=dto.getReadcount() %></td></tr>
	<tr><td>글제목</td><td><%=dto.getSubject() %></td></tr>
	<tr><td>글내용</td><td><%=dto.getContent() %></td></tr>
	<tr><td colspan="2">
	<input type="button" value="글목록" onclick="location.href='list.jsp'">
	<% 
	if(id != null) {
		if(id.equals(dto.getName())) { %>
			<input type="button" value="글수정"
			onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">
			<input type="button" value="글삭제"
			onclick="location.href='deletePro.jsp?num=<%=dto.getNum()%>'"></tr>
	<%
		}
	}
	%>
</table>
</body>
</html>