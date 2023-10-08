package com.mj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mj.service.IndentService;

@RestController
public class IndentController {
	
	@Autowired
	IndentService indentService; 
	
}
