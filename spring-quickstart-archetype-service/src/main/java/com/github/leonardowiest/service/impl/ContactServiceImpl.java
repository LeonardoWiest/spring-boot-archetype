package com.github.leonardowiest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.leonardowiest.domain.Contact;
import com.github.leonardowiest.repository.ContactRepository;
import com.github.leonardowiest.service.ContactService;
import com.github.util.dto.ContactDTO;
import com.github.util.dto.SimpleContactDTO;

/**
 * 
 * @author Leonardo Wiest
 *
 */
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public ResponseEntity<ContactDTO> createNewContact(ContactDTO contactDTO) {

		Contact newContact = new Contact();
		newContact.setFirstName(contactDTO.getFirstName());
		newContact.setLastName(contactDTO.getLastName());
		
		contactRepository.saveAndFlush(newContact);

		return new ResponseEntity<ContactDTO>(contactDTO, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ContactDTO> updateContactWithPut(Long id, ContactDTO contactDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ContactDTO> updateContactWithPatch(Long id, ContactDTO contactDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<SimpleContactDTO>> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ContactDTO> getSingleContact() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ContactDTO> deleteContact(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
