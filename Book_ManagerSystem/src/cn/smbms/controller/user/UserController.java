package cn.smbms.controller.user;

import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;
import cn.smbms.tools.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @program: Book_ManagerSystem
 * @description: 用户控制层
 * @author: SkyCloud
 * @create: 2020-06-09 20:31
 **/
@Controller
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
    * @Author: SkyCloud
    * @Date: 2020/6/9
    * @Param: [uname, model, currentPageNo]
    * @return: java.lang.String
    */
    @RequestMapping(value = {"/userlist.html","/user.do"})
    public String getUserList(@RequestParam(value ="queryname",required = false) String uname,
                              Model model,
                              @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer currentPageNo){
        //List<User> userList = userService.getUserList(userName,userRole);
        List<User> userList = userService.getUserList_page(uname,currentPageNo);

        //放入model容器中，然后再返回页面中获取到
        model.addAttribute("userList",userList);

        //用户名和用户角色添加到model
        model.addAttribute("queryUserName",uname);

        PageSupport pageSupport = new PageSupport();

        //1-设置页容量
        pageSupport.setPageSize(Constants.pageSize);

        //2-设置用户总记录数
        int totalCount=this.userService.getUserCount(uname);
        pageSupport.setTotalCount(totalCount);

        //3-设置总页数-上述2个set方法已经计算出来，不需要再人为地设置

        //4-当前页码
        pageSupport.setCurrentPageNo(currentPageNo);

        model.addAttribute("pageSupport",pageSupport);

        return "user/userlist";
    }

    /**
    * @Author: SkyCloud
    * @Date: 2020/6/9
    * @Param: []
    * @return: java.lang.String
    * @description:跳转添加用户页面
    */
    @RequestMapping(value = {"/useradd.html"})
    public String addUser(){
        return  "user/useradd";
    }

    /**
    * @Author: SkyCloud
    * @Date: 2020/6/9
    * @Param: [uname, pwd, model]
    * @return: java.lang.String
    * @description:保存添加用户
    */
    @RequestMapping(value = {"/useraddsave.html"},method = RequestMethod.POST)
    public String saveUser(@RequestParam(value ="uname",required = false) String uname,
                           @RequestParam(value ="pwd",required = false)String pwd,
                           @RequestParam(value ="num",required = false) Integer num,
                           @RequestParam(value ="balance",required = false)Integer balance,
                           HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if ((num==null)||uname.equals("")||pwd.equals("")||balance==null){
            out.flush();
            out.println("<script>");
            out.println("alert('不能为空，请重新输入！');");
            out.println("</script>");
            return "user/useradd";
        }else{
            int i = userService.getUserList(uname).size();
            if (i>0){
                out.flush();
                out.println("<script>");
                out.println("alert('用户名已存在，请重新输入！');");
                out.println("</script>");
                return "user/useradd";
            }else{
                userService.addUser(uname,pwd,num,balance);
                out.flush();
                out.println("<script>");
                out.println("alert('添加成功！');");
                out.println("</script>");
                response.getWriter().write("<script>; " +
                        "window.location='userlist.html'; window.close();</script>");
                return null;
            }
        }
    }


    /**
    * @Author: SkyCloud
    * @Date: 2020/6/9
    * @Param: []
    * @return: java.lang.String
    * @description:跳转修改页面
    */
    @RequestMapping(value = {"/usermodify.html"})
    public String modifyUser(@RequestParam(value ="uid",required = false) Integer uid,
                             Model model) {

        User userList = userService.getUserByUid(uid);
        //放入model容器中，然后再返回页面中获取到
        model.addAttribute("user",userList);
        return "user/usermodify";
    }

    /**
    * @Author: SkyCloud
    * @Date: 2020/6/9
    * @Param: [uid, uname, pwd, balance, model]
    * @return: java.lang.String
    * @description:保存修改内容
    */
    @RequestMapping(value = {"/usermodifysave.html"},method = RequestMethod.POST)
    public void modifysaveUser(@RequestParam(value ="uid",required = false) Integer uid,
                             @RequestParam(value ="uname",required = false) String uname,
                             @RequestParam(value ="pwd",required = false)String pwd,
                             @RequestParam(value ="balance",required = false)String balance,
                             Model model,
                             HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (uname.equals("")||pwd.equals("")||balance.equals("")){
            out.flush();
            out.println("<script>");
            out.println("alert('不能为空，请重新输入！');");
            out.println("</script>");
            //return "user/usermodify";
            response.getWriter().write("<script>; " +
                    "window.location='usermodify.html'; window.close();</script>");
        }else if(userService.getUserList(uname).size()==1) {
            out.print("<script>alert('用户名已存在!');</script>");
            out.flush();
        } else{
            userService.updateUser(uid,uname,pwd,balance);
            out.flush();
            out.println("<script>");
            out.println("alert('修改成功！');");
            out.println("</script>");
            //return "redirect:/sys/user/userlist.html";
            response.getWriter().write("<script>; " +
                    "window.location='userlist.html'; window.close();</script>");
            //return "user/userlist";
        }
    }

    /**
    * @Author: SkyCloud
    * @Date: 2020/6/10
    * @Param: [uid, model]
    * @return: java.lang.String
    * @description:用户信息查看
    */
    @RequestMapping(value = {"/userview.html"})
    public String userview(@RequestParam(value ="uid",required = false) Integer uid,
                             Model model) {

        User userList = userService.getUserByUid(uid);
        //放入model容器中，然后再返回页面中获取到
        model.addAttribute("user",userList);
        return "user/userview";
    }

    /**
    * @Author: SkyCloud
    * @Date: 2020/6/10
    * @Param: [uid, model, response]
    * @return: java.lang.String
    * @description:删除用户信息
    */
    @RequestMapping(value = {"/userdelete.html"})
    public void deleteUser(@RequestParam(value ="uid",required = false) Integer uid,
                             Model model,
                             HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        userService.deleteUser(uid);
        out.flush();
        out.println("<script>");
        out.println("alert('删除成功！');");
        out.println("</script>");

        response.getWriter().flush();

        List<User> userList = userService.getUserListNone();
        //放入model容器中，然后再返回页面中获取到
        model.addAttribute("user",userList);
        response.getWriter().write("<script>; " +
                "window.location='userlist.html'; window.close();</script>");
        //return "redirect:/sys/user/userlist.html";
    }

}