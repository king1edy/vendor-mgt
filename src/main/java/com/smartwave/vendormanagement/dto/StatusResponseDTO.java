package com.smartwave.vendormanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusResponseDTO {
    private UUID id;
    private String statusName;
    private String description;
}