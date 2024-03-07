package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
	private String useeId;
	private String password;
	private Integer AccountNo;
	private Float Balance;
	private String FirstName;
	private String LastName;
	private String Email;
	private Integer MobileNo;
	private String city;
}