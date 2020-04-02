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
public class SimpleContactDTO {

	@ApiModelProperty(notes = "Id contact")
	private Long id;

	@ApiModelProperty(notes = "First name")
	private String firstName;
}
