package com.mj.service;

import java.util.List;

import com.mj.vo.CategoryVO;

public interface CategoryService {
	List<CategoryVO> getAllCategory();	
	CategoryVO getCategoryById(int id);	
	void saveCategory(CategoryVO deptVo);
	Boolean updateCategory (CategoryVO deptVo);	
	Boolean deleteCategoryById(int id);
}
