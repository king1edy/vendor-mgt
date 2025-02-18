package com.smartwave.vendormanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

// VendorRequestDTO.java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorRequestDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    private String phoneNumber;

    @NotNull(message = "Category ID is required")
    private UUID categoryId;

    @NotNull(message = "Status ID is required")
    private UUID statusId;
}
