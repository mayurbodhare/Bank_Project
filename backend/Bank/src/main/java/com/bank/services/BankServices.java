package com.bank.services;

import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.UserDao;
import com.bank.dto.UserDTO;
import com.bank.entity.UserEntity;
import com.bank.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BankServices {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Transactional
	public UserVO loginUser(Integer accountNo, String password) {
		
		UserVO userVO = new UserVO(null, "waiting to login", 0);
		
		UserEntity userEntity = userDao.getUser(accountNo);
//		log.info(userEntity.toString());
//		check if a/c no. exists.
		if(Objects.nonNull(userEntity)) {
//		check if password matched.
			if(userEntity.getPassword().equals(password)) {
				userVO.setUserDTO(mapper.map(userEntity, UserDTO.class));
				userVO.setMessage("login Successful!!!");
				userVO.setStatus(1);
			}
			else {
				userVO.setMessage("Password does not matched!!!");
				userVO.setStatus(0);
			}
		}else {
			userVO.setMessage("Account does not exist!!!");
			userVO.setStatus(-1);
		}
		
		return userVO;
	}


	public Integer getBalance(Integer accountNo) {
		UserEntity userEntity = userDao.getUser(accountNo);
		return userEntity.getAccountEntity().getBalance();
	}

	@Transactional
	public UserVO transferToWithAmount(Integer accountNo, Integer transferAccount, Integer amount) {
		log.info("Inside transer service!!!");
		log.info(accountNo.toString());
		log.info(transferAccount.toString());
		log.info(amount.toString());
		
		UserVO userVO = new UserVO(null, "waiting to transfer", 0);
		
		UserEntity senderAccount = userDao.getUser(accountNo);
//		check if sender a/c no. exists.
		if(Objects.nonNull(senderAccount)) {
			Integer senderBalance = senderAccount.getAccountEntity().getBalance();
//			check if sender has sufficient funds or not
			if(senderBalance >= amount) {
				UserEntity recipientAccount = userDao.getUser(transferAccount);
//				check if recipient a/c no. exists.
				if(Objects.nonNull(recipientAccount)) {
//					transfer logic
					Integer recipientBalance = recipientAccount.getAccountEntity().getBalance();
					senderAccount.getAccountEntity().setBalance(senderBalance - amount);
					recipientAccount.getAccountEntity().setBalance(recipientBalance + amount);
					userDao.saveUser(recipientAccount);
					UserEntity updatedUserEntity = userDao.saveUser(senderAccount);
					userVO.setUserDTO(mapper.map(updatedUserEntity, UserDTO.class));
					userVO.setMessage("transfer suceesfull!!!");
					userVO.setStatus(1);
				}
				else {
					userVO.setMessage("recepient a/c does not exist!!!");
					userVO.setStatus(-2);
				}
			}
			else {
				userVO.setMessage("insufficient funds!!!");
				userVO.setStatus(0);
			}
		}
		else {
			userVO.setMessage("sender a/c does not exist!!!");
			userVO.setStatus(-1);
		}
		return userVO;
	}
	
}
