package cn.smbms.controller.user;

import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;
import cn.smbms.tools.PageSupport;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.relation.Role;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/userlist.html","/user.do"})
    public String getUserList(@RequestParam(value ="queryname",required = false) String userName,
                              @RequestParam(value = "queryUserRole",required = false) Integer userRole,
                              Model model,
                              @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer currentPageNo){
        //List<User> userList = userService.getUserList(userName,userRole);
        List<User> userList = userService.getUserList_page(userName,userRole,currentPageNo);

        //放入model容器中，然后再返回页面中获取到
        model.addAttribute("userList",userList);

        //获得角色列表
        List<Role> roleList=this.userService.getRoleList();
        model.addAttribute("roleList",roleList);

        //用户名和用户角色添加到model
        model.addAttribute("queryUserName",userName);
        model.addAttribute("queryUserRole",userRole);

        PageSupport pageSupport = new PageSupport();

        //1-设置页容量
        pageSupport.setPageSize(Constants.pageSize);

        //2-设置用户总记录数
        int totalCount=this.userService.getUserCount(userName,userRole);
        pageSupport.setTotalCount(totalCount);

        //3-设置总页数-上述2个set方法已经计算出来，不需要再人为地设置

        //4-当前页码
        pageSupport.setCurrentPageNo(currentPageNo);

        model.addAttribute("pageSupport",pageSupport);

        return "user/userlist";
    }

    @RequestMapping(value = {"/useradd.html"})
    public String addUser(){
        return  "user/useradd";
    }

    @RequestMapping(value = {"/useraddsave.html"})
    public String saveUser(@RequestParam(value ="userCode",required = false) String userCode,
                          @RequestParam(value ="userName",required = false)String userName,
                          @RequestParam(value ="userPassword",required = false)String userPassword,
                          @RequestParam(value ="gender",required = false)Integer gender,
                          @RequestParam(value ="birthday",required = false)String birthday,
                          @RequestParam(value ="phone",required = false)String phone,
                          @RequestParam(value ="address",required = false)String address,
                          @RequestParam(value ="userRole",required = false)Integer userRole,
                           Model model) throws ParseException {
         String time=birthday;//标准日期必须是dao这样（至于你说的“--”这种不好处理）
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         Date date=format.parse(time);//得到这个时间的Date形式
        userService.addUser(userCode,userName,userPassword,gender,date,phone,address,userRole);

        List<User> userList = userService.getUserList(userName,userRole);
        //放入model容器中，然后再返回页面中获取到
        model.addAttribute("userList",userList);

        //获得角色列表
        List<Role> roleList=this.userService.getRoleList();
        model.addAttribute("roleList",roleList);

        return "user/userlist";
    }

    // 增加  --身份验证



    //


   // 删除--身份验证

}
