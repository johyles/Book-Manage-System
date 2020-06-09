package cn.smbms.controller.user;

import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Provider;
import cn.smbms.pojo.User;
import cn.smbms.service.bill.BillService;
import cn.smbms.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/sys/bill")
public class BillController {

   @Autowired
   private BillService billService;

    @RequestMapping(value = {"/bill.do"})
    public String getBillList(@RequestParam(value ="queryProductName",required = false) String queryProductName,
                              @RequestParam(value = "queryProviderId",required = false) Integer queryProviderId,
                              @RequestParam(value = "queryIsPayment",required = false) Integer queryIsPayment,
                              Model model,
                              HttpSession session) throws NoSuchFieldException {
        User userSession = (User) session.getAttribute("userSession");
        int id = userSession.getId();
        List<Bill> billList = billService.getBillList2(queryProductName,queryProviderId,queryIsPayment,id);
        //放入model容器中，然后再返回页面中获取到
        model.addAttribute("billList",billList);

        //获得供应商列表
        List<Provider> providerList=this.billService.getproviderNameList();
        model.addAttribute("providerList",providerList);

        //用户名和用户角色添加到model
        model.addAttribute("queryProductName",queryProductName);
        model.addAttribute("queryProviderId",queryProviderId);
        model.addAttribute("queryIsPayment",queryIsPayment);
        return "bill/billlist";
    }

}
