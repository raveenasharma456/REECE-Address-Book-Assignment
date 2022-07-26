package com.example.reeceaddressbook.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.reeceaddressbook.dao.AddressBookRepository;
import com.example.reeceaddressbook.dao.CustomerDetailsRepository;
import com.example.reeceaddressbook.dao.PlumbingRepository;
import com.example.reeceaddressbook.dao.TilesRepository;
import com.example.reeceaddressbook.dto.ContactDetailsDto;
import com.example.reeceaddressbook.exceptions.AddressTypeNotFoundException;
import com.example.reeceaddressbook.model.MstAddressBook;
import com.example.reeceaddressbook.model.MstCustomerDetails;
import com.example.reeceaddressbook.model.PlumbingAddressBook;
import com.example.reeceaddressbook.model.TilesAddressBook;

@Service
@Transactional
public class AddressBookServiceImpl implements AddressBookService {
	
	private static final Logger logger = LogManager.getLogger(AddressBookServiceImpl.class);

	static Map<String,String> messageRespMap=new HashMap<>();

	@Autowired
	CustomerDetailsRepository custDetailsRepo;

	@Autowired
	AddressBookRepository addressbookRepo;

	@Autowired
	PlumbingRepository plumbingRepo;

	@Autowired
	TilesRepository tilesRepo;
	
	@Override
	public ResponseEntity<Object> saveContactEnteries(String addressBookTypeId,
			ContactDetailsDto contactDetaisDto) {
		logger.info("<---------Saving Contact Enteries---------->");
		if(null!=addressBookTypeId) {
		Optional<MstAddressBook> addressObject = addressbookRepo.findByAddressBookType(Integer.parseInt(addressBookTypeId));
		logger.info("Address Object :: --------> "+addressObject);
		logger.info("addressBookTypeId in saveContactEnteries is Present :: ", !addressObject.isPresent() );
		if (!addressObject.isPresent())
			throw new AddressTypeNotFoundException(addressBookTypeId+" is Invalid ");
		else {
			MstCustomerDetails custDetails = convertToCustomerModel(contactDetaisDto);
			custDetailsRepo.save(custDetails);
			String custId = custDetailsRepo.findLatestCustId();
			logger.info( "<-----------"+ custId + " :: customer Id fetched from Customer Table after saving customer's personal details");
			if(contactDetaisDto.isPlumbingCustomer()) {
				PlumbingAddressBook plumbingAdressBook = convertToPlumbingModel(custId,contactDetaisDto);
				plumbingRepo.save(plumbingAdressBook);
			}
			if(contactDetaisDto.isTilesCustomer()) {
				TilesAddressBook tilesAddressBook = convertToTilesModel(custId,contactDetaisDto );
				tilesRepo.save(tilesAddressBook);
			}
		}
		}
		messageRespMap.put("200", "Customer's address book data saved Successfully");
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(messageRespMap);			 
	}

	private TilesAddressBook convertToTilesModel(String custId, ContactDetailsDto contactDetailsDto) {
		TilesAddressBook tilesDetails=new TilesAddressBook();
		tilesDetails.setCreatedBy(contactDetailsDto.getCreatedBy());
		tilesDetails.setCreatedDate(new Date());
		MstCustomerDetails custDetails = new MstCustomerDetails();
		custDetails .setCustId(Long.getLong(custId));
		custDetails.setContactNo(contactDetailsDto.getContactNo());
		custDetails.setCreatedBy(contactDetailsDto.getCreatedBy());
		custDetails.setCreatedDt(new Date());
		custDetails.setFirstName(contactDetailsDto.getFirstName());
		custDetails.setLastName(contactDetailsDto.getLastName());
		custDetails.setMiddleName(contactDetailsDto.getMiddleName());
		custDetails.setPlumbingCustomer(contactDetailsDto.isPlumbingCustomer());
		custDetails.setTilesCustomer(contactDetailsDto.isTilesCustomer());
		tilesDetails.setCustDetails(custDetails);
		tilesDetails.setTilesAddBookId(Long.getLong(java.util.UUID.randomUUID().toString()));
		return tilesDetails;
	}

	private PlumbingAddressBook convertToPlumbingModel(String custId, ContactDetailsDto contactDetailsDto) {
		PlumbingAddressBook plumbingDetails =new PlumbingAddressBook();
		plumbingDetails.setCreatedBy(contactDetailsDto.getCreatedBy());
		plumbingDetails.setCreatedDate(new Date());
		MstCustomerDetails custDetails = new MstCustomerDetails();
		custDetails .setCustId(Long.getLong(custId));
		custDetails.setContactNo(contactDetailsDto.getContactNo());
		custDetails.setCreatedBy(contactDetailsDto.getCreatedBy());
		custDetails.setCreatedDt(new Date());
		custDetails.setFirstName(contactDetailsDto.getFirstName());
		custDetails.setLastName(contactDetailsDto.getLastName());
		custDetails.setMiddleName(contactDetailsDto.getMiddleName());
		custDetails.setPlumbingCustomer(contactDetailsDto.isPlumbingCustomer());
		custDetails.setTilesCustomer(contactDetailsDto.isTilesCustomer());
		plumbingDetails.setCustDetails(custDetails);
		plumbingDetails.setPlumbingAddBookId(Long.getLong(java.util.UUID.randomUUID().toString()));
		return plumbingDetails;
	}

	private MstCustomerDetails convertToCustomerModel(ContactDetailsDto dto){
		MstCustomerDetails custDetails = new MstCustomerDetails();
		custDetails .setContactNo(dto.getContactNo());
		custDetails.setCreatedBy(dto.getCreatedBy());
		custDetails.setCreatedDt(new Date());
		custDetails.setFirstName(dto.getFirstName());
		custDetails.setLastName(dto.getLastName());
		custDetails.setMiddleName(dto.getMiddleName());
		custDetails.setPlumbingCustomer(dto.isPlumbingCustomer());
		custDetails.setTilesCustomer(dto.isTilesCustomer());
		custDetails.setCreatedDt(dto.getCreatedDt());
		custDetails.setCreatedBy(dto.getCreatedBy());
		return custDetails; 

	}
}
