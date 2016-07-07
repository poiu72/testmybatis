package mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by jiaranran on 2016/7/4.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(HttpSession session,String username,String password) throws Exception{
        /*调用service进行身份验证*/
        session.setAttribute("username",username);
        return "redirect:/itemController/queryItem.do";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session,String username,String password) throws Exception{
        /*调用service进行身份验证*/
        session.invalidate();
        return "redirect:/itemController/queryItem.do";
    }
}
