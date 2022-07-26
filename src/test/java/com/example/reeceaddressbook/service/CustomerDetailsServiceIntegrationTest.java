package com.example.reeceaddressbook.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.example.reeceaddressbook.dao.CustomerDetailsRepository;

@SpringBootTest(classes=CustomerDetailsService.class)
public class CustomerDetailsServiceIntegrationTest {

	@Mock
	private CustomerDetailsRepository cdRepo;
	
	@InjectMocks // auto inject customerDetailsRepository
	private CustomerDetailsService cdService = new CustomerDetailsServiceImpl();

	@BeforeEach
	void setMockOutput() {
		when(cdRepo.findLatestCustId()).thenReturn("2");
	}

	@DisplayName("Test Mock customerDetailsService + customerDetailsRepository")
	@Test
	void testGet() {
		 assertEquals(HttpStatus.OK, cdService.findAll().getStatusCode());

	}
}
