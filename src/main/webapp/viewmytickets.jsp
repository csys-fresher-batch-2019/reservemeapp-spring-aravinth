<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body style = "background-color:powderblue">
<%
Integer userid = (Integer)session.getAttribute("LOGGED_IN_USER_ID");
%>
<div align="right">
<h2>USERID: <%=userid%></h2>
</div>
<br/>

</body>
</html>