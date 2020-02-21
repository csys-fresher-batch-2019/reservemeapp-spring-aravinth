<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style = "background-color:powderblue">
<%
int bookingid = (Integer)session.getAttribute("LOGGED_IN_BOOKING_ID");
int totCost = (Integer)session.getAttribute("LOGGED_IN_TOT_AMOUNT");
%>
<div align="right">
<h2>BookingID: <%=bookingid%></h2>
</div>
<br/>
<center>
Enter Card number : <input type = "number" name = "cardnumber"
placeholder = "Enter card no" required autofocus/> <br/><br/>
Enter cvv :<input type = "number" name = "cvv"
placeholder = "Enter cvv" required autofocus/> <br/><br/>
Enter Expiry Month/year:<input type = "text" name = "expiry"
placeholder = "Enter expiry" required autofocus/>  <br/><br/>
Enter comments:<input type = "text" name = "comments"
placeholder = "Enter comments" required autofocus/> <br/><br/>
Enter total Amount to pay:<input type = "number" name ="totalAmounts"value ="<%=totCost %>"readonly /> <br/><br/>
 <h2><a href="paymentServlet?BookingId=<%=bookingid%>"><button> Submit</button></a></h2></center>

</center>
</form>
</body>
</html>