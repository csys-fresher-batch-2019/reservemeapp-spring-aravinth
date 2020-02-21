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
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<%
int bookingid = (Integer)session.getAttribute("LOGGED_IN_BOOKING_ID");
int totTicketCost = (Integer)session.getAttribute("LOGGED_IN_TOT_AMOUNT");

%>
<center><h2>Your ticket has confirmed...
<br/>
This is your bookingId:<%=bookingid %></h2>
<h2>And this is your total ticket cost:<%=totTicketCost %></h2>
<br/>
<h2>Press<h2/><br/>
 <h2><a href="updationServlet?BookingId=<%=bookingid%>"><button> ACKNOWLEDGE</button></a></h2></center>
</body>
</html>