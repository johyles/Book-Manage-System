package cn.smbms.service.user;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //登陆
    public User login(String userCode, String password) {
        User user = userMapper.getUserByUserCode(userCode);
        if(user!=null && !user.getUserPassword().equals(password)){
            //当用户存在，但是密码不一致，赋值为null
            user=null;
        }
        return user;
    }

    //根据用户名和用户角色获得用户列表
    public List<User> getUserList(String userName, Integer userRole) {
       return this.userMapper.getUserList(userName,userRole);

    }

    //获得角色列表
    public List<Role> getRoleList() {
      return   this.userMapper.getRoleList();

    }

    @Override
    public void addUser(String userCode, String userName, String userPassword, Integer gender, Date birthday, String phone, String address, Integer userRole) {
        this.userMapper.addUser(userCode,userName,userPassword,gender,birthday,phone,address,userRole);
    }
}
