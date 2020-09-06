package com.lvym.web.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lvym.pojo.User;
import com.lvym.service.UserService;

@Controller
@RequestMapping("/admin")
public class LoginController {
	@Autowired
	private UserService userservice;
	
	@GetMapping
	public String loginPage() {
		return "admin/login";
	}
	@PostMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password,HttpSession session,RedirectAttributes attributes) {
		User user = userservice.checkUser(username, password);
		System.out.println("safdtgvdgfdhgb");
		System.out.println(username);
		System.out.println(password);
		if(user!=null) {
			user.setPassword(null);
			session.setAttribute("user", user);
			return "admin/index";
		}else {
			attributes.addFlashAttribute("message","用户名和密码出错");//重定向传值
			return "redirect:/admin";
		}
		
		
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/admin";
	}
	
}
