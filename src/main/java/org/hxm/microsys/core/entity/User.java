package org.hxm.microsys.core.entity;

import lombok.Getter;
import org.apache.ibatis.type.Alias;

@Getter
@Alias("User")
public class User {
    private int userId;
    private String userName;
    private int sex;
    private int age;
    private String phone;
    private String address;
    private int type;
    private int status;

}
