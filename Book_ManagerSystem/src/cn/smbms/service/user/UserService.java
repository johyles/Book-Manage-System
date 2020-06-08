package cn.smbms.service.user;

import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import javax.management.relation.Role;
import java.util.Date;
import java.util.List;


public interface UserService {

    //登陆验证
    public User login(String userCode, String password);

    //根据用户名和用户角色获得用户列表
    public List<User> getUserList(String userName, Integer userRole);

    //获得角色列表
     public  List<Role> getRoleList();

    //添加用户
    public  void addUser(String userCode, String userName,
                         String userPassword, Integer gender,
                         Date birthday, String phone,
                         String address, Integer userRole);
}
