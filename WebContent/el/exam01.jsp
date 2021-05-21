<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language</title>
</head>
<body>
<%
String name = "Hello";
request.setAttribute("name", name);

String name1 = request.getParameter("name");
String age = request.getParameter("age");

%>
<h3>${name eq 'hello' }</h3>  <!-- attribute값을 읽어옴 -->
<h3>${3*5 }</h3>
<h3>${3>5 }</h3>
<h3>${empty "" }</h3>
<h3>${3 gt 5}</h3>
<h3>${3 lt 5}</h3><%-- 
<h3>${3 div 5 }</h3>
<h3>${12 mod 5 }</h3> --%>

<%=name %>/<%=age %><br>
${param.name } / ${param["age"] }
</body>
</html>