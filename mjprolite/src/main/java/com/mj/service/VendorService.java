package com.mj.service;

import java.util.List;

import com.mj.vo.VendorVO;

public interface VendorService {
	List<VendorVO> getAllVendor();
	VendorVO getVendorById(int id);
	boolean saveVendor(VendorVO vendorVO);
	boolean updateVendor(VendorVO vendorVo);
	boolean deleteVendor(int id);

}
