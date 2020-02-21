<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><form action="resetPasswordServlet">
<h2><center>Enter UserId:<input type="number" name="userid" placeholder="number"/></center></h2>
<h2><center>Enter password:<input type="password" name="password" required /></center></h2>
<h2><center>Enter password Again:<input type="password" name="password2" required /></center></h2>
<center><button>SUBMIT</button></center>
<%
String result1 = (String) request.getParameter("res");
if (result1 != null) {
out.println("<center><font color=red>" + result1 + "</font></center>");
}

String result2 = (String) request.getParameter("res1");
if (result2 != null) {
out.println("<center><font color=red>" + result2 + "</font></center>");
}
%>
</body>
</html>