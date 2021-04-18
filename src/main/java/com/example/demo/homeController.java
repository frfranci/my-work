package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class homeController {
	
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(@RequestParam("error") Optional<String> errorObj, ModelMap model) {
		
	        return "login.html";
	    }
	
	@GetMapping("/")
	public String getAliens() {
		
		return "home.jsp";
	
	}
	
	@PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/adminHome")
	public String getAdminHome() {
		
		return "AdminHome.jsp";
	
	}
	@PreAuthorize("hasAuthority('READ_PRIVILEGE')")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/userHome")
	public String getUserHome() {
		return "UserPage.jsp";
	
	}

}
