package in.cdac.usermgmt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet
{
		protected void doPost(HttpServletRequest req, HttpServletResponse res) 
				throws ServletException,IOException {
			String username = req.getParameter("username");
			String password = req.getParameter("userpassword");
			
			/* User Authentication Login 
			 * 
			 */
//			PrintWriter output = res.getWriter();
//			output.write("Logged in successfully");
//			output.write("Welcome "+username);
			
			req.getRequestDispatcher("/Welcome").forward(req, res);
			
		}

}
