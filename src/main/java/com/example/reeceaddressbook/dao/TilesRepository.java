package com.example.reeceaddressbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.reeceaddressbook.model.TilesAddressBook;

@EnableJpaRepositories
public interface TilesRepository extends JpaRepository<TilesAddressBook, Integer> {

}

	