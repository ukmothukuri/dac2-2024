<%@page import="in.cdac.model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=application.getInitParameter("ProjectTitle")%></title>
</head>
<body>
<%
Book bk = (Book)request.getAttribute("book");
%>
	
<div>
		<center>
			Add Book details
			<form action="./EditBook" method="post">
				BookId: <input type="hidden" id="bookid" name="bookid" value="<%=bk.getId()%>" /> <br>
				Name: <input type="text" id="bookname" name="bookname" value="<%=bk.getName()%>"/> <br> 
				Author: <input type="text" id="bookauthor" name="bookauthor" value="<%=bk.getAuthor()%>"/> <br>
				Price: <input type="number" id="bookprice" name="bookprice" value="<%=bk.getPrice()%>"/> <br>
				Publication: <textarea rows="3" cols="5" id="bookpublisher" name="bookpublisher"><%=bk.getPublication()%>"</textarea> <br> <br><br>
				<button type="submit">Update Details</button>
				
			</form>
		</center>
	</div>
</body>
</html>