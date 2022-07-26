package com.example.reeceaddressbook.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.reeceaddressbook.dao.AddressBookRepository;
import com.example.reeceaddressbook.dao.CustomerDetailsRepository;
import com.example.reeceaddressbook.model.MstAddressBook;
import com.example.reeceaddressbook.model.MstCustomerDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"classpath:application.properties"})
@SpringBootTest(classes=AddressBookController.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AddressBookControllerIntegrationTest {
	 
private static final ObjectMapper om = new ObjectMapper();

@Autowired
private TestRestTemplate restTemplate;
    
@MockBean
private AddressBookRepository abRepository;

@MockBean
private CustomerDetailsRepository cdRepository;

@Before
public void init() {
    MstCustomerDetails custDetils = new MstCustomerDetails(1L, "FisrtName", "String", "String","String",true,true, null, null, null, null);
    when(cdRepository.findUniqueContactsInAddressBooks()).thenReturn(List.of(custDetils));
}

@Test
public void save_contacts_OK() throws Exception {
    MstCustomerDetails newContacts=new MstCustomerDetails();
    newContacts.setContactNo("+61767665555");
    newContacts.setFirstName("Test");
    newContacts.setMiddleName("Test");
    newContacts.setLastName("Test");
    newContacts.setPlumbingCustomer(false);
    newContacts.setTilesCustomer(true);
    newContacts.setCreatedBy("test");
	when(cdRepository.save(any(MstCustomerDetails.class))).thenReturn(newContacts);
    String expected = om.writeValueAsString(newContacts);
    ResponseEntity<String> response = restTemplate.postForEntity("/saveContactEnteries", newContacts, String.class);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    JSONAssert.assertEquals(expected, response.getBody(), false);
    verify(abRepository, times(1)).save(any(MstAddressBook.class));
}

@Test
public void delete_customer_OK() {
    doNothing().when(cdRepository.deleteByCustId(Long.getLong("1")));
    HttpEntity<String> entity = new HttpEntity<>(null, new HttpHeaders());
    ResponseEntity<String> response = restTemplate.exchange("/deleteCustomerEntity", HttpMethod.DELETE, entity, String.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    verify(cdRepository, times(1)).deleteByCustId(Long.getLong("1"));
}

@Test
public void find_allContacts_OK() throws Exception {
    List<MstCustomerDetails> contacts = Arrays.asList(
            new MstCustomerDetails(Long.getLong("1"),"string","string", "string", "Test", false, false, null, null, null, null),
            new MstCustomerDetails(Long.getLong("2"),"string","string", "string", "Test", false, false, null, null, null, null));
    when(cdRepository.findAll()).thenReturn(contacts);
    String expected = om.writeValueAsString(contacts);
    ResponseEntity<String> response = restTemplate.getForEntity("/printAllContacts", String.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    JSONAssert.assertEquals(expected, response.getBody(), false);
    verify(cdRepository, times(1)).findAll();
}


@Test
public void find_uniqueContacts_OK() throws Exception {
    List<MstCustomerDetails> contacts = Arrays.asList(
            new MstCustomerDetails(Long.getLong("1"),"string","string", "string", null, false, false, null, null, null, null));
    when(cdRepository.findUniqueContactsInAddressBooks()).thenReturn(contacts);
    String expected = om.writeValueAsString(contacts);
    ResponseEntity<String> response = restTemplate.getForEntity("/printUniqueContacts", String.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    JSONAssert.assertEquals(expected, response.getBody(), false);
    verify(cdRepository, times(1)).findAll();
}

}
