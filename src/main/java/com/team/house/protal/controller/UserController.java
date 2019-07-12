package com.team.house.protal.controller;

import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller("userController2")
@RequestMapping("/page/")
public class UserController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("login")
    public String login(String veryCode, String name, String password, Model model, HttpSession session) {
        String savecode = (String) session.getAttribute("savecode");
        if (veryCode.equals(savecode)) {
            Users user = usersService.login(name, password);
            if (user != null) {
                session.setAttribute("user", user);
                //一般可设置在未使用该页面时 session的有效时间
                session.setMaxInactiveInterval(900);
                return "redirect:getHouse";
            } else {
                model.addAttribute("info", "用户名或密码不正确！");
                return "login";
            }
        }else {
            model.addAttribute("info","验证码输入超时！");
            return "login";
        }

        }

        @RequestMapping("checkName")
        @ResponseBody
        public String checkName (String name){
            int i = usersService.checkName(name);
            if (name == null || name.equals("")) {
                i = 2;
            }
            return "{\"result\":" + i + "}";
        }

        @RequestMapping(value = "reg")
        //@ResponseBody
        public String reg (Users user)throws Exception {
            int i = usersService.addUser(user);
            if (i > 0) {
                //return "<script>alert('注册成功');location.href='login.jsp'</script>";
                return "login";
            } else {
                return "regs";
            }
        }

    }

