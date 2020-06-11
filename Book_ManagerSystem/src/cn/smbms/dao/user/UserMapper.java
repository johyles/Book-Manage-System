package cn.smbms.dao.user;

import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: Book_ManagerSystem
 * @description: 用户Dao层
 * @author: SkyCloud
 * @create: 2020-06-09 20:35
 **/

public interface UserMapper {

    //根据用户名获得用户
    public User getUserByUserCode(@Param("uname") String uname);

    //根据用户名和用户角色获得用户列表
    public List<User> getUserList(@Param("uname") String uname);


    //添加用户
    public void addUser(@Param("uname") String uname,
                        @Param("pwd") String pwd,
                        @Param("balance") Integer balance,
                        @Param("num")Integer num);

    //分页查询用户列表
    public List<User> getUserList_page(@Param("uname")String uname,
                                       @Param("from")int from,
                                       @Param("pageSize")int pageSize);


    //查询用户总记录数
    public int getUserCount(@Param("uname")String uname);

    //修改用户信息
    public void updateUser(@Param("uid")Integer uid,
                           @Param("uname") String uname,
                           @Param("pwd")String pwd,
                           @Param("balance")String balance);

    //根据用户ID获得用户列表
    public User getUserByUid(@Param("uid")Integer uid);

    //根据用户ID获得用户列表
    public List<User> getUserListByUid(@Param("uid")Integer uid);

    //查询所有用户，无条件
    public List<User> getUserListNone();

    //删除用户根据id
    public void deleteUser(@Param("uid")Integer uid);

    //注册时添加用户
    public int add(User user);

    //更改用户密码
    public int  updatePassword(User user);

}