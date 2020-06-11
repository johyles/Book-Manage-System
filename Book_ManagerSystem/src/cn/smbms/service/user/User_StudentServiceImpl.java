package cn.smbms.service.user;

import cn.smbms.dao.user.User_StudentMapper;
import cn.smbms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: Book_ManagerSystem
 * @description: 学生个人用户服务
 * @author: SkyCloud
 * @create: 2020-06-10 14:29
 **/
@Service
public class User_StudentServiceImpl implements User_StudentService{

    @Autowired
    private User_StudentMapper user_studentMapper;

    //根据用户名获得用户列表
    public List<User> getUserList(Integer uid) {
        return this.user_studentMapper.getUserList(uid);

    }

    //根据用户名获得用户列表
    public User getUser(Integer uid) {
        return this.user_studentMapper.getUser(uid);
    }


}
