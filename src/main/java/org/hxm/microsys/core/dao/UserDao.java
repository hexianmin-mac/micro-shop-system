package org.hxm.microsys.core.dao;

import org.apache.ibatis.annotations.Param;
import org.hxm.microsys.core.entity.SysUser;
import org.hxm.microsys.core.entity.User;

import java.util.List;

public interface UserDao {
    SysUser login(@Param("name") String name, @Param("password") String password);
    // 根据 id 寻找对应的 User
    User findUserById(int id);
    //查询所有用户
    List<User> getAllUser();
}
