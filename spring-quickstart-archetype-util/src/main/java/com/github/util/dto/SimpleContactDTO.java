package com.github.util.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Leonardo Wiest
 *
 */
@ApiModel
public class SimpleContactDTO {

	@ApiModelProperty(notes = "Id contact")
	private Long id;

	@ApiModelProperty(notes = "First name")
	private String firstName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
