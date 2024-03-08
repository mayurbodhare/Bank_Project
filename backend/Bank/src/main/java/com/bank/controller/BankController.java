package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.UserDTO;
import com.bank.services.BankServices;
import com.bank.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@RestController("")
@Slf4j
public class BankController {
	@Autowired
	private BankServices bankServices;
	
	@PostMapping("")
	public UserVO loginUser(@RequestBody UserDTO userDTO) {
		log.info("Inside login controller!!!");
		log.info(userDTO.toString());
		return bankServices.loginUser(userDTO.getAccountNo(), userDTO.getPassword());
	}
	
	@GetMapping("bal")
	public Integer getBalance(@RequestParam Integer accountNo) {
		return bankServices.getBalance(accountNo);
	}
	
	@PostMapping("trf")
	public UserVO transferBalance(@RequestBody UserDTO userDTO) {
		log.info("Inside login controller!!!");
		log.info(userDTO.getTransferAccount().toString());
		log.info(userDTO.getTransferAmount().toString());
		return bankServices.transferToWithAmount(userDTO.getAccountNo(), userDTO.getTransferAccount(), userDTO.getTransferAmount());
	}
	
	
}
