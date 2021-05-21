<%@page import="stateless.Member"%>
<%@page import="java.util.List"%>
<%@page import="stateless.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/memberList.jsp</title>
</head>
<body>
<jsp:useBean id="dao" class="stateless.MemberDAO"></jsp:useBean>

<%
	//MemberDAO dao = new MemberDAO();
	List<Member> list = dao.getMemberList();
%>

<h1>회원리스트</h1>
<table border="1">
<%
	for(int i = 0; i<list.size(); i++) {
		%><tr>
		<td>
		<a href="memberInfo.jsp?memberId=<%=list.get(i).getMemberId() %>">
			<%=list.get(i).getMemberId()%></a>
			</td>	
		<td><%=list.get(i).getMemberPwd() %></td>
		<td><%=list.get(i).getMemberName()%></td>
		<td><%=list.get(i).getMemberAge()%></td></tr>
	<%
	}
%>
</table>

</body>
</html>