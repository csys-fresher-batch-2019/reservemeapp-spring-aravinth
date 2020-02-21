<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><form action="forgetPasswordServle">
<h2><center>Enter UserId:<input type="number" name="userid" placeholder="number"/></center></h2>
<h2><center>Enter email ID:<input type="text" name="mailid"required/></center></h2>
<center><button>SUBMIT</button></center>
<br/>
<%
String result = (String) request.getParameter("res");
if (result != null) {
out.println("<center><font color=red>" + result + "</font></center>");
}
%>

</body>
</html>