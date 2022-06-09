package com.labs.spring.boot;

import org.springframework.stereotype.Component;


public class Greetings {

        private String message =" hello spring boot demo";

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
}
