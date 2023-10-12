package com.mj.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.IndentHeaderEntity;
import com.mj.entity.RoleEntity;
import com.mj.entity.UserEntity;
import com.mj.repository.IndentHeaderRepo;
import com.mj.service.IndentHeaderService;
import com.mj.vo.IndentHeaderVO;
import com.mj.vo.IndentVO;
import com.mj.vo.RoleVO;
import com.mj.vo.UserVO;

@Service
public class IndentHeaderServiceImpl implements IndentHeaderService {

	@Autowired
	IndentHeaderRepo indentHeaderRepo;

	@Override
	public List<IndentHeaderVO> getAllIndentHeader() {
		
		List<IndentHeaderEntity> indentHeaderEntityList=indentHeaderRepo.findAll();
		
		List<IndentHeaderVO> indentHeaderVOList=new ArrayList<>();;
		
		for(IndentHeaderEntity indentHeaderEntity:indentHeaderEntityList) {
			
			RoleVO roleVO=new RoleVO(
					indentHeaderEntity.getUser().getRole().getRoleId(),
					indentHeaderEntity.getUser().getRole().getRoleName(),
					indentHeaderEntity.getUser().getRole().getIsActive(),
					indentHeaderEntity.getUser().getRole().getCreatedBy(),
					indentHeaderEntity.getUser().getRole().getCreatedAt(),
					indentHeaderEntity.getUser().getRole().getModifiedBy(),
					indentHeaderEntity.getUser().getRole().getModifiedAt());
			
			UserVO userVO=new UserVO(
					indentHeaderEntity.getUser().getUserId(),
					indentHeaderEntity.getUser().getUserName(),
					indentHeaderEntity.getUser().getPassword(),
					indentHeaderEntity.getUser().getIsActive(),
					indentHeaderEntity.getUser().getCreatedBy(),
					indentHeaderEntity.getUser().getCreatedAt(),
					indentHeaderEntity.getUser().getModifiedBy(),
					indentHeaderEntity.getUser().getModifiedAt(),
					roleVO
					);
			
			IndentHeaderVO indentHeaderVO=new IndentHeaderVO(
					indentHeaderEntity.getIndentHeaderId(),
					indentHeaderEntity.getDescription(),
					indentHeaderEntity.getNetprice(),
					indentHeaderEntity.getIsActive(),
					indentHeaderEntity.getCreatedBy(),
					indentHeaderEntity.getCreatedAt(),
					indentHeaderEntity.getModifiedBy(),
					indentHeaderEntity.getModifiedAt(),
					userVO);
			
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
		
		RoleVO roleVO=new RoleVO(
				indentHeaderEntity.get().getUser().getRole().getRoleId(),
				indentHeaderEntity.get().getUser().getRole().getRoleName(),
				indentHeaderEntity.get().getUser().getRole().getIsActive(),
				indentHeaderEntity.get().getUser().getRole().getCreatedBy(),
				indentHeaderEntity.get().getUser().getRole().getCreatedAt(),
				indentHeaderEntity.get().getUser().getRole().getModifiedBy(),
				indentHeaderEntity.get().getUser().getRole().getModifiedAt());
		
		UserVO userVO=new UserVO(
				indentHeaderEntity.get().getUser().getUserId(),
				indentHeaderEntity.get().getUser().getUserName(),
				indentHeaderEntity.get().getUser().getPassword(),
				indentHeaderEntity.get().getUser().getIsActive(),
				indentHeaderEntity.get().getUser().getCreatedBy(),
				indentHeaderEntity.get().getUser().getCreatedAt(),
				indentHeaderEntity.get().getUser().getModifiedBy(),
				indentHeaderEntity.get().getUser().getModifiedAt(),
				roleVO
				);
		
		IndentHeaderVO indentHeaderVO=new IndentHeaderVO(
				indentHeaderEntity.get().getIndentHeaderId(),
				indentHeaderEntity.get().getDescription(),
				indentHeaderEntity.get().getNetprice(),
				indentHeaderEntity.get().getIsActive(),
				indentHeaderEntity.get().getCreatedBy(),
				indentHeaderEntity.get().getCreatedAt(),
				indentHeaderEntity.get().getModifiedBy(),
				indentHeaderEntity.get().getModifiedAt(),
				userVO);

		
		return indentHeaderVO;
	}
	
	@Override
	public IndentHeaderVO getIndentHeaderByDescription(String description) {
		
		Optional<IndentHeaderEntity> indentHeaderEntity=indentHeaderRepo.findByDescription(description);
		
		if(indentHeaderEntity.isEmpty()) {
			return null;
		}
		
		RoleVO roleVO=new RoleVO(
				indentHeaderEntity.get().getUser().getRole().getRoleId(),
				indentHeaderEntity.get().getUser().getRole().getRoleName(),
				indentHeaderEntity.get().getUser().getRole().getIsActive(),
				indentHeaderEntity.get().getUser().getRole().getCreatedBy(),
				indentHeaderEntity.get().getUser().getRole().getCreatedAt(),
				indentHeaderEntity.get().getUser().getRole().getModifiedBy(),
				indentHeaderEntity.get().getUser().getRole().getModifiedAt());
		
		UserVO userVO=new UserVO(
				indentHeaderEntity.get().getUser().getUserId(),
				indentHeaderEntity.get().getUser().getUserName(),
				indentHeaderEntity.get().getUser().getPassword(),
				indentHeaderEntity.get().getUser().getIsActive(),
				indentHeaderEntity.get().getUser().getCreatedBy(),
				indentHeaderEntity.get().getUser().getCreatedAt(),
				indentHeaderEntity.get().getUser().getModifiedBy(),
				indentHeaderEntity.get().getUser().getModifiedAt(),
				roleVO
				);
		
		IndentHeaderVO indentHeaderVO=new IndentHeaderVO(
				indentHeaderEntity.get().getIndentHeaderId(),
				indentHeaderEntity.get().getDescription(),
				indentHeaderEntity.get().getNetprice(),
				indentHeaderEntity.get().getIsActive(),
				indentHeaderEntity.get().getCreatedBy(),
				indentHeaderEntity.get().getCreatedAt(),
				indentHeaderEntity.get().getModifiedBy(),
				indentHeaderEntity.get().getModifiedAt(),
				userVO);

		
		return indentHeaderVO;
		
	}
	
	@Override
	public void saveIndentHeader(IndentHeaderVO indentHeaderVO) {
		
		RoleEntity roleEntity=new RoleEntity(
				indentHeaderVO.getUser().getRole().getRoleId(),
				indentHeaderVO.getUser().getRole().getRoleName(),
				indentHeaderVO.getUser().getRole().getIsActive(),
				indentHeaderVO.getUser().getRole().getCreatedBy(),
				indentHeaderVO.getUser().getRole().getCreatedAt(),
				indentHeaderVO.getUser().getRole().getModifiedBy(),
				indentHeaderVO.getUser().getRole().getModifiedAt());
		
		UserEntity userEntity=new UserEntity(
				indentHeaderVO.getUser().getUserId(),
				indentHeaderVO.getUser().getUserName(),
				indentHeaderVO.getUser().getPassword(),
				indentHeaderVO.getUser().getIsActive(),
				indentHeaderVO.getUser().getCreatedBy(),
				indentHeaderVO.getUser().getCreatedAt(),
				indentHeaderVO.getUser().getModifiedBy(),
				indentHeaderVO.getUser().getModifiedAt(),
				roleEntity
				);
		
		IndentHeaderEntity indentHeaderEntity=new IndentHeaderEntity(
				indentHeaderVO.getIndentHeaderId(),
				indentHeaderVO.getDescription(),
				indentHeaderVO.getNetprice(),
				indentHeaderVO.getIsActive(),
				indentHeaderVO.getCreatedBy(),
				indentHeaderVO.getCreatedAt(),
				indentHeaderVO.getModifiedBy(),
				indentHeaderVO.getModifiedAt(),
				userEntity);
		
		indentHeaderRepo.save(indentHeaderEntity);
		
	}

	@Override
	public Boolean updateIndentHeader(IndentHeaderVO indentHeaderVO) {
		
		if(getIndentHeaderById(indentHeaderVO.getIndentHeaderId())==null) {
			return false;
		}
		
		RoleEntity roleEntity=new RoleEntity(
				indentHeaderVO.getUser().getRole().getRoleId(),
				indentHeaderVO.getUser().getRole().getRoleName(),
				indentHeaderVO.getUser().getRole().getIsActive(),
				indentHeaderVO.getUser().getRole().getCreatedBy(),
				indentHeaderVO.getUser().getRole().getCreatedAt(),
				indentHeaderVO.getUser().getRole().getModifiedBy(),
				indentHeaderVO.getUser().getRole().getModifiedAt());
		
		UserEntity userEntity=new UserEntity(
				indentHeaderVO.getUser().getUserId(),
				indentHeaderVO.getUser().getUserName(),
				indentHeaderVO.getUser().getPassword(),
				indentHeaderVO.getUser().getIsActive(),
				indentHeaderVO.getUser().getCreatedBy(),
				indentHeaderVO.getUser().getCreatedAt(),
				indentHeaderVO.getUser().getModifiedBy(),
				indentHeaderVO.getUser().getModifiedAt(),
				roleEntity
				);
		
		IndentHeaderEntity indentHeaderEntity=new IndentHeaderEntity(
				indentHeaderVO.getIndentHeaderId(),
				indentHeaderVO.getDescription(),
				indentHeaderVO.getNetprice(),
				indentHeaderVO.getIsActive(),
				indentHeaderVO.getCreatedBy(),
				indentHeaderVO.getCreatedAt(),
				indentHeaderVO.getModifiedBy(),
				indentHeaderVO.getModifiedAt(),
				userEntity);
		
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

	@Override
	public Integer editIndentHeaderPrice(Long price, Integer id) {
		
		IndentHeaderVO indentHeaderVo=getIndentHeaderById(id);
		
		indentHeaderRepo.updateNetPrice(Math.round(indentHeaderVo.getNetprice())+price, id);
		
		return null;
	}

	
}
