package com.bank.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.entity.UserEntity;
import com.bank.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;


@Repository
@Transactional
@Slf4j
public class UserDao {
	
	@Autowired
	UserRepository userRepository;

	public UserEntity getUser(Integer accountNo) {
		log.info("Inside getUser dao!!!");
		Boolean isPresent = userRepository.existsById(accountNo);
		if(isPresent) {
			Optional<UserEntity> optional = userRepository.findById(accountNo);
			UserEntity userEntity = optional.get();			
			return userEntity;			
		}
		else {
			return null;			
		}		
	}

	public UserEntity saveUser(UserEntity userEntity) {
		log.info("Inside login dao!!!");
		return userRepository.save(userEntity);
	}
	

}
