package com.mj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.IndentEntity;
import com.mj.entity.IndentHeaderEntity;
import com.mj.repository.IndentRepo;
import com.mj.service.IndentService;
import com.mj.vo.IndentHeaderVO;
import com.mj.vo.IndentVO;

@Service
public class IndentServiceImpl implements IndentService {

	@Autowired
	IndentRepo indentRepo;
	
	@Override
	public List<IndentVO> getAllIndent() {
		
		List<IndentEntity> indentEntityList=indentRepo.findAll();
		
		List<IndentVO> indentVOList=new ArrayList<>();
		
		for(IndentEntity indentEntity:indentEntityList) {
			
			IndentHeaderVO indentHeaderVO=new IndentHeaderVO(
					indentEntity.getIndentHeaderEntity().getIndentHeaderId(),
					indentEntity.getIndentHeaderEntity().getDescription(),
					indentEntity.getIndentHeaderEntity().getNetprice(),
					indentEntity.getIndentHeaderEntity().getIsActive(),
					indentEntity.getIndentHeaderEntity().getCreatedBy(),
					indentEntity.getIndentHeaderEntity().getCreatedAt(),
					indentEntity.getIndentHeaderEntity().getModifiedBy(),
					indentEntity.getIndentHeaderEntity().getModifiedAt());
			
			IndentVO indentVO=new IndentVO(
					indentEntity.getIndentId(),
					indentEntity.getIndentCode(),
					indentEntity.getUnitPrice(),
					indentEntity.getTotalPrice(),
					indentEntity.getQuantity(),
					indentEntity.getIsActive(),
					indentEntity.getCreatedBy(),
					indentEntity.getCreatedAt(),
					indentEntity.getModifiedBy(),
					indentEntity.getModifiedAt(),
					indentHeaderVO);
			
			indentVOList.add(indentVO);
		}
		
		return indentVOList;
	}

	@Override
	public IndentVO getIndentById(Integer id) {
		
		Optional<IndentEntity> indentEntity=indentRepo.findById(id);
		
		if(indentEntity.isEmpty()) {
			return null;
		}
		
		IndentHeaderVO indentHeaderVO=new IndentHeaderVO(
				indentEntity.get().getIndentHeaderEntity().getIndentHeaderId(),
				indentEntity.get().getIndentHeaderEntity().getDescription(),
				indentEntity.get().getIndentHeaderEntity().getNetprice(),
				indentEntity.get().getIndentHeaderEntity().getIsActive(),
				indentEntity.get().getIndentHeaderEntity().getCreatedBy(),
				indentEntity.get().getIndentHeaderEntity().getCreatedAt(),
				indentEntity.get().getIndentHeaderEntity().getModifiedBy(),
				indentEntity.get().getIndentHeaderEntity().getModifiedAt());
		
		IndentVO indentVO=new IndentVO(
				indentEntity.get().getIndentId(),
				indentEntity.get().getIndentCode(),
				indentEntity.get().getUnitPrice(),
				indentEntity.get().getTotalPrice(),
				indentEntity.get().getQuantity(),
				indentEntity.get().getIsActive(),
				indentEntity.get().getCreatedBy(),
				indentEntity.get().getCreatedAt(),
				indentEntity.get().getModifiedBy(),
				indentEntity.get().getModifiedAt(),
				indentHeaderVO);
		
		return indentVO;
	}

	@Override
	public void saveIndentHeader(IndentVO indentVO) {
		
		IndentHeaderEntity indentHeaderEntity=new IndentHeaderEntity(
				indentVO.getIndentHeaderVO().getIndentHeaderId(),
				indentVO.getIndentHeaderVO().getDescription(),
				indentVO.getIndentHeaderVO().getNetprice(),
				indentVO.getIndentHeaderVO().getIsActive(),
				indentVO.getIndentHeaderVO().getCreatedBy(),
				indentVO.getIndentHeaderVO().getCreatedAt(),
				indentVO.getIndentHeaderVO().getModifiedBy(),
				indentVO.getIndentHeaderVO().getModifiedAt());
		
		IndentEntity indentEntity=new IndentEntity(
				indentVO.getIndentId(),
				indentVO.getIndentCode(),
				indentVO.getUnitPrice(),
				indentVO.getTotalPrice(),
				indentVO.getQuantity(),
				indentVO.getIsActive(),
				indentVO.getCreatedBy(),
				indentVO.getCreatedAt(),
				indentVO.getModifiedBy(),
				indentVO.getModifiedAt(),
				indentHeaderEntity);
		
		indentRepo.save(indentEntity);
	}

	@Override
	public Boolean updateIndent(IndentVO indentVO) {
		
		if(getIndentById(indentVO.getIndentId())==null) {
			return false;
		}
		
		IndentHeaderEntity indentHeaderEntity=new IndentHeaderEntity(
				indentVO.getIndentHeaderVO().getIndentHeaderId(),
				indentVO.getIndentHeaderVO().getDescription(),
				indentVO.getIndentHeaderVO().getNetprice(),
				indentVO.getIndentHeaderVO().getIsActive(),
				indentVO.getIndentHeaderVO().getCreatedBy(),
				indentVO.getIndentHeaderVO().getCreatedAt(),
				indentVO.getIndentHeaderVO().getModifiedBy(),
				indentVO.getIndentHeaderVO().getModifiedAt());
		
		IndentEntity indentEntity=new IndentEntity(
				indentVO.getIndentId(),
				indentVO.getIndentCode(),
				indentVO.getUnitPrice(),
				indentVO.getTotalPrice(),
				indentVO.getQuantity(),
				indentVO.getIsActive(),
				indentVO.getCreatedBy(),
				indentVO.getCreatedAt(),
				indentVO.getModifiedBy(),
				indentVO.getModifiedAt(),
				indentHeaderEntity);
		
		indentRepo.save(indentEntity);
		
		return true;
		
	}

	@Override
	public Boolean deleteIndentById(Integer id) {
		
		if(indentRepo.findById(id).isEmpty()) {
			return false;
		}
		
		indentRepo.deleteById(id);
		
		return true;
	}

}
