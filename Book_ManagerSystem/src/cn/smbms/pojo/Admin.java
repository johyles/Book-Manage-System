package cn.smbms.pojo;

/**
 * @description:
 * @author: Flame(1211017835 @ qq.com))
 * @time: 2020/6/9 16:16
 */

public class Admin {
    private Integer admin_id;
    private String username;
    private String password;

    public Admin() {
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}