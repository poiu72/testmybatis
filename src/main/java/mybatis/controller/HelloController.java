package mybatis.controller;

import mybatis.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jiaranran on 2016/7/13.
 */
@RequestMapping("/hello")
@Controller
public class HelloController {
   /* @RequestMapping(value = "/home",method = RequestMethod.GET)
    public User home(String username,Model model){
        User user=new User();
        user.setUsername(username);
        model.addAttribute("user",user);
        model.addAttribute("message","world");
        return user;
//        return new ModelAndView("WEB-INF/views/home.jsp");
    }*/
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(User user) {
       return "hello/input";
    }
    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public User postHome(User user){
        return user;
    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("message","world");
        return "hello/test";
    }
}
