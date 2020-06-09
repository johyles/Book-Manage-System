package cn.smbms.service.bill;

import cn.smbms.dao.bill.BillMapper;
import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService{

    @Autowired
    private BillMapper billMapper;

    //根据商品名称获得订单
    public Bill getBillByBillCode(String productName) {
        return this.billMapper.getBillByBillCode(productName);
    }

    //根据商品名称和供应商获得订单
    public List<Bill> getBillList(String productName, Integer providerId) {
        return this.billMapper.getBillList(productName,providerId);
    }

    //根据商品名称，供应商，是否付款获得订单
    public List<Bill> getBillList2(String productName, Integer providerId, Integer isPayment,Integer uid) {
        return this.billMapper.getBillList2(productName,providerId,isPayment,uid);
    }

    //获得供应商列表
    public List<Provider> getproviderNameList() {
        return this.billMapper.getproviderNameList();
    }
}
