package com.cqust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cqust.model.User;
import com.cqust.service.UserService;

/**
 * 用户操作类
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService uService;
	//定义URL访问映射路径
    @RequestMapping(value = "/info/{userId}", method = RequestMethod.GET)
    public String userInfo(Model model,@PathVariable int userId) {
        //根据id查询
    	User user=uService.getUser(userId);
    	//将user传递到userInfo.jsp
        model.addAttribute("user",user);
        return "userInfo";
    }
}
