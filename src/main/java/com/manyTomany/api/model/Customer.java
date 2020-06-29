package com.manyTomany.api.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends AuditModel {
  
  @Id
  @Column(name = "customer_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long customerId;
  
  @Column(name = "full_name", nullable = false)
  private String fullName;
  
  @Column(name = "address", nullable = false)
  private String address;
  
  //Many to Many.. One customer can have multiple account ?
  // Each account types must be unique ... set ..
  
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "customer_bankaccount", joinColumns = {@JoinColumn(name = "customer_id")},
		  inverseJoinColumns = {@JoinColumn(name = "bankaccount_id", referencedColumnName = "bankaccount_id")})
  Set<BankAccount> bankAccounts = new HashSet<>();
  
  public Customer() {
  }
  
  public Long getCustomerId() {
	return customerId;
  }
  
  public void setCustomerId(Long customerId) {
	this.customerId = customerId;
  }
  
  public String getFullName() {
	return fullName;
  }
  
  public void setFullName(String fullName) {
	this.fullName = fullName;
  }
  
  public String getAddress() {
	return address;
  }
  
  public void setAddress(String address) {
	this.address = address;
  }
  
  public Set<BankAccount> getBankAccounts() {
	return bankAccounts;
  }
  
  public void setBankAccounts(Set<BankAccount> bankAccounts) {
	this.bankAccounts = bankAccounts;
  }
  
  @Override
  public String toString() {
	return "Customer{" +
			"customerId=" + customerId +
			", fullName='" + fullName + '\'' +
			", address='" + address + '\'' +
			", bankAccounts=" + bankAccounts +
			'}';
  }
}
