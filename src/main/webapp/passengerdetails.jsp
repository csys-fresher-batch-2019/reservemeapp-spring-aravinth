<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style = "background-color:powderblue">
<%
int userid = (Integer)session.getAttribute("LOGGED_IN_USER_ID");
%>
<div align="right">
<h2>USERID: <%=userid%></h2>
</div>
<br/>
<%
String trainNum = request.getParameter("trainnum");
%>
<center>
<h1>Enter Passenger Details...</h1>

<form action = "passengerservlet">
<h2>

Enter Train Num:<input type = "number" name = "trainnum"value="<%=trainNum %>" readonly />
<br/>
<br/>
Enter user Id:<input type = "number" name = "userid"value ="<%=userid %>"readonly />
<br/>
<br/>
Enter Passenger Name:<input type= "text" name = "passenger_name" pattern ="[A-Za-z]{3,}"placeholder = "passenger name" required/>
<br/>
<br/>
Enter phone number:<input type = "tel" name = "phone_number" pattern = "[0-9]{10}" placeholder = "phonenumber" required/>
<br/>
<br/>
Enter No.Of.Tickets:<input type = "number" name = "noOfTickets"placeholder = "nooftickets" required/>
<br/>
<br/>
<button type = "submit">BOOK</button></h2>
</center>
</form>
</body>
</html>