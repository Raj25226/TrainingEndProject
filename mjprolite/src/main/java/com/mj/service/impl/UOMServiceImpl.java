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
			CategoryVO categoryVO =new CategoryVO(
					uomEntity.getCategory().getCategoryId(),				
					uomEntity.getCategory().getCategoryName(),
					uomEntity.getCategory().getCategoryCode(),
					uomEntity.getCategory().getIsActive(),
					uomEntity.getCategory().getCreatedBy(),
					uomEntity.getCategory().getCreatedAt(),
					uomEntity.getCategory().getModifiedBy(),
					uomEntity.getCategory().getModifiedAt()			
					);
			UOMVO uomvo=new UOMVO(
					uomEntity.getUomId(),
					uomEntity.getUnit(),
					uomEntity.getIsActive(),
					uomEntity.getCreatedBy(),
					uomEntity.getCreatedAt(),
					uomEntity.getModifiedBy(),
					uomEntity.getModifiedAt(),
					categoryVO										
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
		CategoryVO categoryVO =new CategoryVO(
				uomEntity.get().getCategory().getCategoryId(),				
				uomEntity.get().getCategory().getCategoryName(),
				uomEntity.get().getCategory().getCategoryCode(),
				uomEntity.get().getCategory().getIsActive(),
				uomEntity.get().getCategory().getCreatedBy(),
				uomEntity.get().getCategory().getCreatedAt(),
				uomEntity.get().getCategory().getModifiedBy(),
				uomEntity.get().getCategory().getModifiedAt()						
		);
								
		UOMVO uomVo=new UOMVO(
			uomEntity.get().getUomId(),
			uomEntity.get().getUnit(),
			uomEntity.get().getIsActive(),
			uomEntity.get().getCreatedBy(),
			uomEntity.get().getCreatedAt(),
			uomEntity.get().getModifiedBy(),
			uomEntity.get().getModifiedAt()	,
			categoryVO
		);		
		return uomVo;
	}
	@Override
	public void saveUOM(UOMVO uomVO) {
		
		
		CategoryEntity categoryEntity = new CategoryEntity(
			uomVO.getCategory().getCategoryId(),
			uomVO.getCategory().getCategoryName(),
			uomVO.getCategory().getCategoryCode(),
			uomVO.getCategory().getIsActive(),
			uomVO.getCategory().getCreatedBy(),
			uomVO.getCategory().getCreatedAt(),			
			uomVO.getCategory().getModifiedBy(),
			uomVO.getCategory().getModifiedAt()
		);
		UOMEntity uomEntity=new UOMEntity(
				uomVO.getUomId(),
				uomVO.getUnit(),
				uomVO.getIsActive(),
				uomVO.getCreatedBy(),
				uomVO.getCreatedAt(),
				uomVO.getModifiedBy(),
				uomVO.getModifiedAt(),
				categoryEntity
			);
			
		uomrepo.save(uomEntity);
	}

	@Override
	public Boolean updateUOM(UOMVO uomVO) {
		if(getUOMById(uomVO.getUomId())==null) {
			return false;
		}
		CategoryEntity categoryEntity = new CategoryEntity(
				uomVO.getCategory().getCategoryId(),
				uomVO.getCategory().getCategoryName(),
				uomVO.getCategory().getCategoryCode(),
				uomVO.getCategory().getIsActive(),
				uomVO.getCategory().getCreatedBy(),
				uomVO.getCategory().getCreatedAt(),			
				uomVO.getCategory().getModifiedBy(),
				uomVO.getCategory().getModifiedAt()
			);
		UOMEntity uomEntity=new UOMEntity(
				uomVO.getUomId(),
				uomVO.getUnit(),
				uomVO.getIsActive(),
				uomVO.getCreatedBy(),
				uomVO.getCreatedAt(),
				uomVO.getModifiedBy(),
				uomVO.getModifiedAt()	,
				categoryEntity
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

}
