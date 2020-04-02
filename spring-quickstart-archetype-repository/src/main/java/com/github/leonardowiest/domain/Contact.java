package com.github.leonardowiest.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * 
 * @author Leonardo Wiest
 *
 */
@Data
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long accountId;

	private String firstName;

	private String lastName;

	private String phone;
}
