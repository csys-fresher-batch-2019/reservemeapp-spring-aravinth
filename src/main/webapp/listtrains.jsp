<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.chainsys.reservemeapp.model.findTrain"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.reservemeapp.dao.impl.findTrainIMPL"%>
<%@page import="com.chainsys.reservemeapp.dao.findTrainDAO"%>
<%@page import="com.chainsys.reservemeapp.dao.AdminListOfTrainsDAO"%>

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

String source =  request.getParameter("source");
String destination = request.getParameter("destination");
String journeyDate = request.getParameter("journey_date");
findTrainDAO dao = new findTrainIMPL();
//ArrayList<findTrain> list= dao.SearchTrain("chennai", "covai", "2020-01-27");
ArrayList<findTrain> list= dao.SearchTrain(source,destination,journeyDate);

%>



<%
int i= 1;
int n=0;
if(list.size()>0){%>
<h1><center> List Trains</center></h1>
<center>
<h2>
<table border="4">
<thead><tr><th>S.no</th> <th> Train Name </th><th>Train Num </th><th>Ticket Price </th><th>Travelling time</th><th>View Availability</th></tr></thead>
<tbody></h2>
<%
for(findTrain f : list){%>

<tr><td><%=i++ %></td>
<td><%= f.getTrain_name() %></td>
<td><%=f.getTrain_num()%></td>
<td><%= f.getPrice()%></td>
<td><%= f.getTravelling_time()%></td>
<td><a href="viewavailableseats.jsp?trainNum=<%=f.getTrain_num()%>">view Seats</a></tr></center>
<% 
}}else{
%>
<center>
<h1>No Trains Are Available...</br>Try Another Date</h1>
</br>
<h2><center><a href = "findtrain.jsp"><button>Click To Back</button></a></center></h2>

</center>

<%} %>
</tbody>
</table>

</body>
</html>