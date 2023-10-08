package com.mj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mj.entity.IndentEntity;

@Repository
public interface IndentRepo extends JpaRepository<IndentEntity, Integer> {

}
