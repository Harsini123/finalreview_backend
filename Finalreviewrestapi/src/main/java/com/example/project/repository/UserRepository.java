package com.example.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.project.model.User;








public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	
	
    

   
}