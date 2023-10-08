package com.mj.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.IndentHeaderEntity;
import com.mj.repository.IndentHeaderRepo;
import com.mj.service.IndentHeaderService;
import com.mj.vo.IndentHeaderVO;

@Service
public class IndentHeaderServiceImpl implements IndentHeaderService {

	@Autowired
	IndentHeaderRepo indentHeaderRepo;

	@Override
	public List<IndentHeaderVO> getAllIndentHeader() {
		
		List<IndentHeaderEntity> indentHeaderEntityList=indentHeaderRepo.findAll();
		
		List<IndentHeaderVO> indentHeaderVOList=new ArrayList<>();;
		
		for(IndentHeaderEntity indentHeaderEntity:indentHeaderEntityList) {
			
			IndentHeaderVO indentHeaderVO=new IndentHeaderVO(
					indentHeaderEntity.getIndentHeaderId(),
					indentHeaderEntity.getDescription(),
					indentHeaderEntity.getNetprice(),
					indentHeaderEntity.getIsActive(),
					indentHeaderEntity.getCreatedBy(),
					indentHeaderEntity.getCreatedAt(),
					indentHeaderEntity.getModifiedBy(),
					indentHeaderEntity.getModifiedAt());
			
			indentHeaderVOList.add(indentHeaderVO);
		}
		
		return indentHeaderVOList;
	}

	@Override
	public IndentHeaderVO getIndentHeaderById(Integer id) {
		
		Optional<IndentHeaderEntity> indentHeaderEntity=indentHeaderRepo.findById(id);
		
		if(indentHeaderEntity.isEmpty()) {
			return null;
		}
		
		IndentHeaderVO indentHeaderVO=new IndentHeaderVO(
				indentHeaderEntity.get().getIndentHeaderId(),
				indentHeaderEntity.get().getDescription(),
				indentHeaderEntity.get().getNetprice(),
				indentHeaderEntity.get().getIsActive(),
				indentHeaderEntity.get().getCreatedBy(),
				indentHeaderEntity.get().getCreatedAt(),
				indentHeaderEntity.get().getModifiedBy(),
				indentHeaderEntity.get().getModifiedAt());

		
		return indentHeaderVO;
	}

	@Override
	public void saveIndentHeader(IndentHeaderVO indentHeaderVO) {
		
		IndentHeaderEntity indentHeaderEntity=new IndentHeaderEntity(
				indentHeaderVO.getIndentHeaderId(),
				indentHeaderVO.getDescription(),
				indentHeaderVO.getNetprice(),
				indentHeaderVO.getIsActive(),
				indentHeaderVO.getCreatedBy(),
				indentHeaderVO.getCreatedAt(),
				indentHeaderVO.getModifiedBy(),
				indentHeaderVO.getModifiedAt());
		
		indentHeaderRepo.save(indentHeaderEntity);
		
	}

	@Override
	public Boolean updateIndentHeader(IndentHeaderVO indentHeaderVO) {
		
		if(getIndentHeaderById(indentHeaderVO.getIndentHeaderId())==null) {
			return false;
		}
		
		IndentHeaderEntity indentHeaderEntity=new IndentHeaderEntity(
				indentHeaderVO.getIndentHeaderId(),
				indentHeaderVO.getDescription(),
				indentHeaderVO.getNetprice(),
				indentHeaderVO.getIsActive(),
				indentHeaderVO.getCreatedBy(),
				indentHeaderVO.getCreatedAt(),
				indentHeaderVO.getModifiedBy(),
				indentHeaderVO.getModifiedAt());
		
		indentHeaderRepo.save(indentHeaderEntity);
		
		return true;
	}

	@Override
	public Boolean deleteIndentHeaderById(Integer id) {
		
		if(indentHeaderRepo.findById(id).isEmpty()) {
			return false;
		}
		
		indentHeaderRepo.deleteById(id);
		
		return true;
	}
	
	
}
