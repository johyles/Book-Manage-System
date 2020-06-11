package cn.smbms.controller.user;

import cn.smbms.pojo.Admin;
import cn.smbms.pojo.User;
import cn.smbms.service.admin.AdminService;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    //service层
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    Admin loginAdmin = new Admin();
    User loginUser = new User();

    //显示登陆页面,此页面也是首页
    @RequestMapping(value = "/index.html")
    public String index(){
        return "login";
    }

    //提交登陆表单，实现登陆功能
    @RequestMapping(value = "/dologin.html")
    public String doLogin(@RequestParam(value = "usename") String userName,
                          @RequestParam(value = "Password") String passWord,
                          HttpSession session,
                          HttpServletRequest request) {

        //和数据库中的用户信息进行校验
        loginAdmin = this.adminService.login(userName, passWord);
        loginUser = this.userService.login(userName, passWord);
        if (loginUser!=null){
            //是普通学生
            session.setAttribute(Constants.USER_SESSION, loginUser);
            return "redirect:/sys/frame_user.html";
        }else if (loginAdmin!=null){
            //说明管理员存在
            session.setAttribute(Constants.ADMAIN_SESSION, loginAdmin);
            return "redirect:/sys/frame.html";
        }else {
            //用户不存在
            //使用request容器，返回一个提示信息
            request.setAttribute("error", "用户名或者密码错误");
            //页面的跳转
            return "login";
        }
    }

    @RequestMapping("/sys/frame.html")
    public String frame(){
        return "frame";
    }

    @RequestMapping("/sys/frame_user.html")
    public String frame_user(){
        return "frame_user";
    }

    //用户的退出
    @RequestMapping(value = {"/sys/logout.html","/sys/user/logout.html"})
    public String logout(HttpSession session){
        //清空session的内容
        session.invalidate();
        //返回页面
        return "login";
    }



}
