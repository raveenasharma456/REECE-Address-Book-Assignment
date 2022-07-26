package com.example.reeceaddressbook.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.reeceaddressbook.model.MstAddressBook;

@EnableJpaRepositories
public interface AddressBookRepository extends JpaRepository<MstAddressBook, Integer>{

	Optional<MstAddressBook> findByAddressBookType(Integer addressBookType);

}
