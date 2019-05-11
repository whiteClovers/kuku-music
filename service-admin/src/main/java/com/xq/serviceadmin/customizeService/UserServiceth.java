package com.xq.serviceadmin.customizeService;

import com.xq.serviceadmin.entity.User;
import org.springframework.stereotype.Service;

/**
 * @program: kukuMusic
 * @description:
 * @author: Mr.Fu
 * @create: 2019-05-05 15:18
 **/
@Service
public interface UserServiceth {

    public User login(String phone, String password);

    public User getUserFromNickName(String nickName);
}
