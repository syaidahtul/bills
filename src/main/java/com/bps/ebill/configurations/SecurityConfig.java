package com.bps.ebill.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public static final String LOGIN_FORM_URL = "/login";
	public static final String TARGET_AFTER_SUCCESSFUL_LOGIN_PARAM = "target";
	public static final String COLOUR_PARAM = "colour";

	@Override
	public void configure(WebSecurity webSecurity) {
	    webSecurity.ignoring().antMatchers("/resources/**", "/assets/**", "/static/**", "/css/**", "/js/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/secured/**").authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
	            .defaultSuccessUrl("/dashboard")
	            .loginProcessingUrl("/login_processor")
				.failureUrl("/login?error")
				.usernameParameter("username")
				.passwordParameter("password")
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
			.and()
				.exceptionHandling().accessDeniedPage("/403")
			.and().csrf();
		
		// We can configure /login as welcome-file.
		// We need to return login page in our controller suppose login.jsp page. 
		// In the login.jsp, <form> "action" attribute value should be loginForm. 
		// We don't need to write a controller method with @RequestMapping(loginForm). 
		// Here the url goes to spring security and checks whether the user credentials are correct or not.
		// If the credentials are correct it dispatches the request to /login_processor, 
		// otherwise it goes to same page with errors i.e, /login?error.
	}

}
