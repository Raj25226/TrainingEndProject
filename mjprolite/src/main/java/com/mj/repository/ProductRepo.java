package com.mj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mj.entity.ProductEntity;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
	
	@Query(value = "SELECT * FROM PRODUCT WHERE CATEGORY_ID=?",nativeQuery = true)
	public List<ProductEntity> getProductByCategory(Integer id);
}
