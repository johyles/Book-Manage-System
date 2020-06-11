package cn.smbms.pojo;

import java.util.Date;

/**
 * @description:借阅信息
 * @author: Flame(1211017835 @ qq.com))
 * @time: 2020/6/9 17:07
 */

public class Info {
    private Integer lid;//
    private Integer uid;//用户id
    private Integer bid;//书籍id
    private Date lend_date;//借书日期
    private Date back_date;//还书日期
    private String bname;

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Date getLend_date() {
        return lend_date;
    }

    public void setLend_date(Date lend_date) {
        this.lend_date = lend_date;
    }

    public Date getBack_date() {
        return back_date;
    }

    public void setBack_date(Date back_date) {
        this.back_date = back_date;
    }

    public Info() {
    }


}
