package com.mj.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mj.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	
//	@Query(value = "SELECT * FROM user_all u WHERE u.user_name =:userName AND u.password =:password", nativeQuery = true)
	Optional<UserEntity> findByUserNameAndPassword(String userName, String password);
	
	@Query(value = "SELECT * FROM user_all WHERE user_name = :userName", nativeQuery = true)
	Optional<UserEntity> findByUserName(String userName);



}
