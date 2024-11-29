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
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("userpassword");
		PrintWriter out = response.getWriter();
		
		if(username.equals("admin") && password.equals("admin@123")) 
		{
			HttpSession session = request.getSession(true);			
			session.setAttribute("username", username);
			System.out.println("Session ID ===="+session.getId());
			request.setAttribute("role", "administrator");
			
			request.getRequestDispatcher("/welcome").forward(request, response);
		}
		else if(username.equals("student") && password.equals("student@123")) {
			request.setAttribute("role", "student");
			request.getRequestDispatcher("/welcome").forward(request, response);
		}
		else {			
//			out.println("<html>");
//			out.println("<body>");
//			out.println("Invalid Login details.");
//			out.println("<a href='Login.html'>Click here</a> to login again");
//			out.println("</body>");
//			out.println("</html>");
			
			response.sendRedirect("Login.html?msg=invalid credentials");
		}		
	}
}
