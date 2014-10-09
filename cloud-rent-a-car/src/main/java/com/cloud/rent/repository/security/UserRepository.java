package com.cloud.rent.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.rent.model.security.User;

public interface UserRepository extends JpaRepository<User, String>{

}
