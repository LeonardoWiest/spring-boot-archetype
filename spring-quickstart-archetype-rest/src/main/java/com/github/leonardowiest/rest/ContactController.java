package com.github.leonardowiest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.leonardowiest.service.ContactService;
import com.github.util.dto.ContactDTO;
import com.github.util.dto.SimpleContactDTO;

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

	@ApiOperation(value = "Create New Contact", response = ContactDTO.class)
	@RequestMapping(value = "contacts", method = RequestMethod.POST)
	public ResponseEntity<ContactDTO> createNewContact(@RequestBody ContactDTO contactDTO) {

		return contactService.createNewContact(contactDTO);
	};

	@ApiOperation(value = "Update Contact with PUT", response = ContactDTO.class)
	@RequestMapping(value = "contacts/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ContactDTO> updateContactWithPut(
			@PathVariable @ApiParam(value = "Id contact", required = true) Long id,
			@RequestBody ContactDTO contactDTO) {

		return contactService.updateContactWithPut(id, contactDTO);
	}

	@ApiOperation(value = "Update Contact with PATCH", response = ContactDTO.class)
	@RequestMapping(value = "contacts/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<ContactDTO> updateContactWithPatch(
			@PathVariable @ApiParam(value = "Id contact", required = true) Long id,
			@RequestBody ContactDTO contactDTO) {

		return contactService.updateContactWithPatch(id, contactDTO);
	}

	@ApiOperation(value = "List All Contacts", response = ContactDTO.class)
	@RequestMapping(value = "contacts", method = RequestMethod.GET)
	public ResponseEntity<List<SimpleContactDTO>> getAllContacts() {

		return contactService.getAllContacts();
	}

	@ApiOperation(value = "List One Contact", response = ContactDTO.class)
	@RequestMapping(value = "contacts/{id}", method = RequestMethod.GET)
	public ResponseEntity<ContactDTO> getSingleContact(
			@PathVariable @ApiParam(value = "Id contact", required = true) Long id) {

		return contactService.getSingleContact();
	}

	@ApiOperation(value = "Delete Contact", response = ContactDTO.class)
	@RequestMapping(value = "contacts/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ContactDTO> deleteContact(
			@PathVariable @ApiParam(value = "Id contact", required = true) Long id) {

		return contactService.deleteContact(id);
	}
}
