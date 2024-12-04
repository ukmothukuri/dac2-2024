<%@page import="in.cdac.model.Book"%>
<%@page import="java.util.ArrayList"%>
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
  	ArrayList<Book> books = (ArrayList<Book>)request.getAttribute("books");
%>

<script>
	function editBook(bookid){
		document.getElementById("selectedBookid").value=bookid;
		document.getElementById("form2").submit();
	}
	
	function deleteBook(bookid){
		document.getElementById("selectedBookid").value=bookid;
		document.getElementById("form2").submit();
	}
</script>
<div>
	List of books:
	<table border="2">
		<thead>			
			<td>Book Id</td>
			<td>Book Name</td>
			<td>Author</td>
			<td>Price</td>
			<td>Publication</td>	
			<td>Actions</td>	
		</thead>
		
			<%
				for(Book b : books){
			%>
			<tr>
			<td><%=b.getId()%></td>
			<td><%=b.getName()%></td>
			<td><%=b.getAuthor()%></td>
			<td><%=b.getPrice()%></td>
			<td><%=b.getPublication()%></td>
			<td><button onclick="editBook(<%=b.getId()%>)">Edit</button>
			<button onclick="deleteBook(<%=b.getId()%>)">Delete</button></td>
			</tr>
			<%
				}				
			%>		
	</table>
	
	<form action="./EditBook" id="form2">
		<input type="hidden" id="selectedBookid" name="selectedBookid"/>		
	</form>
	
	<form action="./DeleteBook" id="form3">
		<input type="hidden" id="selectedBookid" name="selectedBookid"/>		
	</form>
	
	</div>
</body>
</html>