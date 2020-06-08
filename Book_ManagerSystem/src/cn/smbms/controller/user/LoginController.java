package cn.smbms.controller.user;

import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;
import com.mysql.jdbc.log.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    //log4j
    private  static  final Logger logger= Logger.getLogger(LoginController.class);

    //service层
    @Autowired
    private UserService userService;

    //显示登陆页面,此页面也是首页
    @RequestMapping(value = "/index.html")
    public String index(){
        logger.debug(" enter LoginController=====>showLoginPage method");
        return "login";
    }

    //提交登陆表单，实现登陆功能
    @RequestMapping(value = "/dologin.html")
    public String doLogin(@RequestParam(value = "userCode") String userCode,
                          @RequestParam(value = "userPassword") String password,
                          HttpSession session,
                          HttpServletRequest request){
        logger.debug("enter LoginController =====>doLogin method");
        //和数据库中的用户信息进行校验
        User loginUser = this.userService.login(userCode, password);
        if(loginUser !=null){//说明用户存在
            //使用session容器，把该用户放进去
            session.setAttribute(Constants.USER_SESSION,loginUser);
            //页面的跳转
            return "redirect:/sys/frame.html";
        }else {//用户不存在
            //使用request容器，返回一个提示信息
            request.setAttribute("error","用户名或者密码错误");
            //页面的跳转
            return "login";
        }

    }

    @RequestMapping("/sys/frame.html")
    public String frame(){
        return "frame";
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
