package com.smartwave.vendormanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "vendor_statuses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String statusName;

    @Column
    private String description;
}
