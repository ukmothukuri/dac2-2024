package in.cdac.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping(value = "/login")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping(value = "/userauthentication")
	public ModelAndView getLoginData(@RequestParam ("username") String name,
			@RequestParam ("password") String userPassword) {
		System.out.println("Hello user "+name);
		System.out.println("Your password is: "+userPassword);
		
		/* Check with the DB *?
		 * 
		 */
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");		
		mv.addObject("name", name);
		
		return mv;

	}
}
