package cn.smbms.controller.book;

import cn.smbms.pojo.Book;
import cn.smbms.pojo.Class;
import cn.smbms.service.book.BookService;
import cn.smbms.tools.Constants;
import cn.smbms.tools.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @description:
 * @author: Flame(1211017835 @ qq.com))
 * @time: 2020/6/9 20:41
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    //按分页，图书名与图书类别分页查询图书信息
    @RequestMapping(value = {"/sys/book/book.do"})
    public String getBookList(@RequestParam(value = "queryname",required = false) String bookName,
                              @RequestParam(value = "queryBookClass",required = false) Integer bookClass,
                              Model model,
                              @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer currentPageNo){

        List<Book> bookList = bookService.getBookList(bookName,bookClass,currentPageNo);
        //放入model容器中，然后再返回页面中获取到
        model.addAttribute("bookList",bookList);

        List<Class> classList = bookService.getClassList();
        //放入model容器中，然后再返回页面中获取到
        model.addAttribute("classList",classList);
        //用户名和用户角色列表添加到model
        model.addAttribute("queryBookName",bookName);
        model.addAttribute("queryBookClass",bookClass);

        PageSupport pageSupport = new PageSupport();
        //1-设置页容量
        pageSupport.setPageSize(Constants.pageSize);

        //2-设置用户总记录数
        int totalCount=this.bookService.getBookCount(bookName,bookClass);
        pageSupport.setTotalCount(totalCount);

        //3-设置总页数-上述2个set方法已经计算出来，不需要再人为地设置

        //4-当前页码
        pageSupport.setCurrentPageNo(currentPageNo);

        model.addAttribute("pageSupport",pageSupport);

        return "book/booklist";//逻辑视图名
    }

    //跳转到增加图书界面
    @RequestMapping(value = {"/sys/book/bookadd.html"})
    public String showAddBookPage(){
        return "book/bookadd";
    }

    //增加图书
    @RequestMapping(value = {"/sys/book/bookaddsave.html"})
    public String addBook(@RequestParam(value = "bname",required = false) String bname,
                          @RequestParam(value = "ISBN",required = false) String ISBN,
                          @RequestParam(value = "price",required = false) String price,
                          @RequestParam(value = "class_id",required = false) Integer class_id,
                          @RequestParam(value = "number",required = false) Integer number,
                          @RequestParam(value = "info",required = false) String info,
                          @RequestParam(value = "author",required = false) String author,
                          @RequestParam(value = "publish",required = false) String publish,
                          Model model){

        if(bname.equals("")){ return "402";}
        if(ISBN.equals("")){ return "402";}
        if(price.equals("")){ return "402";}
        if(class_id==null){ return "402";}
        if(number==null){ return "402";}
        if(info.equals("")){ return "402";}
        if(author.equals("")){ return "402";}
        if(publish.equals("")){ return "402";}

        Book book = new Book();
        book.setBname(bname);
        book.setISBN(ISBN);
        book.setPrice(Double.parseDouble(price));
        book.setClass_id(class_id);
        book.setNumber(number);
        book.setInfo(info);
        book.setAuthor(author);
        book.setPublish(publish);
        int i = bookService.addBook(book);
        if(i!=0){
            return "redirect:/sys/book/book.do";
        }else{
            return "402";
        }

    }


    //跳转到修改图书界面
    @RequestMapping(value = {"/sys/book/bookmodify.html"})
    public String showModifyBookPage(@RequestParam(value = "bid",required = false) Integer bid,
                                     Model model){
        Book book = bookService.getBookByBookId(bid);
        //放入model容器中，然后再返回页面中获取到
        model.addAttribute("book",book);

        return "book/bookmodify";
    }


    //修改图书信息
    @RequestMapping(value = {"/sys/book/bookmodifysave.html"})
    public String modifyBook(@RequestParam(value = "id",required = false) Integer id,
                             @RequestParam(value = "bname",required = false) String bname,
                             @RequestParam(value = "ISBN",required = false) String ISBN,
                             @RequestParam(value = "price",required = false) String price,
                             @RequestParam(value = "class_id",required = false) Integer class_id,
                             @RequestParam(value = "number",required = false) Integer number,
                             @RequestParam(value = "info",required = false) String info,
                             @RequestParam(value = "author",required = false) String author,
                             @RequestParam(value = "publish",required = false) String publish,
                             Model model){
        if(bname.equals("")){ return "402";}
        if(ISBN.equals("")){ return "402";}
        if(price.equals("")){ return "402";}
        if(class_id==null){ return "402";}
        if(number==null){ return "402";}
        if(info.equals("")){ return "402";}
        if(author.equals("")){ return "402";}
        if(publish.equals("")){ return "402";}

        Book book = new Book();
        book.setBid(id);
        book.setBname(bname);
        book.setISBN(ISBN);
        book.setPrice(Double.parseDouble(price));
        book.setClass_id(class_id);
        book.setNumber(number);
        book.setInfo(info);
        book.setAuthor(author);
        book.setPublish(publish);
        int i = bookService.modifyBook(book);
        if(i!=0){
            return "redirect:/sys/book/book.do";
        }else{
            return "402";
        }
    }

    @RequestMapping(value = {"/sys/book/bookdelete.html"})
    public void deleteBook(@RequestParam(value ="bid",required = false) Integer bid,
                           Model model,
                           HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int i = bookService.deleteBook(bid);


        out.flush();
        out.println("<script>");
        out.println("alert('删除成功！');");
        out.println("</script>");
        response.getWriter().flush();
        response.getWriter().write("<script>; " +
                    "window.location='book.do'; window.close();</script>");

        /* List<User> userList = userService.getUserListNone();
        //放入model容器中，然后再返回页面中获取到
        model.addAttribute("user",userList);*/


    }


}
