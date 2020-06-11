package cn.smbms.pojo;

/**
 * @description:
 * @author: Flame(1211017835 @ qq.com))
 * @time: 2020/6/9 14:41
 */

public class User {
     private Integer uid;//用户id
     private String uname;//用户姓名
     private String pwd;//用户密码
     private Integer num;//已经借阅的书籍
     private Integer balance;//账户余额

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
