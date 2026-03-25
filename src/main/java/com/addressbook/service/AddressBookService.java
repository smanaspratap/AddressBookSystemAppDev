package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.exception.AddressBookException;
import com.addressbook.model.AddressBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Service class handling the core business logic for the Address Book.
 * Slf4j used for logging, exceptions thrown for missing IDs.
 */
@Slf4j
@Service
public class AddressBookService {

    private final List<AddressBook> contactList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    // Retrieves all contacts
    public List<AddressBook> getAllContacts() {
        log.info("Fetching all Address Book contacts");
        return contactList;
    }

    // Retrieves a specific contact by ID; throws custom exception if not found
    public AddressBook getContactById(long id) {
        log.info("Fetching contact by ID: {}", id);
        return contactList.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Address Book Entry with ID " + id + " not found!"));
    }

    // Adds a new contact
    public AddressBook addContact(AddressBookDTO dto) {
        log.info("Adding new contact for: {}", dto.getName());
        AddressBook newContact = new AddressBook(idCounter.getAndIncrement(), dto.getName(), dto.getPhone(), dto.getEmail(), dto.getAddress());
        contactList.add(newContact);
        return newContact;
    }

    // Updates an existing contact; relies on getContactById which handles validation
    public AddressBook updateContact(long id, AddressBookDTO dto) {
        log.info("Updating contact with ID: {}", id);
        AddressBook contact = getContactById(id);
        contact.setName(dto.getName());
        contact.setPhone(dto.getPhone());
        contact.setEmail(dto.getEmail());
        contact.setAddress(dto.getAddress());
        return contact;
    }

    // Deletes an existing contact
    public String deleteContact(long id) {
        log.info("Deleting contact with ID: {}", id);
        AddressBook contact = getContactById(id);
        contactList.remove(contact);
        return "Contact successfully deleted";
    }
}