package cn.smbms.pojo;

/**
 * @description:
 * @author: Flame(1211017835 @ qq.com))
 * @time: 2020/6/9 14:54
 */

public class Book {
    private Integer bid;//书籍id
    private String bname;//书籍名称
    private String ISBN;//
    private double price;//书籍价格
    private Integer class_id;//书籍类别
    private Integer number;//馆藏数量
    private String info;//书籍简介
    private String author;//作者
    private String publish;//出版社
    private String class_name;//分类名

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getBookClassName() {
        return bookClassName;
    }

    public void setBookClassName(String bookClassName) {
        this.bookClassName = bookClassName;
    }

    private String bookClassName;//书籍分类名称




    public Book() {
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }
}

