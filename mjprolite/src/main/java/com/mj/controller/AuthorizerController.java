package com.mj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mj.utility.Authorizer;
import com.mj.vo.UserVO;

@RestController
@RequestMapping("/mj")
@CrossOrigin("*")
public class AuthorizerController {
	
	@GetMapping("/md5")
	public ResponseEntity<String> getEncryption(@RequestBody UserVO userVO) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Authorizer.getMd5(userVO.getPassword()));
	}

	@GetMapping("/encrypt")
	public ResponseEntity<String> getEncryption(@RequestBody String value){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Authorizer.getEncryptedData(value));
	}
	
	@GetMapping("/decrypt")
	public ResponseEntity<String> getDecryption(@RequestBody String value){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Authorizer.getDecrypteddata(value));
	}
}
