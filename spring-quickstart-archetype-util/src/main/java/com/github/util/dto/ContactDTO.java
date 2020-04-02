package com.github.util.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @author Leonardo Wiest
 *
 */
@ApiModel
@Data
public class ContactDTO {

	@ApiModelProperty(notes = "First name")
	private String firstName;

	@ApiModelProperty(notes = "Last name")
	private String lastName;
}
