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

import com.mj.service.UOMService;
import com.mj.vo.UOMVO;

@RestController
@RequestMapping("/mj")
@CrossOrigin("*")
public class UOMController {
	
	@Autowired
	UOMService uomService;
	
	@GetMapping("/uom")
	public ResponseEntity<List<UOMVO>> getUOMList(){
		
		if(uomService.getAllUOM().size()!=0)
			return ResponseEntity.ok(uomService.getAllUOM());
		else {
			HttpHeaders header=new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).
					headers(header).
					body(null);
		}
	}
	@GetMapping("/uom/{id}")
	public ResponseEntity<UOMVO> getUOMById(@PathVariable Integer id){
		
		if(uomService.getUOMById(id)!=null) {
			return ResponseEntity.ok(uomService.getUOMById(id));
		}else {
			HttpHeaders header = new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).
					headers(header).
					body(null);
		}
	}
	@PostMapping("/uom")
	public ResponseEntity<String> saveUOM(@RequestBody UOMVO uomVO) {
		
		uomService.saveUOM(uomVO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Data Saved Successfully");
	}
	
	@PutMapping("/uom")
	public ResponseEntity<String> updateUOM(@RequestBody UOMVO uomVO) {
		
		UOMVO uomVO1=uomService.getUOMById(uomVO.getUomId());
		
		if(uomVO1==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given UOM Doesnot exist");
		uomService.updateUOM(uomVO);
		
		return ResponseEntity.ok("Data Updated Successfully");
	}
	
	@DeleteMapping("/uom{id}")
	public ResponseEntity<String> deleteUOM(@PathVariable Integer id) {
		
		UOMVO uomVO=uomService.getUOMById(id);
		
		if(uomVO==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given UOM Doesnot exist");
		
		uomService.deleteUOMById(id);
		
		return ResponseEntity.ok("Data deleted Successfully");
	}
	
	
}
