<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page
	import="com.chainsys.reservemeapp.dao.impl.AdminListOfTrainsImpl"%>
<%@page
	import="com.chainsys.reservemeapp.dao.AdminListOfTrainsDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: powderblue">
	<%
		Integer userid = (Integer) session.getAttribute("LOGGED_IN_USER_ID");
	%>
	<div align="right">
		<h2>
			USERID:
			<%=userid%></h2>
	</div>
	<br />
	<form action="listtrains.jsp">
		<h2>
			<center>Enter Your Specifications to find the Train...</center>
		</h2>
		<br /> <br />
		<%
			AdminListOfTrainsDAO dao = new AdminListOfTrainsImpl();
		//AdminListOfTrainsService dao = new AdminListOfTrainsService();
			List<String> sourceStationList = dao.getSourceStation();
		%>
		<br>
		<%
			List<String> destinationStationList = dao.getDestinationStation();
		%>
		<h2>
			<center>
				Select Source station <input name="source"
					list="source_station_list" required>
				<datalist id="source_station_list">
					<%
						for (String s : sourceStationList) {
					%>
					<option value="<%=s%>"><%=s%>
					</option>
					<%
						}
					%>
				</datalist>
			</center>
		</h2>
		<br />
		<h2>
			<center>
				Select destination station <input name="destination"
					list="destination_station_list" required>
				<datalist id="destination_station_list">
					<%
						for (String d : destinationStationList) {
					%>

					<option value="<%=d%>"><%=d%>
					</option>
					<%
						}
					%>
				</datalist>
			</center>
		</h2>
		<br />
		<h2>
			<center>
				Enter Journey Date : <input type="date" name="journey_date"
					placeholder="YYYY-MM-DD" required />
			</center>
		</h2>
		<br />
		<h2>
			<center>
				<button type = "submit">SEARCH</button>
			</center>
		</h2>
		<br />

	</form>
</body>
</html>