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

import com.mj.service.ManufacturerService;
import com.mj.vo.ManufacturerVO;

@RestController
@RequestMapping("/mj")
@CrossOrigin("*")
public class ManufacturerController {

	@Autowired
	ManufacturerService manufacturerService;
	
	@GetMapping("/manufacturer")
    public ResponseEntity<List<ManufacturerVO>> getAllManufacturer(){
		
		if(manufacturerService.getAllManufacturer().size()!=0)
			return ResponseEntity.ok(manufacturerService.getAllManufacturer());
		else {
			HttpHeaders header=new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).
					headers(header).
					body(null);
		}
	}
	
	@GetMapping("/manufacturer/{id}")
	public ResponseEntity<ManufacturerVO> getManufacturerById(Integer id){
		
		if(manufacturerService.getManufacturerById(id)!=null) {
			return ResponseEntity.ok(manufacturerService.getManufacturerById(id));
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
	
	@PostMapping("/manufacturer")
	public ResponseEntity<String> saveManufacturer(@RequestBody ManufacturerVO manufacturerVO){
		
		manufacturerService.saveManufacturer(manufacturerVO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Data saved Successfully");
	}
		
	@PutMapping("/manufacturer")
	public ResponseEntity<String> updateManufacturer(@RequestBody ManufacturerVO manufacturerVO){
		
		ManufacturerVO manufacturerVO1=manufacturerService.getManufacturerById(manufacturerVO.getManufacturerId());

		if(manufacturerVO1==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Manufacturer Does not exist");
		manufacturerService.updateManufacturer(manufacturerVO);
		
		return ResponseEntity.ok("Data Updated Successfully");
		
	}
		
	@DeleteMapping("/manufacturer/{id}")
	public ResponseEntity<String> deleteManufacturer(@PathVariable Integer id) {
		
		ManufacturerVO manufacturerVO=manufacturerService.getManufacturerById(id);
		
		if(manufacturerVO==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Manufacturer Does not exist");
		
		manufacturerService.deleteManufacturerById(id);
		
		return ResponseEntity.ok("Data deleted Successfully");
	}
}


