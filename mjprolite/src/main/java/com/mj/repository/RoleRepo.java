package com.mj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mj.entity.RoleEntity;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity,Integer>{

}
