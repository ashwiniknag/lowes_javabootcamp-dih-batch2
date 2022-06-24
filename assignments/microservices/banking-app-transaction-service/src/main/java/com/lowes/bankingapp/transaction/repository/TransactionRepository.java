package com.lowes.bankingapp.transaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lowes.bankingapp.transaction.model.Transaction;



public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findByFtid(String ftid);
	
}


