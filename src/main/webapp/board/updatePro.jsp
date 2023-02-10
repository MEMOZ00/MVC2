<%@page import="board.boardDTO"%>
<%@page import="board.boardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
int num = Integer.parseInt(request.getParameter("num"));
String name = request.getParameter("name");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

boardDAO dao = new boardDAO();
boardDTO dto = new boardDTO();
dto.setNum(num);
dto.setName(name);
dto.setSubject(subject);
dto.setContent(content);

if(dto!=null){
	dao.updateBoard(dto);
	response.sendRedirect("list.jsp");
}
%>
