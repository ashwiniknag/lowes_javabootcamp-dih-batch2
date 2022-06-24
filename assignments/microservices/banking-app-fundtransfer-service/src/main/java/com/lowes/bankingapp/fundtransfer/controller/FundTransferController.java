package com.lowes.bankingapp.fundtransfer.controller;


import java.net.URI;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lowes.bankingapp.fundtransfer.model.FundTransfer;
import com.lowes.bankingapp.fundtransfer.service.FundTransferService;

@RestController
@RequestMapping("/fundtransfers")
public class FundTransferController {

	@Autowired
	FundTransferService fundTransferService;
	

	
	@PostMapping
	public ResponseEntity<String> createFundTransfer(@RequestBody @Valid FundTransfer fundTransfer) throws Exception
	{
			
		fundTransferService.create(fundTransfer);
			
	        
		return new ResponseEntity<>("Fund Transfer is initiated with Transaction status as PENDING " + fundTransfer.getFtid(), HttpStatus.CREATED);
		
	
	}

}
