package com.manyTomany.api.repository;

import com.manyTomany.api.model.BankAccount;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
  
  Page<BankAccount> findByCustomers(Long customerId, Pageable pageable);
  
  
  
}
