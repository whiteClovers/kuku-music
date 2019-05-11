package com.xq.serviceadmin.MybatisGeneratorTest;

import com.xq.serviceadmin.ServiceAdminApplication;
import com.xq.serviceadmin.customizeDao.UserDao;
import com.xq.serviceadmin.dao.UserMapper;
import com.xq.serviceadmin.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @program: kukuMusic
 * @description:
 * @author: Mr.Fu
 * @create: 2019-05-05 14:25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserDao userDao;

    @Test
    public void testSelect(){
        userMapper.selectAll().stream().forEach(student -> System.out.println(student));

    }

    @Test
    public void testSelectByName(){
        User heartbeat1 = userDao.getUserFromNickName("heartbeat1");
        System.out.println(heartbeat1);
    }

    @Test
    public void testInsert(){


    }

    @Test
    public void testUUid(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);

    }

}
