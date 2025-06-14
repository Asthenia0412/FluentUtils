package com.xiaoyongcai.io.TestJob.Pojo;

import com.xiaoyongcai.io.TestJob.Pojo.Product;
import com.xiaoyongcai.io.TestJob.Pojo.User;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private User user;
    private List<Product> products;
    private Double totalAmount;
    private String status;
    private Date createTime;
    private Date updateTime;

    // getters 和 setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }

    public Date getUpdateTime() { return updateTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
}