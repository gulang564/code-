package com.test.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.domain.BaseEntity;
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
public class CarData extends BaseEntity {
    private String title;//商品名称
    private String uName;
    private double price;
    private double rowPrice;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Long createTime;
    private int num;
}
