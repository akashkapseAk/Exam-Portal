package com.exam.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.daorep.CategoryRepositoryDao;
import com.exam.model.category.Category;
import com.exam.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepositoryDao categoryRepositoryDao;

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepositoryDao.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepositoryDao.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.categoryRepositoryDao.findAll());
	}

	@Override
	public Category getCategory(int CategoryId) {
		// TODO Auto-generated method stub
		return this.categoryRepositoryDao.findById(CategoryId).get();
	}

	@Override
	public void deleteCategory(int CategoryId) {
		// TODO Auto-generated method stub
		Category category = new Category();
		
		this.categoryRepositoryDao.delete(category);
	}

}
