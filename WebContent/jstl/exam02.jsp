<%@page import="com.edu.beans.BookBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/exam02.jsp</title>
</head>
<body>
<c:set var="num"  value="${85 }"/>
점수 <c:out value="${num }"/>	 은
<c:if test="${num gt 60 }"> 합격입니다.</c:if>
<c:if test="${num lt 60 }"> 불합격입니다.</c:if>
<br>

<c:choose>
<c:when test="${num ge 90 }">A학점</c:when>
<c:when test="${num ge 80 }">B학점</c:when>
<c:when test="${num >= 70 }">C학점</c:when>
<c:otherwise>F학점</c:otherwise>
</c:choose>

<%
ArrayList<BookBean> blist = new ArrayList<>();
blist.add(new BookBean("title1","author1","pub1"));
blist.add(new BookBean("title2","auhor2","pub2"));
blist.add(new BookBean("title3","auhor3","pub3"));

/* for(BookBean book:list) {
	out.print("title"+ book.getTitle());
} */

request.setAttribute("list", blist);

%>
<%-- <c:set var="list" value=""><%=list%></c:set> --%>

<c:forEach items ="${list }" var = "item">
${item.title } / ${item.author } / ${item.publisher }<br>
</c:forEach>

</body>




</html>