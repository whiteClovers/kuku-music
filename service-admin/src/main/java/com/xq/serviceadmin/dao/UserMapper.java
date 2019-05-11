package com.xq.serviceadmin.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.xq.serviceadmin.entity.User;
import com.xq.utils.MyMapper;

public interface UserMapper extends MyMapper<User> {
    List<User> selectAllByUserNickname(@Param("userNickname")String userNickname);

    int updateByUserNickname(@Param("updated")User updated,@Param("userNickname")String userNickname);

    User selectOneByPhone(@Param("phone")String phone);




}