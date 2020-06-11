package cn.smbms.controller.lend;

import cn.smbms.pojo.Book;
import cn.smbms.pojo.User;
import cn.smbms.pojo.Info;
import cn.smbms.pojo.Class;
import cn.smbms.service.lend.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author: fusheng-ji
 * @time: 2020/6/10 10:35
 * @description:借阅控制器
 */
@Controller
@RequestMapping("/sys/lend")
public class LendController {
    @Autowired
    private LendService lendService;

    @RequestMapping(value = {"/lendlist.html","/lend.do"})
    /**
     *
     *
     * @description:
     * @param bookName
     * @param model
     * @param session
     * @return: java.lang.String
     * @author: fusheng-ji
     * @time: 2020/6/10 17:34
     */
    public String getLendList(@RequestParam(value ="queryname",required = false) String bookName,
                                  Model model,
                                  HttpSession session) throws NoSuchFieldException{
        User userSession = (User) session.getAttribute("userSession");
        int uid = 1;//userSession.getId();
    List<Info> infoList=lendService.findInfo(uid,bookName);
        //放入model容器中，然后再返回页面中获取到
        model.addAttribute("lendList",infoList);

        //获得分类列表
        List<Class> classList=this.lendService.getclassList();
        model.addAttribute("classList",classList);

        //书名和书籍分类添加到model
        model.addAttribute("queryBookName",bookName);


        return "lend/Lendlist";
    }

    @RequestMapping(value ={"lenddelete.html"})
    /**
     *
     *
     * @description:
     * @param uid
     * @param bid
     * @return: java.lang.String
     * @author: fusheng-ji
     * @time: 2020/6/10 17:34
     */
    public void returnBook(   @RequestParam(value ="uid",required = false) Integer uid,
                                @RequestParam(value ="bid",required = false) Integer bid,
                                HttpServletResponse response) throws IOException{
        lendService.returnBook(uid,bid);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.flush();
        out.println("<script>");
        out.println("alert('还书成功！');");
        out.println("</script>");
        response.getWriter().flush();
        response.getWriter().write("<script>; " +
                "window.location='lendlist.html'; window.close();</script>");
    }

    @RequestMapping(value = {"/book.do","/booklist.html"})
    /**
     *
     *
     * @description:
     * @param bname
     * @param bid
     * @param model
     * @param session
     * @return: java.lang.String
     * @author: fusheng-ji
     * @time: 2020/6/10 19:28
     */
    public String serach(   @RequestParam(value ="queryName",required = false) String bname,
                            @RequestParam(value ="queryClass",required = false) Integer class_id,
                            Model model){
        List<Book> bookList=lendService.findBook(bname,class_id);
        List<Class> classList=lendService.getclassList();
        model.addAttribute("bookList",bookList);
        model.addAttribute("ClassList",classList);
        model.addAttribute("queryName",bname);
        model.addAttribute("queryClass",class_id);

        return "lend/booklist";
    }

    @RequestMapping(value = {"/addlend.do","/lendadd.html"})
/**
 *
 *
 * @description:
 * @param bid
 * @param class_id
 * @param number
 * @param session
 * @param response
 * @return: java.lang.String
 * @author: fusheng-ji
 * @time: 2020/6/10 21:23
 */
    public void addlend(@RequestParam(value = "bid",required = false) Integer bid,
                          @RequestParam(value = "class_id",required = false) Integer class_id,
                          @RequestParam(value = "number",required = false) Integer number,
                          HttpSession session,
                          HttpServletResponse response) throws IOException {
        User userSession = (User) session.getAttribute("userSession");
        int uid = 1;//userSession.getId();
        int i=lendService.addlend(uid,bid,class_id,number);
        if(i==-1){
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('书籍馆藏不足！');");
            out.println("</script>");
            response.getWriter().flush();
            response.getWriter().write("<script>; " +
                    "window.location='booklist.html'; window.close();</script>");
        }else if(i==1){
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('借阅成功！');");
            out.println("</script>");
            response.getWriter().flush();
            response.getWriter().write("<script>; " +
                    "window.location='booklist.html'; window.close();</script>");
        }else{
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('不要重复借阅！');");
            out.println("</script>");
            response.getWriter().flush();
            response.getWriter().write("<script>; " +
                    "window.location='booklist.html'; window.close();</script>");

        }
    }


}
