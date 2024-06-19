package com.lyu.saturday.vo;

import com.lyu.saturday.entity.Check;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TotalChecksVO {

	private List<Check> totalChecks;

	private Integer totalChecksCount;
}
