package com.lowes.bankingapp.account.controller;

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

import com.lowes.bankingapp.account.model.Account;
import com.lowes.bankingapp.account.service.AccountService;

// API Test / Integration test
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountServiceControllerTests {
//
//    @Autowired
//    TestRestTemplate restTemp;
//
////  @Autowired    
//    @MockBean
//    AccountService accountService;
//
//  private static List<Account> accounts = new ArrayList<>();
//  	@BeforeEach
//  	public void setup() {
////        // Initialize Test data
//	Account account1 = new Account();
//	account1.setId(1);
//	account1.setName("Priya");
//	account1.setStatus("Open");
//	account1.setType("Savings");
//	account1.setBalance(5000);
//			
//
//	accounts.add(account1);
//
//	Account account2 = new Account();
//	account2.setId(2);
//	account2.setName("Mahesh");
//	account2.setStatus("Open");
//	account2.setType("Savings");
//	account2.setBalance(10000);
//			
//
//	accounts.add(account2);
// }
//
//    @AfterEach
//    public void cleanup() {
//    	accounts.clear();
//    }
//
//    @Test
//    public void shouldCreateAccount() throws URISyntaxException
//    {
//        // POST /accounts
//
//    
//        Mockito.when(accountService.createAccount(new Account())).thenReturn("Account is created successfully");
//
//        String reqBody = "{\"id\":\"1\",\"name\":\"Priya\",\"Status\":\"Open\",\"Type\":\"Savings\", \"Balance\":\"10000\"}";
//
//
//        // Step 1: Create Request
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.POST, new URI("/accounts"));
//
//        // Step 2: Send Request to Endpoint
//        // Step 3: Receive the Response
//
//        ResponseEntity<String> response = restTemp.exchange(request, String.class);
//
//        System.out.println("Response: " + response.getBody());
//
//        // Step 4: Validate the Response
//        Assertions.assertThat(response).isNotNull();
//        Assertions.assertThat(response.getBody()).isEqualTo("Account is created successfully");
//    }
//
//
//    @Test
//    public void shouldReturnAllAccounts() {
//
//        Mockito.when(accountService.getAccounts()).thenReturn(accounts);
//
//        // REST Template
//        // Step 1: Create Request
//        // Step 2: Send Request to Endpoint
//        // Step 3: Receive the Response
//        ResponseEntity<Object> response = restTemp.getForEntity("/accounts", Object.class);
//
//        List<Account> accounts = (List) response.getBody();
//
//        System.out.println("Response: " + accounts);
//
//        // Step 4: Validate the Response
//        Assertions.assertThat(response).isNotNull();
//        Assertions.assertThat(accounts.size()).isEqualTo(2);
//      
//    }
}
