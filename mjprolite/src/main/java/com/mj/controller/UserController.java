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

import com.mj.entity.UserEntity;
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
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/user/{id}")
	ResponseEntity<UserVO> findUserById(@PathVariable int id) {
	    UserVO userVO = userService.getUserById(id);

	    if (userVO != null) {
	        return ResponseEntity.ok(userVO);
	    } else {
	    	return ResponseEntity.noContent().build();
	    }
	}
	
	@PostMapping("/user")
	ResponseEntity<String> saveUser(@RequestBody UserVO userVO) {
		userVO.setPassword(Authorizer.getEncryptedData(userVO.getPassword()));
	    boolean saved = userService.saveUser(userVO);

	    if (saved) {
	        return ResponseEntity.ok("User Saved Successfully");
	    } else {
	    	return ResponseEntity.noContent().build();
	    }
	}
	
	@PutMapping("/user")
    ResponseEntity<String> updateUser(@RequestBody UserVO userVO) {
		
		UserVO userVO1=userService.getUserById(userVO.getUserId());
		if(userVO1==null) {
			return ResponseEntity.noContent().build();
		}
        else {
        	userService.updateUser(userVO);
        	return ResponseEntity.ok("User Updated Successfully");
        }
    }
	
	
	@DeleteMapping("/user/{id}")
	ResponseEntity<String> deleteUserById(@PathVariable int id) {
		UserVO userVO=userService.getUserById(id);
		if(userVO==null) {
			return ResponseEntity.noContent().build();
		}
		else {
			userService.deleteUser(id);
			return ResponseEntity.ok("User Deleted Successfully");
		}
	}
	
//	@PostMapping("/user/login")
//	public ResponseEntity<String> login(@RequestBody UserVO userVO) {
//	    String userName = userVO.getUserName();
//	    String password = userVO.getPassword();
//
//	    UserEntity user = userService.findByUserNameAndPassword(userName, password);
//
//	    if (user != null) {
//	        // Authentication successful, return a success message or a token
//	        return ResponseEntity.ok("Authentication successful");
//	    } else {
//	        // Authentication failed, return an appropriate error message
//	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
//	    }
//	}
	
	@PostMapping("/user/login")
	public ResponseEntity<String> login(@RequestBody UserVO userVO) {
	    String userName = userVO.getUserName();
	    String password = userVO.getPassword();

	    UserEntity user = userService.findByUserNameAndPassword(userName, password);
	    System.out.println(user);

	    if (user != null) {
	        // Authentication successful, return an appropriate success response
	        return ResponseEntity.ok("Authentication successful");
	    } else {
	        // Authentication failed, return an appropriate error response
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
	    }
	}




}
