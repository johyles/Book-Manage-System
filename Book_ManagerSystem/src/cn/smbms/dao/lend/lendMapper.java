package cn.smbms.dao.lend;

import cn.smbms.pojo.Book;
import cn.smbms.pojo.Class;
import cn.smbms.pojo.Info;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface lendMapper {
    /**
     * @description:借阅Mapper
     * @author: fusheng-ji
     * @time: 2020/6/10 11:05
     */
    //通过用户ID查询已借阅书籍
    public List<Info> findInfo(@Param("uid") Integer uid,@Param("bid") Integer bid);
    //查询分类列表
    public List<Class> getclassList();
    //查询书籍编号
    public int findBidByBname(@Param("bookName")  String bookName);
    //退还书籍
    public void returnBook(@Param("uid") Integer uid,@Param("bid") Integer bid);
    //查询书籍列表
    public List<Book> findBook (@Param("bname") String bname,@Param("class_id") Integer class_id);
    //借书
    public int check(@Param("bid") Integer bid,@Param("uid") Integer uid);
    public void addLend(@Param("uid") Integer uid,
                        @Param("bid") Integer bid,
                        @Param("class_id") Integer class_id,
                        @Param("lend_date") Date lend_date,
                        @Param("back_date") Date back_date);
    public int updateBook(@Param("bid") Integer bid,
                          @Param("number") Integer number);
}
