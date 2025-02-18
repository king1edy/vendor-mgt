package com.smartwave.vendormanagement.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusRequestDTO {
    @NotBlank(message = "Status name is required")
    private String statusName;

    private String description;
}