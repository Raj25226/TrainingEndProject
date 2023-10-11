package com.mj.service.impl;

import com.mj.entity.RoleEntity;
import com.mj.entity.UserEntity;
import com.mj.entity.VendorEntity;
import com.mj.repository.VendorRepo;
import com.mj.service.VendorService;
import com.mj.vo.RoleVO;
import com.mj.vo.UserVO;
import com.mj.vo.VendorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepo vendorRepo;

    @Override
    public List<VendorVO> getAllVendor() {
    	
        List<VendorVO> vendorVOList = new ArrayList<>();
        List<VendorEntity> vendorEntityList = vendorRepo.findAll();

        for (VendorEntity vendorEntity : vendorEntityList) {
        	
            VendorVO vendorVO = new VendorVO();
            vendorVO.setVendorId(vendorEntity.getVendorId());
            vendorVO.setVendorName(vendorEntity.getVendorName());
            vendorVO.setPhoneNumber(vendorEntity.getPhoneNumber());
            vendorVO.setGst(vendorEntity.getGst());
            vendorVO.setEmail(vendorEntity.getEmail());
            vendorVO.setPan(vendorEntity.getPan());
            vendorVO.setTurnover(vendorEntity.getTurnover());
            vendorVO.setIsActive(vendorEntity.getIsActive());
            vendorVO.setCreatedBy(vendorEntity.getCreatedBy());
            vendorVO.setCreatedAt(vendorEntity.getCreatedAt());
            vendorVO.setModifiedBy(vendorEntity.getModifiedBy());
            vendorVO.setModifiedAt(vendorEntity.getModifiedAt());
            
            UserEntity userEntity = vendorEntity.getUser();
            
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
            
            vendorVO.setUser(userVO);
 
            vendorVOList.add(vendorVO);
        }

        return vendorVOList;
    }

    @Override
    public VendorVO getVendorById(int id) {
        Optional<VendorEntity> vendorEntityOptional = vendorRepo.findById(id);

        if (vendorEntityOptional.isPresent()) {
        	
            VendorEntity vendorEntity = vendorEntityOptional.get();
            
            VendorVO vendorVO = new VendorVO();
            vendorVO.setVendorId(vendorEntity.getVendorId());
            vendorVO.setVendorName(vendorEntity.getVendorName());
            vendorVO.setPhoneNumber(vendorEntity.getPhoneNumber());
            vendorVO.setGst(vendorEntity.getGst());
            vendorVO.setEmail(vendorEntity.getEmail());
            vendorVO.setPan(vendorEntity.getPan());
            vendorVO.setTurnover(vendorEntity.getTurnover());
            vendorVO.setIsActive(vendorEntity.getIsActive());
            vendorVO.setCreatedBy(vendorEntity.getCreatedBy());
            vendorVO.setCreatedAt(vendorEntity.getCreatedAt());
            vendorVO.setModifiedBy(vendorEntity.getModifiedBy());
            vendorVO.setModifiedAt(vendorEntity.getModifiedAt());
            
            UserEntity userEntity = vendorEntity.getUser();
            
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
            
            vendorVO.setUser(userVO);
           
            return vendorVO;
        } else {
        	return null;
        } 
    }

    @Override
    public boolean saveVendor(VendorVO vendorVO) {
        VendorEntity vendorEntity = new VendorEntity();
        
        vendorEntity.setVendorName(vendorVO.getVendorName());
        vendorEntity.setPhoneNumber(vendorVO.getPhoneNumber());
        vendorEntity.setGst(vendorVO.getGst());
        vendorEntity.setEmail(vendorVO.getEmail());
        vendorEntity.setPan(vendorVO.getPan());
        vendorEntity.setTurnover(vendorVO.getTurnover());
        vendorEntity.setIsActive(vendorVO.getIsActive());
        vendorEntity.setCreatedBy(vendorVO.getCreatedBy());
        vendorEntity.setCreatedAt(vendorVO.getCreatedAt());
        vendorEntity.setModifiedBy(vendorVO.getModifiedBy());
        vendorEntity.setModifiedAt(vendorVO.getModifiedAt());
        
        UserVO userVO=vendorVO.getUser();
        
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userVO.getUserId());
        userEntity.setUserName(userVO.getUserName());
        userEntity.setPassword(userVO.getPassword());
        userEntity.setIsActive(userVO.getIsActive());
        userEntity.setCreatedBy(userVO.getCreatedBy());
        userEntity.setCreatedAt(userVO.getCreatedAt());
        userEntity.setModifiedBy(userVO.getModifiedBy());
        userEntity.setModifiedAt(userVO.getModifiedAt());
        
        //As userEntity needs roleEntity so we convert from roleVO to roleEntity.
        
        RoleVO roleVo = userVO.getRole();
        
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(roleVo.getRoleId());
        roleEntity.setRoleName(roleVo.getRoleName());
        roleEntity.setIsActive(roleVo.getIsActive());
        roleEntity.setCreatedBy(roleVo.getCreatedBy());
        roleEntity.setCreatedAt(roleVo.getCreatedAt());
        roleEntity.setModifiedBy(roleVo.getModifiedBy());
        roleEntity.setModifiedAt(roleVo.getModifiedAt());
        
        
        vendorEntity.setUser(userEntity);
        
        

        VendorEntity savedEntity = vendorRepo.save(vendorEntity);
        
        if (savedEntity != null) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean updateVendor(VendorVO vendorVO) {
      
            Optional<VendorEntity> vendorEntityOptional = vendorRepo.findById(vendorVO.getVendorId());

            if (vendorEntityOptional.isPresent()) {
                VendorEntity vendorEntity = vendorEntityOptional.get();
                vendorEntity.setVendorName(vendorVO.getVendorName());
                vendorEntity.setPhoneNumber(vendorVO.getPhoneNumber());
                vendorEntity.setGst(vendorVO.getGst());
                vendorEntity.setEmail(vendorVO.getEmail());
                vendorEntity.setPan(vendorVO.getPan());
                vendorEntity.setTurnover(vendorVO.getTurnover());
                vendorEntity.setIsActive(vendorVO.getIsActive());
                vendorEntity.setCreatedBy(vendorVO.getCreatedBy());
                vendorEntity.setCreatedAt(vendorVO.getCreatedAt());
                vendorEntity.setModifiedBy(vendorVO.getModifiedBy());
                vendorEntity.setModifiedAt(vendorVO.getModifiedAt());
                
                UserVO userVO=vendorVO.getUser();
                
                UserEntity userEntity = new UserEntity();
                userEntity.setUserId(userVO.getUserId());
                userEntity.setUserName(userVO.getUserName());
                userEntity.setPassword(userVO.getPassword());
                userEntity.setIsActive(userVO.getIsActive());
                userEntity.setCreatedBy(userVO.getCreatedBy());
                userEntity.setCreatedAt(userVO.getCreatedAt());
                userEntity.setModifiedBy(userVO.getModifiedBy());
                userEntity.setModifiedAt(userVO.getModifiedAt());
                
                
                RoleVO roleVo = userVO.getRole();
                
                RoleEntity roleEntity = new RoleEntity();
                roleEntity.setRoleId(roleVo.getRoleId());
                roleEntity.setRoleName(roleVo.getRoleName());
                roleEntity.setIsActive(roleVo.getIsActive());
                roleEntity.setCreatedBy(roleVo.getCreatedBy());
                roleEntity.setCreatedAt(roleVo.getCreatedAt());
                roleEntity.setModifiedBy(roleVo.getModifiedBy());
                roleEntity.setModifiedAt(roleVo.getModifiedAt());
                
                
                vendorEntity.setUser(userEntity);
               
                vendorRepo.save(vendorEntity);
                return true; 
            } else {
                return false;
            }
    }

    @Override
    public boolean deleteVendor(int id) {
    	if(vendorRepo.findById(id).isEmpty()) {
			return false;
		}
    	vendorRepo.deleteById(id);
		return true;
    }
}
