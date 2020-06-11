package cn.smbms.controller.user;

import cn.smbms.pojo.User;
import cn.smbms.service.user.User_StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: Book_ManagerSystem
 * @description: 普通用户管理
 * @author: SkyCloud
 * @create: 2020-06-10 14:11
 **/
@Controller
@RequestMapping("/sys/user_student")
public class User_StudentController {
    @Autowired
    private User_StudentService user_studentService;

    /**
    * @Author: SkyCloud
    * @Date: 2020/6/10
    * @Param: [uname, model, currentPageNo]
    * @return: java.lang.String
    * @description:查看用户个人信息
    */
    @RequestMapping(value = {"/user_student.html"})
    public String getUserList(Model model,
                              HttpSession session,
                              HttpServletRequest request){
        User userSession = (User) session.getAttribute("userSession");
        //int uid = userSession.getUid();
        int uid = 1;
        User user = user_studentService.getUser(uid);

        //放入model容器中，然后再返回页面中获取到
        model.addAttribute("user",user);

        return "user_student/userview_student";
        //return "redirect:/sys/user_student/userview_student.html";
    }
    
}
