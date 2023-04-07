package com.neusoftwjj.crm.settings.service;

import com.neusoftwjj.crm.settings.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User queryUserByLoginActAndPwd(Map<String ,Object> map);
    List<User> queryAllUsers();
}
