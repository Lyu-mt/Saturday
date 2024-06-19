package com.lyu.saturday.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category {

	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "income_expense_status", length = 10)
	private String status;
}
