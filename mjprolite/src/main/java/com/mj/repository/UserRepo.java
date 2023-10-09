package com.mj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mj.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>{

}
