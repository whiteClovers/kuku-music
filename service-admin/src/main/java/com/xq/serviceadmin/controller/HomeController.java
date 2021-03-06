package com.xq.serviceadmin.controller;

import com.xq.serviceadmin.customizeService.UserServiceth;
import com.xq.serviceadmin.entity.User;
import com.xq.serviceadmin.entity.dto.BaseResult;
import com.xq.serviceadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: kukuMusic
 * @description:
 * @author: Mr.Fu
 * @create: 2019-05-05 16:37
 **/
@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceth userServiceth;

    @GetMapping("/")
    public String root() {
        return "home/home";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }


    /* 
    * @Description:  
    * @Param: [session, phone, pwd] 
    * @return: com.xq.serviceadmin.entity.dto.BaseResult 
    * @Author: Mr.Fu 
    * @Date: 2019/5/18 
    */ 
    @PostMapping("/login")
    public BaseResult login(
            HttpSession session,
            @RequestParam(value = "phone", required = true) String phone,
            @RequestParam(value = "pwd", required = true) String pwd) {
        User user = userServiceth.login(phone, pwd);
        //登录成功
        if (null != user) {
            session.setAttribute("user", user);
            return BaseResult.ok(user);
        }
        //登录失败
        else {
            return BaseResult.notOk("登录失败");
        }
    }


    @GetMapping("/login_error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
        return "user/error";
    }

    @GetMapping("/register")
    public String register() {
        return "user/register";
    }

    @GetMapping("/register_stay")
    public String register_stay() {
        return "user/register_stay";
    }

    /* 
    * @Description:  用户注册
    * @Param: [user, phone, pwd] 
    * @return: com.xq.serviceadmin.entity.dto.BaseResult
    * @Author: Mr.Fu 
    * @Date: 2019/5/18 
    */
    @PostMapping("/register")
    public BaseResult registerUser(User user,
                  @RequestParam(value = "phone", required = true) String phone,
                  @RequestParam(value = "pwd", required = true) String pwd) {
//        String phone = request.getParameter("phone");
//        String password = request.getParameter("password");

        user.setPhone(phone);
        user.setPassword(pwd);
        int insert = userService.insert(user);
        System.out.println(insert);

        if (insert == 1) {
            return BaseResult.ok();
        } else {
            return BaseResult.notOk("注册失败");
        }

    }

    @GetMapping("/validate")
    public String validate(HttpSession session) {
        session.invalidate();

        return "ok";
    }


}
