package com.example.reeceaddressbook.service;

import org.springframework.http.ResponseEntity;

import com.example.reeceaddressbook.dto.ContactDetailsDto;

public interface AddressBookService {

	public ResponseEntity<Object> saveContactEnteries(String addressBookTypeId, ContactDetailsDto contactDetaisDto) ;

}
