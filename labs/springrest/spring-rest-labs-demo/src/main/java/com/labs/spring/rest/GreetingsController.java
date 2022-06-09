package com.labs.spring.rest;

import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.logging.Logger;

@RestController
public class GreetingsController {
    @RequestMapping(path ="/greetings", method = RequestMethod.GET, produces ={MediaType.TEXT_PLAIN_VALUE})
    public String greetings(){
        return "Hello Spring REST!!!!";
    }

    @RequestMapping(value = "/greetings/collection", method = RequestMethod.POST)
    public Map<String, String> postGreetingMap(@RequestBody Map<String, String> greeting) {
        Logger logger
        greeting.put("updated", "POST collection mapping example");
        return greeting;
    }

    @RequestMapping(value = "/greetings", method = RequestMethod.POST, consumes = { "application/xml",
            "application/json" }, produces = { "application/xml", "application/json" })
    public Greetings postGreetingObject(@RequestBody Greetings greeting) {
        greeting.setMessage(greeting.getMessage() + " - POST object mapping example");
        return greeting;
    }



}
