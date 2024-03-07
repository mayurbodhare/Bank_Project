package com.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
	@Id
	private Integer accountNo;

	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Integer mobileNo;
	private String city;

	@OneToOne 
	@JoinColumn(name = "accountNo") 
	private AccountEntity accountEntity;
}