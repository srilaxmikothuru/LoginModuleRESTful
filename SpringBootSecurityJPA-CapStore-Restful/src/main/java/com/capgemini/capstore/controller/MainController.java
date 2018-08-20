package com.capgemini.capstore.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.service.UserDetailsServiceImpl;
 
@RestController
public class MainController {
	
	
	@Autowired
	UserDetailsServiceImpl user;
	
    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
		return user.welcomeMethod(model);
    	
       
    }
 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
         
        return user.adminPage(model, principal);
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
 
        return  user.loginPage(model);
    }
 
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
		return user.logoutSuccessfulPage(model);
        
    }
 
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
 
        // After user login successfully.
        return user.UserInfo(model, principal);
    }
    
    @RequestMapping(value = "/merchantInfo", method = RequestMethod.GET)
    public String merchantInfo(Model model, Principal principal) {
 
        // After user login successfully.
        return user.MerchantInfo(model, principal);
    }
 
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
      // access denied page
        return user.AccessDenied(model, principal);
    }
 
}
