package com.bank.vo;

import com.bank.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	private UserDTO userDTO;
	private String message;
	private Integer status;
}
 