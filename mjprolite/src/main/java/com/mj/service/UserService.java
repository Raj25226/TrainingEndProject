package com.mj.service;

import java.util.List;

import com.mj.vo.UserVO;

public interface UserService {
	
	List<UserVO> getAllUsers();
	UserVO getUserById(int id);
	boolean saveUser(UserVO userVO);
	boolean updateUser(UserVO userVo);
	boolean deleteUser(int id);

}
