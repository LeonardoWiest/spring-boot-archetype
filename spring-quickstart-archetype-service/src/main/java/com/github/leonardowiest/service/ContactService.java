package com.github.leonardowiest.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.github.util.dto.ContactDTO;
import com.github.util.dto.SimpleContactDTO;

/**
 * 
 * @author Leonardo Wiest
 *
 */
public interface ContactService {

	public ResponseEntity<ContactDTO> createNewContact(ContactDTO contactDTO);

	public ResponseEntity<ContactDTO> updateContactWithPut(Long id, ContactDTO contactDTO);

	public ResponseEntity<ContactDTO> updateContactWithPatch(Long id, ContactDTO contactDTO);

	public ResponseEntity<List<SimpleContactDTO>> getAllContacts();

	public ResponseEntity<ContactDTO> getSingleContact();

	public ResponseEntity<ContactDTO> deleteContact(Long id);
}
