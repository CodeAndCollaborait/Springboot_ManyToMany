package com.manyTomany.api.controller;


import com.manyTomany.api.model.BankAccount;
import com.manyTomany.api.model.Customer;
import com.manyTomany.api.repository.BankAccountRepository;
import com.manyTomany.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class BankAccountController {
  
  @Autowired
  private BankAccountRepository bankAccountRepository;
  
  
  @Autowired
  private CustomerRepository customerRepository;
  
  
  @GetMapping("/bankaccounts")
  public Page<BankAccount> bankAccountPage (Pageable pageable){
    return  bankAccountRepository.findAll(pageable);
  }
  
  
  
  
}
  

