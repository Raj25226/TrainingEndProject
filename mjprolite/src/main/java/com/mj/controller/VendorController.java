package com.mj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.mj.service.VendorService;
import com.mj.vo.VendorVO;

@RestController
public class VendorController {
	
	@Autowired
	VendorService vendorService;
	
	@GetMapping("/vendor")
	ResponseEntity<List<VendorVO>> findAllVendor()
	{
		if(vendorService.getAllVendor().size()!=0) {
			return ResponseEntity.ok(vendorService.getAllVendor());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/vendor/{id}")
	ResponseEntity<VendorVO> findVendorById(@PathVariable int id) {
		VendorVO vendorVO = vendorService.getVendorById(id);

	    if (vendorVO != null) {
	        return ResponseEntity.ok(vendorVO);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PostMapping("/vendor")
	ResponseEntity<String> saveVendor(@RequestBody VendorVO vendorVO) {
	    boolean saved = vendorService.saveVendor(vendorVO);

	    if (saved) {
	        return ResponseEntity.ok("Data Saved Successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save data");
	    }
	}
	
	@PutMapping("/vendor")
    ResponseEntity<String> updateVendor(@RequestBody VendorVO vendorVO) {
		
		VendorVO vendorVO1=vendorService.getVendorById(vendorVO.getVendorId());
		if(vendorVO1==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Vendor Does not exist");
		}
        else {
        	vendorService.updateVendor(vendorVO1);
            return ResponseEntity.notFound().build(); 
        }
    }
	
	@DeleteMapping("/vendor/{id}")
	ResponseEntity<String> deleteVendorById(@PathVariable int id) {
		VendorVO vendorVO1=vendorService.getVendorById(id);
		if(vendorVO1==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Vendor Does not exist");
		}
		else {
			vendorService.deleteVendor(id);
			return ResponseEntity.notFound().build(); 	
		}
	}

}
