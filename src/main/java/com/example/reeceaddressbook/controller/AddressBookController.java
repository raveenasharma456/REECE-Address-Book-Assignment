package com.example.reeceaddressbook.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.reeceaddressbook.dto.ContactDetailsDto;
import com.example.reeceaddressbook.exceptions.CustomerNotFoundException;
import com.example.reeceaddressbook.service.AddressBookService;
import com.example.reeceaddressbook.service.CustomerDetailsService;


/**
 * The Class AddressBookController for retrieving addresses and conditions for the AddressBook
 * application.
 */
@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

	private static final Logger logger = LogManager.getLogger(AddressBookController.class);

	@Autowired
	private AddressBookService abservice;

	@Autowired
	private CustomerDetailsService custService;

	//Users should be able to add new contact entries 
	//Users should be able to maintain multiple address book
	/**
	 * Save new contact Entries
	 */
	/**
	 * @param transId
	 * @param contactDetaisDto
	 * @return
	 */
	@PostMapping(value = "/saveContactEnteries")
	public ResponseEntity<Object> saveContacts(@RequestParam(value = "addressBookTypeId", required = true) String adressBookTypeId,
			@RequestBody ContactDetailsDto contactDetaisDto) {
		logger.info("AddressBookController saveContacts method");
		return abservice.saveContactEnteries(adressBookTypeId, contactDetaisDto);
	}	

	//Users should be able to remove existing contact 
	/**
	 * @param custId
	 * @return
	 */
	@DeleteMapping(value = "/removeExistingContactEnteries")
	public ResponseEntity<Object> deleteContactEnteries(@RequestParam(value = "custId", required = true) Long custId)throws CustomerNotFoundException {
		logger.debug("AddressBookController deleteContactEnteries method");
		return custService.deleteCustomerEntity(custId);
	}	

	//Users should be able to print all contacts
	/**
	 * @return
	 */
	@GetMapping(value = "/printAllContacts")
	public ResponseEntity<Object> printAllContacts() {
		logger.debug("AddressBookController printAllContacts method");
		return custService.findAll();
	}

	//Users should be able to print a unique set of all contacts across multiple address book			/**
	/* * @return
	 */
	@GetMapping(value = "/printUniqueContacts")
	public ResponseEntity<Object> printUniqueContacts() {
		logger.debug("AddressBookController printUniqueContacts method");
		return custService.findUniqueContacts();
	}
}
