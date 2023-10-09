package com.mj.service.impl;

import com.mj.entity.VendorEntity;
import com.mj.repository.VendorRepo;
import com.mj.service.VendorService;
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
                VendorEntity existingVendorEntity = vendorEntityOptional.get();
                existingVendorEntity.setVendorName(vendorVO.getVendorName());
                existingVendorEntity.setPhoneNumber(vendorVO.getPhoneNumber());
                existingVendorEntity.setGst(vendorVO.getGst());
                existingVendorEntity.setEmail(vendorVO.getEmail());
                existingVendorEntity.setPan(vendorVO.getPan());
                existingVendorEntity.setTurnover(vendorVO.getTurnover());
                existingVendorEntity.setIsActive(vendorVO.getIsActive());
                existingVendorEntity.setCreatedBy(vendorVO.getCreatedBy());
                existingVendorEntity.setCreatedAt(vendorVO.getCreatedAt());
                existingVendorEntity.setModifiedBy(vendorVO.getModifiedBy());
                existingVendorEntity.setModifiedAt(vendorVO.getModifiedAt());
               
                vendorRepo.save(existingVendorEntity);
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
