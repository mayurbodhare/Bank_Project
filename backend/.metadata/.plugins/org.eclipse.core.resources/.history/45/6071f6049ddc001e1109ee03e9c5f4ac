package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.UserEntity;
import com.bank.services.BankServices;

@RestController("online")
public class BankController {
	
	@Autowired
	private BankServices bankServices;
	
	@PostMapping("")
	public UserEntity loginUser(@RequestBody UserEntity accountDTO) {
		
		return accountDTO;
	}
}
