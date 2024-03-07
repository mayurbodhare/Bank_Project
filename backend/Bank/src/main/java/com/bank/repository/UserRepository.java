package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}