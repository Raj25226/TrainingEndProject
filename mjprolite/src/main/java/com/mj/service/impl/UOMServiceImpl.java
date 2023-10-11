package com.mj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.CategoryEntity;
import com.mj.entity.UOMEntity;
import com.mj.repository.UOMRepo;
import com.mj.service.UOMService;
import com.mj.vo.CategoryVO;
import com.mj.vo.UOMVO;

@Service
public class UOMServiceImpl implements UOMService{

	@Autowired
	UOMRepo uomrepo;
	
	@Override
	public List<UOMVO> getAllUOM() {
		
		List<UOMEntity> uomEntityList=uomrepo.findAll();
		List<UOMVO> uomVOList=new ArrayList<>();
		
		for(UOMEntity uomEntity: uomEntityList) {
			
				List<CategoryVO> categoryVOList =new ArrayList<>();
				List<CategoryEntity> categoryEntityList =uomEntity.getCategory();
				for(CategoryEntity categoryEntity: categoryEntityList) {
				CategoryVO categoryVO =new CategoryVO(
						categoryEntity.getCategoryId(),				
						categoryEntity.getCategoryName(),
						categoryEntity.getCategoryCode(),
						categoryEntity.getIsActive(),
						categoryEntity.getCreatedBy(),
						categoryEntity.getCreatedAt(),
						categoryEntity.getModifiedBy(),
						categoryEntity.getModifiedAt()			
						);
				 categoryVOList.add(categoryVO);
				}

			UOMVO uomvo=new UOMVO(
					uomEntity.getUomId(),
					uomEntity.getUnit(),
					uomEntity.getIsActive(),
					uomEntity.getCreatedBy(),
					uomEntity.getCreatedAt(),
					uomEntity.getModifiedBy(),
					uomEntity.getModifiedAt(),
					categoryVOList									
			);
			uomVOList.add(uomvo);
		}
		return uomVOList;
	}

	@Override
	public UOMVO getUOMById(int id) {		
		
		Optional<UOMEntity> uomEntity=uomrepo.findById(id);
		if(uomEntity.isEmpty()) {
			return null;
		}
		List<CategoryVO> categoryVOList =new ArrayList<>();
		List<CategoryEntity> categoryEntityList =uomEntity.get().getCategory();
		for(CategoryEntity categoryEntity: categoryEntityList) {
		CategoryVO categoryVO =new CategoryVO(
				categoryEntity.getCategoryId(),				
				categoryEntity.getCategoryName(),
				categoryEntity.getCategoryCode(),
				categoryEntity.getIsActive(),
				categoryEntity.getCreatedBy(),
				categoryEntity.getCreatedAt(),
				categoryEntity.getModifiedBy(),
				categoryEntity.getModifiedAt()			
				);
		 categoryVOList.add(categoryVO);
		}
								
		UOMVO uomVo=new UOMVO(
			uomEntity.get().getUomId(),
			uomEntity.get().getUnit(),
			uomEntity.get().getIsActive(),
			uomEntity.get().getCreatedBy(),
			uomEntity.get().getCreatedAt(),
			uomEntity.get().getModifiedBy(),
			uomEntity.get().getModifiedAt(),
			categoryVOList
		);		
		return uomVo;
	}
	@Override
	public void saveUOM(UOMVO uomVO) {
		
		List<CategoryEntity> categoryEntityList =new ArrayList<>();
		List<CategoryVO> categoryVOList =uomVO.getCategory();
		for(CategoryVO categoryVO: categoryVOList) {
		CategoryEntity categoryEntity = new CategoryEntity(
		categoryVO.getCategoryId(),
			categoryVO.getCategoryName(),
			categoryVO.getCategoryCode(),
			categoryVO.getIsActive(),
			categoryVO.getCreatedBy(),
			categoryVO.getCreatedAt(),			
			categoryVO.getModifiedBy(),
			categoryVO.getModifiedAt()
		);
		categoryEntityList.add(categoryEntity);
		}
		
		UOMEntity uomEntity=new UOMEntity(
				uomVO.getUomId(),
				uomVO.getUnit(),
				uomVO.getIsActive(),
				uomVO.getCreatedBy(),
				uomVO.getCreatedAt(),
				uomVO.getModifiedBy(),
				uomVO.getModifiedAt(),
				categoryEntityList
			);
			
		uomrepo.save(uomEntity);
	}

	@Override
	public Boolean updateUOM(UOMVO uomVO) {
		if(getUOMById(uomVO.getUomId())==null) {
			return false;
		}
		List<CategoryEntity> categoryEntityList =new ArrayList<>();
		List<CategoryVO> categoryVOList =uomVO.getCategory();
		for(CategoryVO categoryVO: categoryVOList) {
		CategoryEntity categoryEntity = new CategoryEntity(
		categoryVO.getCategoryId(),
			categoryVO.getCategoryName(),
			categoryVO.getCategoryCode(),
			categoryVO.getIsActive(),
			categoryVO.getCreatedBy(),
			categoryVO.getCreatedAt(),			
			categoryVO.getModifiedBy(),
			categoryVO.getModifiedAt()
		);
		categoryEntityList.add(categoryEntity);
		}
		UOMEntity uomEntity=new UOMEntity(
				uomVO.getUomId(),
				uomVO.getUnit(),
				uomVO.getIsActive(),
				uomVO.getCreatedBy(),
				uomVO.getCreatedAt(),
				uomVO.getModifiedBy(),
				uomVO.getModifiedAt()	,
				categoryEntityList
			);
			
		uomrepo.save(uomEntity);
		return true;

		
	}

	@Override
	public Boolean deleteUOMById(int id) {
		if(uomrepo.findById(id)==null) return false;
		
		uomrepo.deleteById(id);
		return true;
	}

	@Override
	public List<UOMVO> uomList(int id) {

		List<UOMEntity> uomEntityList=uomrepo.showAllUOM(id);
		List<UOMVO> uomVOList=new ArrayList<>();
		
		for(UOMEntity uomEntity: uomEntityList) {
			List<CategoryVO> categoryVOList =new ArrayList<>();
			List<CategoryEntity> categoryEntityList =uomEntity.getCategory();
			for(CategoryEntity categoryEntity: categoryEntityList) {
			CategoryVO categoryVO =new CategoryVO(
					categoryEntity.getCategoryId(),				
					categoryEntity.getCategoryName(),
					categoryEntity.getCategoryCode(),
					categoryEntity.getIsActive(),
					categoryEntity.getCreatedBy(),
					categoryEntity.getCreatedAt(),
					categoryEntity.getModifiedBy(),
					categoryEntity.getModifiedAt()			
					);
			 categoryVOList.add(categoryVO);
			}
			UOMVO uomvo=new UOMVO(
					uomEntity.getUomId(),
					uomEntity.getUnit(),
					uomEntity.getIsActive(),
					uomEntity.getCreatedBy(),
					uomEntity.getCreatedAt(),
					uomEntity.getModifiedBy(),
					uomEntity.getModifiedAt(),
					categoryVOList									
			);
			uomVOList.add(uomvo);
		}
			
		return uomVOList;
	}

}
