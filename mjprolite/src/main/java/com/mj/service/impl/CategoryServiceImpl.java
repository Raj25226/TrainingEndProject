package com.mj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.CategoryEntity;
import com.mj.repository.CategoryRepo;
import com.mj.service.*;
import com.mj.vo.CategoryVO;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepo categoryRepo ;

	@Override
	public List<CategoryVO> getAllCategory() {
		
		List<CategoryEntity> categoryEntitylist=categoryRepo.findAll();
		List<CategoryVO> categoryVOList=new ArrayList<>();
		
		for(CategoryEntity categoryEntity: categoryEntitylist) {
			CategoryVO categoryVo=new CategoryVO(
					categoryEntity.getCategoryId(),
					categoryEntity.getCategoryName(),
					categoryEntity.getCategoryCode(),
					categoryEntity.getIsActive(),
					categoryEntity.getCreatedBy(),
					categoryEntity.getCreatedAt(),
					categoryEntity.getModifiedBy(),
					categoryEntity.getModifiedAt()				
			);
			categoryVOList.add(categoryVo);
		}
		return categoryVOList;
	}

	@Override
	public CategoryVO getCategoryById(int id) {

		Optional<CategoryEntity> categoryEntity=categoryRepo.findById(id);
		if(categoryEntity.isEmpty()) {
			return null;
		}
		CategoryVO categoryVo=new CategoryVO(
				categoryEntity.get().getCategoryId(),
				categoryEntity.get().getCategoryName(),
				categoryEntity.get().getCategoryCode(),
				categoryEntity.get().getIsActive(),
				categoryEntity.get().getCreatedBy(),
				categoryEntity.get().getCreatedAt(),
				categoryEntity.get().getModifiedBy(),
				categoryEntity.get().getModifiedAt()				
		);
		
		return categoryVo;
	}

	@Override
	public void saveCategory(CategoryVO categoryVO) {
		
		CategoryEntity catgoryEntity=new CategoryEntity(
				categoryVO.getCategoryId(),
				categoryVO.getCategoryName(),
				categoryVO.getCategoryCode(),
				categoryVO.getIsActive(),
				categoryVO.getCreatedBy(),
				categoryVO.getCreatedAt(),
				categoryVO.getModifiedBy(),
				categoryVO.getModifiedAt()							
		);
				
			categoryRepo.save(catgoryEntity);		
			
	}

	@Override
	public Boolean updateCategory(CategoryVO categoryVO) {
		
		if(getCategoryById(categoryVO.getCategoryId())==null) {
			return false;
		}
		CategoryEntity catgoryEntity=new CategoryEntity(
				categoryVO.getCategoryId(),
				categoryVO.getCategoryName(),
				categoryVO.getCategoryCode(),
				categoryVO.getIsActive(),
				categoryVO.getCreatedBy(),
				categoryVO.getCreatedAt(),
				categoryVO.getModifiedBy(),
				categoryVO.getModifiedAt()							
		);
				
			categoryRepo.save(catgoryEntity);							
		return true;
	}

	@Override
	public Boolean deleteCategoryById(int id) {

		if(categoryRepo.findById(id)==null) return false;
		
		categoryRepo.deleteById(id);
		return true;
	}
	
}
