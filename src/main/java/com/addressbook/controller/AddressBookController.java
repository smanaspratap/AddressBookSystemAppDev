package com.addressbook.controller;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.dto.ResponseDTO;
import com.addressbook.model.AddressBook;
import com.addressbook.service.AddressBookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing Address Book API endpoints.
 * Integrates closely with the service layer and uses standard ResponseDTOs.
 */
@Slf4j
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    // Handles GET request to fetch all contacts
    @GetMapping(value = {"", "/"})
    public ResponseEntity<ResponseDTO> getAllContacts() {
        log.info("Controller: Calling GET All Contacts API");
        List<AddressBook> contacts = service.getAllContacts();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", contacts);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Handles GET request to fetch a contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable long id) {
        log.info("Controller: Calling GET Contact By ID API for ID: {}", id);
        AddressBook contact = service.getContactById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful", contact);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Handles POST request with standard @Valid annotation to enforce validation
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Controller: Calling POST Add Contact API");
        AddressBook contact = service.addContact(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Book Entry Successfully", contact);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // Handles PUT request with standard @Valid annotation to enforce validation
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable long id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Controller: Calling PUT Update Contact API for ID: {}", id);
        AddressBook contact = service.updateContact(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Address Book Entry Successfully", contact);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Handles DELETE request
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable long id) {
        log.info("Controller: Calling DELETE Contact API for ID: {}", id);
        String message = service.deleteContact(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", message);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}