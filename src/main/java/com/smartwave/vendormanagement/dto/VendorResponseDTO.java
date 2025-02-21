package com.smartwave.vendormanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String phoneNumber;
    private String categoryName;
    private String statusName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
