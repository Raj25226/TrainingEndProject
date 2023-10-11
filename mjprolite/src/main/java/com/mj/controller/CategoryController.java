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

import com.mj.service.CategoryService;
import com.mj.vo.CategoryVO;

@RestController
@RequestMapping("/mj")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	CategoryService categoryservice;
	
	
	@GetMapping("/category")
	public ResponseEntity<List<CategoryVO>> getCategoryList(){
		
		if(categoryservice.getAllCategory().size()!=0)
			return ResponseEntity.ok(categoryservice.getAllCategory());
		else {
			HttpHeaders header=new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).
					headers(header).
					body(null);
		}
	}
	@GetMapping("/category/{id}")
	public ResponseEntity<CategoryVO> getCategoryById(@PathVariable Integer id){
		
		if(categoryservice.getCategoryById(id)!=null) {
			return ResponseEntity.ok(categoryservice.getCategoryById(id));
		}else {
			HttpHeaders header = new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).
					headers(header).
					body(null);
		}
	}
	
	@PostMapping("/category")
	public ResponseEntity<String> saveCategory(@RequestBody CategoryVO categoryVO) {
		
		categoryservice.saveCategory(categoryVO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Data Saved Successfully");
	}
	@PutMapping("/category")
	public ResponseEntity<String> updateCategory(@RequestBody CategoryVO categoryVO) {
		
		CategoryVO categoryVO1=categoryservice.getCategoryById(categoryVO.getCategoryId());
		
		if(categoryVO1==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Category Doesnot exist");
		categoryservice.updateCategory(categoryVO);
		
		return ResponseEntity.ok("Data Updated Successfully");
	}
	
	@DeleteMapping("/category")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
		
		CategoryVO categoryVO=categoryservice.getCategoryById(id);
		
		if(categoryVO==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Category Doesnot exist");
		
		categoryservice.deleteCategoryById(id);
		
		return ResponseEntity.ok("Data deleted Successfully");
	}
	
}
