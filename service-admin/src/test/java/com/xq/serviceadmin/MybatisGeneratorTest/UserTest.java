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

import java.util.Date;
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
    public void testRegister(){
        User user = new User();

        String phone = "15933467891";
        String password = "23342324";
        user.setPhone(phone);
        user.setPassword(password);

        int flag = userMapper.insertSelective(user);
        if (flag == 1){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }
    }

    @Test
    public void testLogin(){
        String phone = "15979033670";
        String password = "1234zz";
        String loginName = userDao.login(phone, password);

        System.out.println("登录用户: " +userMapper.selectAllByUserNickname(loginName));
    }

    @Test
    public void testUserEdit(){
        String nickName = "王小帅";
        String city = "北京";
        String gender = "0";
        Date birth = new Date();

        User user = new User();
        user.setUserId(1);
        user.setUserNickname(nickName);
        user.setAddr(city);
        user.setGender(gender);
        user.setBirth(birth);

        int flag = userMapper.updateByPrimaryKeySelective(user);
        if (flag == 1){
            System.out.println("用户修改成功");
            System.out.println(userMapper.selectByPrimaryKey(1));
        }else {
            System.out.println("用户修改失败");
        }
    }

}
