package org.hxm.microsys.core.entity;

import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@ToString
@Alias("SysUser")
public class SysUser {
    private int sysUid;
    private String sysUName;
    private String password;
    private int type;
    private int status;


    public SysUser() {
    }

    public SysUser(String sysUName, String password) {
        this.sysUName = sysUName;
        this.password = password;
    }
}
