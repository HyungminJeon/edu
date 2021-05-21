<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/example11.jsp</title>
</head>
<body>
<h1>Out 객체</h1>
<%
String name = new String("Hello");
int total = out.getBufferSize();
out.print("<h3>Buffer Size: " + total + "</h3>");
out.print("<h3>" + name + "</h3>");
out.print("<h3>"+ out.getRemaining() + "</h3>");
%>
<h1>Application 객체: ServletContext</h1>  <!-- jsp가 서블릿으로 만들어질 때 마다 만들어지는 객체 -->
<h3>서버명: <%=application.getServerInfo()%></h3>
<h3>서블릿버전: <%= application.getMajorVersion()%>.<%= application.getMinorVersion() %></h3>

<%
	Set<String> list= application.getResourcePaths("/");
	Object[] path = list.toArray();
	for (int i = 0; i < path.length; i++) {
		out.print(path[i]+"<br>");
	}
	application.setAttribute("appName", "edu");
	//어플리케이션 전체에서 appName으로 호출시 edu값을 반환
	
	
%>
</body>
</html>