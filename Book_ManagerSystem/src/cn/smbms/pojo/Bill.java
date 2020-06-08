package cn.smbms.pojo;

import java.math.BigInteger;
import java.util.Date;

public class Bill {
    private BigInteger id;  //订单ID
    private String billCode;  //订单编号
    private String productName; //商品名字
    private String productDesc; //产品
    private String productUnit; //产品计量单位
    private double productCount; //产品单价
    private double totalPrice;  //订单金额
    private int isPayment;    //是否付款
    private Integer createdBy; // 订单创建的用户
    private Date creationDate;  //订单创建时间
    private Integer modifyBy;  //修改的用户
    private Date modifyDate;  // 修改时间
    private Integer providerId;  //产品供应商ID
    private String providerName;    //供应商名称

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public BigInteger getId() {
        return id;
    }
    public void setId(BigInteger id) {
        this.id = id;
    }
    public String getBillCode() {
        return billCode;
    }
    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductDesc() {
        return productDesc;
    }
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
    public String getProductUnit() {
        return productUnit;
    }
    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }
    public double getProductCount() {
        return productCount;
    }
    public void setProductCount(double productCount) {
        this.productCount = productCount;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public int getIsPayment() {
        return isPayment;
    }
    public void setIsPayment(int isPayment) {
        this.isPayment = isPayment;
    }
    public Integer getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public Integer getModifyBy() {
        return modifyBy;
    }
    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }
    public Date getModifyDate() {
        return modifyDate;
    }
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    public Integer getProviderId() {
        return providerId;
    }
    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }
}
