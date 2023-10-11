package com.mj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mj.service.ProductService;
import com.mj.vo.ProductVO;

@RestController
@RequestMapping("/mj")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/product")
	public ResponseEntity<List<ProductVO>> getAllProduct(){
		
		if(productService.getAllProduct().size()!=0) {
			return ResponseEntity.ok(productService.getAllProduct());
		}
		else {
			HttpHeaders header=new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).
					headers(header).
					body(null);
		}
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<List<ProductVO>> getAllProductByCategory(@PathVariable int id){
		
		if(productService.getProductBycategory(id).size()!=0) {
			return ResponseEntity.ok(productService.getProductBycategory(id));
		}
		else {
			HttpHeaders header=new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).
					headers(header).
					body(null);
			}
		}
	
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductVO>getProductById(@PathVariable Integer id) {
		
		if(productService.getProductById(id)!=null) {
			return ResponseEntity.ok(productService.getProductById(id));
		}
		else {
			HttpHeaders header = new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).
					headers(header).
					body(null);
		}
	}
	
	@PostMapping("/product")
	public ResponseEntity<String> saveProduct(@RequestBody ProductVO productVO) {
		 
		productService.saveProduct(productVO);
		 
		return ResponseEntity.status(HttpStatus.CREATED).body("Data Saved Successfully");
	}
	
	@PutMapping("/product")
	public ResponseEntity<String> updateProduct (@RequestBody ProductVO productVO) {
		
		ProductVO productVO1=productService.getProductById(productVO.getProductId());
		
		if(productVO1==null)
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Product Doesnot exist"); 
		productService.updateProduct(productVO);
		
		return ResponseEntity.ok("Data Updated Successfully");
	}
	
	@DeleteMapping("/product/{id}")	
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
		
		ProductVO productVO=productService.getProductById(id);
		
		if(productVO==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Product Not Found");
		
		productService.deleteProduct(id);
		
		return ResponseEntity.ok("Data Deleted Successfully");
	}
}
