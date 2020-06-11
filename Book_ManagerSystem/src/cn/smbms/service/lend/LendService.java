package cn.smbms.service.lend;

import cn.smbms.pojo.Book;
import cn.smbms.pojo.Class;
import cn.smbms.pojo.Info;

import java.util.Date;
import java.util.List;

public interface LendService {
    /**
     * @description:查询用户借阅列表
     * @return:
     * @author: fusheng-ji
     * @time: 2020/6/10 11:07
     */
    //通过用户ID查询已借阅书籍
    public List<Info> findInfo(Integer uid,String bookName);

    //查询分类列表
    public List<Class> getclassList();

    //归还图书
    public void returnBook(Integer uid,Integer bid);
    //查询书籍列表
    public List<Book> findBook(String bname,Integer class_id);
    //借书
    public int addlend(Integer uid, Integer bid,Integer class_id,Integer number);
}
