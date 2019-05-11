package com.xq.serviceadmin.controller;

import com.xq.serviceadmin.customizeService.UserServiceth;
import com.xq.serviceadmin.dao.UserMapper;
import com.xq.serviceadmin.entity.User;
import com.xq.serviceadmin.entity.dto.BaseResult;
import com.xq.serviceadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: kukuMusic
 * @description:
 * @author: Mr.Fu
 * @create: 2019-05-04 20:24
 **/

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserServiceth userServiceth;

    /***
     * 获得当前登录用户的信息
     * @param session
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public BaseResult view(HttpSession session, @PathVariable("id") Integer id) {
        User user = (User) session.getAttribute("user");
        return id == user.getUserId() ? BaseResult.ok(user) : BaseResult.notOk("没有权限");
    }


    @PostMapping("/edit")
    public String userEdit(HttpServletRequest request, User user) throws Exception {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
//        String nickName = request.getParameter("nickName");
//        System.out.println(nickName);

        System.out.println("userId :" + userId);

        user.setUserId(userId);
        System.out.println("edituser :" + user);

        int i = userMapper.updateByPrimaryKeySelective(user);

        if (i == 1) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }

        return "redirect:/user";
    }

}
