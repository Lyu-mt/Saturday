package com.lyu.saturday.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@DynamicUpdate
@Table(name = "income_expense", schema = "db_saturday")
public class Check {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cashflow_id", nullable = false)
	private long id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "income_expense_status", length = 10)
	private String status;

	@Column(name = "cash_number", precision = 24, scale = 2)
	private BigDecimal cashNumber;

	@Column(name = "category_id")
	private String categoryId;

	@Column(name = "remark")
	private String remark;

	@Column(name = "create_time")
	private LocalDate createTime;

}