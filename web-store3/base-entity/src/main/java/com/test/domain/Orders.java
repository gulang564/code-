package com.test.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_orders")
public class Orders extends BaseEntity {
    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "price")
    private Double price;

    @Column(name = "status")
    private Integer status;


    @JsonFormat(pattern = "yyyy-MM-dd:hh-mm-ss")
    @Column(name = "create_time")
    private Long createTime;
    @Column(name = "num")
    private Integer num;
}
