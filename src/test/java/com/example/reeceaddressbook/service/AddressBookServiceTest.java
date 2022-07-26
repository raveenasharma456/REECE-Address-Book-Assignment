package com.example.reeceaddressbook.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.reeceaddressbook.dto.ContactDetailsDto;

@SpringBootTest
public class AddressBookServiceTest {

@Autowired
AddressBookService abServce;

@Test
public void testSaveTest() {
	Map<String,String> messageRespMap=new HashMap<>();
	messageRespMap.put("200", "TestGet");
	ContactDetailsDto dto = new ContactDetailsDto("abc", "cde", "String", "String", false, false, null, null);
	assertEquals(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(messageRespMap), abServce.saveContactEnteries("1", dto));
}

}
