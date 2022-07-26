package com.example.reeceaddressbook.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.reeceaddressbook.model.MstCustomerDetails;

@EnableJpaRepositories
public interface CustomerDetailsRepository extends JpaRepository<MstCustomerDetails, Integer>{ 
	
	Optional<MstCustomerDetails> deleteByCustId(Long custId);

	@Query(value = "SELECT * FROM MST_CUSTOMER_DETAILS CD WHERE CD.IS_PLUMBING_CUSTOMER=TRUE and CD.IS_TILES_CUSTOMER=TRUE ", nativeQuery = true)
	List<MstCustomerDetails> findUniqueContactsInAddressBooks();

	@Query(value = "SELECT CUSTOMER_ID FROM MST_CUSTOMER_DETAILS CD order by CUSTOMER_ID DESC LIMIT 1", nativeQuery = true)
	String findLatestCustId();

}
