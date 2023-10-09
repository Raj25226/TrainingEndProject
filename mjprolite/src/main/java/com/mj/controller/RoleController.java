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
		if(roleService.getAllRoles().size()!=0) {
			return ResponseEntity.ok(roleService.getAllRoles());
		}
		else {
			return ResponseEntity.notFound().build();
		}
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
	
	@PutMapping("/role")
    ResponseEntity<String> updateRole(@RequestBody RoleVO roleVo) {
		
		RoleVO roleVo1=roleService.getRoleById(roleVo.getRoleId());
		if(roleVo1==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Role Does not exist");
		}
        else {
        	roleService.updateRole(roleVo1);
            return ResponseEntity.notFound().build(); 
        }
    }
	
	@DeleteMapping("/role/{id}")
	ResponseEntity<String> deleteRoleById(@PathVariable int id) {
		RoleVO roleVo1=roleService.getRoleById(id);
		if(roleVo1==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Role Does not exist");
		}
		else {
			roleService.deleteRole(id);
			return ResponseEntity.notFound().build(); 	
		}
	}
}
