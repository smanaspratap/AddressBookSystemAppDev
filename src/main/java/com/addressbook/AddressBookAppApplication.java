package com.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Address Book application.
 * Initializes the Spring Boot context.
 */
@SpringBootApplication
public class AddressBookAppApplication {
    // Main method to run the Spring Boot app
    public static void main(String[] args) {
        SpringApplication.run(AddressBookAppApplication.class, args);
    }
}