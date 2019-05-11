package com.xq.serviceadmin.service;

import com.xq.serviceadmin.entity.User;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface UserService {

    public User seleceById(String id);
    public List<User> seleceByExample(Example example);
    public List<User> seleceAll();

    public int insert(User user);

    public int deleteById(String id);
    public int deleteByExample(Example example);

    public int updateByUser(User user);
    public int updateByExample(User user, Example example);

    public int countByExample(Example example);

    // customize
    int updateByUserNickname(User updated,String userNickname);
}


