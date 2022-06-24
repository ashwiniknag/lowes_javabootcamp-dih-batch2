package com.lowes.bankingapp.fundtransfer.service;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.lowes.bankingapp.fundtransfer.model.FundTransfer;


@Service
public class FundTransferService {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;	
	
	
	public void create(FundTransfer fundtransfer) {
		
		String msg = fundtransfer.getFtid() + "," + fundtransfer.getSrcAccnt() + "," + fundtransfer.getDestAccnt() + "," + String.valueOf(fundtransfer.getAmount());
		kafkaTemplate.send("FT_ACCT_CREATED", msg);
		kafkaTemplate.send("FT_TRANS_CREATED", msg);
		
		
}
}	
	
	
	
