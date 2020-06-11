package cn.smbms.service.user;

import cn.smbms.pojo.User;

import java.util.List;

public interface UserService {

    //登陆验证
    public User login(String userCode, String password);

    //查询所有用户，无条件
    public List<User> getUserListNone();

    //根据用户名获得用户列表
    public List<User> getUserList(String userName);

    //根据用户ID获得用户列表
    public User getUserByUid(Integer uid);

    //根据用户名获得用户列表
    public List<User> getUserListByUid(Integer uid);

   /* //获得角色列表
     public  List<Role> getRoleList();*/

    //添加用户
    public  void addUser(String uname, String pwd,Integer num,Integer balance);

    //分页查询用户列表
    public List<User> getUserList_page(String uname, Integer currentPageNo);

    //查询用户总记录数
    public int getUserCount(String userName);

    //修改用户信息
    public void updateUser(Integer uid,String uname, String pwd, String balance);

    //删除用户根据id
    public void deleteUser(Integer uid);
}
