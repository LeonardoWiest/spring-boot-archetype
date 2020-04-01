package com.github.leonardowiest.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.leonardowiest.service.ContactService;
import com.github.util.dto.ContactDTO;

@Service
public class ContactServiceImpl implements ContactService {

	@Override
	public ResponseEntity<ContactDTO> createNewContact(ContactDTO contactDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
