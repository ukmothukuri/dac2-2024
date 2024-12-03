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
 * Servlet implementation class BookManager
 */
public class BookManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//ArrayList<Book> books = new ArrayList<Book>();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		
//		Book b1 = new Book();
//		b1.setId(100);
//		b1.setName("Java");
//		b1.setAuthor("James Gosling");
//		b1.setPrice(850);
//		b1.setPublication("Blackbook");
//		books.add(b1);
//		
//		Book b2 = new Book();
//		b2.setId(101);
//		b2.setName("J2EE");
//		b2.setAuthor("Ecilpse Foundation");
//		b2.setPrice(1250);
//		b2.setPublication("ECFS");
//		books.add(b2);
//		
		DBOperations dob = new DBOperations();
		ArrayList<Book> books  = dob.getAllBookDetails();
		
		request.setAttribute("books", books);
		request.getRequestDispatcher("ViewBooks.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			/* Validations */
		
			/* Initialization of Book Object */
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
			//books.add(bk);
			
			out.print("Book has been added successfully");	
	}

}
