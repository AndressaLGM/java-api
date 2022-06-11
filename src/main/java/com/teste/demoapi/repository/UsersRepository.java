package com.teste.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.demoapi.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
  
}
