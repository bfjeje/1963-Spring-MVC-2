package com.alura.mvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alura.mvc.mudi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	User findUserByUsername(String username);

}
