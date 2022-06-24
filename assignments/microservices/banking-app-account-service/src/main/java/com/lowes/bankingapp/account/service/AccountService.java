package com.lowes.bankingapp.account.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transaction;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.lowes.bankingapp.account.model.Account;
import com.lowes.bankingapp.account.repository.AccountRepository;

@Service
public class AccountService {



	@Autowired
	AccountRepository accountRepo;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public Collection<Account> getAccounts() {
//        return accountRepo.values();
		return accountRepo.findAll();
	}

	public String createAccount(Account account) {

		if (account.getId() <= 0) {
			throw new RuntimeException("Account Id mandatory");
		}
//        accountRepo.put(account.getId(), account);
		accountRepo.save(account);
		return "Account created";
	}

	public String updateAccount(int id, Account account) {
//        accountRepoRepo.remove(id);
//        accountRepo.setId(id);
//        accountRepo.put(id, product);
		// account.setId(id);
		accountRepo.save(account);
		return "Account Updated";
	}

	public String deleteAccount(int id) {

		// accountRepo.remove(id); System.out.println("Account: " + //
//		accountRepo.findById(id); 
//		accountRepo.delete(accountRepo.findById(id).get());
		accountRepo.deleteById(id);
	
		return "Account Deleted";

	}

	public Account getAccount(int id) {

		// return accountRepo.get(id); Optional<Account> account =
		Optional<Account> account = accountRepo.findById(id);
		return account.isPresent() ? account.get() : null;

	}

	@KafkaListener(topics = "TRANS_CREATED", groupId = "account-service")
	public void listenTransactionCreated(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Transaction Created Received: " + cr.value());

		String msg = (String) cr.value();
		String[] tokens = msg.split(",");
		String id = tokens[0];
		String acctId = tokens[1];
		String amount = tokens[2];
		String type = tokens[3];

		double amt = Double.valueOf(amount);
		int accid = Integer.valueOf(acctId);
		boolean transStatus = false;
		Optional<Account> account = accountRepo.findById(accid);
		if (account.isPresent()) {
			Account accnt = account.get();
			if (type.equalsIgnoreCase("Db")) {

				if (accnt.getBalance() >= amt) {
					accnt.setBalance(accnt.getBalance() - amt);
					accountRepo.save(accnt);
					transStatus = true;
				} else {
					
					System.out.println("Insufficient balance in account id  - " + accnt.getId() );
					transStatus = false;

				}
			} else {
				accnt.setBalance(accnt.getBalance() + amt);
				accountRepo.save(accnt);
				transStatus = true;

			}
		}
		id=id.replaceAll("\"", "");
		String transMsg = id + "," + "REJECTED";

		if (transStatus) {
			transMsg = id + "," + "APPROVED";

		}

		kafkaTemplate.send("TRANS_STATUS", transMsg);

		System.out.println("message sent from account to transaction" + transMsg);

	}
	
	@KafkaListener(topics = "FT_ACCT_CREATED", groupId = "account-service")
	public void listenFTCreated(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Fund Transfer Created Received: " + cr.value());

		String msg = (String) cr.value();
		String[] tokens = msg.split(",");
		String ftid = tokens[0];
		String SrcAccnt = tokens[1];
		String DestAccnt = tokens[2];
		String amount = tokens[3];

		double amt = Double.valueOf(amount);
		int srcaccid = Integer.valueOf(SrcAccnt);
		int destaccid = Integer.valueOf(DestAccnt);
		boolean transStatus = false;
		Optional<Account> srcaccount = accountRepo.findById(srcaccid);
		Optional<Account> desaccount = accountRepo.findById(destaccid);
		if (srcaccount.isPresent() && desaccount.isPresent() ) {
			Account srcaccnt = srcaccount.get();
			Account desaccnt = desaccount.get();
			
				if (srcaccnt.getBalance() >= amt) {
					srcaccnt.setBalance(srcaccnt.getBalance() - amt);
					accountRepo.save(srcaccnt);
					desaccnt.setBalance(desaccnt.getBalance() + amt);
					accountRepo.save(desaccnt);
					transStatus = true;
				} else {
					System.out.println("Insufficient balance in account id  - " + srcaccnt.getId() );
					transStatus = false;

				}
		
		}
		

		//id=id.replaceAll("\"", "");
		String transMsg = ftid + "," + "REJECTED";

		if (transStatus) {
			transMsg = ftid + "," + "APPROVED";

		}
		
		Thread.sleep(3000);

		kafkaTemplate.send("FT_ACCT_STATUS", transMsg);

		System.out.println("message sent from FT to account to Transaction " + transMsg);

	}

	public void clear() {
//        accountRepo.clear();
		accountRepo.deleteAll();
	}

}