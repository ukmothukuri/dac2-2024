package in.cdac.springmvcthymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	public String showHomePage() {
		return "index";
	}
	
	@GetMapping(value="/home")
	public String displayHomePage() {
		return "home-page";
	}
}
