package com.mj.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mj.entity.IndentHeaderEntity;

@Repository
public interface IndentHeaderRepo extends JpaRepository<IndentHeaderEntity, Integer> {
	
//	public List<IndentHeaderEntity> findAllByUserId(Integer id);
	
	public Optional<IndentHeaderEntity> findByDescription(String description);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE INDENT_HEADER SET NET_PRICE=? WHERE INDENT_HEADER_ID=?", nativeQuery = true)
	public int updateNetPrice(Long price,Integer id);
	
}
