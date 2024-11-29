package in.cdac.users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Welcome
 */
public class Welcome extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//String username = request.getParameter("username");
		String role = (String)request.getAttribute("role");
		
		String username = null;
		
		HttpSession session = request.getSession(false);
		username = (String)session.getAttribute("username");
		System.out.println("Session ID ===="+session.getId());
		
		if(session == null) {
			response.sendRedirect("SessionExpired.html");
		}
		
		
		PrintWriter out = response.getWriter();
		//out.println("Welcome "+username);
		//out.println("I am "+role);
		
		if(role.equals("administrator")) {
			out.println("<html>");
			out.print("Hi.."+username+" | ");
			out.print("<a href='./logout'>Logout</a>");
			out.println("<br>");
			out.println("<div>");			
			out.print("<a href=''>View Students</a>");
			out.print(" | ");
			out.print("<a href=''>Manage Students</a>");
			out.println("</div>");
			out.println("</html>");
		}
		else if(role.equals("student")) {
			out.println("<html>");
			out.print("Hi.."+username);
			out.print("<a href='/logout'>Logout</a>");
			out.println("<br>");
			out.println("<div>");
			out.print("<a href=''>View Books</a>");			
			out.println("</div>");
			out.println("</html>");
		}
	}

}
