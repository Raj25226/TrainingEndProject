package com.mj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.ManufacturerEntity;
import com.mj.repository.ManufacturerRepo;
import com.mj.service.ManufacturerService;
import com.mj.vo.ManufacturerVO;

@Service
public class ManufacturerServiceImpl implements ManufacturerService{

	@Autowired
	ManufacturerRepo manufacturerRepo;
	
	@Override
	public List<ManufacturerVO> getAllManufacturer() {
		
		List<ManufacturerEntity> manufacturerEntityList=manufacturerRepo.findAll();
						
		List<ManufacturerVO> manufacturerVOList=new ArrayList<>();
		
		for(ManufacturerEntity manufacturerEntity:manufacturerEntityList) {
			
			ManufacturerVO manufacturerVO= new ManufacturerVO(
					manufacturerEntity.getManufacturerId(),
					manufacturerEntity.getManufacturerName(),
					manufacturerEntity.getIsActive(),
					manufacturerEntity.getCreatedBy(),
					manufacturerEntity.getCreatedAt(),
					manufacturerEntity.getModifiedBy(),
					manufacturerEntity.getModifiedAt());
			
			manufacturerVOList.add(manufacturerVO);
			
		}
				
		return  manufacturerVOList;
	}

	@Override
	public ManufacturerVO getManufacturerById(Integer id) {
		
		Optional<ManufacturerEntity> manufacturerEntity=manufacturerRepo.findById(id);
		
		if(manufacturerEntity.isEmpty()) {
			return null;
		}
		ManufacturerVO manufacturerVO=new ManufacturerVO(
				manufacturerEntity.get().getManufacturerId(),
				manufacturerEntity.get().getManufacturerName(),
				manufacturerEntity.get().getIsActive(),
				manufacturerEntity.get().getCreatedBy(),
				manufacturerEntity.get().getCreatedAt(),
				manufacturerEntity.get().getModifiedBy(),
				manufacturerEntity.get().getModifiedAt());
		
		return manufacturerVO;
	}

	@Override
	public void saveManufacturer(ManufacturerVO manufacturerVO) {
		
		ManufacturerEntity manufacturerentity=new ManufacturerEntity(
				manufacturerVO.getManufacturerId(),
				manufacturerVO.getManufacturerName(),
				manufacturerVO.getIsActive(),
				manufacturerVO.getCreatedBy(),
				manufacturerVO.getCreatedAt(),
				manufacturerVO.getModifiedBy(),
				manufacturerVO.getModifiedAt());
		
		manufacturerRepo.save(manufacturerentity);
		
	}

	@Override
	public Boolean updateManufacturer(ManufacturerVO manufacturerVO) {
		
		if(getManufacturerById(manufacturerVO.getManufacturerId())==null){
			return false;
		}
			
		ManufacturerEntity manufacturerentity=new ManufacturerEntity(
				manufacturerVO.getManufacturerId(),
				manufacturerVO.getManufacturerName(),
				manufacturerVO.getIsActive(),
				manufacturerVO.getCreatedBy(),
				manufacturerVO.getCreatedAt(),
				manufacturerVO.getModifiedBy(),
				manufacturerVO.getModifiedAt());
		
		manufacturerRepo.save(manufacturerentity);
		
		return true;
	}

	@Override
	public Boolean deleteManufacturerById(Integer id) {
		
		if(manufacturerRepo.findById(id).isEmpty()) {
			return false;
		}
		
		manufacturerRepo.deleteById(id);
		
		return true;
	}
	
}
