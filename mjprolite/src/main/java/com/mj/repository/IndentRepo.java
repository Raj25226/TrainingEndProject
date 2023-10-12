package com.mj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.mj.entity.IndentEntity;

@Repository
public interface IndentRepo extends JpaRepository<IndentEntity, Integer> {
	
	
	@Query(value = "DELETE FROM INDENT WHERE INDENT_HEADER_ID=?", nativeQuery = true)
	void deleteByIndentHeaderEntity_IndentHeaderId(Integer id);
	@Query(value = "SELECT * FROM INDENT WHERE INDENT_HEADER_ID=?", nativeQuery = true)
	Optional<IndentEntity> getindent(Integer id);
}
