package com.lyu.saturday.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

//	@Resource
//	private CategoryService categoryService;
//
//	@GetMapping("/")
//	public Result<List<Category>> getCategories() {
//		return Result.ok(categoryService.getCategories());
//	}
//
//	@PostMapping("/")
//	public Result<Void> createCategory(@RequestBody Category category) {
//		try {
//			categoryService.createCategory(category);
//		} catch (SaturdayServiceException e) {
//			return Result.fail(e.getMessage());
//		}
//		return Result.Ok();
//	}
}
