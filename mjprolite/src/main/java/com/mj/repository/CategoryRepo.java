package com.mj.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mj.entity.CategoryEntity;


@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer>{

}
