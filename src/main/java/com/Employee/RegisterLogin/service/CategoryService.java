package com.Employee.RegisterLogin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.RegisterLogin.model.Category;
import com.Employee.RegisterLogin.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	CategoryRepo categoryRepo;

	public void createCategory(Category category) {
		categoryRepo.save(category);
	}

	public List<Category> listCategory() {
		return categoryRepo.findAll();
	}

	// Corrected editCategory method
	public void editCategory(int categoryId, Category updateCategory) {
		Category category = categoryRepo.getById(categoryId);
		category.setCategoryName(updateCategory.getCategoryName());
		category.setDescription(updateCategory.getDescription());
		category.setImageUrl(updateCategory.getImageUrl());
		categoryRepo.save(category);
	}

	public boolean findById(int categoryId) {
		return categoryRepo.findById(categoryId).isPresent();
	}
}
