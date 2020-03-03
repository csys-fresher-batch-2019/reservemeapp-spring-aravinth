<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.chainsys.reservemeapp.seatsavailability.SeatStatusIMPL"%>
<%@page import="com.chainsys.reservemeapp.seatsavailability.SeatStatusDAO"%>
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
<br/>
<br/>
<br/>
<br/>
<h2><center>Available Seats
<br/>
<%
String Trainnum = request.getParameter("trainNum");
int trainnum = Integer.parseInt(Trainnum);
SeatStatusDAO dao = new SeatStatusIMPL();
int seatsCount = dao.AvailSeats(trainnum);
out.println(seatsCount);
%>
</center></h2>
<br/>

<center><button><a href="passengerdetails.jsp?trainnum=<%=trainnum%>">Book Ticket</a></button></center>
</body>
</html>