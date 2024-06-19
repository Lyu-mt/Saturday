package com.lyu.saturday.service;

import com.lyu.saturday.common.exception.SaturdayServiceException;
import com.lyu.saturday.entity.Category;
import com.lyu.saturday.repository.CategoryRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

	@Resource
	private CategoryRepository categoryRepository;

	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	public void createCategory(Category category) throws SaturdayServiceException {
		categoryRepository.save(category);
	}

}
