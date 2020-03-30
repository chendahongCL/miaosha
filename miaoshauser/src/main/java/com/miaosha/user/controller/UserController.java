package com.miaosha.user.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.miaosha.common.entity.UserInfo;
import com.miaosha.common.form.UserRegisterForm;
import com.miaosha.user.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "findUserByid", method = RequestMethod.GET)
	public String findUserByid(int id, Model model) {
		UserInfo userInfo = userService.findUserByid(id);
		model.addAttribute("userInfo", userInfo);
		return "viewUser";
	}

	@RequestMapping(value = "toRegisterUser", method = RequestMethod.GET)
	public String toRegisterUser() {

		return "toRegisterUser";
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String registerUser(UserRegisterForm userRegisterForm, Model model) {
		if (StringUtils.isBlank(userRegisterForm.getAccount())) {
			model.addAttribute("error", "用户名不能为空");
			return "toRegisterUser";
		}
		if (StringUtils.isBlank(userRegisterForm.getPassword())
				|| StringUtils.isBlank(userRegisterForm.getRepassword())) {
			model.addAttribute("error", "密码不能为空");
			return "toRegisterUser";
		}
		if (!userRegisterForm.getPassword().equals(userRegisterForm.getRepassword())) {
			model.addAttribute("error", "两次密码输入不一致");
			return "toRegisterUser";
		}
		try {
			userService.saveUserInfo(userRegisterForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "viewUser";
	}
	
	@RequestMapping(value = "toLogin",method = RequestMethod.GET)
    public String toLogin(){

        return "toLogin";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(UserRegisterForm userRegisterForm,Model model){
        if(StringUtils.isBlank(userRegisterForm.getAccount())){
            model.addAttribute("error","用户名不能为空");
            return "toLogin";
        }
        if(StringUtils.isBlank(userRegisterForm.getPassword()) ){
            model.addAttribute("error","密码不能为空");
            return "toLogin";
        }
        try {
            boolean result = userService.verifyUserAccount(userRegisterForm);
            if(!result){
                model.addAttribute("error","密码不对");
                return "toLogin";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "toLogin";
    }

}
