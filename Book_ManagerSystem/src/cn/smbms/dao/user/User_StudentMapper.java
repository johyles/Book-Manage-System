package cn.smbms.dao.user;

import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface User_StudentMapper {

    //根据用户名获得用户表
    public List<User> getUserList(@Param("uid") Integer uid);

    //根据用户名获得用户列表
    public User getUser(@Param("uid")Integer uid);
}
