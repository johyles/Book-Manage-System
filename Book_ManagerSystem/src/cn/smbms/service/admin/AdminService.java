package cn.smbms.service.admin;

import cn.smbms.pojo.Admin;

public interface AdminService {

    //根据管理员名字获取管理员
    public Admin login(String userName, String passWord);
}
