package com.addressbook.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Domain model representing an Address Book contact.
 * Utilizes Lombok for boilerplate code reduction.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBook {
    private long id;
    private String name;
    private String phone;
    private String email;
    private String address;
}