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

@Controller
public class ForgetController {
    @Autowired
    private UserService userService;
    @RequestMapping("/forget.html")
    public String getInRegister()
    {
        return "forget";
    }
    @RequestMapping("/Forget.html")
    public String  userForget(@RequestParam(value = "userName",required = false) String uname,
                              @RequestParam(value = "userPassword",required = false) String password,
                              HttpServletResponse response) throws IOException, ParseException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        User user = new User();
        user.setUname(uname);
        user.setPwd(password);
        userService.update(user);
        out.print("<script>alert('修改成功!');</script>");
        out.flush();
        return "login";


    }

}
