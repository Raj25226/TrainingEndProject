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

import com.mj.service.RoleService;
import com.mj.vo.RoleVO;

@RestController
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@GetMapping("/role")
	ResponseEntity<List<RoleVO>> findAllRole()
	{
		return ResponseEntity.ok(roleService.getAllRoles());
	}
	
	@GetMapping("/role/{id}")
	ResponseEntity<RoleVO> findRoleById(@PathVariable int id) {
	    RoleVO roleVO = roleService.getRoleById(id);

	    if (roleVO != null) {
	        return ResponseEntity.ok(roleVO);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PostMapping("/role")
	ResponseEntity<String> saveRole(@RequestBody RoleVO roleVo) {
	    boolean saved = roleService.saveRole(roleVo);

	    if (saved) {
	        return ResponseEntity.ok("Data Saved Successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save data");
	    }
	}
	
	@PutMapping("/role/{id}")
    ResponseEntity<String> updateRoleById(@PathVariable int id, @RequestBody RoleVO roleVo) {
        boolean updated = roleService.updateRole(roleVo);

        if (updated) {
            return ResponseEntity.ok("Data Updated Successfully");
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }
	
	@DeleteMapping("/role/{id}")
	ResponseEntity<String> deleteRoleById(@PathVariable int id) {
	    boolean deleted = roleService.deleteRole(id);

	    if (deleted) {
	        return ResponseEntity.ok("Data Deleted Successfully");
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
