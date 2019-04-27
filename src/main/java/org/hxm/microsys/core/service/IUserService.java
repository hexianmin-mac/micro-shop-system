package org.hxm.microsys.core.service;

import org.hxm.microsys.core.entity.User;

public interface IUserService {
    // 根据 id 寻找对应的 User
    User findUserById(int id);
}
