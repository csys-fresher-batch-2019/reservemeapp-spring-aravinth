<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<body style = "background-color:powderblue">
<form action = "RegisterServlet">
Enter username:<input type = "text" name = "username" pattern ="[A-Za-z]{3,}" placeholder = "username"required/>
<br/>
Enter password :<input type = "password" name ="userpassword" placeholder = "user password"required/>
<br/>
Enter gender:<input type="radio" name="gender" value="M" > Male
<input type="radio" name="gender" value="F" > Female 
<input type="radio" name="gender" value="O" > Others 
<br/>
Enter Date of Birth:<input type= "date" name = "birthday_date"
placeholder = "YYYY-MM-DD" required/>
<br/>     
Enter contact number:<input type = "tel" name = "contact_number" placeholder = "contact number" pattern = "[0-9]{10}"required/>
<br/>
Enter emailId:<input type ="email" name = "email_id" placeholder = "email id"required/>
<br/>
<button type = "submit">SUBMIT</button>
</form>
</body>
</html>