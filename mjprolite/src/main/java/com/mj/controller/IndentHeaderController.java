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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mj.service.IndentHeaderService;
import com.mj.service.IndentService;
import com.mj.vo.IndentHeaderVO;

@RestController
@RequestMapping("/mj")
@CrossOrigin("*")
public class IndentHeaderController {
	
	@Autowired
	IndentHeaderService indentHeaderService;
	
	@Autowired
	IndentService indentService;
	
	@GetMapping("/indentheader")
	public ResponseEntity<List<IndentHeaderVO>> getIndentHeaderList(){
		
		if(indentHeaderService.getAllIndentHeader().size()!=0)
			return ResponseEntity.ok(indentHeaderService.getAllIndentHeader());
		else {
			HttpHeaders header=new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).
					headers(header).
					body(null);
		}
	}
	
	@PostMapping("/indentheader/desc")
	ResponseEntity<IndentHeaderVO> getIndentHeaderById(@RequestBody String description) {
		
		System.out.println("Hello "+description);
		
		if(indentHeaderService.getIndentHeaderByDescription(description)!=null) {
			return ResponseEntity.ok(indentHeaderService.getIndentHeaderByDescription(description));
		}else {
			HttpHeaders header = new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).
					headers(header).
					body(null);
		}
	}
	
	@GetMapping("/indentheader/{id}")
	public ResponseEntity<IndentHeaderVO> getIndentHeaderById(@PathVariable Integer id) {
		
		if(indentHeaderService.getIndentHeaderById(id)!=null) {
			return ResponseEntity.ok(indentHeaderService.getIndentHeaderById(id));
		}else {
			HttpHeaders header = new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).
					headers(header).
					body(null);
		}
	}
	
	@PostMapping("/indentheader")
	public ResponseEntity<String> saveIndentHeader(@RequestBody IndentHeaderVO indentHeaderVO) {
		
		System.out.println(indentHeaderVO);
		
		indentHeaderService.saveIndentHeader(indentHeaderVO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Data Saved Successfully");
	}
	
	@PutMapping("/indentheader")
	public ResponseEntity<String> updateIndentHeader(@RequestBody IndentHeaderVO indentHeaderVO) {
		
		IndentHeaderVO indentHeaderVO1=indentHeaderService.getIndentHeaderById(indentHeaderVO.getIndentHeaderId());
		
		if(indentHeaderVO1==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Indent Header Doesnot exist");
		indentHeaderService.updateIndentHeader(indentHeaderVO);
		
		return ResponseEntity.ok("Data Updated Successfully");
	}
	
	@PutMapping("/indentheader/{price}/{id}")
	public ResponseEntity<String> updateIndentHeader(@PathVariable Long price, @PathVariable Integer id) {
		
		IndentHeaderVO indentHeaderVO1=indentHeaderService.getIndentHeaderById(id);
		
		if(indentHeaderVO1==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Indent Header Doesnot exist");
		indentHeaderService.editIndentHeaderPrice(price,id);
		
		return ResponseEntity.ok("Data Updated Successfully");
	}
	
	@DeleteMapping("/indentheader/{id}")
	public ResponseEntity<String> deleteIndentHeader(@PathVariable Integer id) {
		
		IndentHeaderVO indentHeaderVO=indentHeaderService.getIndentHeaderById(id);

		if(indentHeaderVO==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Indent Header Doesnot exist");
				
		indentService.deleteallIndentById(id);
	
		System.out.println(id);

		indentHeaderService.deleteIndentHeaderById(id);
			
		return ResponseEntity.ok("Data deleted Successfully");
		
	}
}
