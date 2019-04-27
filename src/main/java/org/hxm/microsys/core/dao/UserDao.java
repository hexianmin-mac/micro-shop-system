package org.hxm.microsys.core.dao;

import org.hxm.microsys.core.entity.User;

public interface UserDao {
    // 根据 id 寻找对应的 User
    User findUserById(int id);
}
