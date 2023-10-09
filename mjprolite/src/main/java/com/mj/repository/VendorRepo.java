package com.mj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mj.entity.VendorEntity;

@Repository
public interface VendorRepo extends JpaRepository<VendorEntity, Integer>{

}
