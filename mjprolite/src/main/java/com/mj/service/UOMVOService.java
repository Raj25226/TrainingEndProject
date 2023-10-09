package com.mj.service;

import java.util.List;

import com.mj.vo.UOMVO;



public interface UOMVOService {
	List<UOMVO> getAllUOM();	
	UOMVO getUOMById(int id);	
	void saveUOM(UOMVO deptVo);
	void updateUOM(UOMVO deptVo);	
	void deleteUOMById(int id);
	
}
