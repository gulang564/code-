package com.test.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/*
       *       <td>订单号</td>
               <td>用户名称</td>
               <td>商品名称</td>
               <td>商品价格</td>
               <td>购买时间</td>
       * */
public class CarData implements Serializable {
    private int order_id;
    private String title;//商品名称
    private String u_name;
    private double price;
    private double rowPrice;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date creatTime;
    private int num;

    public double getRowPrice() {
        return rowPrice;
    }

    public void setRowPrice(double rowPrice) {
        this.rowPrice = rowPrice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
