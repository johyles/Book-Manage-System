package cn.smbms.dao.admin;

import cn.smbms.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    //根据管理员ID获取管理员
    public Admin getAdminByName(@Param("userName") String userName);
}