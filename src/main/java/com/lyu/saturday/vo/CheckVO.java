package com.lyu.saturday.vo;

import lombok.Data;

@Data
public class CheckVO {

	private String userId;

	private String status;

	private Double checkNumber;

	private String createTime;

	private String categoryId;

	private String remark;

}
