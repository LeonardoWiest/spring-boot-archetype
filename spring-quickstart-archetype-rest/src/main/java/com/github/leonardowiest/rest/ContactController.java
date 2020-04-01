package com.github.leonardowiest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.leonardowiest.service.ContactService;
import com.github.util.dto.ContactDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @author Leonardo Wiest
 *
 */
@Api(tags = { "Contact" }, protocols = "http")
@RestController
@RequestMapping("rest/v1/")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@ApiOperation(value = "contacts", response = ContactDTO.class)
	@RequestMapping(value = "contacts", method = RequestMethod.POST)
	public ResponseEntity<ContactDTO> createNewContact(@RequestBody ContactDTO contactDTO) {

		return contactService.createNewContact(contactDTO);
	};

	@ApiOperation(value = "contacts/{id}", response = ContactDTO.class)
	@RequestMapping(value = "contacts/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<ContactDTO> updateContact(
			@PathVariable @ApiParam(value = "Id contact", required = true) Long id,
			@RequestBody ContactDTO contactDTO) {

		return contactService.updateContact(id, contactDTO);
	}
}
