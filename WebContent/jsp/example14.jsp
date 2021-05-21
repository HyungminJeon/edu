<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/example14.jsp</title>
</head>
<body>
<h3>Example14 page</h3>
<%
String res = (String) application.getAttribute("appName"); //appName 으로 지정된 객체 값을 res에 담고
request.setAttribute("result", res);  //request객체에 result값을 넣고 example05에 전달한다
%>

<jsp:forward page="example05.jsp"></jsp:forward>
<%-- <jsp:usebean page="example05.jsp"></jsp:usebean> --%>

<%-- <%
RequestDispatcher rd =  request.getRequestDispatcher("example12.jsp");
rd.forward(request,response);
%> --%>

</body>
</html>