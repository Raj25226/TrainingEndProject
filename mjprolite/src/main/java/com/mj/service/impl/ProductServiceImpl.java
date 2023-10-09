package com.mj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.ProductEntity;
import com.mj.repository.ProductRepo;
import com.mj.service.ProductService;
import com.mj.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;
	
	@Override
	public List<ProductVO> getAllProduct() {
		
		List<ProductEntity> productEntityList=productRepo.findAll();
		
		List<ProductVO> productVOList=new ArrayList<>();
		
		for(ProductEntity productEntity:productEntityList) {
			
			ProductVO productVO=new ProductVO(
					productEntity.getProductId(),
					productEntity.getProductName(),
					productEntity.getProductCode(),
					productEntity.getDescription(),
					productEntity.getSpecification(),
					productEntity.getIsActive(),
					productEntity.getCreatedBy(),
					productEntity.getCreatedAt(),
					productEntity.getModifiedBy(),
					productEntity.getModifiedAt());	
			
			productVOList.add(productVO);
		}
		
		return productVOList;
	}

	@Override
	public ProductVO getProductById(Integer id) {
		
		Optional<ProductEntity> productEntity=productRepo.findById(id);
		
		if(productEntity.isEmpty()) {
			return null;
		}
				
		ProductVO productVO=new ProductVO(
				productEntity.get().getProductId(),
				productEntity.get().getProductName(),
				productEntity.get().getProductCode(),
				productEntity.get().getDescription(),
				productEntity.get().getSpecification(),
				productEntity.get().getIsActive(),
				productEntity.get().getCreatedBy(),
				productEntity.get().getCreatedAt(),
				productEntity.get().getModifiedBy(),
				productEntity.get().getModifiedAt());
		
		return productVO;
	}

	@Override
	public void saveProduct(ProductVO productVO) {
		
		ProductEntity productEntity= new ProductEntity(
				productVO.getProductId(),
				productVO.getProductName(),
				productVO.getProductCode(),
				productVO.getDescription(),
				productVO.getSpecification(),
				productVO.getIsActive(),			
				productVO.getCreatedBy(),
				productVO.getCreatedAt(),
				productVO.getModifiedBy(),
				productVO.getModifiedAt());
		
		productRepo.save(productEntity);
				
	}

	@Override
	public Boolean updateProduct(ProductVO productVO) {

		if(getProductById(productVO.getProductId())==null) {
			return false;
		}
			
		ProductEntity productEntity= new ProductEntity(
				productVO.getProductId(),
				productVO.getProductName(),
				productVO.getProductCode(),
				productVO.getDescription(),
				productVO.getSpecification(),
				productVO.getIsActive(),			
				productVO.getCreatedBy(),
				productVO.getCreatedAt(),
				productVO.getModifiedBy(),
				productVO.getModifiedAt());
		
		productRepo.save(productEntity);
		
		return true;
	}

	@Override
	public Boolean deleteProduct(Integer id) {
		
		if(productRepo.findById(id).isEmpty()) {
			return false;
		}
		
		productRepo.deleteById(id);
		
		return true ;
		
	}
}
