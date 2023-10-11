package com.mj.service;

import java.util.List;

import com.mj.vo.UOMVO;



public interface UOMService {
	List<UOMVO> getAllUOM();	
	UOMVO getUOMById(int id);	
	void saveUOM(UOMVO deptVo);
	Boolean updateUOM(UOMVO deptVo);	
	Boolean deleteUOMById(int id);
	List<UOMVO> uomList(int id);
	
}
