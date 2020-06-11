package cn.smbms.dao.book;

import cn.smbms.pojo.Book;
import cn.smbms.pojo.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //管理员功能：根据书籍名称和书籍种类动态查询图书列表
    public List<Book> getBookList(@Param("bookName") String bookName,
                                  @Param("bookClass")Integer bookClass,
                                  @Param("from")int from,
                                  @Param("pagesize")int pagesize);
    //管理员功能：查询书籍类别列表
    public List<Class> getClassList();

    //返回书籍信息的条数
    public int getBookCount(@Param("bookName") String bookName, @Param("bookClass")Integer bookClass);

    //添加书籍
    public int addBook(Book book);

    //通过书籍的id 返回书籍的信息
    public Book getBookByBookId(@Param("bid")Integer bid);

    //修改书籍的信息
    public int modifyBook(Book book);

    //根据书籍id删除图书
    public int deleteBook(@Param("bid") Integer bid);
}
