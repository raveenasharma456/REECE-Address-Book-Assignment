package com.example.reeceaddressbook.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.reeceaddressbook.dao.CustomerDetailsRepository;
import com.example.reeceaddressbook.model.MstCustomerDetails;

@Service
@Transactional
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	static Map<String,String> messageRespMap=new HashMap<>();
	
	@Autowired
	CustomerDetailsRepository custDetailsRepo;

	@Override
	public ResponseEntity<Object> deleteCustomerEntity(Long custId) {
		Optional<MstCustomerDetails> deletedData = custDetailsRepo.deleteByCustId(custId);
		messageRespMap.put("200", "Customer entery deleted Successfully");
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(messageRespMap); 
	}

	@Override
	public ResponseEntity<Object> findAll() {
		List<MstCustomerDetails> custDetails=custDetailsRepo.findAll();
		messageRespMap.put("200", "Customer's data fethced Successfully");
		if (custDetails == null)
			return ResponseEntity.noContent().build();
		else
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(custDetails);		
	}

	@Override
	public ResponseEntity<Object> findUniqueContacts() {
		List<MstCustomerDetails> custDetails=custDetailsRepo.findUniqueContactsInAddressBooks();
		if (custDetails == null)
			return ResponseEntity.noContent().build();
		else
		messageRespMap.put("200", "Unique data fethced Successfully");
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(custDetails);
	}
	
}
