package com.shoppincartdemo.userservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppincartdemo.userservice.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
	
  User findByEmail(String email);
  
}
