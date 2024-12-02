package com.exam.daorep;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.category.Category;

public interface CategoryRepositoryDao extends JpaRepository<Category, Integer> {

}
