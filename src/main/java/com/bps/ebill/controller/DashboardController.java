package com.bps.ebill.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/secured")
public class DashboardController {
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getDashboard(Locale locale, HttpServletRequest req, Model model) {
		return "secured.dashboard";
	}

}
