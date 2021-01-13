package com.test.dto;

import lombok.*;


import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto implements Serializable {
    private Integer goodsId;
    private Integer userId;
    private Double price;
    private Long createTime;

}
