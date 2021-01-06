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
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="u_id_pg")
	@SequenceGenerator(sequenceName="u_id_sequence", name="u_id_pg",allocationSize = 1)
	@Column(name = "u_id")
	private Integer uId;
	private String uName;
	private String password;
}
