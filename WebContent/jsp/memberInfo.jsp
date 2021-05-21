<%@page import="stateless.Member"%>
<%@page import="stateless.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/memberInfo.jsp</title>
</head>
<body>
	<jsp:useBean id="dao" class="stateless.MemberDAO"></jsp:useBean>
	<jsp:useBean id="mem" class="stateless.Member"></jsp:useBean>
	<%
	String id = request.getParameter("memberId");
	//MemberDAO dao = new MemberDAO();
	mem = dao.getMember(id);
	%>
	<jsp:setProperty property="memberId" name="mem"/>
	
	<H1>회원상세정보</H1>
	<table border ="1">
	<tr>
	<td>아이디</td>
	
	<td><jsp:getProperty property="memberId" name="mem"/></td>
	</tr>
	<tr>
	<td>이름</td><td><%= mem.getMemberName() %></td>
	</tr>
	<tr>
	<td>나이</td><td><%= mem.getMemberAge() %></td>
	</tr>
	<tr>
	<td>비번</td><td><%= mem.getMemberPwd() %></td>
	</tr>
	</table>
	<a href= "memberList.jsp">리스트보기</a>
	
	
</body>
</html>