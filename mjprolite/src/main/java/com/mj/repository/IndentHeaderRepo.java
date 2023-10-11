package com.mj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mj.entity.IndentHeaderEntity;

@Repository
public interface IndentHeaderRepo extends JpaRepository<IndentHeaderEntity, Integer> {
	
//	public List<IndentHeaderEntity> findAllByUserId(Integer id);
	
	public Optional<IndentHeaderEntity> findByDescription(String description);
	
}
