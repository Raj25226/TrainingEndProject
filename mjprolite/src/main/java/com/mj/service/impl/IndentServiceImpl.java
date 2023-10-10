package com.mj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.IndentEntity;
import com.mj.entity.IndentHeaderEntity;
import com.mj.entity.ProductEntity;
import com.mj.entity.RoleEntity;
import com.mj.entity.UserEntity;
import com.mj.repository.IndentRepo;
import com.mj.service.IndentService;
import com.mj.vo.IndentHeaderVO;
import com.mj.vo.IndentVO;
import com.mj.vo.ProductVO;
import com.mj.vo.RoleVO;
import com.mj.vo.UserVO;

@Service
public class IndentServiceImpl implements IndentService {

	@Autowired
	IndentRepo indentRepo;
	
	@Override
	public List<IndentVO> getAllIndent() {
		
		List<IndentEntity> indentEntityList=indentRepo.findAll();
		
		List<IndentVO> indentVOList=new ArrayList<>();
		
		for(IndentEntity indentEntity:indentEntityList) {
			
			RoleVO roleVO=new RoleVO(
					indentEntity.getIndentHeaderEntity().getUser().getRole().getRoleId(),
					indentEntity.getIndentHeaderEntity().getUser().getRole().getRoleName(),
					indentEntity.getIndentHeaderEntity().getUser().getRole().getIsActive(),
					indentEntity.getIndentHeaderEntity().getUser().getRole().getCreatedBy(),
					indentEntity.getIndentHeaderEntity().getUser().getRole().getCreatedAt(),
					indentEntity.getIndentHeaderEntity().getUser().getRole().getModifiedBy(),
					indentEntity.getIndentHeaderEntity().getUser().getRole().getModifiedAt());
			
			UserVO userVO=new UserVO(
					indentEntity.getIndentHeaderEntity().getUser().getUserId(),
					indentEntity.getIndentHeaderEntity().getUser().getUserName(),
					indentEntity.getIndentHeaderEntity().getUser().getPassword(),
					indentEntity.getIndentHeaderEntity().getUser().getIsActive(),
					indentEntity.getIndentHeaderEntity().getUser().getCreatedBy(),
					indentEntity.getIndentHeaderEntity().getUser().getCreatedAt(),
					indentEntity.getIndentHeaderEntity().getUser().getModifiedBy(),
					indentEntity.getIndentHeaderEntity().getUser().getModifiedAt(),
					roleVO
					);
			
			IndentHeaderVO indentHeaderVO=new IndentHeaderVO(
					indentEntity.getIndentHeaderEntity().getIndentHeaderId(),
					indentEntity.getIndentHeaderEntity().getDescription(),
					indentEntity.getIndentHeaderEntity().getNetprice(),
					indentEntity.getIndentHeaderEntity().getIsActive(),
					indentEntity.getIndentHeaderEntity().getCreatedBy(),
					indentEntity.getIndentHeaderEntity().getCreatedAt(),
					indentEntity.getIndentHeaderEntity().getModifiedBy(),
					indentEntity.getIndentHeaderEntity().getModifiedAt(),
					userVO);
			
			ProductVO productVO=new ProductVO(
					indentEntity.getProduct().getProductId(),
					indentEntity.getProduct().getProductName(),
					indentEntity.getProduct().getProductCode(),
					indentEntity.getProduct().getDescription(),
					indentEntity.getProduct().getSpecification(),
					indentEntity.getProduct().getIsActive(),
					indentEntity.getProduct().getCreatedBy(),
					indentEntity.getProduct().getCreatedAt(),
					indentEntity.getProduct().getModifiedBy(),
					indentEntity.getProduct().getModifiedAt());
			
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
					productVO,
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
		
		RoleVO roleVO=new RoleVO(
				indentEntity.get().getIndentHeaderEntity().getUser().getRole().getRoleId(),
				indentEntity.get().getIndentHeaderEntity().getUser().getRole().getRoleName(),
				indentEntity.get().getIndentHeaderEntity().getUser().getRole().getIsActive(),
				indentEntity.get().getIndentHeaderEntity().getUser().getRole().getCreatedBy(),
				indentEntity.get().getIndentHeaderEntity().getUser().getRole().getCreatedAt(),
				indentEntity.get().getIndentHeaderEntity().getUser().getRole().getModifiedBy(),
				indentEntity.get().getIndentHeaderEntity().getUser().getRole().getModifiedAt());
		
		UserVO userVO=new UserVO(
				indentEntity.get().getIndentHeaderEntity().getUser().getUserId(),
				indentEntity.get().getIndentHeaderEntity().getUser().getUserName(),
				indentEntity.get().getIndentHeaderEntity().getUser().getPassword(),
				indentEntity.get().getIndentHeaderEntity().getUser().getIsActive(),
				indentEntity.get().getIndentHeaderEntity().getUser().getCreatedBy(),
				indentEntity.get().getIndentHeaderEntity().getUser().getCreatedAt(),
				indentEntity.get().getIndentHeaderEntity().getUser().getModifiedBy(),
				indentEntity.get().getIndentHeaderEntity().getUser().getModifiedAt(),
				roleVO
				);
		
		IndentHeaderVO indentHeaderVO=new IndentHeaderVO(
				indentEntity.get().getIndentHeaderEntity().getIndentHeaderId(),
				indentEntity.get().getIndentHeaderEntity().getDescription(),
				indentEntity.get().getIndentHeaderEntity().getNetprice(),
				indentEntity.get().getIndentHeaderEntity().getIsActive(),
				indentEntity.get().getIndentHeaderEntity().getCreatedBy(),
				indentEntity.get().getIndentHeaderEntity().getCreatedAt(),
				indentEntity.get().getIndentHeaderEntity().getModifiedBy(),
				indentEntity.get().getIndentHeaderEntity().getModifiedAt(),
				userVO);
		
		ProductVO productVO=new ProductVO(
				indentEntity.get().getProduct().getProductId(),
				indentEntity.get().getProduct().getProductName(),
				indentEntity.get().getProduct().getProductCode(),
				indentEntity.get().getProduct().getDescription(),
				indentEntity.get().getProduct().getSpecification(),
				indentEntity.get().getProduct().getIsActive(),
				indentEntity.get().getProduct().getCreatedBy(),
				indentEntity.get().getProduct().getCreatedAt(),
				indentEntity.get().getProduct().getModifiedBy(),
				indentEntity.get().getProduct().getModifiedAt());
		
		
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
				productVO,
				indentHeaderVO);
		
		return indentVO;
	}

	@Override
	public void saveIndent(IndentVO indentVO) {
	
		RoleEntity roleEntity=new RoleEntity(
				indentVO.getIndentHeaderVO().getUser().getRole().getRoleId(),
				indentVO.getIndentHeaderVO().getUser().getRole().getRoleName(),
				indentVO.getIndentHeaderVO().getUser().getRole().getIsActive(),
				indentVO.getIndentHeaderVO().getUser().getRole().getCreatedBy(),
				indentVO.getIndentHeaderVO().getUser().getRole().getCreatedAt(),
				indentVO.getIndentHeaderVO().getUser().getRole().getModifiedBy(),
				indentVO.getIndentHeaderVO().getUser().getRole().getModifiedAt());
		
		UserEntity userEntity=new UserEntity(
				indentVO.getIndentHeaderVO().getUser().getUserId(),
				indentVO.getIndentHeaderVO().getUser().getUserName(),
				indentVO.getIndentHeaderVO().getUser().getPassword(),
				indentVO.getIndentHeaderVO().getUser().getIsActive(),
				indentVO.getIndentHeaderVO().getUser().getCreatedBy(),
				indentVO.getIndentHeaderVO().getUser().getCreatedAt(),
				indentVO.getIndentHeaderVO().getUser().getModifiedBy(),
				indentVO.getIndentHeaderVO().getUser().getModifiedAt(),
				roleEntity
				);
		
		IndentHeaderEntity indentHeaderEntity=new IndentHeaderEntity(
				indentVO.getIndentHeaderVO().getIndentHeaderId(),
				indentVO.getIndentHeaderVO().getDescription(),
				indentVO.getIndentHeaderVO().getNetprice(),
				indentVO.getIndentHeaderVO().getIsActive(),
				indentVO.getIndentHeaderVO().getCreatedBy(),
				indentVO.getIndentHeaderVO().getCreatedAt(),
				indentVO.getIndentHeaderVO().getModifiedBy(),
				indentVO.getIndentHeaderVO().getModifiedAt(),
				userEntity);
		
		ProductEntity productEntity=new ProductEntity(
				indentVO.getProduct().getProductId(),
				indentVO.getProduct().getProductName(),
				indentVO.getProduct().getProductCode(),
				indentVO.getProduct().getDescription(),
				indentVO.getProduct().getSpecification(),
				indentVO.getProduct().getIsActive(),
				indentVO.getProduct().getCreatedBy(),
				indentVO.getProduct().getCreatedAt(),
				indentVO.getProduct().getModifiedBy(),
				indentVO.getProduct().getModifiedAt());
		
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
				productEntity,
				indentHeaderEntity);
		
		indentRepo.save(indentEntity);
	}

	@Override
	public Boolean updateIndent(IndentVO indentVO) {
		
		if(getIndentById(indentVO.getIndentId())==null) {
			return false;
		}
		
		RoleEntity roleEntity=new RoleEntity(
				indentVO.getIndentHeaderVO().getUser().getRole().getRoleId(),
				indentVO.getIndentHeaderVO().getUser().getRole().getRoleName(),
				indentVO.getIndentHeaderVO().getUser().getRole().getIsActive(),
				indentVO.getIndentHeaderVO().getUser().getRole().getCreatedBy(),
				indentVO.getIndentHeaderVO().getUser().getRole().getCreatedAt(),
				indentVO.getIndentHeaderVO().getUser().getRole().getModifiedBy(),
				indentVO.getIndentHeaderVO().getUser().getRole().getModifiedAt());
		
		UserEntity userEntity=new UserEntity(
				indentVO.getIndentHeaderVO().getUser().getUserId(),
				indentVO.getIndentHeaderVO().getUser().getUserName(),
				indentVO.getIndentHeaderVO().getUser().getPassword(),
				indentVO.getIndentHeaderVO().getUser().getIsActive(),
				indentVO.getIndentHeaderVO().getUser().getCreatedBy(),
				indentVO.getIndentHeaderVO().getUser().getCreatedAt(),
				indentVO.getIndentHeaderVO().getUser().getModifiedBy(),
				indentVO.getIndentHeaderVO().getUser().getModifiedAt(),
				roleEntity
				);
		
		IndentHeaderEntity indentHeaderEntity=new IndentHeaderEntity(
				indentVO.getIndentHeaderVO().getIndentHeaderId(),
				indentVO.getIndentHeaderVO().getDescription(),
				indentVO.getIndentHeaderVO().getNetprice(),
				indentVO.getIndentHeaderVO().getIsActive(),
				indentVO.getIndentHeaderVO().getCreatedBy(),
				indentVO.getIndentHeaderVO().getCreatedAt(),
				indentVO.getIndentHeaderVO().getModifiedBy(),
				indentVO.getIndentHeaderVO().getModifiedAt(),
				userEntity);
		
		ProductEntity productEntity=new ProductEntity(
				indentVO.getProduct().getProductId(),
				indentVO.getProduct().getProductName(),
				indentVO.getProduct().getProductCode(),
				indentVO.getProduct().getDescription(),
				indentVO.getProduct().getSpecification(),
				indentVO.getProduct().getIsActive(),
				indentVO.getProduct().getCreatedBy(),
				indentVO.getProduct().getCreatedAt(),
				indentVO.getProduct().getModifiedBy(),
				indentVO.getProduct().getModifiedAt());
		
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
				productEntity,
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
