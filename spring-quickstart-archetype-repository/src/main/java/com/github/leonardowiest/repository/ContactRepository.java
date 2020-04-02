package com.github.leonardowiest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.leonardowiest.domain.Contact;

/**
 * 
 * @author Leonardo Wiest
 *
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
