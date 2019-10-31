/**
 * 
 */
package com.spartans.Starbucks.controller;

/**
 * @author musahay
 *
 */

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spartans.Starbucks.dao.CustomerDetails;
import com.spartans.Starbucks.service.CustomerDetailsService;
import com.spartans.Starbucks.service.UserRowMapper;


@RestController
public class LoginController {
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CustomerDetailsService customerDetailService;
	
	@GetMapping("/login")
	public String getLogin() {
	
		System.out.println("In Login Controller");
		return "login";
	}
	
	@PostMapping("/login")
	public CustomerDetails login(@ModelAttribute(name="customerDetails") CustomerDetails customerDetails, Model model,  HttpSession session) {
		
		String Username = customerDetails.getEmail();
		String Password = customerDetails.getPassword();
		String DB_Username = "";
		String DB_Password = "";
		String First_Name ="";
		String Middle_Name ="";
		String Last_Name ="";
		int cust_ID = 0;
		String SELECT_SQL = "SELECT * FROM CUST_DETAILS where Email = ?";
		
		System.out.println("Email " + Username);
		session.setAttribute("isLoggedIn", true);
		session.setAttribute("email", Username);

		CustomerDetails user = null;
		try {
			 user = jdbcTemplate.queryForObject(SELECT_SQL, new UserRowMapper(), customerDetails.getEmail());
		} catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		if(user == null) {
			model.addAttribute("error", true);
			model.addAttribute("errorMessage", "UserNotAvailable");
			return user;
		}
		
		DB_Username =user.getEmail();
		DB_Password =user.getPassword();
		First_Name=user.getFirst_name();
		Last_Name=user.getLast_name();
		cust_ID = user.getCust_id();
		
		session.setAttribute("firstName", First_Name);
		session.setAttribute("middleName", Middle_Name);
		session.setAttribute("lastName", Last_Name);
		session.setAttribute("cust_ID", cust_ID);
		System.out.println("Customer id in login cotroller" + cust_ID  + " " + user.getCust_id());
		System.out.println("Customer id in login cotroller" + cust_ID  + " " + user.getEmail());
			
		if(DB_Username.isEmpty() || DB_Username == null) {
			model.addAttribute("error", true);
			model.addAttribute("errorMessage", "UserNotAvailable");
			return user;
		}
		else if(DB_Username.equals(Username) && DB_Password.equals(Password)) {
			model.addAttribute("userName", Username);
			model.addAttribute("ValidLogin", true);
			return user;
		}
		else {
			model.addAttribute("error", true);
			model.addAttribute("errorMessage", "InvalidCredential");
			return user;
		}
	}
	
	@GetMapping("/signup")
	public String signup() {
	System.out.println("Inside Get method for Signup ****");
		return "signup";
	}
	
	@PostMapping("/signup")
	public CustomerDetails signup(@ModelAttribute(name="CustomerDetails") CustomerDetails user, Model model,  HttpSession session) {
		
		System.out.println("In SIgnUp Controller" + user.getEmail());
		customerDetailService.addCustomerDetails(user);
		
		return user;
	
	}
	
	@GetMapping("/logout")
	public String signout(Model model, HttpServletRequest request, HttpServletResponse resp) {
		request.getSession().setAttribute("isLoggedIn", false);
		request.getSession().setAttribute("firstName", "");
		request.getSession().setAttribute("middleName", "");
		request.getSession().setAttribute("lastName", "");
		request.getSession().setAttribute("cust_ID", "");
		
		Cookie[] cookies = request.getCookies();
	    if (cookies != null)
			System.out.println("Clear Cookies..!!");
	        for (Cookie cookie : cookies) {
	            cookie.setValue("");
	            cookie.setPath("/");
	            cookie.setMaxAge(0);
	            resp.addCookie(cookie);
	        }
		
		return "index";
	}
}