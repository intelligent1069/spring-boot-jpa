package com.intelligent1069.spring.jpa.springbootjpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intelligent1069.spring.jpa.springbootjpa.entiry.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
