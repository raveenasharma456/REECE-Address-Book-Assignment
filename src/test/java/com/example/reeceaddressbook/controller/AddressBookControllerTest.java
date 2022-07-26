package com.example.reeceaddressbook.controller;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes=AddressBookController.class)
public class AddressBookControllerTest {

    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getHello() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/").toString(), String.class);
        assertEquals("Hello Controller", response.getBody());

    }
}