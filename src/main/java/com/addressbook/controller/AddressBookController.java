package com.addressbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for managing Address Book API endpoints.
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    // Handles basic GET request for testing connectivity
    @GetMapping("/test")
    public ResponseEntity<String> testAPI() {
        return new ResponseEntity<>("Address Book API is working!", HttpStatus.OK);
    }
}