package cn.smbms.service.admin;

import cn.smbms.dao.admin.AdminMapper;
import cn.smbms.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;

    public Admin login(String userName, String passWord) {
        Admin admin = adminMapper.getAdminByName(userName);
        if(admin!=null && !admin.getPassword().equals(passWord)){
            //当用户存在，但是密码不一致，赋值为null
            admin=null;
        }
        return admin;
    }
}
