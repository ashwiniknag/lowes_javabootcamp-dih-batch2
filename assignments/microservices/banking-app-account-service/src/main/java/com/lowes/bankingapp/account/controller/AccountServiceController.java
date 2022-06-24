package com.lowes.bankingapp.account.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowes.bankingapp.account.model.Account;
import com.lowes.bankingapp.account.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountServiceController {
//   private static Map<String, Account> accountRepo = new HashMap<>();
   private static Logger log = LoggerFactory.getLogger(AccountServiceController.class);
   
   @Autowired
   AccountService accountService;
   
   
   
   @DeleteMapping("/{id}")
   public ResponseEntity<Object> delete(@PathVariable("id") int id) { 
//      accountRepo.remove(id);
	   
	   accountService.deleteAccount(id);
	   
      return new ResponseEntity<>("Account is deleted successsfully", HttpStatus.OK);
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<Object> updateAccount(@PathVariable("id") int id, @RequestBody Account account) { 
//      productRepo.remove(id);
//      product.setId(id);
//      productRepo.put(id, product);
	   
	   accountService.updateAccount(id, account);
	   
      return new ResponseEntity<>("Account is updated successsfully", HttpStatus.OK);
   }
   
   @PostMapping
   public ResponseEntity<String> createProduct(@RequestBody Account account)  {
	   
//      productRepo.put(product.getId(), product);
	   
	   accountService.createAccount(account);
	   
      return new ResponseEntity<>("Account is created successfully", HttpStatus.CREATED);
   }
   
   @GetMapping
   public ResponseEntity<Object> getAccount() throws InterruptedException {
	  log.info("Received request to list Accounts...");

	  
//      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	  
	  return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
   }
}
