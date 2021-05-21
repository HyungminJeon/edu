<%@page import="stateless.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example17.jsp</title>
</head>
<body>
	<%
	String id = request.getParameter("memberId");
	String pwd = request.getParameter("memberPwd");
	String name = request.getParameter("memberName");
	String age = request.getParameter("memberAge");

	Member member1 = new Member();
	member1.setMemberId(Integer.parseInt(id));
	member1.setMemberName(name);
	member1.setMemberAge(Integer.parseInt(age));
	member1.setMemberPwd(pwd);
	
	out.print(member1.getMemberId() +"<br>");
	out.print(member1.getMemberName()+"<br>");
	out.print(member1.getMemberAge()+"<br>");
	out.print(member1.getMemberPwd()+"<br>");
	
	%>
	<!-- 인스턴스 생성-->
	<jsp:useBean id="member2" class="stateless.Member"></jsp:useBean>
	<jsp:setProperty property="*" name="member2"/>
	
	<!-- <jsp:setProperty property="memberId" name="member2" value="10" />
	<jsp:setProperty property="memberPwd" name="member2" value="1234" />
	<jsp:setProperty property="memberName" name="member2" value="Hong" />
	<jsp:setProperty property="memberAge" name="member2" value="20" />
	-->
	<jsp:getProperty property="memberId" name="member2" />
	<jsp:getProperty property="memberPwd" name="member2" />
	<jsp:getProperty property="memberName" name="member2" />
	<jsp:getProperty property="memberAge" name="member2" /> 
</body>
</html>