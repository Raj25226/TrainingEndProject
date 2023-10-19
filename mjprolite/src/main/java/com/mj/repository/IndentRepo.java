package com.mj.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.mj.entity.IndentEntity;

@Repository
public interface IndentRepo extends JpaRepository<IndentEntity, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM INDENT WHERE INDENT_HEADER_ID=?", nativeQuery = true)
	Integer deleteAllIndentsByHeaderId(Integer id);
//	@Query(value = "SELECT * FROM INDENT WHERE INDENT_HEADER_ID=?", nativeQuery = true)
//	Optional<IndentEntity> getindent(Integer id);
	@Query(value = "SELECT * FROM INDENT WHERE INDENT_HEADER_ID=?", nativeQuery = true)
	List<IndentEntity> getindentall(Integer id);
	
}
