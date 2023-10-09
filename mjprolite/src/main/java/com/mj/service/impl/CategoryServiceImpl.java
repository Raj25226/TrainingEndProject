package com.mj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.repository.CategoryRepo;
import com.mj.service.*;
import com.mj.vo.CategoryVO;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepo CategoryService ;

	@Override
	public List<CategoryVO> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryVO getCategoryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCategory(CategoryVO deptVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCategory(CategoryVO deptVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategoryById(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
