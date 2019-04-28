package org.hxm.microsys.core.service;

import org.hxm.microsys.core.entity.SysUser;
import org.hxm.microsys.core.entity.User;

import java.util.List;

public interface IUserService {
    // 根据 id 寻找对应的 User
    User findUserById(int id);
    SysUser login(String name,String password);
    List<User> findAllUser();
}
