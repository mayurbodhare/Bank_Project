package com.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.deo.UserDeo;

@Service
public class BankServices {
	@Autowired
	private UserDeo userDeo;
	
}
