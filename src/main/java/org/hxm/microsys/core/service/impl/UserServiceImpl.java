package org.hxm.microsys.core.service.impl;

import org.hxm.microsys.core.dao.UserDao;
import org.hxm.microsys.core.entity.User;
import org.hxm.microsys.core.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private UserDao userDao;
    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }
}
