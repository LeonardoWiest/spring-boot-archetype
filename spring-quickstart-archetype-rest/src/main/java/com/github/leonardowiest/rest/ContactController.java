package com.github.leonardowiest.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.util.dto.ContactDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Leonardo Wiest
 *
 */
@Api(tags = { "Contact" }, protocols = "http")
@RestController
@RequestMapping("rest/v1/")
public class ContactController {

	
	@ApiOperation(value = "contacts", response = ResponseEntity.class)
	@RequestMapping(value = "contacts", method = RequestMethod.POST)
	public ResponseEntity<ContactDTO> createNewContact(@RequestBody ContactDTO contactDTO) {

		return null;
	};
}
