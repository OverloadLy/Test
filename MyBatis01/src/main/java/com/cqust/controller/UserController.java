package com.cqust.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cqust.model.User;
import com.cqust.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@RequestMapping(value="/findByPage",method=RequestMethod.GET)
	public String findByPage(Model model,@RequestParam("pageNow") int pageNow) {
		uService.findUserByPage(model,pageNow);  
	    return "/result.jsp";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model,HttpServletResponse response,
			                        @RequestParam("name") String name,
			                        @RequestParam("pass") String pass) throws IOException {
		User user=uService.login(name, pass);
		if(user!=null){
			uService.findUserByPage(model,1); 
			return "/result.jsp";
		}
		return "/index.jsp";
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public String addUser(Model model,@ModelAttribute("User") User user) {
		uService.addUser(user);
		uService.findUserByPage(model,1); 
		return "/result.jsp";
		
	}

	@RequestMapping(value="/updateUser",method=RequestMethod.GET)
	public String updateUser(Model model,@ModelAttribute("User") User user,
			                             @RequestParam("id") int id){
		uService.updateUser(user);
		uService.findUserByPage(model,1); 
		return "/result.jsp";	
	}
	
	@RequestMapping(value="/deleteUser",method=RequestMethod.GET)
	public String deleteUser(Model model,@RequestParam("id")int id) {
		uService.deleteUser(id);
		uService.findUserByPage(model,1); 
		return "/result.jsp";
		
	}
	
	@RequestMapping(value="/findById",method=RequestMethod.GET)
	public String findById(Model model,@RequestParam("id") int id) {
		User user=uService.findOne(id);
		model.addAttribute("user",user);
		return "/update.jsp";	
	}
	
}
