package com.lowes.bankingapp.transaction.service;

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

import com.lowes.bankingapp.transaction.model.Account;
import com.lowes.bankingapp.transaction.model.Transaction;
import com.lowes.bankingapp.transaction.repository.TransactionRepository;
import com.lowes.bankingapp.transaction.service.TransactionService;

//@SpringBootTest
public class TransactionServiceTests {
//	
//	@Autowired
//	TransactionService transService;
//
//	@MockBean
//	TransactionRepository transRepo;
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
//	private static List<Transaction> trans = new ArrayList<>();
//	
//	@BeforeEach
//	public void setup() {
//		// Initialize Test data
//		 Transaction trans1 = new Transaction();
//		 Account account1 = new Account();
//		 	account1.setId(1);
//			account1.setName("Priya");
//			account1.setStatus("Open");
//			account1.setType("Savings");
//			account1.setBalance(5000);
//			
//		 trans1.setId(1);
//		 trans1.setType("Cr");
//		 trans1.setStatus("PENDING");
//		 trans1.setFtid("123");
//		 trans1.setAccountId(account1);
//		 trans1.setAmount(1000);
//
//		trans.add(trans1);
//
//		Transaction trans2 = new Transaction();
//		 Account account2 = new Account();
//		 account2.setId(2);
//			account2.setName("Mahesh");
//			account2.setStatus("Open");
//			account2.setType("Savings");
//			account2.setBalance(10000);
//			
//		 trans1.setId(2);
//		 trans1.setType("Db");
//		 trans1.setStatus("PENDING");
//		 trans1.setFtid("123");
//		 trans1.setAccountId(account2);
//		 trans1.setAmount(2000);
//		 
//		 trans.add(trans2);
//	}
//
//	@AfterEach
//	public void cleanup() {
//	
//	trans.clear();
//	}
//
//	@Test
//	public void shouldReturnTransactionForGivenTransactionId() {
//		Mockito.when(transRepo.findById(1)).thenReturn(Optional.of(trans.get(1)));
//		
//		assertNotNull(transService.get(1));
//		//assertEquals(1, transService.get(1).(trans.getId()));
//		
//	}
////
//	@Test
//	public void shouldReturnAllTransactionsWhenDontSpecifyTransactionId() {
//		Mockito.when(transRepo.findAll()).thenReturn(trans);
//		
//		assertEquals(2, transService.list().size());
//		
//	}
//		
//	@Test
//	public void shouldCreateTransactionWhenPassingMandatoryDetails() {
//		Transaction trans1 = new Transaction();
//		 Account account1 = new Account();
//		 	account1.setId(1);
//			account1.setName("Priya");
//			account1.setStatus("Open");
//			account1.setType("Savings");
//			account1.setBalance(5000);
//			
//		 trans1.setId(1);
//		 trans1.setType("Cr");
//		 trans1.setStatus("PENDING");
//		 trans1.setFtid("123");
//		 trans1.setAccountId(account1);
//		 trans1.setAmount(1000);
//
//
//			Mockito.when(transRepo.save(trans1)).thenReturn(trans1);
//		
//			assertEquals(1, transService.create(trans1));
//		}
//
//		@Test
//		public void shouldShowErrorWhenNotPassingMandatoryDetails() {
//			Transaction trans1 = new Transaction();
//			Account account1 = new Account();			
//			account1.setName("Priya");
//			account1.setStatus("Open");
//			account1.setType("Savings");
//			account1.setBalance(5000);
//				
//			try {
//				 trans1.setId(1);
//				 trans1.setType("Cr");
//				 trans1.setStatus("PENDING");
//				 trans1.setFtid("123");
//				 trans1.setAccountId(account1);
//				 trans1.setAmount(1000);
//				 Mockito.when(transRepo.save(trans1)).thenReturn(trans1);
//				//accountService.createAccount(account);
//			} catch (Exception e) {
//				assertEquals("Account Id mandatory", e.getMessage());
//			}
//
//		}
//
//		@Test
//		public void shouldUpdateTransactionForGivenTransaction() {
//			Transaction trans1 = new Transaction();
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
//			 Mockito.when(transRepo.save(trans1)).thenReturn(trans1);
//
//			assertEquals("Transaction updated", transService.update(trans1));
//		}
//
//		@Test
//		public void shouldDeleteTransactionWhenPassingValidTransactionId() {
//
//			assertEquals("Transaction deleted", transService.delete(2));
//		}
}


