
<%@page import="com.itwillbs.board.db.boardDAO"%>
<%@page import="com.itwillbs.board.db.boardDTO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
int readcount = 0; 

boardDTO dto = new boardDTO();
dto.setName(name);
dto.setSubject(subject);
dto.setContent(content);
dto.setDate(new Timestamp(System.currentTimeMillis()));
dto.setReadcount(readcount);

boardDAO dao = new boardDAO();
dao.insertBoard(dto);

response.sendRedirect("list.jsp"); */
%>