package com.addressbook.exception;

/**
 * Custom exception class for handling domain-specific Address Book errors.
 */
public class AddressBookException extends RuntimeException {
    // Constructor injecting the error message to the superclass
    public AddressBookException(String message) {
        super(message);
    }
}