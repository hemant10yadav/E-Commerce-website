package com.e_com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_com.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String username);
}
