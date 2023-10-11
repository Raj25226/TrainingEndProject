package com.mj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.RoleEntity;
import com.mj.repository.RoleRepo;
import com.mj.service.RoleService;
import com.mj.vo.RoleVO;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepo roleRepo;

    @Override
    public List<RoleVO> getAllRoles() {
        List<RoleVO> roleVOList = new ArrayList<>();
        List<RoleEntity> roleEntityList = roleRepo.findAll();

        for (RoleEntity roleEntity : roleEntityList) {
            RoleVO roleVO = new RoleVO();
            roleVO.setRoleId(roleEntity.getRoleId());
            roleVO.setRoleName(roleEntity.getRoleName());
            roleVO.setIsActive(roleEntity.getIsActive());
            roleVO.setCreatedBy(roleEntity.getCreatedBy());
            roleVO.setCreatedAt(roleEntity.getCreatedAt());
            roleVO.setModifiedBy(roleEntity.getModifiedBy());
            roleVO.setModifiedAt(roleEntity.getModifiedAt());

            roleVOList.add(roleVO);
        }

        return roleVOList;
    }

    @Override
    public RoleVO getRoleById(int id) {
        Optional<RoleEntity> roleEntityOptional = roleRepo.findById(id);

        if (roleEntityOptional.isPresent()) {
        	
            RoleEntity roleEntity = roleEntityOptional.get();
            
            RoleVO roleVO = new RoleVO();
            roleVO.setRoleId(roleEntity.getRoleId());
            roleVO.setRoleName(roleEntity.getRoleName());
            roleVO.setIsActive(roleEntity.getIsActive());
            roleVO.setCreatedBy(roleEntity.getCreatedBy());
            roleVO.setCreatedAt(roleEntity.getCreatedAt());
            roleVO.setModifiedBy(roleEntity.getModifiedBy());
            roleVO.setModifiedAt(roleEntity.getModifiedAt());

            return roleVO;
        } 
        else {
            return null; 
        }
    }

    @Override
    public boolean saveRole(RoleVO roleVo) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName(roleVo.getRoleName());
        roleEntity.setIsActive(roleVo.getIsActive());
        roleEntity.setCreatedBy(roleVo.getCreatedBy());
        roleEntity.setCreatedAt(roleVo.getCreatedAt());
        roleEntity.setModifiedBy(roleVo.getModifiedBy());
        roleEntity.setModifiedAt(roleVo.getModifiedAt());

        RoleEntity savedRoleEntity = roleRepo.save(roleEntity);

        if (savedRoleEntity != null) {
            return true; 
        } else {
            return false; 
        }
    }

    @Override
    public boolean updateRole(RoleVO roleVo) {
        Optional<RoleEntity> roleEntityOptional = roleRepo.findById(roleVo.getRoleId());

        if (roleEntityOptional.isPresent()) {
        	 RoleEntity roleEntity = roleEntityOptional.get();
             roleEntity.setRoleId(roleVo.getRoleId());
             roleEntity.setRoleName(roleVo.getRoleName());
             roleEntity.setIsActive(roleVo.getIsActive());
             roleEntity.setCreatedBy(roleVo.getCreatedBy());
             roleEntity.setCreatedAt(roleVo.getCreatedAt());
             roleEntity.setModifiedBy(roleVo.getModifiedBy());
             roleEntity.setModifiedAt(roleVo.getModifiedAt());

             roleRepo.save(roleEntity);

            return true;
        } else {
            return false; 
        }
    }

    @Override
    public boolean deleteRole(int id) {
    	if(roleRepo.findById(id).isEmpty()) {
			return false;
		}
    	roleRepo.deleteById(id);
		return true;
    }
}
