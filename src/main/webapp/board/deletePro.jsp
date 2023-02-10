<%@page import="board.boardDTO"%>
<%@page import="board.boardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
int num = Integer.parseInt(request.getParameter("num"));
boardDAO dao = new boardDAO();
dao.deleteBoard(num);

response.sendRedirect("list.jsp");
%>