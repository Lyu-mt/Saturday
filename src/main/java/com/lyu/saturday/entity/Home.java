package com.lyu.saturday.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "home", schema = "db_saturday")
public class Home {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private long id;

	@Column(name = "user_name", nullable = false)
	private String userName;

}