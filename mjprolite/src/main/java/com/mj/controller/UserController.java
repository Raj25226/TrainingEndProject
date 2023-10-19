package com.mj.controller;
import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mj.service.MailSenderService;
import com.mj.service.UserService;
import com.mj.utility.Authorizer;
import com.mj.vo.UserVO;

@RestController
@RequestMapping("/mj")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired 
	MailSenderService mailService;
	
	@Autowired
    JavaMailSender javaMailSender;
	
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
	
	@GetMapping("/user/byId/{id}")
	ResponseEntity<UserVO> findUserById(@PathVariable int id) {
	    UserVO userVO = userService.getUserById(id);

	    if (userVO != null) {
	        return ResponseEntity.ok(userVO);
	    } else {
	    	return ResponseEntity.noContent().build();
	    }
	}
	
	@GetMapping("/user/byEmail/{email}")
	ResponseEntity<UserVO> findUserByEmail(@PathVariable String email) {
		
		 try {
		        UserVO userVO = userService.getUserByEmail(email);
		        System.out.println(userVO);

		        if (userVO != null) {
		            return ResponseEntity.ok(userVO);
		        } else {
		            return ResponseEntity.noContent().build();
		        }
		    } catch (Exception e) {
		    	System.out.println("ERROR");
		    	return ResponseEntity.noContent().build();
		    }
	}

	@GetMapping("/api/email/send/{email}") // Added leading slash
	public ResponseEntity<String> sendEmail(@PathVariable String email) {
	    try {
	    	String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    	SecureRandom random = new SecureRandom();
	    	 
	    	Integer length=7;
	    	 StringBuilder sb = new StringBuilder(length);
	         for (int i = 0; i < length; i++) {
	             int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
	             char randomChar = ALLOWED_CHARACTERS.charAt(randomIndex);
	             sb.append(randomChar);
	         }
	        
	        String otp = sb.toString();
	        String msg= "Kindly note that the One Time Password (OTP) for your request is  \n \n  \t"+otp;
	         System.out.println(msg);
	    	
	        mailService.sendNewMail(email, "OTP for Eprocurement Verification", msg);
	        
	        return ResponseEntity.ok(otp);
	        
	    } catch (Exception e) {
	        // Return an error response if email sending fails
	    	System.out.println(e);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email sending failed.");
	    }
	}

	
	@PostMapping("/user")
    public ResponseEntity<UserVO> saveUser(@RequestBody UserVO userVO) {
       
            if (userVO != null ) {
                // Hash the user's password (you might want to check this method)
                userVO.setPassword(Authorizer.getMd5(userVO.getPassword()));

                UserVO userVO1 = userService.saveUser(userVO);

                if (userVO1 != null) {
                    return ResponseEntity.ok(userVO1);
                } else {
                    // Handle the case where saving the user failed
                    return ResponseEntity.noContent().build();
                }
            } else {
                // Handle the case where userVO or userVO.getUserId() is null
                return ResponseEntity.noContent().build();
            }
            
    }
	
	@PutMapping("/user")
    ResponseEntity<String> updateUser(@RequestBody UserVO userVO) {
		
		userVO.setPassword(Authorizer.getMd5(userVO.getPassword()));
		
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
	
	
	@PostMapping("/user/login")
	public ResponseEntity<UserVO> login(@RequestBody UserVO userVO) {
		
	    String userName = userVO.getUserName();
	    String password = Authorizer.getMd5(userVO.getPassword());

	    UserVO user = userService.findByUserNameAndPassword(userName, password);
	    

	    if (user != null) {
	        // Authentication successful, return an appropriate success response
	        return ResponseEntity.ok(user);
	    } else {
			HttpHeaders header=new HttpHeaders();
			header.add("Data", "No Data Found");
			return ResponseEntity.
					status(HttpStatus.UNAUTHORIZED).
					headers(header).
					body(null);
		}
	}




}
