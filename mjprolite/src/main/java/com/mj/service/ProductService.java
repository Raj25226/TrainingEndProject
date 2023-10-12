package com.mj.service;

import java.util.List;

import com.mj.vo.ProductVO;

public interface ProductService {

    List<ProductVO> getAllProduct();
	
    ProductVO getProductById(Integer id);
	
	void saveProduct(ProductVO productVO);
	
	Boolean updateProduct (ProductVO productVO);
	
	Boolean deleteProduct(Integer id);
	
	List<ProductVO> getProductBycategory(Integer id);
}
