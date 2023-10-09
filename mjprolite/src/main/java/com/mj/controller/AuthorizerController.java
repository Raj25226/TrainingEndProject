package com.mj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mj.utility.Authorizer;
import com.mj.vo.UserVO;

@RestController
public class AuthorizerController {
	
	@GetMapping("/authorize")
	public ResponseEntity<String> getEncryption(@RequestBody UserVO userVO) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Authorizer.getMd5(userVO.getPassword()));
	}

}
