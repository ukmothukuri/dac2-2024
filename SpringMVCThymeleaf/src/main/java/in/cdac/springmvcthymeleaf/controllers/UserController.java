package in.cdac.springmvcthymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.cdac.springmvcthymeleaf.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@GetMapping("/userlogin")
	public String showLoginPage(Model m) {
		m.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/userauthentication")
	public String authenticateUser(@ModelAttribute User user, HttpServletRequest request) {
		System.out.println(user.getUsername()+"--"+user.getPassword());
		 
		HttpSession session = request.getSession(true);
		session.setAttribute("username", user.getUsername());
		
		 return "redirect:login";
	}
	
	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	}
	
	@PostMapping("/userregistration")
	public String registerUser() {
		return "register";
	}
	
	
	
}
