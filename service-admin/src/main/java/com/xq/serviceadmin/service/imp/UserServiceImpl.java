package com.xq.serviceadmin.service.imp;

import com.xq.serviceadmin.dao.UserMapper;
import com.xq.serviceadmin.entity.User;
import com.xq.serviceadmin.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final static int startId = 100;
    private AtomicInteger insertId = new AtomicInteger(startId);

//    private char[] charName = {1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n};

    @Resource
    private UserMapper userMapper;

    public User seleceById(String id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> seleceByExample(Example example){
        return userMapper.selectByExample(example);
    }

    public List<User> seleceAll(){
        return userMapper.selectAll();
    }

    public int insert(User user){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String defaultNickName = uuid.substring(0,9);
        user.setUserNickname(defaultNickName);
        user.setUserId(insertId.incrementAndGet());
        user.setRegTime(new Date());

        System.out.println("service user: "+user);
        return userMapper.insert(user);
    }

    public int deleteById(String id){
        return userMapper.deleteByPrimaryKey(id);
    }

    public int deleteByExample(Example example){
        return userMapper.deleteByExample(example);
    }

    public int updateByUser(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public int updateByExample(User user, Example example){
        return userMapper.updateByExampleSelective(user, example);
    }

    public int countByExample(Example example){
        return userMapper.selectCountByExample(example);
    }

    //customize
    public int updateByUserNickname(User updated,String userNickname){
        return userMapper.updateByUserNickname(updated, userNickname);
    }

}


