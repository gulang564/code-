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
@Table(name = "t_goods")
public class Goods implements Serializable {

  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="goods_id_pg")
  @SequenceGenerator(sequenceName="goods_id_sequence", name="goods_id_pg",allocationSize = 1)
  private int id;
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
