package com.mj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


import com.mj.service.VendorService;
import com.mj.vo.VendorVO;

@RestController
@RequestMapping("/mj")
@CrossOrigin("*")
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
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/vendor/{id}")
	ResponseEntity<VendorVO> findVendorById(@PathVariable int id) {
		VendorVO vendorVO = vendorService.getVendorById(id);

	    if (vendorVO != null) {
	        return ResponseEntity.ok(vendorVO);
	    } else {
	    	return ResponseEntity.noContent().build();
	    }
	}
	
	
	@PostMapping("/vendor")
	ResponseEntity<String> saveVendor(@RequestBody VendorVO vendorVO) {
	    boolean saved = vendorService.saveVendor(vendorVO);

	    if (saved) {
	        return ResponseEntity.ok("Vendor Saved Successfully");
	    } else {
	    	return ResponseEntity.noContent().build();
	    }
	}
	
	@PutMapping("/vendor")
    ResponseEntity<String> updateVendor(@RequestBody VendorVO vendorVO) {
		
		VendorVO vendorVO1=vendorService.getVendorById(vendorVO.getVendorId());
		if(vendorVO1==null) {
			return ResponseEntity.noContent().build();
		}
        else {
        	vendorService.updateVendor(vendorVO);
        	return ResponseEntity.ok("Vendor Updated Successfully"); 
        }
    }
	
	@DeleteMapping("/vendor/{id}")
	ResponseEntity<String> deleteVendorById(@PathVariable int id) {
		VendorVO vendorVO=vendorService.getVendorById(id);
		if(vendorVO==null) {
			return ResponseEntity.noContent().build();
		}
		else {
			vendorService.deleteVendor(id);
			return ResponseEntity.ok("Vendor Deleted Successfully");
		}
	}

}
