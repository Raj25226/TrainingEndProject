package com.mj.service;

import java.util.List;

import com.mj.vo.RoleVO;

public interface RoleService {
	
	 List<RoleVO> getAllRoles();
	 RoleVO getRoleById(int id);
	 boolean saveRole(RoleVO roleVo);
	 boolean updateRole (RoleVO roleVo);
	 boolean deleteRole(int id);

}
