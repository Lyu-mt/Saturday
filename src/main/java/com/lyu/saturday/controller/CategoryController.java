package com.lyu.saturday.controller;

import com.lyu.saturday.common.Result;
import com.lyu.saturday.common.exception.SaturdayServiceException;
import com.lyu.saturday.entity.Category;
import com.lyu.saturday.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Resource
	private CategoryService categoryService;

	@GetMapping("/")
	public Result<List<Category>> getCategories() {
		return Result.ok(categoryService.getCategories());
	}

	@PostMapping("/")
	public Result<Void> createCategory(@RequestBody Category category) {
		try {
			categoryService.createCategory(category);
		} catch (SaturdayServiceException e) {
			return Result.fail(e.getMessage());
		}
		return Result.Ok();
	}
}
