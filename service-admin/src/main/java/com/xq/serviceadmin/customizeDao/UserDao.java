package com.xq.serviceadmin.customizeDao;

import com.xq.serviceadmin.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @program: kukuMusic
 * @description:
 * @author: Mr.Fu
 * @create: 2019-05-05 14:53
 **/
public interface UserDao {



    @Select("select user_nickName from user where phone=#{phone} and password=#{password} ")
    public String login(@Param("phone") String phone,@Param("password") String password);

    @Select("select * from user where user_nickName=#{nickName} ")
    public User getUserFromNickName(@Param("nickName") String nickName);
}
