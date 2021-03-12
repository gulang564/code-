package com.test.jwtapplication.com.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id ;
    @Column(name ="username")
    String userName;
    @Column(name ="password")
    String passWord;
}
