package cn.smbms.service.user;

import cn.smbms.pojo.User;

import java.util.List;

public interface User_StudentService {

    //根据用户名获得用户列表
    public List<User> getUserList(Integer uid);

    //根据用户名获得用户列表
    public User getUser(Integer uid);

}
