package com.mj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mj.entity.IndentHeaderEntity;

@Repository
public interface IndentHeaderRepo extends JpaRepository<IndentHeaderEntity, Integer> {
	
	public List<IndentHeaderEntity> findAllByUserId(Integer id);
	
}
