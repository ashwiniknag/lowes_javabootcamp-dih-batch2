package com.lowes.bankingapp.account.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.lowes.bankingapp.account.model.Account;
import com.lowes.bankingapp.account.repository.AccountRepository;
import com.lowes.bankingapp.account.service.AccountService;

//@SpringBootTest
public class AccountServiceTests {

//	@Autowired
//	AccountService accountService;
//
//	@MockBean
//	AccountRepository accountRepo;
//
//	@BeforeAll
//	public static void init() {
//		// Logic to initialize test data goes here
//		System.out.println("Test data initialization at class level..");
//	}
//
//	@AfterAll
//	public static void tearDown() {
//		// Logic to clean up test data goes here
//		System.out.println("Test data clean up at class level..");
//	}
//	
//	private static List<Account> accounts = new ArrayList<>();
//
//	@BeforeEach
//	public void setup() {
//		// Initialize Test data
//		Account account1 = new Account();
//		account1.setId(1);
//		account1.setName("Priya");
//		account1.setStatus("Open");
//		account1.setType("Savings");
//		account1.setBalance(5000);
//				
//
//		accounts.add(account1);
//
//		Account account2 = new Account();
//		account2.setId(2);
//		account2.setName("Mahesh");
//		account2.setStatus("Open");
//		account2.setType("Savings");
//		account2.setBalance(10000);
//				
//
//		accounts.add(account2);
//	}
//
//	@AfterEach
//	public void cleanup() {
//	//	accountService.clear();
//	accounts.clear();
//	}
//
//	@Test
//	public void shouldCreateAccountWhenPassingMandatoryDetails() {
//		Account account = new Account();
//		account.setId(2);
//		account.setName("Mahesh");
//		account.setStatus("Open");
//		account.setType("Savings");
//		account.setBalance(10000);
//		//accountService.createAccount(account);
//		Mockito.when(accountRepo.save(account)).thenReturn(account);
//	
//		assertEquals("Account created", accountService.createAccount(account));
//	}
//
//	@Test
//	public void shouldShowErrorWhenNotPassingMandatoryDetails() {
//		Account account = new Account();
//		
//		try {
//			account.setName("Mahesh");
//			account.setStatus("Open");
//			Mockito.when(accountRepo.save(account)).thenReturn(account);
//			//accountService.createAccount(account);
//		} catch (Exception e) {
//			assertEquals("Account Id mandatory", e.getMessage());
//		}
//
//	}
//
//	@Test
//	public void shouldUpdateAccountForGivenAccountId() {
//		Account account1 = new Account();
//		account1.setName("Mahesh");
//		account1.setStatus("Blocked");
//		account1.setType("Savings");
//		account1.setBalance(5000);
//
//		Mockito.when(accountRepo.save(account1)).thenReturn(account1);
//
//		assertEquals("Account Updated", accountService.updateAccount(2,account1));
//	}
//
//	@Test
//	public void shouldDeleteAccountWhenPassingValidAccountId() {
////		accountService.deleteAccount(2);
////			assertNull(accountService.getAccount(2));
//		//	assertEquals(1, accountService.getAccounts().size());
//		assertEquals("Account Deleted", accountService.deleteAccount(2));
//	}
//
//	@Test
//	public void shouldReturnAccountForGivenAccountId() {
//		Mockito.when(accountRepo.findById(2)).thenReturn(Optional.of(accounts.get(1)));
//		
//		
//		assertNotNull(accountService.getAccount(2));
//		assertEquals(2, accountService.getAccount(2).getId());
//	}
////
//	@Test
//	public void shouldReturnAllAccountsWhenDontSpecifyAccountId() {
//		Mockito.when(accountRepo.findAll()).thenReturn(accounts);
//		
//		assertEquals(2, accountService.getAccounts().size());
//}

}
