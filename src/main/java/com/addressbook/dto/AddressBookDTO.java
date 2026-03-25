package com.addressbook.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Data Transfer Object for carrying Address Book request data.
 * Includes validation logic to enforce data integrity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name is invalid. It must start with a capital letter and have at least 3 characters.")
    private String name;

    @NotEmpty(message = "Phone number cannot be empty")
    private String phone;

    private String email;
    private String address;
}