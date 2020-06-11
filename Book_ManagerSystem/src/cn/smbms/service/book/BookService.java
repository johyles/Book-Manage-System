package cn.smbms.service.book;

import cn.smbms.pojo.Book;
import cn.smbms.pojo.Class;

import java.util.List;

public interface BookService {
    //管理员功能：根据书籍名称和书籍种类动态查询图书列表
    public List<Book> getBookList(String bookName, Integer bookClass, Integer currentPageNow);

    //管理员功能：查询书籍类别列表
    public List<Class> getClassList();

    //返回书籍信息的条数
    public int getBookCount(String bookName,Integer bookClass);

    //添加书籍
    public int addBook(Book book);

    //通过书籍id获得书籍信息
    public Book getBookByBookId(Integer bid);

    //修改图书信息
     public int modifyBook(Book book);
     //根据图书id删除图书
    public int deleteBook(Integer bid);
}
