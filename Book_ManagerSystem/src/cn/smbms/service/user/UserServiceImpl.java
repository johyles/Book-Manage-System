package cn.smbms.service.user;


import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import cn.smbms.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: Book_ManagerSystem
 * @description:
 * @author: SkyCloud
 * @create: 2020-06-09 20:33
 **/
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    //登陆
    public User login(String uname, String pwd) {
        User user = userMapper.getUserByUserCode(uname);
        if(user!=null && !user.getPwd().equals(pwd)){
            //当用户存在，但是密码不一致，赋值为null
            user=null;
        }
        return user;
    }

    //查询所有用户，无条件
    public List<User> getUserListNone() {
        return this.userMapper.getUserListNone();
    }


    //根据用户名和用户角色获得用户列表
    public List<User> getUserList(String userName) {
       return this.userMapper.getUserList(userName);

    }

    //根据用户ID获得用户列表
    public User getUserByUid(Integer uid) {
        return this.userMapper.getUserByUid(uid);
    }

    //根据用户ID获得用户列表
    public List<User> getUserListByUid(Integer uid) {
        return this.userMapper.getUserListByUid(uid);
    }

    //添加用户
    public void addUser(String uname, String pwd,Integer num,Integer balance) {
        this.userMapper.addUser(uname,pwd,num,balance);
    }

    //分页查询用户列表
    public List<User> getUserList_page(String uname,Integer currentPageNo) {
        //规律 ：表中的记录索引from=（当前页码currentPageNow-1）*页容量PageSize
        int PageSize= Constants.pageSize;
        int from = (currentPageNo-1)*PageSize;
        List<User> userListPage= this.userMapper.getUserList_page(uname,from,PageSize);
        return userListPage;
    }

    //查询用户总记录数
    public int getUserCount(String userName) {
        return this.userMapper.getUserCount(userName);
    }

    //修改用户信息
    public void updateUser(Integer uid,String uname, String pwd, String balance) {
        this.userMapper.updateUser(uid,uname,pwd,balance);
    }

    //删除用户根据id
    public void deleteUser(Integer uid) {
        this.userMapper.deleteUser(uid);
    }


}
