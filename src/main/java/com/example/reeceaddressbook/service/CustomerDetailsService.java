package com.example.reeceaddressbook.service;

import org.springframework.http.ResponseEntity;

public interface CustomerDetailsService {

	public ResponseEntity<Object> findAll() ;
	public ResponseEntity<Object> findUniqueContacts();
	public ResponseEntity<Object> deleteCustomerEntity(Long custId);

}
