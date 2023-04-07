package com.neusoftwjj.crm.settings.service.Impl;


import com.neusoftwjj.crm.settings.mapper.UserMapper;
import com.neusoftwjj.crm.settings.model.User;
import com.neusoftwjj.crm.settings.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User queryUserByLoginActAndPwd(Map<String, Object> map) {
        return userMapper.selectUserByLoginActAndPwd(map);
    }

    @Override
    public List<User> queryAllUsers(){
        return userMapper.selectAllUsers();
    }
}
