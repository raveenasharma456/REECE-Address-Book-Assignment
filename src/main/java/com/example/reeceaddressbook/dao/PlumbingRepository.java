package com.example.reeceaddressbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.reeceaddressbook.model.PlumbingAddressBook;

@EnableJpaRepositories
public interface PlumbingRepository extends JpaRepository<PlumbingAddressBook, Integer> {

}
