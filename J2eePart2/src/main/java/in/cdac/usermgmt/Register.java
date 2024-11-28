package in.cdac.usermgmt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
	IOException 
	{
		
		String username = request.getParameter("username");
		String useremail = request.getParameter("useremail");
		String usermobile = request.getParameter("usermobile");
		String userpassword = request.getParameter("userpassword");
		
		/* Save it into DB */
		
		PrintWriter out = response.getWriter();
		out.println("User Registration is succesfull");
	}
}
