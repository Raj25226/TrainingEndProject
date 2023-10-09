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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mj.service.UserService;
import com.mj.utility.Authorizer;
import com.mj.vo.UserVO;

@RestController
@RequestMapping("/mj")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user")
	ResponseEntity<List<UserVO>> findAllUsers()
	{
		if(userService.getAllUsers().size()!=0) {
			return ResponseEntity.ok(userService.getAllUsers());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/user/{id}")
	ResponseEntity<UserVO> findUserById(@PathVariable int id) {
	    UserVO userVO = userService.getUserById(id);

	    if (userVO != null) {
	        return ResponseEntity.ok(userVO);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PostMapping("/user")
	ResponseEntity<String> saveUser(@RequestBody UserVO userVO) {
		userVO.setPassword(Authorizer.getEncryptedData(userVO.getPassword()));
	    boolean saved = userService.saveUser(userVO);

	    if (saved) {
	        return ResponseEntity.ok("Data Saved Successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save data");
	    }
	}
	
	@PutMapping("/user")
    ResponseEntity<String> updateUser(@RequestBody UserVO userVO) {
		
		UserVO userVO1=userService.getUserById(userVO.getUserId());
		if(userVO1==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given User Does not exist");
		}
        else {
        	userService.updateUser(userVO1);
            return ResponseEntity.notFound().build(); 
        }
    }
	
	
	@DeleteMapping("/user/{id}")
	ResponseEntity<String> deleteUserById(@PathVariable int id) {
		UserVO userVO1=userService.getUserById(id);
		if(userVO1==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given User Does not exist");
		}
		else {
			userService.deleteUser(id);
			return ResponseEntity.notFound().build(); 	
		}
	}

}
