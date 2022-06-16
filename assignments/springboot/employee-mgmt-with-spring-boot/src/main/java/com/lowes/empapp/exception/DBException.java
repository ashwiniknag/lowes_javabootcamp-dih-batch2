package com.lowes.empapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
	public class DBException extends Exception {
		public DBException(String message) {
			super(message);
		}
}
