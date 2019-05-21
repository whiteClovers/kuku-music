package com.xq.serviceadmin.controller;

import com.xq.serviceadmin.customizeService.UserServiceth;
import com.xq.serviceadmin.dao.UserMapper;
import com.xq.serviceadmin.entity.User;
import com.xq.serviceadmin.entity.dto.BaseResult;
import com.xq.serviceadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        User curUser = userMapper.selectByPrimaryKey(user.getUserId());
        return id == user.getUserId() ? BaseResult.ok(curUser) : BaseResult.notOk("没有权限");
    }


    /* 
    * @Description: 用户信息修改 
    * @Param: [user, session] 
    * @return: com.xq.serviceadmin.entity.dto.BaseResult 
    * @Author: Mr.Fu 
    * @Date: 2019/5/18 
    */ 
    @PostMapping("/edit")
    public BaseResult userEdit(User user, HttpSession session) throws Exception {
        User loginUser = (User)session.getAttribute("user");
        Integer userId = loginUser.getUserId();

        user.setUserId(userId);

        int i = userMapper.updateByPrimaryKeySelective(user);
        System.out.println("编辑后的user :" + user);

        if (i == 1) {
            return BaseResult.ok(user);
        } else {
            return BaseResult.notOk("编辑用户信息失败");
        }
    }

}
