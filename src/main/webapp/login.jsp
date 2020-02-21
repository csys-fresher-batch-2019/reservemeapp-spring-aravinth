<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style = "background-color:powderblue">
<form action="LoginServlet">
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<h2><center>Enter user Id:<input type = "number" name = "userid" placeholder = "user Id"required/></center></h2>
<br/>
<h2><center>Enter password :<input type ="password" name ="userpassword" placeholder = "userpassword"required/></center></h2>
<br/>
<h2><center><button>SUBMIT</button></center></h2>
 <br/>
 <%
 String result = (String) request.getParameter("res");
 if(result!=null)
 {
 out.println("<center><font color=red>" + result + "</font></center>");
 }
 %>
 <br/>
 <center>
 <a href = "forgetpassword.jsp">Forget password/<br/>Change password</a></center>
</form>
</body>
</html>