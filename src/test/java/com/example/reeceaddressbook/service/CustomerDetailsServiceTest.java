package com.example.reeceaddressbook.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

//Junit 5 Test

@SpringBootTest(classes = CustomerDetailsService.class)
public class CustomerDetailsServiceTest {

	@Autowired(required=true)
	CustomerDetailsService cdService;

	@DisplayName("Test Spring @Autowired Integration")
	@Test
	public void testDeleteTest() {
		Map<String,String> messageRespMap=new HashMap<>();
		messageRespMap.put("200", "String");
		assertEquals(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(messageRespMap), cdService.deleteCustomerEntity(Long.getLong("1")));
	}

	@Test
	public void testFetchAllTest() {
		Map<String,String> messageRespMap=new HashMap<>();
		messageRespMap.put("200", "TestGet");
		assertEquals(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(messageRespMap), cdService.findAll());
	}

	@Test
	public void testFetcUniqueTest() {
		Map<String,String> messageRespMap=new HashMap<>();
		messageRespMap.put("200", "TestGetUnique");
		assertEquals(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(messageRespMap), cdService.findUniqueContacts());
	}
}
