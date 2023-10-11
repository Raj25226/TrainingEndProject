package com.mj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.RoleEntity;
import com.mj.entity.UserEntity;
import com.mj.repository.UserRepo;
import com.mj.service.UserService;
import com.mj.vo.RoleVO;
import com.mj.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<UserVO> getAllUsers() {
        List<UserVO> userVOList = new ArrayList<>();
        List<UserEntity> userEntityList = userRepo.findAll();

        for (UserEntity userEntity : userEntityList) {
        	
        	 UserVO userVO = new UserVO();
        	 
             userVO.setUserId(userEntity.getUserId());
             userVO.setUserName(userEntity.getUserName());
             userVO.setPassword(userEntity.getPassword());
             userVO.setIsActive(userEntity.getIsActive());
             userVO.setCreatedBy(userEntity.getCreatedBy());
             userVO.setCreatedAt(userEntity.getCreatedAt());
             userVO.setModifiedBy(userEntity.getModifiedBy());
             userVO.setModifiedAt(userEntity.getModifiedAt());
             
             RoleEntity roleEntity = userEntity.getRole();
             
             RoleVO roleVO = new RoleVO();
             
             roleVO.setRoleId(roleEntity.getRoleId());
             roleVO.setRoleName(roleEntity.getRoleName());
             roleVO.setIsActive(roleEntity.getIsActive());
             roleVO.setCreatedBy(roleEntity.getCreatedBy());
             roleVO.setCreatedAt(roleEntity.getCreatedAt());
             roleVO.setModifiedBy(roleEntity.getModifiedBy());
             roleVO.setModifiedAt(roleEntity.getModifiedAt());
             
             userVO.setRole(roleVO);
            
             userVOList.add(userVO);
        }

        return userVOList;
    }

    @Override
    public UserVO getUserById(int id) {
        Optional<UserEntity> userEntityOptional = userRepo.findById(id);

        if (userEntityOptional.isPresent()) {
        	
            UserEntity userEntity = userEntityOptional.get();
            UserVO userVO = new UserVO();
       	 
            userVO.setUserId(userEntity.getUserId());
            userVO.setUserName(userEntity.getUserName());
            userVO.setPassword(userEntity.getPassword()); 
            userVO.setIsActive(userEntity.getIsActive());
            userVO.setCreatedBy(userEntity.getCreatedBy());
            userVO.setCreatedAt(userEntity.getCreatedAt());
            userVO.setModifiedBy(userEntity.getModifiedBy());
            userVO.setModifiedAt(userEntity.getModifiedAt());
            
            RoleEntity roleEntity = userEntity.getRole();
            
            RoleVO roleVO = new RoleVO();
            roleVO.setRoleId(roleEntity.getRoleId());
            roleVO.setRoleName(roleEntity.getRoleName());
            roleVO.setIsActive(roleEntity.getIsActive());
            roleVO.setCreatedBy(roleEntity.getCreatedBy());
            roleVO.setCreatedAt(roleEntity.getCreatedAt());
            roleVO.setModifiedBy(roleEntity.getModifiedBy());
            roleVO.setModifiedAt(roleEntity.getModifiedAt());
            
            userVO.setRole(roleVO);
            
            return userVO;
        } else {
        	return null;
        } 
    }

    @Override
    public boolean saveUser(UserVO userVO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userVO.getUserName());
        userEntity.setPassword(userVO.getPassword()); 
        userEntity.setIsActive(userVO.getIsActive());
        userEntity.setCreatedBy(userVO.getCreatedBy());
        userEntity.setCreatedAt(userVO.getCreatedAt());
        userEntity.setModifiedBy(userVO.getModifiedBy());
        userEntity.setModifiedAt(userVO.getModifiedAt());
        
        //As userEntity needs roleEntity so we convert from roleVO to roleEntity.
        
        RoleVO roleVO = userVO.getRole();
        
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(roleVO.getRoleId());
        roleEntity.setRoleName(roleVO.getRoleName());
        roleEntity.setIsActive(roleVO.getIsActive());
        roleEntity.setCreatedBy(roleVO.getCreatedBy());
        roleEntity.setCreatedAt(roleVO.getCreatedAt());
        roleEntity.setModifiedBy(roleVO.getModifiedBy());
        roleEntity.setModifiedAt(roleVO.getModifiedAt());
        
        userEntity.setRole(roleEntity);
        
        

        UserEntity savedEntity = userRepo.save(userEntity);

        if (savedEntity != null) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean updateUser(UserVO userVO) {
    	
            Optional<UserEntity> userEntityOptional = userRepo.findById(userVO.getUserId());

            if (userEntityOptional.isPresent()) {
                UserEntity userEntity = userEntityOptional.get();
                
                userEntity.setUserName(userVO.getUserName());
                userEntity.setPassword(userVO.getPassword()); 
                userEntity.setIsActive(userVO.getIsActive());
                userEntity.setCreatedBy(userVO.getCreatedBy());
                userEntity.setCreatedAt(userVO.getCreatedAt());
                userEntity.setModifiedBy(userVO.getModifiedBy());
                userEntity.setModifiedAt(userVO.getModifiedAt());
                
                RoleVO roleVO = userVO.getRole();
                
                RoleEntity roleEntity = new RoleEntity();
                roleEntity.setRoleId(roleVO.getRoleId());
                roleEntity.setRoleName(roleVO.getRoleName());
                roleEntity.setIsActive(roleVO.getIsActive());
                roleEntity.setCreatedBy(roleVO.getCreatedBy());
                roleEntity.setCreatedAt(roleVO.getCreatedAt());
                roleEntity.setModifiedBy(roleVO.getModifiedBy());
                roleEntity.setModifiedAt(roleVO.getModifiedAt());
                
                userEntity.setRole(roleEntity);
                
                userRepo.save(userEntity);
                
                return true;   
            } else {
                return false; 
            }
    }

    @Override
    public boolean deleteUser(int id) {
    	if(userRepo.findById(id).isEmpty()) {
			return false;
		}
    	userRepo.deleteById(id);
		return true;
    }

	@Override
	public UserEntity findByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		Optional<UserEntity> userEntityOptional = userRepo.findByUserNameAndPassword(userName, password);
		if (userEntityOptional.isPresent()) {
			UserEntity userEntity = userEntityOptional.get();
			return userEntity;
		}
		return null;
	}
}
