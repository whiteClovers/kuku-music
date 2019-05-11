package com.xq.serviceadmin.customizeService.imp;

import com.xq.serviceadmin.customizeDao.UserDao;
import com.xq.serviceadmin.customizeService.UserServiceth;
import com.xq.serviceadmin.dao.UserMapper;
import com.xq.serviceadmin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: kukuMusic
 * @description:
 * @author: Mr.Fu
 * @create: 2019-05-05 15:18
 **/
@Service
public class UserServicethImpl implements UserServiceth {

    @Autowired
    UserDao userDao;
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String phone, String password) {
        User user = userMapper.selectOneByPhone(phone);
        if (password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    public User getUserFromNickName(String nickName) {
        return userDao.getUserFromNickName(nickName);
    }
}
