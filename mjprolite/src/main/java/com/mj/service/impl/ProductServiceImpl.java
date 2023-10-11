package com.mj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.CategoryEntity;
import com.mj.entity.ProductEntity;
import com.mj.repository.ProductRepo;
import com.mj.service.ProductService;
import com.mj.vo.CategoryVO;
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
			
			CategoryVO categoryVO=new CategoryVO(
					productEntity.getCategory().getCategoryId(),
					productEntity.getCategory().getCategoryName(),
					productEntity.getCategory().getCategoryCode(),
					productEntity.getCategory().getIsActive(),
					productEntity.getCategory().getCreatedBy(),
					productEntity.getCategory().getCreatedAt(),
					productEntity.getCategory().getModifiedBy(),
					productEntity.getCategory().getModifiedAt());
			
//			List<ManufacturerVO> manufacturerVOList=new ArrayList<>();
//			
//			for(ManufacturerEntity manufacturerEntity:productEntity.getManufacturer()) {
//				
//				ManufacturerVO manufacturerVO=new ManufacturerVO(
//						manufacturerEntity.getManufacturerId(),
//						manufacturerEntity.getManufacturerName(),
//						manufacturerEntity.getIsActive(),
//						manufacturerEntity.getCreatedBy(),
//						manufacturerEntity.getCreatedAt(),
//						manufacturerEntity.getModifiedBy(),
//						manufacturerEntity.getModifiedAt());
//				
//				manufacturerVOList.add(manufacturerVO);
//			}
					
			
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
					productEntity.getModifiedAt(),
					categoryVO);	
			
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
		
		CategoryVO categoryVO=new CategoryVO(
				productEntity.get().getCategory().getCategoryId(),
				productEntity.get().getCategory().getCategoryCode(),
				productEntity.get().getCategory().getCategoryName(),
				productEntity.get().getCategory().getIsActive(),
				productEntity.get().getCategory().getCreatedBy(),
				productEntity.get().getCategory().getCreatedAt(),
				productEntity.get().getCategory().getModifiedBy(),
				productEntity.get().getCategory().getModifiedAt());
		
//		List<ManufacturerVO> manufacturerVOList=new ArrayList<>();
//		
//		for(ManufacturerEntity manufacturerEntity:productEntity.get().getManufacturer()) {
//		
//		ManufacturerVO manufacturerVO=new ManufacturerVO(
//				manufacturerEntity.getManufacturerId(),
//				manufacturerEntity.getManufacturerName(),
//				manufacturerEntity.getIsActive(),
//				manufacturerEntity.getCreatedBy(),
//				manufacturerEntity.getCreatedAt(),
//				manufacturerEntity.getModifiedBy(),
//				manufacturerEntity.getModifiedAt());
//		
//		manufacturerVOList.add(manufacturerVO);
//	}

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
				productEntity.get().getModifiedAt(),
				categoryVO);
		
		return productVO;
	}

	@Override
	public void saveProduct(ProductVO productVO) {
		

		CategoryEntity categoryEntity=new CategoryEntity(
				productVO.getCategory().getCategoryId(),
				productVO.getCategory().getCategoryName(),
				productVO.getCategory().getCategoryCode(),
				productVO.getCategory().getIsActive(),
				productVO.getCategory().getCreatedBy(),
				productVO.getCategory().getCreatedAt(),
				productVO.getCategory().getModifiedBy(),
				productVO.getCategory().getModifiedAt());
		
//		List<ManufacturerEntity> manufacturerEntityList=new ArrayList<>();
//		
//		for(ManufacturerVO manufacturerVO:productVO.getManufacturer()) {
//			
//			ManufacturerEntity manufacturerEntity=new ManufacturerEntity(
//					manufacturerVO.getManufacturerId(),
//					manufacturerVO.getManufacturerName(),
//					manufacturerVO.getIsActive(),
//					manufacturerVO.getCreatedBy(),
//					manufacturerVO.getCreatedAt(),
//					manufacturerVO.getModifiedBy(),
//					manufacturerVO.getModifiedAt());
//			
//			manufacturerEntityList.add(manufacturerEntity);
//		}
		
		
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
				productVO.getModifiedAt(),
				categoryEntity);
		
		productRepo.save(productEntity);
				
	}

	@Override
	public Boolean updateProduct(ProductVO productVO) {

		if(getProductById(productVO.getProductId())==null) {
			return false;
		}
			
		CategoryEntity categoryEntity=new CategoryEntity(
				productVO.getCategory().getCategoryId(),
				productVO.getCategory().getCategoryName(),
				productVO.getCategory().getCategoryCode(),
				productVO.getCategory().getIsActive(),
				productVO.getCategory().getCreatedBy(),
				productVO.getCategory().getCreatedAt(),
				productVO.getCategory().getModifiedBy(),
				productVO.getCategory().getModifiedAt());
		
//		List<ManufacturerEntity> manufacturerEntityList=new ArrayList<>();
//		
//		for(ManufacturerVO manufacturerVO:productVO.getManufacturer()) {
//			
//			ManufacturerEntity manufacturerEntity=new ManufacturerEntity(
//					manufacturerVO.getManufacturerId(),
//					manufacturerVO.getManufacturerName(),
//					manufacturerVO.getIsActive(),
//					manufacturerVO.getCreatedBy(),
//					manufacturerVO.getCreatedAt(),
//					manufacturerVO.getModifiedBy(),
//					manufacturerVO.getModifiedAt());
//			
//			manufacturerEntityList.add(manufacturerEntity);
//		}
		
		
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
				productVO.getModifiedAt(),
				categoryEntity);
		
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

	@Override
	public List<ProductVO> getProductBycategory(Integer id) {
		
		List<ProductEntity> productEntityList=productRepo.getProductByCategory(id);
		
		List<ProductVO> productVOList=new ArrayList<>();
		
		for(ProductEntity productEntity:productEntityList) {
			
			CategoryVO categoryVO=new CategoryVO(
					productEntity.getCategory().getCategoryId(),
					productEntity.getCategory().getCategoryName(),
					productEntity.getCategory().getCategoryCode(),
					productEntity.getCategory().getIsActive(),
					productEntity.getCategory().getCreatedBy(),
					productEntity.getCategory().getCreatedAt(),
					productEntity.getCategory().getModifiedBy(),
					productEntity.getCategory().getModifiedAt());
			
//			List<ManufacturerVO> manufacturerVOList=new ArrayList<>();
//			
//			for(ManufacturerEntity manufacturerEntity:productEntity.getManufacturer()) {
//				
//				ManufacturerVO manufacturerVO=new ManufacturerVO(
//						manufacturerEntity.getManufacturerId(),
//						manufacturerEntity.getManufacturerName(),
//						manufacturerEntity.getIsActive(),
//						manufacturerEntity.getCreatedBy(),
//						manufacturerEntity.getCreatedAt(),
//						manufacturerEntity.getModifiedBy(),
//						manufacturerEntity.getModifiedAt());
//				
//				manufacturerVOList.add(manufacturerVO);
//			}
					
			
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
					productEntity.getModifiedAt(),
					categoryVO);	
			
			productVOList.add(productVO);
		}
		
		return productVOList;
	}
}
