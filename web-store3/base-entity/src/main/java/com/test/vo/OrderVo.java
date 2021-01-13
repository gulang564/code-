package com.test.vo;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderVo implements Serializable {
    private Integer id;
    private String title;
    private Double price;
    private Long createTime;
    private Integer num;

}
