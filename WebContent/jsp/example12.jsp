<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Example12.jsp</h1>
	<%--<%@ include file="example05.jsp" %> --%>
	<%!//필드나 메서드 선언 
	public void work(String p, PageContext pc) {
		try {
			JspWriter out = pc.getOut(); //새롭게 out 객체 선언 
			if (p.equals("include")) {
				pc.include("example05.jsp");
			} else if(p.equals("forward")) {
				pc.forward("example05.jsp");
			}
		} catch (Exception e) {
			System.out.println("오류발생");
		}
	}%>
	<%
	String p = request.getParameter("p");
	this.work(p,pageContext);
	%>

</body>
</html>