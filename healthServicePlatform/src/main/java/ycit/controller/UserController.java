package ycit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ycit.exception.UserException;
import ycit.pojo.User;
import ycit.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	

	//用户注册
	@RequestMapping("/register")
	public String register(User user,@RequestParam("confirmPwd")String confirmPwd,Model model){
		 try {
			boolean addSucFlag = userService.addUser(user,confirmPwd);
			model.addAttribute("msg", "添加成功!");
			return "login";
		} catch (UserException e) {
			model.addAttribute("msg", e.getMessage());
			//e.printStackTrace();
		}
		return "register";
	}
	//用户登录
	@RequestMapping("/login")
	public String login(User user,Model model,HttpSession session){
		  User u = userService.queryUserByuserCodeAndPwd(user);
		  if(u != null){
			 session.setAttribute("myuser", u);
			 model.addAttribute("user", u);
			  return "index";
		  }else{
			  model.addAttribute("msg","登录失败，用户名或者密码不正确");
			  return "login";
		  }
		
	}
	//用户退出登录
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		session.invalidate();
		return "login";
	}
	

	

}
