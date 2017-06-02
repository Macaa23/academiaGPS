package com.ubb.gps.account.web;

import com.ubb.gps.account.model.User;
import com.ubb.gps.account.service.SecurityService;
import com.ubb.gps.account.service.UserService;
import com.ubb.gps.account.validator.GetPropertyValues;
import com.ubb.gps.account.validator.UserValidator;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	private static int TYPE = 0;
	
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    GetPropertyValues properties = new GetPropertyValues();
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) throws IOException {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        if (userForm.getUsername().equals("admindanza")) {
			TYPE = 1;
		}
        
        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        
    	String[] account = properties.getPropValues();
    	
    	/*if(account[0].equals(userForm.getUsername())&& account[1].equals(userForm.getPasswordConfirm())){
        	TYPE = 1;
        }*/
    	
    	
        return "redirect:/inicio";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) throws IOException {
		
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/inicio"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	if(TYPE == 1){
    		return "index_admin";
    	}else{
    		return "welcome";
    	}
    }
}