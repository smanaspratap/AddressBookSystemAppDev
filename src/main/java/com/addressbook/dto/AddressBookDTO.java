package com.addressbook.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Data Transfer Object for carrying Address Book request data.
 * Utilizes Lombok for boilerplate code reduction.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    private String name;
    private String phone;
    private String email;
    private String address;
}