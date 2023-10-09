package com.mj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mj.service.ProductService;
import com.mj.vo.ProductVO;

public class ProductController {

	@Autowired
	ProductService productService;
	
	List<ProductVO> getAllProduct(){
		return productService.getAllProduct();
	}
	
	ProductVO getProductById(Integer id) {
		return productService.getProductById(id);
	}
	
	void saveProduct(ProductVO productVO) {
		 productService.saveProduct(productVO);
	}
	
	Boolean updateProduct (ProductVO productVO) {
		return productService.updateProduct(productVO);
		
	}
	
	Boolean deleteProduct(Integer id) {
		return productService.deleteProduct(id);
	}
}
