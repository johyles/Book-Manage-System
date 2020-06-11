package cn.smbms.controller.user;

import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

@Controller
public class RegistController {
    @Autowired
    private UserService userService;
    @RequestMapping("/regist.html")
    public String getInRegister()
    {
        return "Regist";
    }
    @RequestMapping("/Register.html")
    public String userRegisterSave(@RequestParam(value = "userName",required = false)String uname,
                                   @RequestParam(value = "userPassword",required = false)String password,
                                   @RequestParam(value = "ruserPassword",required = false)String ruserPassword,
                                   HttpServletResponse response) throws IOException, ParseException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<User> userList = userService.getUserList(uname);
         if(userList.size()>0){
            out.print("<script>alert('用户名不能相同!');</script>");
            out.flush();
            return "Regist";
         }
        if(uname.equals("") ||password.equals("") ||ruserPassword.equals("")){
            out.print("<script>alert('输入内容不能为空!');</script>");
            out.flush();
            return "Regist";
        }else if(!password.equals(ruserPassword)){
            out.print("<script>alert('两次密码必须一致!');</script>");
            out.flush();
            return "Regist";
        }else {
            User user = new User();
            user.setUname(uname);
            user.setPwd(password);
            userService.add(user);
            out.print("<script>alert('注册成功!');</script>");
            out.flush();
            return "login";
        }
    }
}
