<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=application.getInitParameter("ProjectTitle")%></title>
</head>
<%
 String msg = "";
if(request.getAttribute("msg") != null){
	msg = (String)request.getAttribute("msg");
}
%>
<body>
	<div>
		<center>
			Add Book details
			<form action="./BookManager" method="post">
			<%-- 	<span id="errormsg" style="color: red"><%=errormsg%></span> <br> --%>
				<%--BookId: <input type="text" id="bookid" name="bookid" /> <br> --%>
				Name: <input type="text" id="bookname" name="bookname" /> <br> 
				Author: <input type="text" id="bookauthor" name="bookauthor" /> <br>
				Price: <input type="number" id="bookprice" name="bookprice" /> <br>
				Publication: <textarea rows="5" cols="3" id="bookpublisher" name="bookpublisher"></textarea> <br> <br><br>
				<button type="submit">Add</button>
				<span style="color:red"><%=msg%></span>
			</form>
		</center>
	</div>
</body>
</html>