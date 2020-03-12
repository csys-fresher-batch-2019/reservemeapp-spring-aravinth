<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.chainsys.reservemeapp.model.TrainDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.reservemeapp.dao.impl.TrainDTOImpl"%>
<%@page import="com.chainsys.reservemeapp.dao.TrainDTO"%>
<%@page import="com.chainsys.reservemeapp.dao.TrainsDAO"%>

<!DOCTYPE html>
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

<%
	ArrayList<TrainDto> list= (ArrayList <TrainDto>)request.getAttribute("trainList");
%>



<%
	int i= 1;
int n=0;
if(list.size()>0){
%>
<h1><center> List Trains</center></h1>
<center>
<h2>
<table border="4">
<thead><tr><th>S.no</th> <th> Train Name </th><th>Train Num </th><th>Ticket Price </th><th>Travelling time</th><th>View Availability</th></tr></thead>
<tbody></h2>
<%
	for(TrainDto f : list){
%>

<tr><td><%=i++ %></td>
<td><%=f.getTrainName()%></td>
<td><%=f.getTrainNum()%></td>
<td><%=f.getPrice()%></td>
<td><%=f.getTravellingTime()%></td>
<td><a href="AvailableSeatsServlet?trainNum=<%=f.getTrainNum()%>">view Seats</a></tr></center>
<% 
}}else{
%>
<center>
<h1>No Trains Are Available...</br>Try Another Date</h1>
</br>
<h2><center><a href = "FindTrainServlet"><button>Click To Back</button></a></center></h2>

</center>

<%} %>
</tbody>
</table>

</body>
</html>