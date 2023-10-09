package com.mj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mj.entity.UOMEntity;

@Repository
public interface UOMRepo extends JpaRepository<UOMEntity, Integer>{

}
