package com.test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

//@Entity   @Table 同时使用的原因是   使用@Entity  可以使用类名替代表名，即使表名改变，sql 也不需要改变，到时候就可以映射，完成一句完善的sql
@Entity
@Table(name = "t_goods")  //使用该注解，则说明，类名即是表名，属性名就是表的列名
//@Table()  //可定制化度比较高，可以把类名和属性名，和指定的数据库表的表名和列名自定
public class Goods extends BaseEntity {

    @Column(name = "price")
    private Double price;

    @Column(name = "title")
    private String title;
    @Column(name = "detail")
    private String detail;
    @Column(name = "image")
    private String image;
    @Column(name = "type_id")
    private Integer typeId;

}
