package com.bps.ebill.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bps.ebill.forms.LoginForm;

@Controller
@RequestMapping()
public class LoginController {
	
	@GetMapping("/")
	public String getDaftarBil() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public ModelAndView getLogin(@RequestParam(value = "error", required = false) String error) {
		ModelAndView model = new ModelAndView("login");
		
		if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }
		model.addObject("loginForm", new LoginForm());
		return model;
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

      ModelAndView model = new ModelAndView();
        
      //check if user is login
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      if (!(auth instanceof AnonymousAuthenticationToken)) {
        UserDetails userDetail = (UserDetails) auth.getPrincipal();	
        model.addObject("username", userDetail.getUsername());
      }
        
      model.setViewName("403");
      return model;

    }
	
}
 