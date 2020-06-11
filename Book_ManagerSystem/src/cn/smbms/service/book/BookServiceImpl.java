package cn.smbms.service.book;

import cn.smbms.dao.book.BookMapper;
import cn.smbms.pojo.Book;
import cn.smbms.pojo.Class;
import cn.smbms.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Flame(1211017835 @ qq.com))
 * @time: 2020/6/9 20:55
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    //管理员功能：根据书籍名称和书籍种类动态查询图书列表
    //分页查询用户列表
    public List<Book> getBookList(String bookName, Integer bookClass, Integer currentPageNow) {
        //规律 ：表中的记录索引from=（当前页码currentPageNow-1）*页容量PageSize
        int PageSize= Constants.pageSize;
        int from = (currentPageNow-1)*PageSize;
        List<Book> bookListPage= this.bookMapper.getBookList(bookName,bookClass,from,PageSize);
        return bookListPage;
    }

    @Override
    public List<Class> getClassList() {
        return bookMapper.getClassList();
    }

    @Override
    public int getBookCount(String bookname,Integer bookClass) {
        return bookMapper.getBookCount(bookname,bookClass);
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public Book getBookByBookId(Integer bid) {
        return bookMapper.getBookByBookId(bid);
    }

    @Override
    public int modifyBook(Book book) {
        return bookMapper.modifyBook(book);
    }

    @Override
    public int deleteBook(Integer bid) {
        return bookMapper.deleteBook(bid);
    }
}
