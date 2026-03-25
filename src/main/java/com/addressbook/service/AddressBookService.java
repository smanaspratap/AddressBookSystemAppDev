package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Service class handling the core business logic for the Address Book.
 * In-memory storage is used temporarily. Slf4j used for logging.
 */
@Slf4j
@Service
public class AddressBookService {

    private final List<AddressBook> contactList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    // Get all contacts from the in-memory list
    public List<AddressBook> getAllContacts() {
        log.info("Fetching all Address Book contacts.");
        return contactList;
    }

    // Add a new contact to the list
    public AddressBook addContact(AddressBookDTO dto) {
        log.info("Adding new contact with name: {}", dto.getName());
        AddressBook newContact = new AddressBook(idCounter.getAndIncrement(), dto.getName(), dto.getPhone(), dto.getEmail(), dto.getAddress());
        contactList.add(newContact);
        return newContact;
    }
}