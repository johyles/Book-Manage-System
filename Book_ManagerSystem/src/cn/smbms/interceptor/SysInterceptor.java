package cn.smbms.interceptor;

import cn.smbms.pojo.Admin;
import cn.smbms.pojo.User;
import cn.smbms.tools.Constants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: 四两数字先生（公众号/CSDN）
 */
public class SysInterceptor  extends HandlerInterceptorAdapter {

    //提前处理器方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //对url进行拦截,身份验证
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(Constants.USER_SESSION);
        Admin loginAdmin = (Admin) session.getAttribute(Constants.ADMAIN_SESSION);
        if(loginUser!=null||loginAdmin!=null){//登陆用户存在
            //表示放行
            return true;
        }else {//登陆用户不存在
            /*注意不要忘记 /   */
            request.getRequestDispatcher("/401.jsp").forward(request,response);
            //不放行
            return false;
        }

    }
}
