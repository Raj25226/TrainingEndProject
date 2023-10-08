package com.mj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mj.entity.IndentHeaderEntity;

@Repository
public interface IndentHeaderRepo extends JpaRepository<IndentHeaderEntity, Integer> {

}
