package com.test.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/*
       *       <td>订单号</td>
               <td>用户名称</td>
               <td>商品名称</td>
               <td>商品价格</td>
               <td>购买时间</td>
       * */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarData implements Serializable {
    private int orderId;
    private String title;//商品名称
    private String uName;
    private double price;
    private double rowPrice;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private int num;
}
