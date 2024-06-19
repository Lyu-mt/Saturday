package com.lyu.saturday.controller;

import com.lyu.saturday.common.Result;
import com.lyu.saturday.common.ResultMessage;
import com.lyu.saturday.common.exception.SaturdayServiceException;
import com.lyu.saturday.entity.Check;
import com.lyu.saturday.service.CheckService;
import com.lyu.saturday.vo.CheckVO;
import com.lyu.saturday.vo.MonthVO;
import com.lyu.saturday.vo.TotalChecksVO;
import jakarta.annotation.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/check")
public class CheckController {

	@Resource
	private CheckService checkService;

	@GetMapping("/")
	public Result<TotalChecksVO> getChecks() {
		return Result.ok(checkService.getChecks());
	}

	@PostMapping("/")
	public Result<Void> createCheck(@RequestBody CheckVO checkVo) {
		try {
			checkService.createCheck(checkVo);
		} catch (SaturdayServiceException | ParseException e) {
			return Result.fail(ResultMessage.Err.setInfo(e.getMessage()));
		}
		return Result.Ok();
	}

	@PostMapping("/{id}")
	public Result<Void> editCheck(@RequestBody CheckVO checkVo, @PathVariable(value = "id") long id) {
		try {
			checkService.editCheck(checkVo, id);
		} catch (SaturdayServiceException | ParseException e) {
			return Result.fail(ResultMessage.Err.setInfo(e.getMessage()));
		}
		return Result.Ok();
	}

	@DeleteMapping("/{id}")
	public Result<Void> deleteCheck(@PathVariable(value = "id") long id) {
		try {
			checkService.deleteCheck(id);
		} catch (SaturdayServiceException e) {
			return Result.fail(ResultMessage.Err.setInfo(e.getMessage()));
		}
		return Result.Ok();
	}

	// 获取本月支出/收入
	@GetMapping("/month")
	public Result<MonthVO> getMonthExpense(@Param("status") String status) {
		MonthVO monthVO;
		try {
			monthVO = checkService.getMonthExpense(status);
		} catch (SaturdayServiceException e) {
			return Result.fail(ResultMessage.Err.setInfo(e.getMessage()));
		}
		return Result.ok(monthVO);
	}


}
