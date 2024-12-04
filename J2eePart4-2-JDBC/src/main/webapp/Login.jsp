<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=application.getInitParameter("ProjectTitle")%></title>
</head>
<%
String errormsg = request.getParameter("msg");
if(request.getParameter("msg") == null){
	errormsg = "";
}
%>

<!-- Hi i have created a Login Page here.. default user is: admin and password: admin@123 -->
<%-- This is Login Page --%>

<script>
  function checkForErrorMsg(){	  
	  var msg = '<%=errormsg%>';
	  if(msg != "NA"){
		 // alert(msg);		 		
	  }
  }
</script>

<body onload="checkForErrorMsg()">

<%@include file="Header.jsp"%>

	<div>
		<center>
			User Login
			<form action="./login" method="post">
				<span id="errormsg" style="color: red"><%=errormsg%></span>	
				<br>
				UserName: <input type="text" id="username" name="username" /> <br>				
				Password: <input type="password" id="userpassword"
					name="userpassword" /> 
				
					<br> <br>
				<button type="submit">Login</button>
			</form>
		</center>
	</div>


	<%@include file="Footer.jsp" %>


</body>
</html>