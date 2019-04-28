package org.hxm.microsys.core.dao;

import org.apache.ibatis.annotations.Param;
import org.hxm.microsys.core.entity.SysUser;
import org.hxm.microsys.core.entity.User;

import java.util.List;

public interface UserDao {
    SysUser login(@Param("name") String name, @Param("password") String password);
    // 根据 id 寻找对应的 User
    List<User> findUserByName(@Param("name") String name);
    //查询所有用户
    List<User> getAllUser();
    User findUserById(@Param("id") int id);
    int updateUser(@Param("user") User user);
}
