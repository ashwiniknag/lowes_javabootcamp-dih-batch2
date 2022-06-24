package com.lowes.bankingapp.transaction.service;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.lowes.bankingapp.transaction.model.Account;
import com.lowes.bankingapp.transaction.model.Transaction;
import com.lowes.bankingapp.transaction.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepo;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public Integer create(Transaction transaction) {
		transaction.setStatus("PENDING");
		transaction = transactionRepo.save(transaction);

		String msg = transaction.getId() + "," + transaction.getAccountId().getId() + ","
				+ String.valueOf(transaction.getAmount() + "," + transaction.getType());

	kafkaTemplate.send("TRANS_CREATED", msg);
		

		return transaction.getId();
		
		
	}

	public String update(Transaction transaction) {
		transactionRepo.save(transaction);
		return "Transaction updated";
	}

	public Optional<Transaction> get(Integer id) {
		Optional<Transaction> transaction = transactionRepo.findById(id);
		return transaction;
		// .isPresent() ? id.get() : null;
	}

	public String delete(Integer empId) {
		transactionRepo.deleteById(empId);
		return "Transaction deleted";
	}

	public List<Transaction> list() {
		return transactionRepo.findAll();
	}

	public void deleteAll() {
		transactionRepo.deleteAll();
	}

	@KafkaListener(topics = "TRANS_STATUS", groupId = "transaction-service")
	public void listenTransactionStatus(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Transaction Status Received from account: " + cr.value());
		// Logic to update transaction with APPROVED/REJECTED status

		String msg = (String) cr.value();
		String[] tokens = msg.split(",");
		String id = tokens[0];
		String status = tokens[1];

		int tid = Integer.valueOf(id);
		Optional<Transaction> trans = transactionRepo.findById(tid);
		Transaction transaction = trans.get();
		transaction.setStatus("REJECTED");
		
		if (status.equalsIgnoreCase("APPROVED")) {
			transaction.setStatus("APPROVED");
			System.out.println("TRANSACTION APPROVED :: " + tid);
		}
		System.out.println("Transaction Status is - " + transaction.getStatus() );
		transactionRepo.save(transaction);
		
		
	}

	@KafkaListener(topics = "FT_TRANS_CREATED", groupId = "transaction-service")
	public void listenFTTransactioncreate(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################Fund transfer -Transaction create message recieved: " + cr.value());

		String msg = (String) cr.value();
		String[] tokens = msg.split(",");
		String ftid = tokens[0];
		String SrcAccnt = tokens[1];
		String DestAccnt = tokens[2];
		String amount = tokens[3];

		double amt = Double.valueOf(amount);
		int srcaccid = Integer.valueOf(SrcAccnt);
		int destaccid = Integer.valueOf(DestAccnt);

		Transaction srctrans = new Transaction();
		srctrans.setFtid(ftid);

		Account acc = new Account();
		acc.setId(srcaccid);
		srctrans.setAccountId(acc);
		srctrans.setType("Db");
		srctrans.setStatus("PENDING");
		srctrans.setDescription("");
		srctrans.setAmount(amt);

		transactionRepo.save(srctrans);

		Transaction destrans = new Transaction();
		destrans.setFtid(ftid);

		Account acc1 = new Account();
		acc1.setId(destaccid);
		destrans.setAccountId(acc1);
		destrans.setType("Cr");
		destrans.setStatus("PENDING");
		destrans.setDescription("");
		destrans.setAmount(amt);

		transactionRepo.save(destrans);

	}

	@KafkaListener(topics = "FT_ACCT_STATUS", groupId = "transaction-service")
	public void listenFTTransactionStatus(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("###################fund transafer - Transaction status message recieved from account: " + cr.value());

		String msg = (String) cr.value();
		String[] tokens = msg.split(",");
		String ftid = tokens[0];
		String status = tokens[1];

		List<Transaction> listTrans = transactionRepo.findByFtid(ftid);
		System.out.println("size of transaction" + listTrans.size());

		for (Transaction trans : listTrans) {
			trans.setStatus("REJECTED");
			if (status.equalsIgnoreCase("APPROVED")) {
				trans.setStatus("APPROVED");
			}

			System.out.println("transaction" + trans);
			System.out.println("Transaction Status is - " + trans.getStatus() );
			transactionRepo.save(trans);
		}
	}
	
	

}
