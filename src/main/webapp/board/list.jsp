<%@page import="java.util.ArrayList"%>
<%@page import="com.itwillbs.board.db.boardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글목록
<%-- <%
String id = (String)session.getAttribute("id");
boardDAO dao = new boardDAO();

int pageSize = 10;
String pageNum = request.getParameter("pageNum");
if(pageNum==null) {
	pageNum="1";
}
int currentPage=Integer.parseInt(pageNum);
//시작 페이지 번호
int startRow = pageSize*(currentPage-1)+1;
//끝 페이지 번호
int endRow = startRow+pageSize-1;
//mysql limit 시작행 및 시작행으로부터 가져올 갯수
int start = startRow-1;
int num = pageSize;
ArrayList<boardDTO> dtolist = dao.getBoardList(start, num);
%> --%>
<%
ArrayList<boardDTO> dtolist = (ArrayList<boardDTO>)request.getAttribute("dtolist");
int currentPage = (Integer)request.getAttribute("currentPage");
int startPage = (Integer)request.getAttribute("startPage");
int pageBlock = (Integer)request.getAttribute("pageBlock");
int endPage= (Integer)request.getAttribute("endPage");
int allPage = (Integer)request.getAttribute("allPage");
%>
<table border="1">
<tr><td>글번호</td><td>글쓴이</td><td>글제목</td><td>조회수</td><td>등록일</td></tr>
<% 
for(int i = 0; i < dtolist.size(); i++) {
	boardDTO dto = dtolist.get(i);
%>
<tr>
<td><%=dto.getNum() %></td>
<td><%=dto.getName() %></td>
<td><a href="BoardContent.bo?num=<%=dto.getNum()%>"><%=dto.getSubject() %></a></td>
<td><%=dto.getReadcount() %></td>
<td><%=dto.getDate() %></td>
</tr>	
	<%
}
%>
</table>
<% 
// startPage~endPage 1~10, 11~20, 21~30
/* int pageBlock = 10;
int startPage = (currentPage-1)/pageBlock*pageBlock+1;
int endPage = startPage+pageBlock-1;
//총 게시글 수
int allPage = dao.getBoardPage();
// 나타낼 페이지 수
int pageCount = allPage/pageSize+(allPage%pageSize==0?0:1);
// endPage 재설정
if(endPage > pageCount) {
	endPage = pageCount;
}
// */
if(startPage > pageBlock) {
%>
	<a href="BoardList.bo?pageNum=<%= currentPage-pageBlock%>">[10페이지 이전]</a>
<% 
}
for(int i = startPage; i <= endPage; i++) {	
%>
	<a href="BoardList.bo?pageNum=<%= i%>"><%= i%></a> 
<% 
}
if(endPage > allPage) {
%>
	<a href="BoardList.bo?pageNum=<%= currentPage+pageBlock%>">[10페이지 다음]</a> 
<%
}
%>
</body>
</html>