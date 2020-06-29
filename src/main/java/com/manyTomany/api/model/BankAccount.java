package com.manyTomany.api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bankAccounts")
@JsonIgnoreProperties(value = {"customers"})
public class BankAccount extends AuditModel {
  
  @Id
  @Column(name = "bankaccount_id")
  @GeneratedValue
  private Long bankaccountId;
  
  @Column(name = "account_name", nullable = false)
  private String accountName;
  
  @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "bankAccounts")

  Set<Customer> customers = new HashSet<>();
  
  public BankAccount() {
  }
  
  public Long getBankaccountId() {
	return bankaccountId;
  }
  
  public void setBankaccountId(Long bankaccountId) {
	this.bankaccountId = bankaccountId;
  }
  
  public String getAccountName() {
	return accountName;
  }
  
  public void setAccountName(String accountName) {
	this.accountName = accountName;
  }
  
  public Set<Customer> getCustomers() {
	return customers;
  }
  
  public void setCustomers(Set<Customer> customers) {
	this.customers = customers;
  }
  
  @Override
  public String toString() {
	return "BankAccount{" +
			"bankaccountId=" + bankaccountId +
			", accountName='" + accountName + '\'' +
			", customers=" + customers +
			'}';
  }
}
