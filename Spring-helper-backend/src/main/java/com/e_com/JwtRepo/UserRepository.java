package com.e_com.JwtRepo;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import com.e_com.Entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	public Users findByUserName(String username);
}
