package com.manyTomany.api.controller;


import com.manyTomany.api.model.Customer;
import com.manyTomany.api.repository.BankAccountRepository;
import com.manyTomany.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class CustomerController {
  
  @Autowired
  private CustomerRepository customerRepository;
  
  @Autowired
  private BankAccountRepository bankAccountRepository;
  
  @GetMapping("/customers")
  public ResponseEntity<Customer> customerPage(Pageable pageable) {
	 return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
  }

  
//    @GetMapping("/customers")
//  public Page<Customer> customerPage(Pageable pageable) {
//	 return customerRepository.findAll(pageable);
//  }
//
  
  @PostMapping("/customers")
  public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
    return  new ResponseEntity<>(customerRepository.save(customer), HttpStatus.CREATED);
  }
  
  
}
