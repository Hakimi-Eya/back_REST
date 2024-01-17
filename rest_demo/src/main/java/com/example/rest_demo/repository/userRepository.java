package com.example.rest_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest_demo.model.user;

@Repository
public interface userRepository extends JpaRepository<user,Integer> {

    user findByEmail(String email);
}
