package com.lyu.saturday.controller;

import com.lyu.saturday.common.Result;
import com.lyu.saturday.common.ResultMessage;
import com.lyu.saturday.common.exception.SaturdayServiceException;
import com.lyu.saturday.entity.Home;
import com.lyu.saturday.service.HomeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Resource
	private HomeService homeService;

	@GetMapping("/user")
	public Result<List<Home>> getUsers() {
		return Result.ok(homeService.getUsers());
	}

	@PostMapping("/user")
	public Result<Void> createUser(String name) {
		try {
			homeService.createUser(name);
		} catch (SaturdayServiceException e) {
			return Result.fail(ResultMessage.Err.setInfo(e.getMessage()));
		}
		return Result.Ok();
	}

}
