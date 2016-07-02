package mybatis.controller;

import mybatis.model.ItemCustom;
import mybatis.model.User;
import mybatis.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
@RequestMapping("/userController")
public class UserController {
	private UserServiceI userService;
	
	
	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}


	//@RequestMapping("/showUser/{id}")
	@RequestMapping("/{id}/showUser")
	public String showUser(@PathVariable String id,HttpServletRequest requet){
		User user = userService.getUserById(id);
		requet.setAttribute("user", user);
		return "items/showUser";
	}

}
