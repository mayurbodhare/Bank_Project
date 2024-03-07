package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Integer accountNo;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Integer mobileNo;
	private String city;
}