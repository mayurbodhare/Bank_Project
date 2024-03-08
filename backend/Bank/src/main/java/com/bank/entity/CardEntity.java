package com.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardEntity {
	@Id
	private Integer cardNo;
	private Integer pin;
	private Integer accountNo;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private AccountEntity accountEntity;
}
