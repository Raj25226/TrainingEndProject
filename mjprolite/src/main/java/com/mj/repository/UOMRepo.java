package com.mj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mj.entity.UOMEntity;

@Repository
public interface UOMRepo extends JpaRepository<UOMEntity, Integer>{

	@Query(value="select * from uom where uom_id=category_id",nativeQuery=true)
	List<UOMEntity> showAllUOM(int category_id);
}
