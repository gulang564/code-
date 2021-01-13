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
@Table(name = "t_user")
public class User extends BaseEntity {

    @Column(name = "u_name")
    private String uName;

    @Column(name = "password")
    private String password;
}
