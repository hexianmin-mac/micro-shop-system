package org.hxm.microsys.core.service.impl;

import org.hxm.microsys.core.dao.UserDao;
import org.hxm.microsys.core.entity.SysUser;
import org.hxm.microsys.core.entity.User;
import org.hxm.microsys.core.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private UserDao userDao;


    @Override
    public List<User> findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public SysUser login(String name, String password) {
        return userDao.login(name,password);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public int insertOrUpdateUser(User user) {
        return userDao.insertOrUpdateUser(user);
    }

}
