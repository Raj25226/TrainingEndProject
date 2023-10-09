package com.mj.service;

import java.util.List;

import com.mj.vo.ManufacturerVO;

public interface ManufacturerService {

List<ManufacturerVO> getAllManufacturer();
	
    ManufacturerVO getManufacturerById(Integer id);
	
	void saveManufacturer(ManufacturerVO manufacturerVO);
	
	Boolean updateManufacturer (ManufacturerVO manufacturerVO);
	
	Boolean deleteManufacturerById(Integer id);
}
