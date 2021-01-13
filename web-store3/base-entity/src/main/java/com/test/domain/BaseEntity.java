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

@MappedSuperclass  //声明父类的时候 需要添加@MappedSuperclass  ，这样注解在属性上的的注解，就可以在子类中生效
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_pg")
    @SequenceGenerator(sequenceName = "id_sequence", name = "id_pg", allocationSize = 1)
    public int id;
}
