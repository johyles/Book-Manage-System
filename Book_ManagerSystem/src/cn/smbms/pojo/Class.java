package cn.smbms.pojo;

/**
 * @description:书籍类别
 * @author: Flame(1211017835 @ qq.com))
 * @time: 2020/6/9 17:03
 */

public class Class {
    private Integer class_id;//类别id
    private String class_name;//类别名称

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
