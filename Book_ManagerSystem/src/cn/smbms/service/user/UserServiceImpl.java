package cn.smbms.service.user;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import cn.smbms.tools.Constants;
import org.aspectj.apache.bcel.classfile.Constant;
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

    //添加用户
    public void addUser(String userCode, String userName, String userPassword, Integer gender, Date birthday, String phone, String address, Integer userRole) {
        this.userMapper.addUser(userCode,userName,userPassword,gender,birthday,phone,address,userRole);
    }

    //分页查询用户列表
    public List<User> getUserList_page(String userName, Integer userRole, Integer currentPageNo) {
        //规律 ：表中的记录索引from=（当前页码currentPageNow-1）*页容量PageSize
        int PageSize= Constants.pageSize;
        int from = (currentPageNo-1)*PageSize;
        List<User> userListPage= this.userMapper.getUserList_page(userName,userRole,from,PageSize);
        return userListPage;
    }

    //查询用户总记录数
    public int getUserCount(String userName, Integer userRole) {
        return this.userMapper.getUserCount(userName,userRole);
    }

}
