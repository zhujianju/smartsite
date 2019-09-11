package com.jf.jf_smartsite.security.web;

import com.jf.jf_smartsite.IOTData.entity.comEntity.Result;
import com.jf.jf_smartsite.security.entity.User;
import com.jf.jf_smartsite.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("user")
    public String Login(User user,HttpSession session){
        System.out.println(user);
        User one = userService.findOne(user.getUsername());
        if(one != null){
            if(one.getPassword().equals(user.getPassword())){
                session.setAttribute("user",one);
                return "redirect:/admin/index.html";
            }
        }
        return "redirect:/login.html";
    }
    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/login.html";
    }
    @RequestMapping("getUser")
    public @ResponseBody User getUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        return user;
    }

}
