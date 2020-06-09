package cn.smbms.dao.user;

import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import javax.management.relation.Role;
import java.util.Date;
import java.util.List;

public interface UserMapper {

    //根据用户名获得用户
    public User getUserByUserCode(@Param("userCode") String userCode);

    //根据用户名和用户角色获得用户列表
    public List<User> getUserList(@Param("userName") String userName, @Param("userRole") Integer userRole);

    //获得角色列表
    public List<Role> getRoleList();

    //添加用户
    public void addUser(@Param("userCode") String userCode,
                        @Param("userName") String userName,
                        @Param("userPassword") String userPassword,
                        @Param("gender") Integer gender,
                        @Param("birthday") Date birthday,
                        @Param("phone") String phone,
                        @Param("address") String address,
                        @Param("userRole") Integer userRole);

    //分页查询用户列表
    public List<User> getUserList_page(@Param("userName")String userName,
                                       @Param("userRole")Integer userRole,
                                       @Param("from")int from,
                                       @Param("pageSize")int pageSize);


    //查询用户总记录数
    public int getUserCount(@Param("userName")String userName, @Param("userRole")Integer userRole);
}
