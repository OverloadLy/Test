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
 * �û�������
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService uService;
	//����URL����ӳ��·��
    @RequestMapping(value = "/info/{userId}", method = RequestMethod.GET)
    public String userInfo(Model model,@PathVariable int userId) {
        //����id��ѯ
    	User user=uService.getUser(userId);
    	//��user���ݵ�userInfo.jsp
        model.addAttribute("user",user);
        return "userInfo";
    }
}
