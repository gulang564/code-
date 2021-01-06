package com.test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "t_goods_type")
public class GoodsType implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="goods_type_pg")
    @SequenceGenerator(sequenceName="goods_type_sequence", name="goods_type_pg",allocationSize = 1)
    private Integer typeId;
    @Column(name = "type_name")
    private String typeName;
}
