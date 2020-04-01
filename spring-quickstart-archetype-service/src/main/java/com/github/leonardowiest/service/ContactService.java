package com.github.leonardowiest.service;

import org.springframework.http.ResponseEntity;

import com.github.util.dto.ContactDTO;

/**
 * 
 * @author Leonardo Wiest
 *
 */
public interface ContactService {

	public ResponseEntity<ContactDTO> createNewContact(ContactDTO contactDTO);

	public ResponseEntity<ContactDTO> updateContact(Long id, ContactDTO contactDTO);
}
