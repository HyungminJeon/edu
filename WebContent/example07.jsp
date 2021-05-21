<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example07.jsp ::: 스크립트릿(애플릿,서블릿)</title>
</head>
<body>
	<%!//멤버변수선언
	//메소드선언%>
	<h1>구구단</h1>
	<h3>table 활용해서</h3>
	<table>
		<%
		for (int i = 1; i < 10; i++) {
		%>
		<tr>
			<%
			for (int j = 2; j < 10; j++) {
			%>
			<td><%=j%></td>
			<td>*</td>
			<td><%=i%></td>
			<td>=</td>
			<td><%=(j * i)%></td>
			<td></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>

