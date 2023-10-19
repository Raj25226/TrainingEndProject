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

import com.mj.service.IndentService;
import com.mj.vo.IndentVO;

@RestController
@RequestMapping("/mj")
@CrossOrigin("*")
public class IndentController {
	
	@Autowired
	IndentService indentService;
	
	@GetMapping("/indent")
	public ResponseEntity<List<IndentVO>> getIndentList(){
		
		if(indentService.getAllIndent().size()!=0)
			return ResponseEntity.ok(indentService.getAllIndent());
		else {
			HttpHeaders header=new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).
					headers(header).
					body(null);
		}
	}
	
	@GetMapping("/indent/{id}")
	public ResponseEntity<IndentVO> getIndentById(@PathVariable Integer id) {
		
		if(indentService.getIndentById(id)!=null) {
			return ResponseEntity.ok(indentService.getIndentById(id));
		}else {
			HttpHeaders header = new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).
					headers(header).
					body(null);
		}
	}
	@GetMapping("/indentall/{id}")
	public ResponseEntity<List<IndentVO>> getIndentByheaderId(@PathVariable Integer id) {
		
		if(indentService.getIndentByheaderIdAll(id)!=null) {
			return ResponseEntity.ok(indentService.getIndentByheaderIdAll(id));
		}else {
			HttpHeaders header = new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).
					headers(header).
					body(null);
		}
	}
	
	
	@PostMapping("/indent")
	public ResponseEntity<String> saveIndent(@RequestBody IndentVO indentVO) {
		
		indentService.saveIndent(indentVO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Data Saved Successfully");
	}
	
	@PutMapping("/indent")
	public ResponseEntity<String> updateIndent(@RequestBody IndentVO indentVO) {
		
		IndentVO indentVO1=indentService.getIndentById(indentVO.getIndentId());
		
		if(indentVO1==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Indent Does not exist");
		indentService.updateIndent(indentVO);
		
		return ResponseEntity.ok("Data Updated Successfully");
	}
	
	@DeleteMapping("/indent/{id}")
	public ResponseEntity<String> deleteIndent(@PathVariable Integer id) {
		
		IndentVO indentVO=indentService.getIndentById(id);
		
		if(indentVO==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Indent Does not exist");
		
		indentService.deleteIndentById(id);
		
		return ResponseEntity.ok("Data deleted Successfully");
	}
	@DeleteMapping("/indent1/{id}")
	public ResponseEntity<String> deleteallIndent(@PathVariable Integer id) {
		
		IndentVO indentVO=indentService.getIndentById(id);
		
		if(indentVO==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Indent Does not exist");
		
		indentService.deleteallIndentById(id);
		
		return ResponseEntity.ok("Data deleted Successfully");
	}
	
}
