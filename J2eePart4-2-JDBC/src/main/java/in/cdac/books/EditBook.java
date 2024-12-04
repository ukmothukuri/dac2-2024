package in.cdac.books;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import in.cdac.dao.DBOperations;
import in.cdac.model.Book;

/**
 * Servlet implementation class EditBook
 */
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int bookid = Integer.parseInt(request.getParameter("selectedBookid"));
    	
    	    	DBOperations dob = new DBOperations();
    	    	Book b = dob.getBookDetailsById(bookid);
//		
		request.setAttribute("book", b);
		request.getRequestDispatcher("EditBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("bookid"));
		String name = request.getParameter("bookname");
		String author = request.getParameter("bookauthor");
		Float price = Float.parseFloat(request.getParameter("bookprice"));
		String publisher =request.getParameter("bookpublisher");
		
		Book bk = new Book();
		bk.setId(id);
		bk.setName(name);
		bk.setAuthor(author);
		bk.setPrice(price);
		bk.setPublication(publisher);
		DBOperations dob = new DBOperations();
		int result =dob.updateBookDetails(bk);
		if(result == 1) {			
			out.print("Book has been updated successfully");
		}else {			
			out.print("Unable to updated the book details. Please try after sometime.");
		}
		
		
	}

}
