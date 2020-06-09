package cn.smbms.dao.bill;

import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Provider;
import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import javax.management.relation.Role;
import java.util.List;

public interface BillMapper {

    //根据商品名称获得订单
    public Bill getBillByBillCode(@Param("productName") String productName);

    //根据商品名称和供应商获得订单
    public List<Bill> getBillList(@Param("productName") String productName, @Param("providerId") Integer providerId);

    //根据商品名称，供应商，是否付款获得订单
    public List<Bill> getBillList2(@Param("productName") String productName,
                                   @Param("providerId") Integer providerId,
                                   @Param("isPayment") Integer isPayment,
                                   @Param("uid")Integer uid);

    //获得供应商列表
    public List<Provider> getproviderNameList();
}
