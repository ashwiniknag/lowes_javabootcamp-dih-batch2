package com.lowes.bankingapp.transaction.controller;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.lowes.bankingapp.transaction.model.Account;
import com.lowes.bankingapp.transaction.model.*;
import com.lowes.bankingapp.transaction.service.*;


//API Test / Integration test
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionControllerTests {

//	 @Autowired
//	    TestRestTemplate restTemp;
//
//	//  @Autowired    
//	    @MockBean
//	    TransactionService transService;
//	    
//	    private static List<Transaction> trans = new ArrayList<>();
//	    @BeforeEach
//		public void setup() {
//			// Initialize Test data
//			 Transaction trans1 = new Transaction();
//			 Account account1 = new Account();
//			 	account1.setId(1);
//				account1.setName("Priya");
//				account1.setStatus("Open");
//				account1.setType("Savings");
//				account1.setBalance(5000);
//				
//			 trans1.setId(1);
//			 trans1.setType("Cr");
//			 trans1.setStatus("PENDING");
//			 trans1.setFtid("123");
//			 trans1.setAccountId(account1);
//			 trans1.setAmount(1000);
//
//			trans.add(trans1);
//
//			Transaction trans2 = new Transaction();
//			 Account account2 = new Account();
//			 account2.setId(2);
//				account2.setName("Mahesh");
//				account2.setStatus("Open");
//				account2.setType("Savings");
//				account2.setBalance(10000);
//				
//			 trans1.setId(2);
//			 trans1.setType("Db");
//			 trans1.setStatus("PENDING");
//			 trans1.setFtid("123");
//			 trans1.setAccountId(account2);
//			 trans1.setAmount(2000);
//			 
//			 trans.add(trans2);
//		}
//
//		@AfterEach
//		public void cleanup() {
//		//	accountService.clear();
//		trans.clear();
//		}
//		
//	    @Test
//	    public void shouldCreateTransaction() throws URISyntaxException
//	    {
//	        // POST /accounts
//
//	    	Transaction trans1 = new Transaction();
//	        Mockito.when(transService.create(trans1)).thenReturn(trans1.getId());
//
//	        String reqBody = "{\"id\":\"1\",\"type\": \"Cr\",\"description\": \"college fee\",\"amount\": 1000.0,\"accountId\": {\"id\": 1,\"name\": \"Priya\",\"type\": \"Saving\",\"status\": \"Open\",\"balance\": 5000.0},\"status\": \"PENDING\"}";
//
//
//	        // Step 1: Create Request
//	        HttpHeaders headers = new HttpHeaders();
//	        headers.setContentType(MediaType.APPLICATION_JSON);
//
//	        RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.POST, new URI("/transactions"));
//
//	        // Step 2: Send Request to Endpoint
//	        // Step 3: Receive the Response
//
//	        ResponseEntity<String> response = restTemp.exchange(request, String.class);
//
//	        System.out.println("Response: " + response.getBody());
//
//	        // Step 4: Validate the Response
//	        Assertions.assertThat(response).isNotNull();
//	     
//	    }
//
//
//	    @Test
//	    public void shouldReturnAllAccounts() {
//
//	        Mockito.when(transService.list()).thenReturn(trans);
//
//	        // REST Template
//	        // Step 1: Create Request
//	        // Step 2: Send Request to Endpoint
//	        // Step 3: Receive the Response
//	        ResponseEntity<Object> response = restTemp.getForEntity("/transactions", Object.class);
//
//	        List<Account> accounts = (List) response.getBody();
//
//	        System.out.println("Response: " + accounts);
//
//	        // Step 4: Validate the Response
//	        Assertions.assertThat(response).isNotNull();
//	        Assertions.assertThat(accounts.size()).isEqualTo(2);
//	      
//	    }
}
